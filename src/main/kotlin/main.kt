fun main() {
  val parser: InputParser = ResourceFileInputParser(path = "input.txt")
  val explorer: MarsReporter = parser.parse()
  val result = explorer.report()
  result.display()
}

