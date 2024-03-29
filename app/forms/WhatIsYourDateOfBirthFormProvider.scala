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

import java.time.{Clock, LocalDate}
import forms.mappings.Mappings

import javax.inject.Inject
import play.api.data.Form

import java.time.format.DateTimeFormatter

class WhatIsYourDateOfBirthFormProvider @Inject()(clock: Clock) extends Mappings {

  val minDate: LocalDate = LocalDate.now(clock).minusYears(130)
  val maxDate: LocalDate = LocalDate.now(clock).minusYears(15).minusMonths(9)
  private def dateFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy")

  def apply(): Form[LocalDate] =
    Form(
      "value" -> localDate(
        invalidKey     = "whatIsYourDateOfBirth.error.invalid",
        allRequiredKey = "whatIsYourDateOfBirth.error.required.all",
        twoRequiredKey = "whatIsYourDateOfBirth.error.required.two",
        requiredKey    = "whatIsYourDateOfBirth.error.required"
      ).verifying(
        maxDate(maxDate, "whatIsYourDateOfBirth.error.afterMaximum", maxDate.format(dateFormatter)),
        minDate(minDate, "whatIsYourDateOfBirth.error.beforeMinimum", minDate.format(dateFormatter))
      )
    )
}
