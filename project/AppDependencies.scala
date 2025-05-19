import sbt._

object AppDependencies {

  private val bootstrapVersion = "9.12.0"
  private val hmrcMongoVersion = "2.6.0"

  val compile: Seq[ModuleID] = Seq(
    play.sbt.PlayImport.ws,
    "uk.gov.hmrc"                   %% "play-frontend-hmrc-play-30"             % "12.1.0",
    "uk.gov.hmrc"                   %% "play-conditional-form-mapping-play-30"  % "3.3.0",
    "uk.gov.hmrc"                   %% "bootstrap-frontend-play-30"             % bootstrapVersion,
    "uk.gov.hmrc.mongo"             %% "hmrc-mongo-play-30"                     % hmrcMongoVersion,
    "uk.gov.hmrc"                   %% "domain-play-30"                         % "9.0.0",
    "org.typelevel"                 %% "cats-core"                              % "2.3.0",
    "org.apache.xmlgraphics"        %  "fop"                                    % "2.7",
    "com.googlecode.libphonenumber" %  "libphonenumber"                         % "8.12.47"
  )

  val test: Seq[ModuleID] = Seq(
    "uk.gov.hmrc"             %% "bootstrap-test-play-30"  % bootstrapVersion,
    "org.scalatestplus"       %% "scalacheck-1-17"         % "3.2.17.0",
    "uk.gov.hmrc.mongo"       %% "hmrc-mongo-test-play-30" % hmrcMongoVersion
  ).map(_ % Test)

  val integration: Seq[ModuleID] = Seq.empty

  def apply(): Seq[ModuleID] = compile ++ test
}