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

package viewmodels.checkAnswers

import controllers.routes
import models.{CheckMode, UserAnswers}
import pages.WhatIsYourPreviousNamePage
import play.api.i18n.Messages
import play.twirl.api.HtmlFormat
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.HtmlContent
import uk.gov.hmrc.govukfrontend.views.viewmodels.summarylist.SummaryListRow
import viewmodels.govuk.summarylist._
import viewmodels.implicits._

object WhatIsYourPreviousNameSummary  {

  //TODO: Fix summary row
  def row(answers: UserAnswers)(implicit messages: Messages): Option[SummaryListRow] = None
//    answers.get(WhatIsYourPreviousNamePage).map {
//      answer =>
//
//        val value = List(Some(answer.firstName), answer.middleNames, Some(answer.lastName))
//          .flatten.map(HtmlFormat.escape(_).toString)
//          .mkString("<br/>")
//
//        SummaryListRowViewModel(
//          key     = "whatIsYourPreviousName.checkYourAnswersLabel",
//          value   = ValueViewModel(HtmlContent(value)),
//          actions = Seq(
//            ActionItemViewModel("site.change", routes.WhatIsYourPreviousNameController.onPageLoad(CheckMode).url)
//              .withVisuallyHiddenText(messages("whatIsYourPreviousName.change.hidden"))
//          )
//        )
//    }
}
