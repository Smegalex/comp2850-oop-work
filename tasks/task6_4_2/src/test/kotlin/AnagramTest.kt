// Task 6.4.2

import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class AnagramTest: StringSpec({
    "Two strings of different length are not anagrams" {
        withClue("Different lengths") {"agha" anagramOf "agh" shouldBe false}
        withClue("Normal and empty string") {"agha" anagramOf "" shouldBe false}
    }

    "An empty string is not an anagram of itself" {
        {"" anagramOf "" shouldBe false}
    }

    "A non-empty string is an anagram of itself" {
        {"agha" anagramOf "agha" shouldBe true}
    }

    "Two strings are anagrams if they contain the same characters in a different order" {
       {"agha" anagramOf "aagh" shouldBe true}
    }

    "Letter case is disregarded when comparing character sequences, i.e., the lowercase and uppercase forms of a character are considered to be equivalent"{
        {"aGHa" anagramOf "AAGh" shouldBe true}
    }
})
