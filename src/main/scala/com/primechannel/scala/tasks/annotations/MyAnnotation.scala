package annotations

import scala.annotation.meta._

class impure extends scala.annotation.StaticAnnotation

//@getter @setter @beanGetter @beanSetter
class deprecated(message: String = "", since: String = "") extends scala.annotation.StaticAnnotation

