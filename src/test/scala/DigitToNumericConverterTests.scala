import org.scalatest.FunSuite

class DigitToNumericConverterTests extends FunSuite {

  val c = new DigitToNumericConverter

  test("should return '0' when passed the proper input string") {
    assert("0" === c.makeNumeral(c.ZERO))
  }

  test("should return '1' when passed the proper input string") {
    assert("1" === c.makeNumeral(c.ONE))
  }

  test("should return '2' when passed the proper input string") {
    assert("2" === c.makeNumeral(c.TWO))
  }

  test("should return '3' when passed the proper input string") {
    assert("3" === c.makeNumeral(c.THREE))
  }

  test("should return '4' when passed the proper input string") {
    assert("4" === c.makeNumeral(c.FOUR))
  }

  test("should return '5' when passed the proper input string") {
    assert("5" === c.makeNumeral(c.FIVE))
  }

  test("should return '6' when passed the proper input string") {
    assert("6" === c.makeNumeral(c.SIX))
  }

  test("should return '7' when passed the proper input string") {
    assert("7" === c.makeNumeral(c.SEVEN))
  }

  test("should return '8' when passed the proper input string") {
    assert("8" === c.makeNumeral(c.EIGHT))
  }

  test("should return '9' when passed the proper input string") {
    assert("9" === c.makeNumeral(c.NINE))
  }
}

