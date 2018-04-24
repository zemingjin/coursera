package coursera.course2

import org.scalatest.{FlatSpec, Matchers}

class RationalTest extends FlatSpec with Matchers {
  val x = Rational(1, 3)
  val y = Rational(5, 7)
  val z = Rational(3, 2)
  val t = new Rational(7)

  it should "return a new Rational for math's" in {
    assert(Rational(1, 2).add(Rational(2, 3)).toString == "7/6")
    assert(Rational(1, 2).sub(Rational(2, 3)).toString == "-1/6")
    assert(Rational(1, 2).mul(Rational(2, 3)).toString == "1/3")
    assert(Rational(1, 2).div(Rational(2, 3)).toString == "3/4")
    assert(x.add(y).add(z).toString == "107/42")
    assert(x.add(y).mul(z).toString == "11/7")
    assert(x.sub(y).sub(z).toString == "-79/42")
    assert(y.add(y).toString == "10/7")
    assert(x.less(y))
    assert(!y.less(y))
    assert(x.max(y).toString == "5/7")
    assert(y.max(x).toString == "5/7")
    assert(t.toString == "7/1")
    assert((x + y + z).toString == "107/42")
    assert(((x + y) * z).toString == "11/7")
    assert((x - y - z).toString == "-79/42")
    assert((y + y).toString == "10/7")
    assert(x < y)
  }

}
