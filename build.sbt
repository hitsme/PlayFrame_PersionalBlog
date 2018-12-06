import play.sbt.PlayImport

name := "PlayFrame_PersionalBlog"
 
version := "1.0" 
      
lazy val `playframe_persionalblog` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.2"


unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

libraryDependencies += evolutions
libraryDependencies ++= Seq(
 // jdbc,

  ws,
  guice,
  specs2 % Test,
  "mysql" % "mysql-connector-java" % "5.1.34",
  "com.typesafe.play" %% "play-slick" % "3.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "3.0.0"

)
// enable Play cache API (based on your Play version)
libraryDependencies += play.sbt.PlayImport.cacheApi
// include play-redis library
//libraryDependencies += "com.github.karelcemus" %% "play-redis" % "2.3.0"
//libraryDependencies += ehcache
//libraryDependencies += "com.github.karelcemus" %% "play-redis" % "2.3.0"

libraryDependencies ++= Seq(
  // play framework cache API
  "com.github.karelcemus" %% "play-redis" % "2.3.0",
  // runtime DI
  PlayImport.guice,
  // runtime DI
  PlayImport.cacheApi
)
//libraryDependencies +="jp.co.bizreach" %% "play-modules-redis" % "2.6.0"
routesGenerator := InjectedRoutesGenerator
