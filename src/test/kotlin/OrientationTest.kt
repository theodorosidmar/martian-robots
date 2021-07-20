import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class OrientationTest {
  @Test
  fun rotateRight() {
    assertEquals(Orientation.E, Orientation.N.rotateRight())
    assertEquals(Orientation.S, Orientation.E.rotateRight())
    assertEquals(Orientation.W, Orientation.S.rotateRight())
    assertEquals(Orientation.N, Orientation.W.rotateRight())
  }

  @Test
  fun rotateLeft() {
    assertEquals(Orientation.W, Orientation.N.rotateLeft())
    assertEquals(Orientation.S, Orientation.W.rotateLeft())
    assertEquals(Orientation.E, Orientation.S.rotateLeft())
    assertEquals(Orientation.N, Orientation.E.rotateLeft())
  }
}