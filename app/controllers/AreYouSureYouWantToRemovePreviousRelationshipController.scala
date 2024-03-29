/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers

import controllers.actions._
import forms.AreYouSureYouWantToRemovePreviousRelationshipFormProvider

import javax.inject.Inject
import models.{Index, Mode, UserAnswers}
import navigation.Navigator
import pages.{AreYouSureYouWantToRemovePreviousRelationshipPage, PreviousMarriageOrPartnershipDetailsPage, PreviousRelationshipQuery, PreviousRelationshipTypePage}
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, AnyContent, MessagesControllerComponents}
import repositories.SessionRepository
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendBaseController
import views.html.AreYouSureYouWantToRemovePreviousRelationshipView

import scala.concurrent.{ExecutionContext, Future}

class AreYouSureYouWantToRemovePreviousRelationshipController @Inject()(
                                         override val messagesApi: MessagesApi,
                                         sessionRepository: SessionRepository,
                                         navigator: Navigator,
                                         identify: IdentifierAction,
                                         getData: DataRetrievalAction,
                                         requireData: DataRequiredAction,
                                         formProvider: AreYouSureYouWantToRemovePreviousRelationshipFormProvider,
                                         val controllerComponents: MessagesControllerComponents,
                                         view: AreYouSureYouWantToRemovePreviousRelationshipView
                                 )(implicit ec: ExecutionContext) extends FrontendBaseController with I18nSupport {

  val form = formProvider()

  private def removeRelationship(answers: UserAnswers, index: Index): Future[Unit] = for {
    updatedAnswers <- Future.fromTry(answers.remove(PreviousRelationshipQuery(index)))
    _              <- sessionRepository.set(updatedAnswers)
  } yield ()

  def onPageLoad(index: Index, mode: Mode): Action[AnyContent] = (identify andThen getData andThen requireData) {
    implicit request =>
      request.userAnswers.get(PreviousMarriageOrPartnershipDetailsPage(index)).map { details =>
        val relationshipType = request.userAnswers.get(PreviousRelationshipTypePage(index))
        Ok(view(form, relationshipType, details, index, mode))
      }.getOrElse(Redirect(routes.JourneyRecoveryController.onPageLoad()))
  }

  def onSubmit(index: Index, mode: Mode): Action[AnyContent] = (identify andThen getData andThen requireData).async {
    implicit request =>
      form.bindFromRequest().fold(
        formWithErrors =>
          request.userAnswers.get(PreviousMarriageOrPartnershipDetailsPage(index)).map { details =>
            val relationshipType = request.userAnswers.get(PreviousRelationshipTypePage(index))
            Future.successful(BadRequest(view(formWithErrors, relationshipType, details, index, mode)))
          }.getOrElse(Future.successful(Redirect(routes.JourneyRecoveryController.onPageLoad()))),
        value =>
          for {
            updatedAnswers <- Future.fromTry(request.userAnswers.set(AreYouSureYouWantToRemovePreviousRelationshipPage(index), value))
            _              <- if (value) removeRelationship(updatedAnswers, index) else Future.unit
          } yield Redirect(navigator.nextPage(AreYouSureYouWantToRemovePreviousRelationshipPage(index), mode, updatedAnswers))
      )
  }
}
