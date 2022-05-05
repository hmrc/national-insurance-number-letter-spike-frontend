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

import base.SpecBase
import forms.PreviousMarriageOrPartnershipDetailsFormProvider
import models.{Index, NormalMode, PreviousMarriageOrPartnershipDetails, UserAnswers}
import navigation.{FakeNavigator, Navigator}
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.when
import org.scalatestplus.mockito.MockitoSugar
import pages.PreviousMarriageOrPartnershipDetailsPage
import play.api.inject.bind
import play.api.mvc.Call
import play.api.test.FakeRequest
import play.api.test.Helpers._
import repositories.SessionRepository
import views.html.PreviousMarriageOrPartnershipDetailsView

import java.time.LocalDate
import scala.concurrent.Future

class PreviousMarriageOrPartnershipDetailsControllerSpec extends SpecBase with MockitoSugar {

  def onwardRoute = Call("GET", "/foo")

  val formProvider = new PreviousMarriageOrPartnershipDetailsFormProvider()
  val form = formProvider()

  lazy val previousMarriageOrPartnershipDetailsRoute = routes.PreviousMarriageOrPartnershipDetailsController.onPageLoad(Index(0), NormalMode).url

  val model = PreviousMarriageOrPartnershipDetails(
    startDate = LocalDate.now, endDate = LocalDate.now, endingReason = "value"
  )

  val userAnswers = UserAnswers(userAnswersId).set(PreviousMarriageOrPartnershipDetailsPage(Index(0)), model).success.value

  "PreviousMarriageOrPartnershipDetails Controller" - {

    "must return OK and the correct view for a GET" in {

      val application = applicationBuilder(userAnswers = Some(emptyUserAnswers)).build()

      running(application) {
        val request = FakeRequest(GET, previousMarriageOrPartnershipDetailsRoute)

        val view = application.injector.instanceOf[PreviousMarriageOrPartnershipDetailsView]

        val result = route(application, request).value

        status(result) mustEqual OK
        contentAsString(result) mustEqual view(form, Index(0), NormalMode)(request, messages(application)).toString
      }
    }

    "must populate the view correctly on a GET when the question has previously been answered" in {

      val application = applicationBuilder(userAnswers = Some(userAnswers)).build()

      running(application) {
        val request = FakeRequest(GET, previousMarriageOrPartnershipDetailsRoute)

        val view = application.injector.instanceOf[PreviousMarriageOrPartnershipDetailsView]

        val result = route(application, request).value

        status(result) mustEqual OK
        contentAsString(result) mustEqual view(form.fill(model), Index(0), NormalMode)(request, messages(application)).toString
      }
    }

    "must redirect to the next page when valid data is submitted" in {

      val mockSessionRepository = mock[SessionRepository]

      when(mockSessionRepository.set(any())) thenReturn Future.successful(true)

      val validData = List(
        "startDate.day" -> LocalDate.now.getDayOfMonth.toString, "startDate.month" -> LocalDate.now.getMonthValue.toString, "startDate.year" -> LocalDate.now.getYear.toString,
        "endDate.day" -> LocalDate.now.getDayOfMonth.toString, "endDate.month" -> LocalDate.now.getMonthValue.toString, "endDate.year" -> LocalDate.now.getYear.toString,
        "endReason" -> "value"
      )

      val application =
        applicationBuilder(userAnswers = Some(emptyUserAnswers))
          .overrides(
            bind[Navigator].toInstance(new FakeNavigator(onwardRoute)),
            bind[SessionRepository].toInstance(mockSessionRepository)
          )
          .build()

      running(application) {
        val request =
          FakeRequest(POST, previousMarriageOrPartnershipDetailsRoute)
            .withFormUrlEncodedBody(validData: _*)

        val result = route(application, request).value

        status(result) mustEqual SEE_OTHER
        redirectLocation(result).value mustEqual onwardRoute.url
      }
    }

    "must return a Bad Request and errors when invalid data is submitted" in {

      val application = applicationBuilder(userAnswers = Some(emptyUserAnswers)).build()

      running(application) {
        val request =
          FakeRequest(POST, previousMarriageOrPartnershipDetailsRoute)
            .withFormUrlEncodedBody(("value", "invalid value"))

        val boundForm = form.bind(Map("value" -> "invalid value"))

        val view = application.injector.instanceOf[PreviousMarriageOrPartnershipDetailsView]

        val result = route(application, request).value

        status(result) mustEqual BAD_REQUEST
        contentAsString(result) mustEqual view(boundForm, Index(0), NormalMode)(request, messages(application)).toString
      }
    }

    "must redirect to Journey Recovery for a GET if no existing data is found" in {

      val application = applicationBuilder(userAnswers = None).build()

      running(application) {
        val request = FakeRequest(GET, previousMarriageOrPartnershipDetailsRoute)

        val result = route(application, request).value

        status(result) mustEqual SEE_OTHER
        redirectLocation(result).value mustEqual routes.JourneyRecoveryController.onPageLoad().url
      }
    }

    "must redirect to Journey Recovery for a POST if no existing data is found" in {

      val application = applicationBuilder(userAnswers = None).build()

      running(application) {
        val request =
          FakeRequest(POST, previousMarriageOrPartnershipDetailsRoute)
            .withFormUrlEncodedBody(("startDate", "value 1"), ("endDate", "value 2"))

        val result = route(application, request).value

        status(result) mustEqual SEE_OTHER
        redirectLocation(result).value mustEqual routes.JourneyRecoveryController.onPageLoad().url
      }
    }
  }
}
