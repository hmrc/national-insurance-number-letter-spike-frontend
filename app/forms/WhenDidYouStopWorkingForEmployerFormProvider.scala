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

package forms

import java.time.LocalDate
import forms.mappings.Mappings

import javax.inject.Inject
import play.api.data.Form

import java.time.format.DateTimeFormatter

class WhenDidYouStopWorkingForEmployerFormProvider @Inject() extends Mappings {

  private def dateFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy")

  def apply(startDate: LocalDate): Form[LocalDate] =
    Form(
      "value" -> localDate(
        invalidKey     = "whenDidYouStopWorkingForEmployer.error.invalid",
        allRequiredKey = "whenDidYouStopWorkingForEmployer.error.required.all",
        twoRequiredKey = "whenDidYouStopWorkingForEmployer.error.required.two",
        requiredKey    = "whenDidYouStopWorkingForEmployer.error.required"
      ).verifying(minDate(
        minimum  = startDate,
        errorKey = "whenDidYouStopWorkingForEmployer.error.tooEarly",
        args     = startDate.format(dateFormatter)
      ))
    )
}
