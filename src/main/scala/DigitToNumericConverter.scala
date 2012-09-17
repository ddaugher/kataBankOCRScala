import collection.mutable

class DigitToNumericConverter {

  val mapping = new mutable.HashMap[String, String]

  final val ZERO: String = " _ | ||_|"
  final val ONE: String = "     |  |"
  final val TWO: String = " _  _||_ "
  final val THREE: String = " _  _| _|"
  final val FOUR: String = "   |_|  |"
  final val FIVE: String = " _ |_  _|"
  final val SIX: String = " _ |_ |_|"
  final val SEVEN: String = " _   |  |"
  final val EIGHT: String = " _ |_||_|"
  final val NINE: String = " _ |_| _|"

  mapping.put(ZERO, "0")
  mapping.put(ONE, "1")
  mapping.put(TWO, "2")
  mapping.put(THREE, "3")
  mapping.put(FOUR, "4")
  mapping.put(FIVE, "5")
  mapping.put(SIX, "6")
  mapping.put(SEVEN, "7")
  mapping.put(EIGHT, "8")
  mapping.put(NINE, "9")

  def makeNumeral(s: String): Option[String] = {
    val thisDigit = mapping.get(s)
    thisDigit
  }
}
