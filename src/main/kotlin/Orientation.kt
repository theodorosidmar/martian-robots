enum class Orientation {
  N, S, E, W;

  fun rotateRight(): Orientation = when (this) {
    N -> E
    E -> S
    S -> W
    W -> N
  }

  fun rotateLeft(): Orientation = when (this) {
    N -> W
    W -> S
    S -> E
    E -> N
  }

  companion object {
    fun valueOf(value: Char) = valueOf(value.toString())
  }
}
