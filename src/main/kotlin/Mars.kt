data class Mars(
  val size: Pair<Int, Int>
) {
  fun isEdge(position: Position) =
    position.x < 0 ||
    position.y < 0 ||
    position.x > size.first ||
    position.y > size.second
}

