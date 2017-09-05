package dosofredriver

package object util {
  implicit def listOrdering[T: Numeric]: Ordering[List[T]] = {
    (x: List[T], y: List[T]) => {
      implicitly[Ordering[T]].compare(x.sum, y.sum)
    }
  }
}
