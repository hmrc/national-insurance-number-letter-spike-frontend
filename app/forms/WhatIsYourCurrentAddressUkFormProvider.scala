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

import javax.inject.Inject

import forms.mappings.Mappings
import play.api.data.Form
import play.api.data.Forms._
import models.CurrentAddressUk

class WhatIsYourCurrentAddressUkFormProvider @Inject() extends Mappings {

   def apply(): Form[CurrentAddressUk] = Form(
     mapping(
       "addressLine1" -> text("whatIsYourCurrentAddressUk.error.addressLine1.required")
         .verifying(maxLength(100, "whatIsYourCurrentAddressUk.error.addressLine1.length")),
       "addressLine2" -> optional(text("whatIsYourCurrentAddressUk.error.addressLine2.required")
         .verifying(maxLength(100, "whatIsYourCurrentAddressUk.error.addressLine2.length"))),
       "addressLine3" -> text("whatIsYourCurrentAddressUk.error.addressLine3.required")
         .verifying(maxLength(100, "whatIsYourCurrentAddressUk.error.addressLine3.length")),
       "postcode" -> text("whatIsYourCurrentAddressUk.error.postcode.required")
         .verifying(maxLength(100, "whatIsYourCurrentAddressUk.error.postcode.length"))
    )(
       (line1, line2, line3, postcode) => CurrentAddressUk.apply(line1, line2, Some(line3), postcode)
     )(
       // Temporary until model can be updated to enforce town or city as mandatory
       addr => addr.addressLine3 match {
         case Some(line3) => Some((addr.addressLine1, addr.addressLine2, line3, addr.postcode))
         case None => Some((addr.addressLine1, None, addr.addressLine2.getOrElse(""), addr.postcode))
       }
     )
   )
 }
