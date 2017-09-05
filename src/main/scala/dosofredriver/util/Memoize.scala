package dosofredriver.util

import scala.collection.mutable

object Memoize {
  def memoize[I, O](f: I => O): I => O = new mutable.HashMap[I, O]() {
    override def apply(key: I) = getOrElseUpdate(key, f(key))
  }
}
