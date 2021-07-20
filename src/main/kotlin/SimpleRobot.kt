import Orientation.*
import kotlin.properties.Delegates.observable

class SimpleRobot(position: Position, orientation: Orientation) : ExplorableRobot {
  override var isLost: Boolean = false
  override val instructions: MutableList<Instruction> = mutableListOf()
  override val currentOrientation: Orientation get() = state.orientation
  override val lastOrientation: Orientation? get() = lastState?.orientation
  override val currentPosition: Position get() = state.position
  override val lastPosition: Position? get() = lastState?.position
  override val nextPosition: Position get() = when (state.orientation) {
    N -> Position(x = state.position.x, y = state.position.y.inc())
    S -> Position(x = state.position.x, y = state.position.y.dec())
    E -> Position(x = state.position.x.inc(), y = state.position.y)
    W -> Position(x = state.position.x.dec(), y = state.position.y)
  }

  private var lastState: State? = null
  private var state: State by observable(State(position = position, orientation = orientation)) { _, old, _ ->
    lastState = old
  }

  override fun addInstructions(instructions: List<Instruction>) {
    this.instructions.addAll(instructions)
  }

  override fun rotateRight() {
    state = State(position = currentPosition, orientation = state.orientation.rotateRight())
  }

  override fun rotateLeft() {
    state = State(position = currentPosition, orientation = state.orientation.rotateLeft())
  }

  override fun forward() {
    state = State(position = nextPosition, orientation = currentOrientation)
  }

  private inner class State(
    val position: Position,
    val orientation: Orientation
  )
}
