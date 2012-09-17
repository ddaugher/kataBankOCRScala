import org.scalatest.FunSuite

class DigitToNumericConverterTests extends FunSuite {

  val c = new DigitToNumericConverter

  test("should return None when passed an invalid string - '___|_||_|'") {
    assert(None === c.makeNumeral("___|_||_|"))
  }

  test("should return None when passed an empty string") {
    assert(None === c.makeNumeral(""))
  }

  test("should return Some('0') when passed the proper input string") {
    assert(Some("0") === c.makeNumeral(c.ZERO))
  }

  test("should return Some('1') when passed the proper input string") {
    assert(Some("1") === c.makeNumeral(c.ONE))
  }

  test("should return Some('2') when passed the proper input string") {
    assert(Some("2") === c.makeNumeral(c.TWO))
  }

  test("should return Some('3') when passed the proper input string") {
    assert(Some("3") === c.makeNumeral(c.THREE))
  }

  test("should return Some('4') when passed the proper input string") {
    assert(Some("4") === c.makeNumeral(c.FOUR))
  }

  test("should return Some('5') when passed the proper input string") {
    assert(Some("5") === c.makeNumeral(c.FIVE))
  }

  test("should return Some('6') when passed the proper input string") {
    assert(Some("6") === c.makeNumeral(c.SIX))
  }

  test("should return Some('7') when passed the proper input string") {
    assert(Some("7") === c.makeNumeral(c.SEVEN))
  }

  test("should return Some('8') when passed the proper input string") {
    assert(Some("8") === c.makeNumeral(c.EIGHT))
  }

  test("should return Some('9') when passed the proper input string") {
    assert(Some("9") === c.makeNumeral(c.NINE))
  }
}

