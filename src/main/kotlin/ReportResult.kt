data class ReportResult(
  val robots: List<Robot>
) {
  fun display() {
    robots.forEach { robot ->
      if (robot.isLost) println("${robot.lastPosition?.x} ${robot.lastPosition?.y} ${robot.lastOrientation} LOST")
      else println("${robot.currentPosition.x} ${robot.currentPosition.y} ${robot.currentOrientation}")
    }
  }
}
