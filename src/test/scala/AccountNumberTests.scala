import org.scalatest.{BeforeAndAfter, FunSuite}

class AccountNumberTests extends FunSuite with BeforeAndAfter {

  var impl: AccountNumber = _

  before {
    impl = new AccountNumber
  }

  ignore("xxx") {

    val nineZeros = " _  _  _  _  _  _  _  _  _ " +
      "| || || || || || || || || |" +
      "|_||_||_||_||_||_||_||_||_|" +
      "                           "
    assert(None === impl.lineOfOcrDigit(nineZeros, 0))
  }

  test("account number is an array of nine digits") {
    val nineZeros: String = " _  _  _  _  _  _  _  _  _ " +
   				                  "| || || || || || || || || |" +
   				                  "|_||_||_||_||_||_||_||_||_|" +
   				                  "                           "

    val arrayToCheck: List[String] = impl.divideOcrAccountNumberIntoOcrDigits(nineZeros)
    assert(9 === arrayToCheck.size)
  }

  test("third parsed digit matches stick zero") {
    val nineZeros: String =  " _  _  _  _  _  _  _  _  _ " +
      "| || || || || || || || || |" +
      "|_||_||_||_||_||_||_||_||_|" +
      "                           "

    val c = new DigitToNumericConverter
		val stringToCheck: String = impl.divideOcrAccountNumberIntoOcrDigits(nineZeros)(3).toString
		assert(c.ZERO === stringToCheck)
 	}

  test("stick 123456789 is properly recognized") {
    val oneThruNine: String =
      "    _  _     _  _  _  _  _ " +
    	"  | _| _||_||_ |_   ||_||_|" +
    	"  ||_  _|  | _||_|  ||_| _|" +
    	"                           "
    val tempImpl = new AccountNumber(oneThruNine)
    assert("123456789" == tempImpl.textVersion)
  }

//
// 	@Test
// 	public void checkSumShowsValidAccountNumberIsValid() {
// 		String NUMBER_TO_CHECK = "123456789";
// 		AccountNumber accountNumber = new AccountNumber(useCase.get(NUMBER_TO_CHECK));
// 		Assert.assertTrue(accountNumber.isValid);
// 	}
//
// 	@Test
// 	public void checkSumShowsInvalidAccountNumberIsInvalid() {
// 		String NUMBER_TO_CHECK = "111111111";
// 		AccountNumber accountNumber = new AccountNumber(useCase.get(NUMBER_TO_CHECK));
// 		Assert.assertFalse(accountNumber.isValid);
// 	}

}
