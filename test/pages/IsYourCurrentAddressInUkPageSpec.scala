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

package pages

import models.{Country, CurrentAddressInternational, CurrentAddressUk, UserAnswers}
import org.scalatest.{OptionValues, TryValues}
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

class IsYourCurrentAddressInUkPageSpec extends AnyFreeSpec with Matchers with OptionValues with TryValues {

  "IsYourCurrentAddressInUkPage" - {

    "must remove international address when true" in {
      val answers = UserAnswers("id")
        .set(WhatIsYourCurrentAddressUkPage, CurrentAddressUk("line 1", None, None, "AA1 1AA")).get
        .set(WhatIsYourCurrentAddressInternationalPage, CurrentAddressInternational("line 1", None, None, None, Country("FR", "France"))).get

      val result = answers.set(IsYourCurrentAddressInUkPage, true).success.value

      result.get(WhatIsYourCurrentAddressUkPage).value mustBe CurrentAddressUk("line 1", None, None, "AA1 1AA")
      result.get(WhatIsYourCurrentAddressInternationalPage) must not be defined
    }

    "must remove uk address when false" in {
      val answers = UserAnswers("id")
        .set(WhatIsYourCurrentAddressUkPage, CurrentAddressUk("line 1", None, None, "AA1 1AA")).get
        .set(WhatIsYourCurrentAddressInternationalPage, CurrentAddressInternational("line 1", None, None, None, Country("FR", "France"))).get

      val result = answers.set(IsYourCurrentAddressInUkPage, false).success.value

      result.get(WhatIsYourCurrentAddressInternationalPage).value mustBe CurrentAddressInternational("line 1", None, None, None, Country("FR", "France"))
      result.get(WhatIsYourCurrentAddressUkPage) must not be defined
    }
  }
}
