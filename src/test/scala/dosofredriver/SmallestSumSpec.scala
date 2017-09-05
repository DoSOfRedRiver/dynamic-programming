package dosofredriver

import dosofredriver.SmallestSum.smallestSumMemo
import org.scalatest.{Matchers, WordSpec}

class SmallestSumSpec extends WordSpec with Matchers {
  val smallest = List(-4, 2, -3, -1)
  val list = List(3, -4, 2, -3, -1, 7, -5)

  "A SmallestSum should" should {
    s"return $smallest as range with smallest sum in $list" in {
      smallestSumMemo(list) shouldBe smallest
    }
  }
}
