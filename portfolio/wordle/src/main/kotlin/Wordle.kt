import kotlin.io.path.Path // file reading package
import kotlin.io.path.readLines

// ANSI codes for colors
const val RED = "\u001b[31m"
const val YELLOW = "\u001b[93m"
const val GREEN = "\u001b[92m"
const val BOLD = "\u001b[1m"
const val RESET = "\u001b[0m"

const val WORD_LENGTH = 5

// Implement the six requiRED functions here
fun isValid(word: String): Boolean {
    """
    Returns true if the given word is valid in Wordle (consists of exactly 5 letters)
    """
    return word.length == WORD_LENGTH && word.all { it.isLetter() }
}

fun readWordList(fileName: String): MutableList<String> {
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
    print(BOLD + "Attempt $attempt: " + RESET)
    var attempt = readln().lowercase()
    while (!isValid(attempt)) { // Prompting follow up inputs until input is valid
        print(RED + "Invalid word!\n" + RESET + "Try again: ")
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
    val correctnessList = MutableList<Int>(WORD_LENGTH) { 0 } // init list
    // convert to mutable CharArray
    val guessArray = guess.lowercase().toCharArray()
    val targetArray = target.lowercase().toCharArray()
    for (index in targetArray.indices) {
        if (guessArray[index] == targetArray[index]) { // correct letter in correct position
            correctnessList[index] = 2
            guessArray[index] = '-' // mark as matched
            targetArray[index] = '_' // mark as used
        }
    }
    for (index in targetArray.indices) { // second pass to mark remaining letters in wrong positions
        if (guessArray[index] in targetArray) {
            correctnessList[index] = 1
            targetArray[targetArray.indexOf(guessArray[index])] = '_' // mark as used
        }
    }
    return correctnessList.toList() // converting from mutable list
}

fun displayGuess(guess: String, matches: List<Int>) {
    """
    Displays all the letters of the current guess, 
    using YELLOW to indicate a letter that is in 
    the wrong place and GREEN to indicate a letter 
    that has been correctly placed.
    """
    val capitalGuess = guess.uppercase() // capitalize the letters to have them as in original Wordle
    
    for (index in guess.indices) {
        if (matches[index] == 2) {
            print(BOLD + GREEN + capitalGuess[index] + RESET)
        } else if (matches[index] == 1) {
            print(BOLD + YELLOW + capitalGuess[index] + RESET)
        } else {
            print(capitalGuess[index] + RESET)
        }
    }
    print('\n')
}
