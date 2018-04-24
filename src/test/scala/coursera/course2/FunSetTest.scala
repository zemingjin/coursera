package coursera.course2

import org.scalatest.{FlatSpec, Matchers}

class FunSetTest extends FlatSpec with Matchers {
  it should "return a set" in {
    val set = FunSet

    val singleton = set.singletonSet(1)

    assert(singleton.toString() == "")
  }
}
