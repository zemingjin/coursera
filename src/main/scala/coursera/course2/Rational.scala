package coursera.course2

import math.abs

case class Rational(x: Int, y: Int) {
  def this(x: Int) = this(x, 1)
  require(y > 0, "Denominator should be positive")
  override def toString: String = numer/gcd + "/" + denom / gcd

  def + (that: Rational): Rational = add(that)
  def - (that: Rational): Rational = sub(that)
  def * (that: Rational): Rational = mul(that)
  def / (that: Rational): Rational = div(that)
  def == (that:Rational): Boolean = equals(that)
  def < (that:Rational): Boolean = less(that)
  def unary_- : Rational = neg
  def add(that: Rational): Rational = Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  def sub(that: Rational): Rational = this + -that
  def mul(that: Rational): Rational = Rational(numer * that.numer, denom * that.denom)
  def div(that: Rational): Rational = Rational(numer * that.denom, denom * that.numer)
  def equals(that: Rational): Boolean = numer * that.denom == denom * that.numer
  def neg: Rational = Rational(-numer, denom)
  def less(that: Rational): Boolean = numer * that.denom < that.numer * denom
  def max(that: Rational): Rational = if (this < that) that else this

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private def gcd: Int = abs(gcd(numer, denom))
  val numer = x
  val denom = y
}