import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldBeInstanceOf
import java.nio.file.NoSuchFileException

@Suppress("unused")
class WordleTest : StringSpec({
    // isValid() tests
    "5 letter English word is valid regardless of case" {
        withClue("lowercase") { isValid("lower") shouldBe true }
        withClue("UPPERCASE") { isValid("UPPER") shouldBe true }
        withClue("MixedCase") { isValid("MiXeD") shouldBe true }
    }
    "Mix of letters and symbols is invalid" {
        withClue("Numbers") { isValid("Numb3r") shouldBe false }
        withClue("Symbols") { isValid("\$ymb.!") shouldBe false }
    }
    "Only 5 letter word is valid" {
        withClue("4 letters") { isValid("FOUR") shouldBe false }
        withClue("5 letters") { isValid("FIVER") shouldBe true }
        withClue("6 letters") { isValid("SIXSIX") shouldBe false }
    }

    // readWordList() tests
    "Word list can be read from a correct file" {
        withClue("Check correct return type") {
            readWordList("data/words.txt").shouldBeInstanceOf<MutableList<String>>()
        }
        withClue("Check length of return") { readWordList("data/words.txt") shouldHaveSize 2315 }
    }
    "Reading from non existent file throws a NoSuchFileException" {
        shouldThrow<NoSuchFileException> { readWordList("data/wordList.txt") }
    }

    // pickRandomWord() tests
    "The random word is from word list" {
        val wordList = readWordList("data/words.txt")
        val wordListCopy = wordList.toMutableList()
        wordListCopy.shouldContain(pickRandomWord(wordList))
    }
    "The random word is removed from wordList" {
        val wordList = readWordList("data/words.txt")
        wordList.shouldNotContain(pickRandomWord(wordList))
    }
    "Different words should be selected over 2 iterations" {
        val wordList = readWordList("data/words.txt")
        val word1 = pickRandomWord(wordList)
        val word2 = pickRandomWord(wordList)
        word1 shouldNotBe word2
    }

    // evaluateGuess() tests
    "Correct guess evaluates as correct regardless of case" {
        val correctList = listOf(2, 2, 2, 2, 2)
        withClue("Both inputs lowercase") { evaluateGuess("guess", "guess") shouldBe correctList }
        withClue("Guess lowercase, target uppercase") { evaluateGuess("guess", "GUESS") shouldBe correctList }
        withClue("Both inputs mixed case") { evaluateGuess("GueSs", "gUESs") shouldBe correctList }
    }
    "Correct letters in incorrect position are evaluated correctly" {
        withClue("Only incorrect positions") { evaluateGuess("tposi", "posit") shouldBe listOf(1, 1, 1, 1, 1) }
        withClue("Some letters are in correct positions") {
            evaluateGuess("psoit", "posit") shouldBe listOf(2, 1, 1, 2, 2)
        }
        withClue(
            "Incorrectly positioned letter X is not marked if there is " +
                "already correctly positioned letter X before it in the word and no other X are present in target word",
        ) {
            evaluateGuess("posts", "posit") shouldBe listOf(2, 2, 2, 1, 0)
        }
        withClue(
            "Incorrectly positioned letter X is not marked if there is already correctly " +
                "positioned letter X anywhere in the message and no other X are present in target word",
        ) {
            evaluateGuess("potit", "posit") shouldBe listOf(2, 2, 0, 2, 2,)
        }
        withClue(
            "Only the first incorrectly positioned letter X should be marked as 1 if there " + 
                "is only 1 letter X in target word",
        ) {
            evaluateGuess("oppit", "posit") shouldBe listOf(1, 1, 0, 2, 2)
        }
        withClue(
            "If there are 2 instances of letter X in target word and there is 2" +
                "incorrectly positioned letters X in guess both should be marked with 1",
        ) {
            evaluateGuess("sopts", "posst") shouldBe listOf(1, 2, 1, 1, 1)
        }
    }
    "All incorrect letters should be marked as 0" {
        withClue("All incorrect") { evaluateGuess("words", "lamey") shouldBe listOf(0, 0, 0, 0, 0) }
    }
})
