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

import models._
import org.scalacheck.Arbitrary
import org.scalacheck.Arbitrary.arbitrary
import pages._
import play.api.libs.json.{JsValue, Json}

trait UserAnswersEntryGenerators extends PageGenerators with ModelGenerators { this: Generators =>

  implicit lazy val arbitraryPreviousRelationshipTypeUserAnswersEntry: Arbitrary[(PreviousRelationshipTypePage, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[PreviousRelationshipTypePage]
        value <- arbitrary[PreviousRelationshipType].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryCurrentRelationshipTypeUserAnswersEntry: Arbitrary[(CurrentRelationshipTypePage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[CurrentRelationshipTypePage.type]
        value <- arbitrary[CurrentRelationshipType].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhatIsYourGenderUserAnswersEntry: Arbitrary[(WhatIsYourGenderPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhatIsYourGenderPage.type]
        value <- arbitrary[WhatIsYourGender].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryAreYouSureYouWantToRemovePreviousRelationshipUserAnswersEntry: Arbitrary[(AreYouSureYouWantToRemovePreviousRelationshipPage, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[AreYouSureYouWantToRemovePreviousRelationshipPage]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryAreYouSureYouWantToRemovePreviousNameUserAnswersEntry: Arbitrary[(AreYouSureYouWantToRemovePreviousNamePage, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[AreYouSureYouWantToRemovePreviousNamePage]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryAreYouSureYouWantToRemovePreviousEmployerUserAnswersEntry: Arbitrary[(AreYouSureYouWantToRemovePreviousEmployerPage, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[AreYouSureYouWantToRemovePreviousEmployerPage]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryAreYouSureYouWantToRemovePreviousAddressUserAnswersEntry: Arbitrary[(AreYouSureYouWantToRemovePreviousAddressPage, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[AreYouSureYouWantToRemovePreviousAddressPage]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhichAlternativeDocumentsUserAnswersEntry: Arbitrary[(WhichAlternativeDocumentsPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhichAlternativeDocumentsPage.type]
        value <- arbitrary[AlternativeDocuments].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryAreYouStillEmployedUserAnswersEntry: Arbitrary[(AreYouStillEmployedPage, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[AreYouStillEmployedPage]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryDoYouKnowYourNationalInsuranceNumberUserAnswersEntry: Arbitrary[(DoYouKnowYourNationalInsuranceNumberPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[DoYouKnowYourNationalInsuranceNumberPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhichPrimaryDocumentUserAnswersEntry: Arbitrary[(WhichPrimaryDocumentPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhichPrimaryDocumentPage.type]
        value <- arbitrary[PrimaryDocument].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryDoYouHaveTwoSecondaryDocumentsUserAnswersEntry: Arbitrary[(DoYouHaveTwoSecondaryDocumentsPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[DoYouHaveTwoSecondaryDocumentsPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryDoYouHavePrimaryDocumentUserAnswersEntry: Arbitrary[(DoYouHavePrimaryDocumentPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[DoYouHavePrimaryDocumentPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhenDidYouStopWorkingForPreviousEmployerUserAnswersEntry: Arbitrary[(WhenDidYouStopWorkingForEmployerPage, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhenDidYouStopWorkingForEmployerPage]
        value <- arbitrary[Int].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhenDidYouStartWorkingForPreviousEmployerUserAnswersEntry: Arbitrary[(WhenDidYouStartWorkingForEmployerPage, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhenDidYouStartWorkingForEmployerPage]
        value <- arbitrary[Int].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhatIsYourPreviousEmployersNameUserAnswersEntry: Arbitrary[(WhatIsYourEmployersNamePage, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhatIsYourEmployersNamePage]
        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhatIsYourPreviousEmployersAddressUserAnswersEntry: Arbitrary[(WhatIsYourEmployersAddressPage, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhatIsYourEmployersAddressPage]
        value <- arbitrary[EmployersAddress].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryHaveYouEverWorkedInUkUserAnswersEntry: Arbitrary[(HaveYouEverWorkedInUkPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[HaveYouEverWorkedInUkPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryEmploymentHistoryUserAnswersEntry: Arbitrary[(EmploymentHistoryPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[EmploymentHistoryPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhatOtherUkBenefitsHaveYouReceivedUserAnswersEntry: Arbitrary[(WhatOtherUkBenefitsHaveYouReceivedPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhatOtherUkBenefitsHaveYouReceivedPage.type]
        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryHaveYouEverReceivedOtherUkBenefitsUserAnswersEntry: Arbitrary[(HaveYouEverReceivedOtherUkBenefitsPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[HaveYouEverReceivedOtherUkBenefitsPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhatIsYourChildBenefitNumberUserAnswersEntry: Arbitrary[(WhatIsYourChildBenefitNumberPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhatIsYourChildBenefitNumberPage.type]
        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryHaveYouEverClaimedChildBenefitUserAnswersEntry: Arbitrary[(HaveYouEverClaimedChildBenefitPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[HaveYouEverClaimedChildBenefitPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryDoYouKnowYourChildBenefitNumberUserAnswersEntry: Arbitrary[(DoYouKnowYourChildBenefitNumberPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[DoYouKnowYourChildBenefitNumberPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryPreviousMarriageOrPartnershipDetailsUserAnswersEntry: Arbitrary[(PreviousMarriageOrPartnershipDetailsPage, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[PreviousMarriageOrPartnershipDetailsPage]
        value <- arbitrary[PreviousMarriageOrPartnershipDetails].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryHaveYouPreviouslyBeenInAMarriageOrCivilPartnershipUserAnswersEntry: Arbitrary[(HaveYouPreviouslyBeenInAMarriageOrCivilPartnershipPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[HaveYouPreviouslyBeenInAMarriageOrCivilPartnershipPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhenDidYouGetMarriedUserAnswersEntry: Arbitrary[(WhenDidYouGetMarriedPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhenDidYouGetMarriedPage.type]
        value <- arbitrary[Int].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryAreYouMarriedUserAnswersEntry: Arbitrary[(AreYouMarriedPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[AreYouMarriedPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhatIsYourTelephoneNumberUserAnswersEntry: Arbitrary[(WhatIsYourTelephoneNumberPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhatIsYourTelephoneNumberPage.type]
        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhatIsYourNationalInsuranceNumberUserAnswersEntry: Arbitrary[(WhatIsYourNationalInsuranceNumberPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhatIsYourNationalInsuranceNumberPage.type]
        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryAreYouReturningFromLivingAbroadUserAnswersEntry: Arbitrary[(AreYouReturningFromLivingAbroadPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[AreYouReturningFromLivingAbroadPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhatIsYourPreviousAddressUkUserAnswersEntry: Arbitrary[(WhatIsYourPreviousAddressUkPage, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhatIsYourPreviousAddressUkPage]
        value <- arbitrary[PreviousAddressUk].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhatIsYourPreviousAddressInternationalUserAnswersEntry: Arbitrary[(WhatIsYourPreviousAddressInternationalPage, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhatIsYourPreviousAddressInternationalPage]
        value <- arbitrary[PreviousAddressInternational].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryIsYourPreviousAddressInUkUserAnswersEntry: Arbitrary[(IsYourPreviousAddressInUkPage, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[IsYourPreviousAddressInUkPage]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryDoYouHaveAnyPreviousAddressesUserAnswersEntry: Arbitrary[(DoYouHaveAnyPreviousAddressesPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[DoYouHaveAnyPreviousAddressesPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhatIsYourCurrentAddressUkUserAnswersEntry: Arbitrary[(WhatIsYourCurrentAddressUkPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhatIsYourCurrentAddressUkPage.type]
        value <- arbitrary[CurrentAddressUk].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhatIsYourCurrentAddressInternationalUserAnswersEntry: Arbitrary[(WhatIsYourCurrentAddressInternationalPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhatIsYourCurrentAddressInternationalPage.type]
        value <- arbitrary[CurrentAddressInternational].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryIsYourCurrentAddressInUkUserAnswersEntry: Arbitrary[(IsYourCurrentAddressInUkPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[IsYourCurrentAddressInUkPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhatIsYourDateOfBirthUserAnswersEntry: Arbitrary[(WhatIsYourDateOfBirthPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhatIsYourDateOfBirthPage.type]
        value <- arbitrary[Int].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhatIsYourPreviousNameUserAnswersEntry: Arbitrary[(WhatIsYourPreviousNamePage, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhatIsYourPreviousNamePage]
        value <- arbitrary[WhatIsYourPreviousName].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryDoYouHaveAPreviousNameUserAnswersEntry: Arbitrary[(DoYouHaveAPreviousNamePage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[DoYouHaveAPreviousNamePage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryWhatIsYourNameUserAnswersEntry: Arbitrary[(WhatIsYourNamePage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[WhatIsYourNamePage.type]
        value <- arbitrary[WhatIsYourName].map(Json.toJson(_))
      } yield (page, value)
    }
}
