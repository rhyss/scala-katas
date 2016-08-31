import org.scalatest.FunSuite
import org.scalatest._


class FizzbuzzTests extends FunSuite with Matchers {

  test("returns fizz for 3") {
    FizzBuzz.forRange(3, 3) should equal(List("fizz"))
  }

  test("returns the digit for all numbers not divisible by 3 between 0 and 10") {
    FizzBuzz.forRange(0, 10) should equal(List(0, 1, 2, "fizz", 4, "buzz", "fizz", 7, 8, "fizz", "buzz").map(_.toString))
  }

  test("returns buzz for multiples of 5") {
    FizzBuzz.forRange(5, 5) should equal(List("buzz"))
    FizzBuzz.forRange(10, 10) should equal(List("buzz"))
    FizzBuzz.forRange(25, 25) should equal(List("buzz"))
  }

  test("returns fizzbuzz for multiples of three and 5") {
    FizzBuzz.forRange(15, 15) should equal(List("fizzbuzz"))
    FizzBuzz.forRange(30, 30) should equal(List("fizzbuzz"))
  }

  test("returns fizz for numbers containing 3") {
    FizzBuzz.forRange(13, 13) should equal(List("fizz"))
    FizzBuzz.forRange(23, 23) should equal(List("fizz"))
    FizzBuzz.forRange(43, 43) should equal(List("fizz"))
    FizzBuzz.forRange(53, 53) should equal(List("fizz"))
  }

  test("returns a formatted string for output") {
    FizzBuzz.toString(FizzBuzz.forRange(1, 3)) should equal("1, 2, fizz")
  }

}
