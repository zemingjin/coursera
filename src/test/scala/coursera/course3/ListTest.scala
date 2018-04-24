package coursera.course3

import org.scalatest.{FlatSpec, Matchers}

class ListTest extends FlatSpec with Matchers {
  val t1 = Cons(1, new Nil)
  val t2 = Cons(1, Cons(2, Cons(3, new Nil)))

  assert(t1.toString == "(1,Nil)")
  assert(t2.toString == "(1,(2,(3,Nil)))")
  assert(t2.nth(2) == 3)
  t2.nth(-1)
}
