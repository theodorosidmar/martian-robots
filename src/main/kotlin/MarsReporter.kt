import Instruction.*

class MarsReporter(
  private val mars: Mars,
  private val robots: List<ExplorableRobot>
) {
  private val scents = mutableListOf<Position>()

  fun report(): ReportResult {
    robots.forEach { robot ->
      val iterator = robot.instructions.iterator()
      while (iterator.hasNext()) {
        when (iterator.next()) {
          R -> robot.rotateRight()
          L -> robot.rotateLeft()
          F -> {
            if (robot.nextPosition in scents) continue
            robot.forward()
            if (setRobotAsLostIfIsEdge(robot = robot)) break
          }
        }
      }
    }
    return ReportResult(robots = robots)
  }

  private fun setRobotAsLostIfIsEdge(robot: Robot): Boolean {
    if (mars.isEdge(position = robot.currentPosition)) {
      robot.isLost = true
      scents.add(robot.currentPosition)
      return true
    }
    return false
  }
}
