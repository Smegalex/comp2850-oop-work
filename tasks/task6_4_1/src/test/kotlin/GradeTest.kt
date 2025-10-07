// Task 6.4.1

import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class GradeTest : StringSpec({
    "Grade of Distinction for marks between 70 and 100" {
        withClue("Mark=100") { grade(100) shouldBe "Distinction" }
        withClue("Mark=85") { grade(85) shouldBe "Distinction" }
        withClue("Mark=70") { grade(70) shouldBe "Distinction" }
    }

    "Grade of Pass for marks between 40 and 69" {
        withClue("Mark=69") { grade(69) shouldBe "Pass" }
        withClue("Mark=55") { grade(55) shouldBe "Pass" }
        withClue("Mark=40") { grade(40) shouldBe "Pass" }
    }

    "Grade of Fail for marks between 0 and 39" {
        withClue("Mark=39") { grade(39) shouldBe "Fail" }
        withClue("Mark=20") { grade(20) shouldBe "Fail" }
        withClue("Mark=0") { grade(0) shouldBe "Fail" }
    }

    "No grade for marks below 0" {
        withClue("Mark=-1") { grade(-1) shouldBe "?" }
        withClue("Mark=-20") { grade(-20) shouldBe "?" }
    }

    "No grade for marks over 100" {
        withClue("Mark=101") { grade(101) shouldBe "?" }
        withClue("Mark=120") { grade(120) shouldBe "?" }
    }

    // Add more tests here
})
