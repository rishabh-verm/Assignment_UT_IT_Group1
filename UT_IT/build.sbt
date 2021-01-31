name := "UT_IT"

version := "0.1"

scalaVersion := "2.13.4"

/* Creating a module for question1 and question2 then providing testing dependencies */
lazy val Assignment_1_2 = project.in(file("Assignment_1_2"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.3" % Test,
      "org.mockito" %% "mockito-scala" % "1.5.12" % Test
    )
  )

/* Creating a module for question3 then providing testing dependencies  */
lazy val Assignment_3 = project.in(file("Assignment_3"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.3" % Test,
      "org.mockito" %% "mockito-scala" % "1.5.12" % Test
    )
  )

lazy val root = project.in(file(".")).aggregate(Assignment_1_2, Assignment_3)