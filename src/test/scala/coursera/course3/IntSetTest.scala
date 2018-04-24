package coursera.course3

import org.scalatest.{FlatSpec, Matchers}

class IntSetTest extends FlatSpec with Matchers {
  def mockTree: tweet.NonEmpty = NonEmpty(7, NonEmpty(5, Empty, Empty),
                                    NonEmpty(11, NonEmpty(9, Empty, Empty),
                                             NonEmpty(13, Empty, Empty)))

  val t1 = NonEmpty(3, Empty, Empty)
  val t2 = t1.incl(4)
  val t3 = NonEmpty(5, Empty, Empty)
  val t4 = NonEmpty(1, Empty, Empty)

  it should "return a valid true" in {
    assert(mockTree.toString == "{{.5.}7{{.9.}11{.13.}}}")
    assert(t1.toString == "{.3.}")
    assert(t2.toString == "{.3{.4.}}")
    assert((t1 union t2).toString == "{.3{.4.}}")
    assert((t1 union t2 union t3).toString == "{{{.3.}4.}5.}")
    assert((t1 union t2 union t3 union t4).toString == "{.1{{.3.}4{.5.}}}")
  }

}
