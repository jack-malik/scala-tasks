package implicitstuff

class ImplicitTest {

}

object ImplicitTest {
  import scala.reflect.ClassTag

  def f[T](v: T)(implicit ev: ClassTag[T]) = {
    ev.toString
  }

  def main(args: Array[String]): Unit = {
    import scala.reflect.ClassTag
    val x: Any = 5
    f(x) // returns the string "Any"
  }
}
