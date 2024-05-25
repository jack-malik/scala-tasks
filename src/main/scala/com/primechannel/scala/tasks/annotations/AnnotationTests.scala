package annotations

object AnnotationTests {
  var age = 42
  println("In AnnotationTests object body ..")
  addToAge(1)
  echo("hello")

  // [2] use it
  @impure
  @deprecated
  def addToAge(i: Int) {
    age += i
  }

  @impure
  @deprecated
  def echo(s: String) {
    println(s"In echo: $s")
  }
  def main(args: Array[String]): Unit = {
    println("Hello annotations")
  }
}
