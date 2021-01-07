package monoids.mutiplication

/* Monoids contains one of the property as Identity*/
object IdentityElement extends App {

  trait Monoid[T] {
    def combine(a: T, b: T): T

    def empty: T
  }

  def identityLaw[T](x: T)(implicit M: Monoid[T]): Boolean = {
    (M.combine(x, M.empty) == x) && (M.combine(M.empty, x) == x)
  }

  implicit val intMonoid = new Monoid[Int] {
    override def combine(a: Int, b: Int): Int = a + b

    override def empty: Int = 0
  }

  val result = identityLaw(4)

  println("the result of identityLaw is" + result)

}
