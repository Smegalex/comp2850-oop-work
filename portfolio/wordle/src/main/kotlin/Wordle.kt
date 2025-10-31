import kotlin.io.path.* // file reading package

// ANSI codes for colors
val red = "\u001b[31m" 
val bold = "\u001b[1m"
val reset = "\u001b[0m"

// Implement the six required functions here
fun isValid(word: String): Boolean {
	"""
	Returns true if the given word is valid in Wordle (consists of exactly 5 letters)
	"""
	return word.length == 5 && word.all { it.isLetter() } 
}

fun readWordList(fileName: String): MutableList<String>{
	"""
	Reads Wordle target words from the specified file, 
	returning them as a list of strings
	"""
	return Path(fileName).readLines().toMutableList()
}

fun pickRandomWord(words: MutableList<String>): String {
	"""
	Chooses a random word from the given list, removes that 
	word from the list, then returns it.
	"""
	val selectedWord = words.random()
	words.remove(selectedWord)
	return selectedWord
}

fun obtainGuess(attempt: Int): String {
	"""
	Prints a prompt using the given attempt number, 
	then reads a word from stdin. The word should be 
	returned if valid, otherwise the user should be 
	prompted to try again.
	"""
	print(bold + "Attempt 1: " + reset)
	var attempt = readln().lowercase()
	while (!isValid(attempt)) { // Prompting follow up inputs until input is valid
		print(red+"Invalid word!\n"+reset+"Try again: ")
		attempt = readln().lowercase()
	} 
	return attempt
}

fun evaluateGuess(guess: String, target: String): List<Int> {
	"""
	Compares a guess with the target word. Returns a list 
	containing 5 integers, representing the result of comparison 
	at each letter position. 
	- 0 for guess letters that are not present in the target word
	- 1 for letters that are in the target word but at a different position
	- 2 for letters that have been guessed correctly
	"""
	val correctnessList = List<Int>(5) { 0 } // init list
	for (index in 0..5) {
		if (guess[index] == target[index]) { // correct letter in correct position
			correctnessList[index] = 2
		} else if(guess[index] in target) { // correct letter incorrect position
			correctnessList[index] = 1
			target[index] = "_" 
		}
	}
}