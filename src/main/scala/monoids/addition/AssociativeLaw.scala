package monoids.addition

/* Monoids contains one of the property as Associativity*/
object AssociativeLaw extends App {

  trait Monoid[T] {
    def combine(a: T, b: T): T

    def empty: T
  }

  def associativeLaw[T](x: T, y: T, z: T)(implicit M: Monoid[T]): Boolean = {
    (M.combine(x, M.combine(y, z))) == M.combine(M.combine(x, y), z)
  }

  implicit val monoid = new Monoid[Int] {
    override def combine(a: Int, b: Int): Int = a + b

    override def empty: Int = 0
  }

  val result = associativeLaw(2, 4, 6)

  println("the result of associativeLaw is" + result)

}
