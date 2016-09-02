import org.scalatest.FunSuite
import org.scalatest._

class BerlinClockTests extends FunSuite with Matchers {

  // The clock is read from the top row to the bottom. The top row of four red fields denote five full hours each,
  // alongside the second row, also of four red fields, which denote one full hour each, displaying the hour value
  // in 24-hour format. The third row consists of eleven yellow-and-red fields, which denote five full minutes each
  // (the red ones also denoting 15, 30 and 45 minutes past), and the bottom row has another four yellow fields,
  // which mark one full minute each. The round yellow light on top blinks to denote even- (when lit) or odd-numbered
  // (when unlit) seconds.

  test("hours for 00:00:00 should be 0 top red and 0 second row red") {
    BerlinClock(0, 0, 0).row1 should equal((Off, Off, Off, Off))
    BerlinClock(0, 0, 0).row2 should equal((Off, Off, Off, Off))
  }

  test("hours for 06:00:00 should be 1 top red and 1 second row red") {
    BerlinClock(6, 0, 0).row1 should equal((Red, Off, Off, Off))
    BerlinClock(6, 0, 0).row2 should equal((Red, Off, Off, Off))
  }

  test("hours for 12:00:00 should be 2 top red and 1 second row red") {
    BerlinClock(12, 0, 0).row1 should equal((Red, Red, Off, Off))
    BerlinClock(12, 0, 0).row2 should equal((Red, Red, Off, Off))
  }

  test("hours for 18:00:00 should be 3 top red and 3 second row red") {
    BerlinClock(18, 0, 0).row1 should equal((Red, Red, Red, Off))
    BerlinClock(18, 0, 0).row2 should equal((Red, Red, Red, Off))
  }

  test("hours for 24:00:00 should be 4 top red and 4 second row red") {
    BerlinClock(24, 0, 0).row1 should equal((Red, Red, Red, Red))
    BerlinClock(24, 0, 0).row2 should equal((Red, Red, Red, Red))
  }

  test("minutes for 01:00:00 should be all off in the 3rd and 4th row") {
    BerlinClock(0, 0, 0).row3 should equal((Off, Off, Off, Off, Off, Off, Off, Off, Off, Off, Off))
    BerlinClock(0, 0, 0).row4 should equal((Off, Off, Off, Off))
  }

  test("minutes for 01:06:00 should be 1 orange in 3rd and 1 orange in 4th") {
    BerlinClock(0, 6, 0).row3 should equal((Yellow, Off, Off, Off, Off, Off, Off, Off, Off, Off, Off))
    BerlinClock(0, 6, 0).row4 should equal((Yellow, Off, Off, Off))
  }

  test("minutes for 01:12:00 should be 2 orange in 3rd and 2 orange in 4th") {
    BerlinClock(0, 12, 0).row3 should equal((Yellow, Yellow, Off, Off, Off, Off, Off, Off, Off, Off, Off))
    BerlinClock(0, 12, 0).row4 should equal((Yellow, Yellow, Off, Off))
  }

  test("minutes for 01:18:00 should be 2 orange, 1 red in 3rd and 3 orange in 4th") {
    BerlinClock(0, 18, 0).row3 should equal((Yellow, Yellow, Red, Off, Off, Off, Off, Off, Off, Off, Off))
    BerlinClock(0, 18, 0).row4 should equal((Yellow, Yellow, Yellow, Off))
  }

  test("minutes for 01:24:00 should be 2 orange, 1 red, 1 orange in 3rd and 4 orange in 4th") {
    BerlinClock(0, 24, 0).row3 should equal((Yellow, Yellow, Red, Yellow, Off, Off, Off, Off, Off, Off, Off))
    BerlinClock(0, 24, 0).row4 should equal((Yellow, Yellow, Yellow, Yellow))
  }

  test("minutes for 01:30:00 should be 2 orange, 1 red, 2 orange, 1 red in 3rd and all off in 4th") {
    BerlinClock(0, 30, 0).row3 should equal((Yellow, Yellow, Red, Yellow, Yellow, Red, Off, Off, Off, Off, Off))
    BerlinClock(0, 30, 0).row4 should equal((Off, Off, Off, Off))
  }

  test("minutes for 01:45:00 should be 2 orange, 1 red, 2 orange, 1 red, 2 orange, 1 red in 3rd and all off in 4th") {
    BerlinClock(0, 45, 0).row3 should equal((Yellow, Yellow, Red, Yellow, Yellow, Red, Yellow, Yellow, Red, Off, Off))
    BerlinClock(0, 45, 0).row4 should equal((Off, Off, Off, Off))
  }

  test("top light on for even seconds") {
    BerlinClock(0, 0, 0).topLight should equal(Yellow)
    BerlinClock(0, 0, 2).topLight should equal(Yellow)
    BerlinClock(0, 0, 4).topLight should equal(Yellow)
    BerlinClock(0, 0, 6).topLight should equal(Yellow)
    BerlinClock(0, 0, 8).topLight should equal(Yellow)
    BerlinClock(0, 0, 10).topLight should equal(Yellow)
  }

  test("top light off for even seconds") {
    BerlinClock(0, 0, 1).topLight should equal(Off)
    BerlinClock(0, 0, 3).topLight should equal(Off)
    BerlinClock(0, 0, 5).topLight should equal(Off)
    BerlinClock(0, 0, 7).topLight should equal(Off)
    BerlinClock(0, 0, 9).topLight should equal(Off)
    BerlinClock(0, 0, 11).topLight should equal(Off)
  }

}