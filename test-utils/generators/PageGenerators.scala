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

package generators

import models.Index
import org.scalacheck.Arbitrary
import pages._

trait PageGenerators {

  implicit lazy val arbitraryPreviousRelationshipTypePage: Arbitrary[PreviousRelationshipTypePage] =
    Arbitrary(PreviousRelationshipTypePage(Index(0)))

  implicit lazy val arbitraryCurrentRelationshipTypePage: Arbitrary[CurrentRelationshipTypePage.type] =
    Arbitrary(CurrentRelationshipTypePage)

  implicit lazy val arbitraryWhatIsYourGenderPage: Arbitrary[WhatIsYourGenderPage.type] =
    Arbitrary(WhatIsYourGenderPage)

  implicit lazy val arbitraryAreYouSureYouWantToRemovePreviousRelationshipPage: Arbitrary[AreYouSureYouWantToRemovePreviousRelationshipPage] =
    Arbitrary(AreYouSureYouWantToRemovePreviousRelationshipPage(Index(0)))

  implicit lazy val arbitraryAreYouSureYouWantToRemovePreviousNamePage: Arbitrary[AreYouSureYouWantToRemovePreviousNamePage] =
    Arbitrary(AreYouSureYouWantToRemovePreviousNamePage(Index(0)))

  implicit lazy val arbitraryAreYouSureYouWantToRemovePreviousEmployerPage: Arbitrary[AreYouSureYouWantToRemovePreviousEmployerPage] =
    Arbitrary(AreYouSureYouWantToRemovePreviousEmployerPage(Index(0)))

  implicit lazy val arbitraryAreYouSureYouWantToRemovePreviousAddressPage: Arbitrary[AreYouSureYouWantToRemovePreviousAddressPage] =
    Arbitrary(AreYouSureYouWantToRemovePreviousAddressPage(Index(0)))

  implicit lazy val arbitraryWhichAlternativeDocumentsPage: Arbitrary[WhichAlternativeDocumentsPage.type] =
    Arbitrary(WhichAlternativeDocumentsPage)

  implicit lazy val arbitraryAreYouStillEmployedPage: Arbitrary[AreYouStillEmployedPage] =
    Arbitrary(AreYouStillEmployedPage(Index(0)))

  implicit lazy val arbitraryDoYouKnowYourNationalInsuranceNumberPage: Arbitrary[DoYouKnowYourNationalInsuranceNumberPage.type] =
    Arbitrary(DoYouKnowYourNationalInsuranceNumberPage)

  implicit lazy val arbitraryWhichPrimaryDocumentPage: Arbitrary[WhichPrimaryDocumentPage.type] =
    Arbitrary(WhichPrimaryDocumentPage)

  implicit lazy val arbitraryDoYouHaveTwoSecondaryDocumentsPage: Arbitrary[DoYouHaveTwoSecondaryDocumentsPage.type] =
    Arbitrary(DoYouHaveTwoSecondaryDocumentsPage)

  implicit lazy val arbitraryDoYouHavePrimaryDocumentPage: Arbitrary[DoYouHavePrimaryDocumentPage.type] =
    Arbitrary(DoYouHavePrimaryDocumentPage)

  implicit lazy val arbitraryWhenDidYouStopWorkingForPreviousEmployerPage: Arbitrary[WhenDidYouStopWorkingForEmployerPage] =
    Arbitrary(WhenDidYouStopWorkingForEmployerPage(Index(0)))

  implicit lazy val arbitraryWhenDidYouStartWorkingForPreviousEmployerPage: Arbitrary[WhenDidYouStartWorkingForEmployerPage] =
    Arbitrary(WhenDidYouStartWorkingForEmployerPage(Index(0)))

  implicit lazy val arbitraryWhatIsYourPreviousEmployersNamePage: Arbitrary[WhatIsYourEmployersNamePage] =
    Arbitrary(WhatIsYourEmployersNamePage(Index(0)))

  implicit lazy val arbitraryWhatIsYourPreviousEmployersAddressPage: Arbitrary[WhatIsYourEmployersAddressPage] =
    Arbitrary(WhatIsYourEmployersAddressPage(Index(0)))

  implicit lazy val arbitraryHaveYouEverWorkedInUkPage: Arbitrary[HaveYouEverWorkedInUkPage.type] =
    Arbitrary(HaveYouEverWorkedInUkPage)

  implicit lazy val arbitraryEmploymentHistoryPage: Arbitrary[EmploymentHistoryPage.type] =
    Arbitrary(EmploymentHistoryPage)

  implicit lazy val arbitraryWhatOtherUkBenefitsHaveYouReceivedPage: Arbitrary[WhatOtherUkBenefitsHaveYouReceivedPage.type] =
    Arbitrary(WhatOtherUkBenefitsHaveYouReceivedPage)

  implicit lazy val arbitraryHaveYouEverReceivedOtherUkBenefitsPage: Arbitrary[HaveYouEverReceivedOtherUkBenefitsPage.type] =
    Arbitrary(HaveYouEverReceivedOtherUkBenefitsPage)

  implicit lazy val arbitraryWhatIsYourChildBenefitNumberPage: Arbitrary[WhatIsYourChildBenefitNumberPage.type] =
    Arbitrary(WhatIsYourChildBenefitNumberPage)

  implicit lazy val arbitraryHaveYouEverClaimedChildBenefitPage: Arbitrary[HaveYouEverClaimedChildBenefitPage.type] =
    Arbitrary(HaveYouEverClaimedChildBenefitPage)

  implicit lazy val arbitraryDoYouKnowYourChildBenefitNumberPage: Arbitrary[DoYouKnowYourChildBenefitNumberPage.type] =
    Arbitrary(DoYouKnowYourChildBenefitNumberPage)

  implicit lazy val arbitraryPreviousMarriageOrPartnershipDetailsPage: Arbitrary[PreviousMarriageOrPartnershipDetailsPage] =
    Arbitrary(PreviousMarriageOrPartnershipDetailsPage(Index(0)))

  implicit lazy val arbitraryHaveYouPreviouslyBeenInAMarriageOrCivilPartnershipPage: Arbitrary[HaveYouPreviouslyBeenInAMarriageOrCivilPartnershipPage.type] =
    Arbitrary(HaveYouPreviouslyBeenInAMarriageOrCivilPartnershipPage)

  implicit lazy val arbitraryWhenDidYouGetMarriedPage: Arbitrary[WhenDidYouGetMarriedPage.type] =
    Arbitrary(WhenDidYouGetMarriedPage)

  implicit lazy val arbitraryAreYouMarriedPage: Arbitrary[AreYouMarriedPage.type] =
    Arbitrary(AreYouMarriedPage)

  implicit lazy val arbitraryWhatIsYourTelephoneNumberPage: Arbitrary[WhatIsYourTelephoneNumberPage.type] =
    Arbitrary(WhatIsYourTelephoneNumberPage)

  implicit lazy val arbitraryWhatIsYourNationalInsuranceNumberPage: Arbitrary[WhatIsYourNationalInsuranceNumberPage.type] =
    Arbitrary(WhatIsYourNationalInsuranceNumberPage)

  implicit lazy val arbitraryAreYouReturningFromLivingAbroadPage: Arbitrary[AreYouReturningFromLivingAbroadPage.type] =
    Arbitrary(AreYouReturningFromLivingAbroadPage)

  implicit lazy val arbitraryWhatIsYourPreviousAddressUkPage: Arbitrary[WhatIsYourPreviousAddressUkPage] =
    Arbitrary(WhatIsYourPreviousAddressUkPage(Index(0)))

  implicit lazy val arbitraryWhatIsYourPreviousAddressInternationalPage: Arbitrary[WhatIsYourPreviousAddressInternationalPage] =
    Arbitrary(WhatIsYourPreviousAddressInternationalPage(Index(0)))

  implicit lazy val arbitraryIsYourPreviousAddressInUkPage: Arbitrary[IsYourPreviousAddressInUkPage] =
    Arbitrary(IsYourPreviousAddressInUkPage(Index(0)))

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

  implicit lazy val arbitraryWhatIsYourPreviousNamePage: Arbitrary[WhatIsYourPreviousNamePage] =
    Arbitrary(WhatIsYourPreviousNamePage(Index(0)))

  implicit lazy val arbitraryDoYouHaveAPreviousNamePage: Arbitrary[DoYouHaveAPreviousNamePage.type] =
    Arbitrary(DoYouHaveAPreviousNamePage)

  implicit lazy val arbitraryWhatIsYourNamePage: Arbitrary[WhatIsYourNamePage.type] =
    Arbitrary(WhatIsYourNamePage)
}
