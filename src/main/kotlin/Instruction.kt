enum class Instruction {
  R, L, F;

  companion object {
    fun valueOf(value: Char) = valueOf(value.toString())
  }
}
