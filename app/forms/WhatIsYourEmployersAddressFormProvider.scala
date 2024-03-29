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

import forms.mappings.Mappings
import models.EmployersAddress
import play.api.data.Form
import play.api.data.Forms._

import javax.inject.Inject

class WhatIsYourEmployersAddressFormProvider @Inject() extends Mappings {

   def apply(): Form[EmployersAddress] = Form(
     mapping(
       "addressLine1" -> text("whatIsYourEmployersAddress.error.addressLine1.required")
         .verifying(maxLength(100, "whatIsYourEmployersAddress.error.addressLine1.length")),
       "addressLine2" -> optional(text("whatIsYourEmployersAddress.error.addressLine2.required")
         .verifying(maxLength(100, "whatIsYourEmployersAddress.error.addressLine2.length"))),
       "addressLine3" -> optional(text("whatIsYourEmployersAddress.error.addressLine3.required")
         .verifying(maxLength(100, "whatIsYourEmployersAddress.error.addressLine3.length"))),
       "postcode" -> text("whatIsYourEmployersAddress.error.postcode.required")
         .verifying(maxLength(100, "whatIsYourEmployersAddress.error.postcode.length"))
    )(EmployersAddress.apply)(EmployersAddress.unapply)
   )
 }
