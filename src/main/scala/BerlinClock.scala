

class BerlinClock(h: Int, m: Int, s: Int) {
  type RowOf4Lights = (Light, Light, Light, Light)
  type RowOf11Lights = (Light, Light, Light, Light, Light, Light, Light, Light, Light, Light, Light)

  lazy val topLight : Light = if (s % 2 == 0) Yellow else Off
  val row1 : RowOf4Lights = rowOfFourLightsFor(_ / 5, h, Red)
  val row2 : RowOf4Lights = rowOfFourLightsFor(_ % 5, h, Red)
  lazy val row3 : RowOf11Lights = m / 5 match {
    case 0 => (Off, Off, Off, Off, Off, Off, Off, Off, Off, Off, Off)
    case 1 => (Yellow, Off, Off, Off, Off, Off, Off, Off, Off, Off, Off)
    case 2 => (Yellow, Yellow, Off, Off, Off, Off, Off, Off, Off, Off, Off)
    case 3 => (Yellow, Yellow, Red, Off, Off, Off, Off, Off, Off, Off, Off)
    case 4 => (Yellow, Yellow, Red, Yellow, Off, Off, Off, Off, Off, Off, Off)
    case 5 => (Yellow, Yellow, Red, Yellow, Yellow, Off, Off, Off, Off, Off, Off)
    case 6 => (Yellow, Yellow, Red, Yellow, Yellow, Red, Off, Off, Off, Off, Off)
    case 7 => (Yellow, Yellow, Red, Yellow, Yellow, Red, Yellow, Off, Off, Off, Off)
    case 8 => (Yellow, Yellow, Red, Yellow, Yellow, Red, Yellow, Yellow, Off, Off, Off)
    case 9 => (Yellow, Yellow, Red, Yellow, Yellow, Red, Yellow, Yellow, Red, Off, Off)
    case 10 => (Yellow, Yellow, Red, Yellow, Yellow, Red, Yellow, Yellow, Red, Yellow, Off)
    case 11 => (Yellow, Yellow, Red, Yellow, Yellow, Red, Yellow, Yellow, Red, Yellow, Yellow)
  }
  lazy val row4 : RowOf4Lights = rowOfFourLightsFor(_ % 5, m, Yellow)

  def rowOfFourLightsFor(f: (Int) => Int, i: Int, onColour: Light) = f(i) match {
    case 0 => (Off, Off, Off, Off)
    case 1 => (onColour, Off, Off, Off)
    case 2 => (onColour, onColour, Off, Off)
    case 3 => (onColour, onColour, onColour, Off)
    case 4 => (onColour, onColour, onColour, onColour)
  }

}

object BerlinClock {
  def apply(hours: Int, minutes: Int, seconds: Int) = new BerlinClock(hours, minutes, seconds)
}

sealed trait Light
object Red extends Light {
  override def toString = "Red"
}
object Yellow extends Light {
  override def toString = "Yellow"
}
object Off extends Light {
  override def toString = "Off"
}