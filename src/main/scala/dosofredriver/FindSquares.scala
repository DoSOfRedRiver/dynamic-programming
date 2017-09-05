package dosofredriver

import dosofredriver.util.Memoize.memoize

object FindSquares {

  private def minOrientation(coef: Int)(f: Int => Int): Int = {
    for (i <- 1 to coef / 2)
      yield f(i)
  }.foldLeft(Integer.MAX_VALUE)(Math.min)

  val findSquresMemo: ((Int, Int)) => Int =
     memoize { case (m, n) =>
      if (m == n) 1
      else {
        val minVert = minOrientation(n) { i =>
            findSquresMemo((m, i)) + findSquresMemo((m, n - i)) }

        val minHor = minOrientation(m) { i =>
          findSquresMemo((i, n)) + findSquresMemo((m - i, n)) }

        Math.min(minVert, minHor)
      }
    }
}
