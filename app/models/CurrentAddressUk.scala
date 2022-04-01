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

package models

import play.api.libs.json._

final case class CurrentAddressUk(
                                   addressLine1: String,
                                   addressLine2: Option[String],
                                   addressLine3: Option[String],
                                   postcode: String
                                 ) {

  def lines: List[String] =
    List(Some(addressLine1), addressLine2, addressLine3, Some(postcode)).flatten

}

object CurrentAddressUk {
  implicit val format = Json.format[CurrentAddressUk]
}
