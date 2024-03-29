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

import base.SpecBase
import forms.WhatIsYourEmployersAddressFormProvider
import models.{EmployersAddress, Index, NormalMode, UserAnswers}
import navigation.{FakeNavigator, Navigator}
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.when
import org.scalatestplus.mockito.MockitoSugar
import pages.{WhatIsYourEmployersAddressPage, WhatIsYourEmployersNamePage}
import play.api.inject.bind
import play.api.mvc.Call
import play.api.test.FakeRequest
import play.api.test.Helpers._
import repositories.SessionRepository
import views.html.WhatIsYourEmployersAddressView

import java.time.LocalDate
import scala.concurrent.Future

class WhatIsYourEmployersAddressControllerSpec extends SpecBase with MockitoSugar {

  def onwardRoute = Call("GET", "/foo")
  private val employerName = "foo"
  private val baseAnswers = emptyUserAnswers.set(WhatIsYourEmployersNamePage(Index(0)), employerName).success.value

  val formProvider = new WhatIsYourEmployersAddressFormProvider()
  val form = formProvider()

  lazy val whatIsYourPreviousEmployersAddressRoute = routes.WhatIsYourEmployersAddressController.onPageLoad(Index(0), NormalMode).url

  val userAnswers = baseAnswers
    .set(WhatIsYourEmployersAddressPage(Index(0)), EmployersAddress("value 1", Some("value 2"), None, "postcode"))
    .success.value

  "WhatIsYourPreviousEmployersAddress Controller" - {

    "must return OK and the correct view for a GET" in {

      val application = applicationBuilder(userAnswers = Some(baseAnswers)).build()

      running(application) {
        val request = FakeRequest(GET, whatIsYourPreviousEmployersAddressRoute)

        val view = application.injector.instanceOf[WhatIsYourEmployersAddressView]

        val result = route(application, request).value

        status(result) mustEqual OK
        contentAsString(result) mustEqual view(form, Index(0), NormalMode, employerName)(request, messages(application)).toString
      }
    }

    "must populate the view correctly on a GET when the question has previously been answered" in {

      val application = applicationBuilder(userAnswers = Some(userAnswers)).build()

      running(application) {
        val request = FakeRequest(GET, whatIsYourPreviousEmployersAddressRoute)

        val view = application.injector.instanceOf[WhatIsYourEmployersAddressView]

        val result = route(application, request).value

        status(result) mustEqual OK
        contentAsString(result) mustEqual view(
          form.fill(EmployersAddress("value 1", Some("value 2"), None, "postcode")),
          Index(0),
          NormalMode,
          employerName
        )(request, messages(application)).toString
      }
    }

    "must redirect to the next page when valid data is submitted" in {

      val mockSessionRepository = mock[SessionRepository]

      when(mockSessionRepository.set(any())) thenReturn Future.successful(true)

      val application =
        applicationBuilder(userAnswers = Some(baseAnswers))
          .overrides(
            bind[Navigator].toInstance(new FakeNavigator(onwardRoute)),
            bind[SessionRepository].toInstance(mockSessionRepository)
          )
          .build()

      val validData = List(
        "addressLine1" -> "value 1", "addressLine2" -> "value 2", "postcode" -> "postcode",
        "from.day" -> LocalDate.now.getDayOfMonth.toString, "from.month" -> LocalDate.now.getMonthValue.toString, "from.year" -> LocalDate.now.getYear.toString,
        "to.day" -> LocalDate.now.getDayOfMonth.toString, "to.month" -> LocalDate.now.getMonthValue.toString, "to.year" -> LocalDate.now.getYear.toString
      )

      running(application) {
        val request =
          FakeRequest(POST, whatIsYourPreviousEmployersAddressRoute)
            .withFormUrlEncodedBody(validData: _*)

        val result = route(application, request).value

        status(result) mustEqual SEE_OTHER
        redirectLocation(result).value mustEqual onwardRoute.url
      }
    }

    "must return a Bad Request and errors when invalid data is submitted" in {

      val application = applicationBuilder(userAnswers = Some(baseAnswers)).build()

      running(application) {
        val request =
          FakeRequest(POST, whatIsYourPreviousEmployersAddressRoute)
            .withFormUrlEncodedBody(("value", "invalid value"))

        val boundForm = form.bind(Map("value" -> "invalid value"))

        val view = application.injector.instanceOf[WhatIsYourEmployersAddressView]

        val result = route(application, request).value

        status(result) mustEqual BAD_REQUEST
        contentAsString(result) mustEqual view(boundForm, Index(0), NormalMode, employerName)(request, messages(application)).toString
      }
    }

    "must redirect to Journey Recovery for a GET if no existing data is found" in {

      val application = applicationBuilder(userAnswers = None).build()

      running(application) {
        val request = FakeRequest(GET, whatIsYourPreviousEmployersAddressRoute)

        val result = route(application, request).value

        status(result) mustEqual SEE_OTHER
        redirectLocation(result).value mustEqual routes.JourneyRecoveryController.onPageLoad().url
      }
    }

    "must redirect to Journey Recovery for a POST if no existing data is found" in {

      val application = applicationBuilder(userAnswers = None).build()

      running(application) {
        val request =
          FakeRequest(POST, whatIsYourPreviousEmployersAddressRoute)
            .withFormUrlEncodedBody(("addressLine1", "value 1"), ("addressLine2", "value 2"))

        val result = route(application, request).value

        status(result) mustEqual SEE_OTHER
        redirectLocation(result).value mustEqual routes.JourneyRecoveryController.onPageLoad().url
      }
    }
  }
}
