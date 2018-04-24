package coursera.course3

import java.util.NoSuchElementException

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]

  def singleton[T](elem: T) = new Cons[T](elem, new Nil)
  def nth(n: Int): T =
    if (isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) head
    else if (n > 0) tail.nth(n - 1)
    else throw new IndexOutOfBoundsException("Invalid index:" + n)

}

case class Cons[T](_head: T, _tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
  override def toString: String = "("+head+","+tail.toString+")"

  val head:T = _head
  val tail:List[T] = _tail

}

class Nil[T] extends List[T] {
  override def isEmpty: Boolean = true
  override def head: Nothing = throw new NoSuchElementException("Nil.head")
  override def tail: Nothing = throw new NotImplementedError("Nil.tail")

  override def toString: String = "Nil"
}