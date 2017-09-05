package dosofredriver

import dosofredriver.util.Memoize.memoize

import scala.language.implicitConversions

object SmallestSum {
  import util.listOrdering


  private def maybeNextSum(slice: List[Int]): Option[List[Int]] = {
    if (slice.size > 1)
      Some(smallestSumMemo(slice))
    else None
  }

  val smallestSumMemo: List[Int] => List[Int] = memoize { l =>
    if (l.size == 1) l
    else {
      val interm = {
        for {
          i <- 1 to l.size

          sliceRight = l.slice(i, l.length)
          sliceLeft = l.slice(0, l.length - i)

          lToR = maybeNextSum(sliceRight)
          rToL = maybeNextSum(sliceLeft)

        } yield List(lToR, rToL, Some(sliceRight), Some(sliceLeft))
          .flatten.min
      }

      interm.min
    }
  }
}
