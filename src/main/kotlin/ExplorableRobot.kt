interface ExplorableRobot : Robot {
  val instructions: MutableList<Instruction>
  fun addInstructions(instructions: List<Instruction>)
}
