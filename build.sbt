import sbt.Tests.{Group, SubProcess}
import sbt.inConfig

lazy val scala211 = "2.11.12"
lazy val scala212 = "2.12.10"

ThisBuild / organization := "com.example"
//ThisBuild / scalaVersion := scala211

lazy val root = (project in file("."))
  .aggregate(project211, project212, common)
  .settings(
    name := "sbt-scala-versions",
    crossScalaVersions := Nil
  )

lazy val project211 = (project in file("project211"))
  .dependsOn(common)
  .settings(
    scalaVersion := scala211
  )

lazy val project212 = (project in file("project212"))
  .dependsOn(common)
  .settings(
    scalaVersion := scala212
  )

lazy val common = (project in file("common")).settings(
  crossScalaVersions := Seq(scala211, scala212)
)

ThisBuild / libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test
