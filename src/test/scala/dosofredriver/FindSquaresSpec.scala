package dosofredriver

import dosofredriver.FindSquares.findSquresMemo
import org.scalatest.{Matchers, WordSpec}

class FindSquaresSpec extends WordSpec with Matchers {

  "A FindSquares" should {
    "return 5 as result for 4x5 rectangle" in {
      findSquresMemo((4,5)) shouldBe 5
    }

    "return 5 as result for 6x5 rectangle" in {
      findSquresMemo((6,5)) shouldBe 5
    }
  }
}
