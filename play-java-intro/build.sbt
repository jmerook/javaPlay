name := """play-java-intro"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

libraryDependencies ++= Seq(
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "4.3.11.Final"
)
libraryDependencies += "org.postgresql" % "postgresql" % "9.3-1103-jdbc4"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }
fork in run := true


fork in run := true