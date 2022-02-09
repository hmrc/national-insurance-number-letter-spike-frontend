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

package generators

import org.scalacheck.Arbitrary
import pages._

trait PageGenerators {

  implicit lazy val arbitraryWhatIsYourChildBenefitNumberPage: Arbitrary[WhatIsYourChildBenefitNumberPage.type] =
    Arbitrary(WhatIsYourChildBenefitNumberPage)

  implicit lazy val arbitraryHaveYouEverClaimedChildBenefitPage: Arbitrary[HaveYouEverClaimedChildBenefitPage.type] =
    Arbitrary(HaveYouEverClaimedChildBenefitPage)

  implicit lazy val arbitraryDoYouKnowYourChildBenefitNumberPage: Arbitrary[DoYouKnowYourChildBenefitNumberPage.type] =
    Arbitrary(DoYouKnowYourChildBenefitNumberPage)

  implicit lazy val arbitraryPreviousMarriageOrPartnershipDetailsPage: Arbitrary[PreviousMarriageOrPartnershipDetailsPage.type] =
    Arbitrary(PreviousMarriageOrPartnershipDetailsPage)

  implicit lazy val arbitraryHaveYouPreviouslyBeenInAMarriageOrCivilPartnershipPage: Arbitrary[HaveYouPreviouslyBeenInAMarriageOrCivilPartnershipPage.type] =
    Arbitrary(HaveYouPreviouslyBeenInAMarriageOrCivilPartnershipPage)

  implicit lazy val arbitraryWhenDidYouGetMarriedPage: Arbitrary[WhenDidYouGetMarriedPage.type] =
    Arbitrary(WhenDidYouGetMarriedPage)

  implicit lazy val arbitraryWhenDidYouEnterACivilPartnershipPage: Arbitrary[WhenDidYouEnterACivilPartnershipPage.type] =
    Arbitrary(WhenDidYouEnterACivilPartnershipPage)

  implicit lazy val arbitraryAreYouMarriedPage: Arbitrary[AreYouMarriedPage.type] =
    Arbitrary(AreYouMarriedPage)

  implicit lazy val arbitraryAreYouInACivilPartnershipPage: Arbitrary[AreYouInACivilPartnershipPage.type] =
    Arbitrary(AreYouInACivilPartnershipPage)

  implicit lazy val arbitraryWhatIsYourTelephoneNumberPage: Arbitrary[WhatIsYourTelephoneNumberPage.type] =
    Arbitrary(WhatIsYourTelephoneNumberPage)

  implicit lazy val arbitraryWhatIsYourNationalInsuranceNumberPage: Arbitrary[WhatIsYourNationalInsuranceNumberPage.type] =
    Arbitrary(WhatIsYourNationalInsuranceNumberPage)

  implicit lazy val arbitraryAreYouReturningFromLivingAbroadPage: Arbitrary[AreYouReturningFromLivingAbroadPage.type] =
    Arbitrary(AreYouReturningFromLivingAbroadPage)

  implicit lazy val arbitraryWhatIsYourPreviousAddressUkPage: Arbitrary[WhatIsYourPreviousAddressUkPage.type] =
    Arbitrary(WhatIsYourPreviousAddressUkPage)

  implicit lazy val arbitraryWhatIsYourPreviousAddressInternationalPage: Arbitrary[WhatIsYourPreviousAddressInternationalPage.type] =
    Arbitrary(WhatIsYourPreviousAddressInternationalPage)

  implicit lazy val arbitraryIsYourPreviousAddressInUkPage: Arbitrary[IsYourPreviousAddressInUkPage.type] =
    Arbitrary(IsYourPreviousAddressInUkPage)

  implicit lazy val arbitraryDoYouHaveAnyPreviousAddressesPage: Arbitrary[DoYouHaveAnyPreviousAddressesPage.type] =
    Arbitrary(DoYouHaveAnyPreviousAddressesPage)

  implicit lazy val arbitraryWhatIsYourCurrentAddressUkPage: Arbitrary[WhatIsYourCurrentAddressUkPage.type] =
    Arbitrary(WhatIsYourCurrentAddressUkPage)

  implicit lazy val arbitraryWhatIsYourCurrentAddressInternationalPage: Arbitrary[WhatIsYourCurrentAddressInternationalPage.type] =
    Arbitrary(WhatIsYourCurrentAddressInternationalPage)

  implicit lazy val arbitraryIsYourCurrentAddressInUkPage: Arbitrary[IsYourCurrentAddressInUkPage.type] =
    Arbitrary(IsYourCurrentAddressInUkPage)

  implicit lazy val arbitraryWhatIsYourDateOfBirthPage: Arbitrary[WhatIsYourDateOfBirthPage.type] =
    Arbitrary(WhatIsYourDateOfBirthPage)

  implicit lazy val arbitraryWhatIsYourPreviousNamePage: Arbitrary[WhatIsYourPreviousNamePage.type] =
    Arbitrary(WhatIsYourPreviousNamePage)

  implicit lazy val arbitraryDoYouHaveAPreviousNamePage: Arbitrary[DoYouHaveAPreviousNamePage.type] =
    Arbitrary(DoYouHaveAPreviousNamePage)

  implicit lazy val arbitraryWhatIsYourNamePage: Arbitrary[WhatIsYourNamePage.type] =
    Arbitrary(WhatIsYourNamePage)
}
