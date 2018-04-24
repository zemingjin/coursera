package coursera.course2

import org.scalatest.{FlatSpec, Matchers}

class Course2Test extends FlatSpec with Matchers {
  def course2: Course2 = new Course2

  it should "return the same value for sum and sum_t" in {
    assert(course2.sum(x => x)(1, 3) == course2.sum_t(n => n)(1, 3))
    assert(course2.sum(n => n * n * n)(1, 3) == course2.sum_t(n => n * n * n)(1, 3))
  }

  it should "return the same value for fact and factViaProd" in {
    assert(course2.fact(5) == course2.factViaProd(5))
    assert(course2.fact(1) == course2.factViaProd(1))
    assert(course2.fact(0) == course2.factViaProd(0))
  }

  it should "return product value" in {
    assert(course2.product(x => x * x)(1, 4) == 576)
    assert(course2.product(x => x * x)(1, 3) == 36)
    assert(course2.product(x => x * x)(3, 4) == 144)
  }

  it should "return a small number" in {
    assert(course2.fixedPoint(x => 1 + x / 2)(1) == 1.99609375)
  }

  it should "return the square root of the given number" in {
    assert(course2.squr(2) == 1.4142135623746899)
  }

}
