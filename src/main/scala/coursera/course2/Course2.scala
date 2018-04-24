package coursera.course2

import math.abs;

class Course2 {
  def sum(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (a, b) => a + b, 0)(a, b)

  def sum_t(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }

  def id(x: Int): Int = x
  def cube(x: Int): Int = x * x * x
  def fact(x: Int): Int = if (x == 0) 1 else x * fact(x - 1)
  def factViaProd(n: Int): Int = product(x => x)(1, n)
  def summation(x: Int): Int = if (x == 0) 0 else x + summation(x - 1)
  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (a, b) => a * b, 1)(a, b)

  def mapReduce(f: Int => Int, g: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else g(f(a), mapReduce(f, g, zero)(a + 1, b))

  val tolerance = 0.001
  def isCloseEnough(x: Double, y: Double): Boolean = abs((x - y)/x)/x < tolerance
  def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {
    def iterate(guess: Double): Double = {
      val next: Double = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  def averageDamp(f: Double => Double)(x: Double): Double = (x + f(x)) / 2

  def squr(x: Double): Double = fixedPoint(averageDamp(y => x/y))(1.0)
}
