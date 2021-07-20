class ResourceFileInputParser(path: String) : InputParser {
  @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
  private val lines: List<String> by lazy {
    this::class.java.classLoader.getResource(path).readText().lines()
  }
  private lateinit var mars: Mars
  private val robots = mutableListOf<ExplorableRobot>()

  override fun parse(): MarsReporter {
    lines.forEachIndexed { index, line: String ->
      if (isMarsLine(index = index)) {
        mars = Mars(size = Pair(first = line[0].digitToInt(), second = line[1].digitToInt()))
        return@forEachIndexed
      }
      if (isRobotLine(line = line)) {
        robots.add(SimpleRobot(
          position = Position(x = line[0].digitToInt(), y = line[1].digitToInt()),
          orientation = Orientation.valueOf(line[2])
        ))
        return@forEachIndexed
      }
      robots.last().apply {
        addInstructions(line.map { Instruction.valueOf(it) })
      }
    }
    return MarsReporter(mars = mars, robots = robots)
  }

  private fun isMarsLine(index: Int) =
    index == 0

  private fun isRobotLine(line: String) =
    line[0].isDigit()
}
