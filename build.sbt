name := """test-web"""
organization := "example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.15"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test
libraryDependencies += jdbc
libraryDependencies += "com.mysql" % "mysql-connector-j" % "8.0.33"

// sqlite version
// libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.47.1.0"

