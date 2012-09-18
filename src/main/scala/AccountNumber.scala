import collection.mutable.ListBuffer

class AccountNumber() {
  final val WIDTH_OF_OCR_NUMERAL: Int = 3
  final var textVersion: String = ""
  var isValid: Boolean = false
  final val NUMBER_OF_DIGITS: Int = 9


  def this(ocrAccountNumber: String) {
    this()
    textVersion = createAccountNumberFromOcr(ocrAccountNumber)
    isValid = checkSum
  }

  def divideOcrAccountNumberIntoOcrDigits(ocrAccountNumber: String): List[String] = {

    var accountNumberAsOcrDigits = ListBuffer[String]()

    List.range(0, NUMBER_OF_DIGITS).foreach(c =>
      accountNumberAsOcrDigits.append(parseDigit(ocrAccountNumber, accountNumberAsOcrDigits.toList, c))
    )
    accountNumberAsOcrDigits.toList
  }

  def parseDigit(ocrAccountNumber: String, accountNumberAsOcrDigits: List[String], digit: Int): String = {
    val startOfFirstLine: Int = (digit * WIDTH_OF_OCR_NUMERAL)
    val startOfSecondLine: Int = startOfFirstLine + (WIDTH_OF_OCR_NUMERAL * NUMBER_OF_DIGITS)
    val startOfThirdLine: Int = startOfSecondLine + (WIDTH_OF_OCR_NUMERAL * NUMBER_OF_DIGITS)

    val firstLineOfOcrDigit: String = lineOfOcrDigit(ocrAccountNumber, startOfFirstLine)
    val secondLineOfOcrDigit: String = lineOfOcrDigit(ocrAccountNumber, startOfSecondLine)
    val thirdLineOfOcrDigit: String = lineOfOcrDigit(ocrAccountNumber, startOfThirdLine)

    val complete = firstLineOfOcrDigit + secondLineOfOcrDigit + thirdLineOfOcrDigit
    complete
  }

  def lineOfOcrDigit(ocrAccountNumber: String, startOfLine: Int): String = {
    ocrAccountNumber.substring(startOfLine, (startOfLine + WIDTH_OF_OCR_NUMERAL))
  }

  def createAccountNumberFromOcr(ocrToInterpret: String): String = {

    val accountNumberAsOcrDigits: List[String] = divideOcrAccountNumberIntoOcrDigits(ocrToInterpret)
    val ACCOUNT_NUMBER_LENGTH: Int = accountNumberAsOcrDigits.size
    createAccountNumber(accountNumberAsOcrDigits, ACCOUNT_NUMBER_LENGTH)
  }

  def createAccountNumber(accountNumberAsOcrDigits: List[String], ACCOUNT_NUMBER_LENGTH: Int): String = {
    val converter  = new DigitToNumericConverter
    var accountNumber: String = ""

    List.range(0, ACCOUNT_NUMBER_LENGTH).foreach(c =>
      accountNumber = accountNumber + (converter.makeNumeral(accountNumberAsOcrDigits(c)))
    )
    accountNumber
  }

  def checkSum: Boolean = {
    val checkSumCalculation: Int = 0
    var currentDigit: Int = 0

    List.range(0, NUMBER_OF_DIGITS).foreach(c => thisNeedsToBeRenamed(c, checkSumCalculation) )

    (checkSumCalculation % 11) == 0
  }

  def thisNeedsToBeRenamed(c: Int, checkSumCalculation: Int): Int = {
    val thisCharacter: String = textVersion.substring(c, c + 1)
    val currentDigit: Int = Integer.parseInt(thisCharacter)
    checkSumCalculation + ((NUMBER_OF_DIGITS - c) * currentDigit)
  }
}

