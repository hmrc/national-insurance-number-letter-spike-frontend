/*
 * Copyright 2022 HM Revenue & Customs
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

import com.google.inject.Inject
import controllers.actions.{DataRequiredAction, DataRetrievalAction, IdentifierAction}
import models.{CheckMode, Index}
import pages.{PreviousAddressesQuery, PreviousEmployersQuery, WhatIsYourPreviousAddressInternationalPage, WhatIsYourPreviousAddressUkPage}
import play.api.i18n.{I18nSupport, Messages, MessagesApi}
import play.api.mvc.{Action, AnyContent, MessagesControllerComponents}
import uk.gov.hmrc.govukfrontend.views.Aliases.Text
import uk.gov.hmrc.hmrcfrontend.views.Aliases.{ListWithActionsAction, ListWithActionsItem}
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendBaseController
import viewmodels.checkAnswers._
import viewmodels.govuk.summarylist._
import views.html.CheckYourAnswersView

class CheckYourAnswersController @Inject()(
                                            override val messagesApi: MessagesApi,
                                            identify: IdentifierAction,
                                            getData: DataRetrievalAction,
                                            requireData: DataRequiredAction,
                                            val controllerComponents: MessagesControllerComponents,
                                            view: CheckYourAnswersView
                                          ) extends FrontendBaseController with I18nSupport {

  // scalastyle:off
  def onPageLoad(): Action[AnyContent] = (identify andThen getData andThen requireData) {
    implicit request =>
      
      val answers = request.userAnswers

      val personalDetails = SummaryListViewModel(Seq(
        WhatIsYourNameSummary.row(answers),
        DoYouHaveAPreviousNameSummary.row(answers),
        WhatIsYourPreviousNameSummary.row(answers),
        WhatIsYourDateOfBirthSummary.row(answers),
        AreYouReturningFromLivingAbroadSummary.row(answers),
        WhatIsYourTelephoneNumberSummary.row(answers),
        DoYouKnowYourNationalInsuranceNumberSummary.row(answers),
        WhatIsYourNationalInsuranceNumberSummary.row(answers)
      ).flatten)

      val currentAddress =
        SummaryListViewModel(Seq(
          IsYourCurrentAddressInUkSummary.row(answers),
          WhatIsYourCurrentAddressUkSummary.row(answers),
          WhatIsYourCurrentAddressInternationalSummary.row(answers)
        ).flatten)

      val previousAddresses = {
        val previousAddresses = answers.get(PreviousAddressesQuery).getOrElse(List.empty)
        previousAddresses.indices.map { i =>

          val lines = answers.get(WhatIsYourPreviousAddressUkPage(Index(i))).map(_.lines)
            .orElse(answers.get(WhatIsYourPreviousAddressInternationalPage(Index(i))).map(_.lines))
            .getOrElse(List.empty)

          ListWithActionsItem(
            name = Text(lines.mkString(", ")),
            actions = List(
              ListWithActionsAction(content = Text(Messages("site.change")), href = routes.IsYourPreviousAddressInUkController.onPageLoad(Index(i), CheckMode).url),
              ListWithActionsAction(content = Text(Messages("site.remove")), href = routes.AreYouSureYouWantToRemovePreviousAddressController.onPageLoad(Index(i), CheckMode).url)
            )
          )
        }
      }

      val relationshipHistory = SummaryListViewModel(Seq(
        AreYouMarriedSummary.row(answers),
        WhenDidYouGetMarriedSummary.row(answers),
        HaveYouPreviouslyBeenInAMarriageOrCivilPartnershipSummary.row(answers),
        PreviousMarriageOrPartnershipDetailsSummary.row(answers)
      ).flatten)

      val benefitHistory = SummaryListViewModel(Seq(
        HaveYouEverClaimedChildBenefitSummary.row(answers),
        DoYouKnowYourChildBenefitNumberSummary.row(answers),
        WhatIsYourChildBenefitNumberSummary.row(answers),
        HaveYouEverReceivedOtherUkBenefitsSummary.row(answers),
        WhatOtherUkBenefitsHaveYouReceivedSummary.row(answers)
      ).flatten)

      val employmentHistory =
        SummaryListViewModel(Seq(
          HaveYouEverWorkedInUkSummary.row(answers),
          WhatIsYourEmployersNameSummary.row(answers),
          WhatIsYourEmployersAddressSummary.row(answers),
          WhenDidYouStartWorkingForEmployerSummary.row(answers),
          AreYouStillEmployedSummary.row(answers),
          WhenDidYouFinishYourEmploymentSummary.row(answers)
        ).flatten)

      val previousEmployers = answers.get(PreviousEmployersQuery).getOrElse(List.empty)
        .indices.map(PreviousEmployerSummary.item(answers, CheckMode, _))

      val supportingDocuments = SummaryListViewModel(Seq(
        DoYouHavePrimaryDocumentSummary.row(answers),
        WhichPrimaryDocumentSummary.row(answers),
        DoYouHaveTwoSecondaryDocumentsSummary.row(answers),
        WhichAlternativeDocumentsSummary.row(answers)
      ).flatten)

      Ok(view(personalDetails, currentAddress, previousAddresses, relationshipHistory, benefitHistory, employmentHistory, previousEmployers, supportingDocuments))
  }
}
