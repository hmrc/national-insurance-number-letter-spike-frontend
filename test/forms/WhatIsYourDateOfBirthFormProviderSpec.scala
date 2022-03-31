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

package forms

import forms.behaviours.DateBehaviours
import play.api.data.FormError

import java.time.LocalDate

class WhatIsYourDateOfBirthFormProviderSpec extends DateBehaviours {

  val form = new WhatIsYourDateOfBirthFormProvider()()

  ".value" - {

    val validData = datesBetween(
      min = LocalDate.of(1900, 1, 1),
      max = LocalDate.now().minusDays(1)
    )

    behave like dateField(form, "value", validData)

    behave like dateFieldWithMax(form, "value", LocalDate.now().minusDays(1), FormError("value", "whatIsYourDateOfBirth.error.beforeToday"))

    behave like mandatoryDateField(form, "value", "whatIsYourDateOfBirth.error.required.all")
  }
}
