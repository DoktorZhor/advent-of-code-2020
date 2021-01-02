lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.13.3"
    )),
    name := "scalatest-example",
    scalacOptions ++= commonOptions
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test

val commonOptions = Seq(
"-deprecation",
"-explaintypes",
"-feature",
"-unchecked",
"-Xfatal-warnings",
"-Xlint:_,-type-parameter-shadow,inaccessible,unused,infer-any,nullary-unit",
"-Yrangepos",
"-Ywarn-numeric-widen",
"-Ywarn-value-discard"
)
