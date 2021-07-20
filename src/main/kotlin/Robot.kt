interface Robot {
  val currentOrientation: Orientation
  val lastOrientation: Orientation?
  val currentPosition: Position
  val nextPosition: Position
  val lastPosition: Position?
  var isLost: Boolean

  fun forward()
  fun rotateRight()
  fun rotateLeft()
}
