package org.virtuslab.ideprobe.protocol

import java.nio.file.Path

import org.virtuslab.ideprobe.jsonrpc.JsonRpc.Method.Notification
import org.virtuslab.ideprobe.jsonrpc.JsonRpc.Method.Request
import org.virtuslab.ideprobe.jsonrpc.PayloadJsonFormat._
import pureconfig.generic.auto._

import scala.concurrent.duration.Duration

object Endpoints {

  // commands
  val PreconfigureJDK = Request[Unit, Unit]("jdk/preconfigure")
  val AwaitIdle = Request[Unit, Unit]("awaitIdle")
  val AwaitNotification = Request[(String, Duration), IdeNotification]("notification/await")
  val Build = Request[BuildParams, BuildResult]("build")
  val CloseProject = Request[ProjectRef, Unit]("project/close")
  val Find = Request[NavigationQuery, List[NavigationTarget]]("find")
  val InvokeActionAsync = Request[String, Unit]("action/invokeAsync")
  val InvokeAction = Request[String, Unit]("action/invoke")
  val OpenProject = Request[Path, ProjectRef]("project/open")
  val Run = Request[ApplicationRunConfiguration, ProcessResult]("run/application")
  val RunJUnit = Request[JUnitRunConfiguration, TestsRunResult]("run/junit")
  val Shutdown = Notification[Unit]("shutdown")
  val SyncFiles = Request[Unit, Unit]("fs/sync")
  val TakeScreenshot = Request[String, Unit]("screenshot")
  val RunLocalInspection = Request[InspectionRunParams, InspectionRunResult]("inspections/local/run")

  // queries
  val FileReferences = Request[FileRef, Seq[Reference]]("file/references")
  val Freezes = Request[Unit, Seq[Freeze]]("freezes")
  val ListOpenProjects = Request[Unit, Seq[ProjectRef]]("projects/all")
  val Messages = Request[Unit, Seq[IdeMessage]]("messages")
  val ModuleSdk = Request[ModuleRef, Option[Sdk]]("module/sdk")
  val PID = Request[Unit, Long]("pid")
  val Ping = Request[Unit, Unit]("ping")
  val Plugins = Request[Unit, Seq[InstalledPlugin]]("plugins")
  val ProjectSdk = Request[ProjectRef, Option[Sdk]]("project/sdk")
  val ProjectModel = Request[ProjectRef, Project]("project/model")
  val VcsRoots = Request[ProjectRef, Seq[VcsRoot]]("project/vcsRoots")
}
