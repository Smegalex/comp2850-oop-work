import kotlin.system.exitProcess
import java.nio.file.NoSuchFileException

const val MAX_ATTEMPTS = 6
const val SUM_OF_CORRECTLY_PLACED_LETTERS = 5 * 2

fun main() {
	val wordListFileName = "data/words.txt"
	val wordList: MutableList<String>
	try {
		wordList = readWordList(wordListFileName)
	} catch (e: NoSuchFileException) {
		println("Word list file not found: " + e)
		exitProcess(1)
	}

	welcomeMessage(MAX_ATTEMPTS)
	do {
		val correctAnswer = pickRandomWord(wordList)

		var guessed = false
		var guess: String
		var correctnessList: List<Int>
		for (attempt in 1..MAX_ATTEMPTS) {
			guess = obtainGuess(attempt)
			correctnessList = evaluateGuess(guess, correctAnswer)
			displayGuess(guess, correctnessList)
            // check if all the letters have been placed correctly
			if (correctnessList.sum() == SUM_OF_CORRECTLY_PLACED_LETTERS) {
				guessed = true
				break
			}
		}
		if (guessed) {
			println(GREEN + BOLD + "Congratulations! You guessed the word!" + RESET)
		} else {
			println(RED + BOLD + "You are out of guesses:(" + RESET + "\nThe word was" + BOLD + " $correctAnswer" + RESET + ".")
		}
		println("Play again? (y/n)")
		print(": ")
	} while (readln().lowercase() == "y")
}

fun welcomeMessage(maxAttempts: Int) {
	println(BOLD + "Welcome to Wordle!" + RESET)
	println("The program selects a random word from a list of 5 letter english words.")
	println("You will have up to $maxAttempts attempts to guess the word.")
	println("Only 5 letter words are accepted as guesses.")
	println("The program will mark correctly guessed letters in the correct spot as " + GREEN + "GREEN" + RESET + ".")
	println("Meanwhile correctly guessed letters in the wrong spot will be marked " + YELLOW + "YELLOW" + RESET + ".")
	println("Good luck!\n")
}
