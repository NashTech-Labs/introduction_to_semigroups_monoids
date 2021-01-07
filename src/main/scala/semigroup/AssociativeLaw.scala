package semigroup

/* Semigroups contains one property as Associativity*/
object AssociativeLaw extends App {

  trait Semigroup[A] {
    def combine(x: A, y: A): A
  }

  def associativeLaw[T](x: T, y: T, z: T)(implicit S: Semigroup[T]): Boolean = {
    (S.combine(x, S.combine(y, z))) == S.combine(S.combine(x, y), z)
  }

  implicit val intAdditionSemigroup: Semigroup[Int] = new Semigroup[Int] {
    def combine(x: Int, y: Int): Int = x + y
  }

  val result = associativeLaw(1, 2, 3)
  println("the value of result is" + result)

}
