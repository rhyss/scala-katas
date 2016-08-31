object FizzBuzz {
  def forRange(start: Int, end: Int): Stream[String] = {
    val r: Stream[Int] = (start to end).toStream

    val r2 = r map {
      case 0 => "0"
      case n : Int if n % 3 == 0 && n % 5 == 0 => "fizzbuzz"
      case n : Int if n.toString.contains("3") => "fizz"
      case n : Int if n % 3 == 0 => "fizz"
      case n : Int if n % 5 == 0 => "buzz"
      case n => n.toString
    }

    r2
  }

  def toString(s: Seq[String]) = s.mkString(", ")

  def output(s: String) = println(s)

}
