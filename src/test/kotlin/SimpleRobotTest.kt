import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SimpleRobotTest {
  @Test
  fun rotateRight() {
    val robot = SimpleRobot(position = Position(x = 1, y = 1), orientation = Orientation.N)
    robot.rotateRight()
    assertEquals(Orientation.E, robot.currentOrientation)
    robot.rotateRight()
    assertEquals(Orientation.S, robot.currentOrientation)
    robot.rotateRight()
    assertEquals(Orientation.W, robot.currentOrientation)
    robot.rotateRight()
    assertEquals(Orientation.N, robot.currentOrientation)
  }

  @Test
  fun rotateLeft() {
    val robot = SimpleRobot(position = Position(x = 1, y = 1), orientation = Orientation.N)
    robot.rotateLeft()
    assertEquals(Orientation.W, robot.currentOrientation)
    robot.rotateLeft()
    assertEquals(Orientation.S, robot.currentOrientation)
    robot.rotateLeft()
    assertEquals(Orientation.E, robot.currentOrientation)
    robot.rotateLeft()
    assertEquals(Orientation.N, robot.currentOrientation)
  }

  @Test
  fun forward() {
    val robot = SimpleRobot(position = Position(x = 1, y = 1), orientation = Orientation.N)
    robot.forward()
    assertEquals(Position(x = 1, y = 2), robot.currentPosition)
  }
}
//override val nextPosition: Position get() = when (state.orientation) {
//  N -> Position(x = state.position.x, y = state.position.y.inc())
//  S -> Position(x = state.position.x, y = state.position.y.dec())
//  E -> Position(x = state.position.x.inc(), y = state.position.y)
//  W -> Position(x = state.position.x.dec(), y = state.position.y)
//}
