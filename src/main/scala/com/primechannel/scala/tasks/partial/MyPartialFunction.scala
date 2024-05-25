package partial
import PartialFunction._

class MyPartialFunction {

}

object MyPartialFunction {

  val divide = new PartialFunction[Int, Int] {
    def apply(x: Int) = 42 / x
    def isDefinedAt(x: Int) = x != 0
  }
/*
  val squareRoot: PartialFunction[Double, Double]: PartialFunction = {
    def apply(x: Double) = Math.sqrt(x)
    def isDefinedAt(x: Double) = x >= 0
  }*/


}
