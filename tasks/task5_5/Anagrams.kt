// Task 5.1.1: anagram checking using a function
infix fun String.anagramOf(str: String): Boolean {
    if (this.length != str.length) {
        return false
    }
    val firstChars = this.lowercase().toList().sorted()
    val secondChars = str.lowercase().toList().sorted()
    return firstChars == secondChars
}

fun main(){
	println("Enter 2 words you want to check for anagrams:")
	print("Enter the first word: ")
	val first = readln().lowercase()
	print("Enter the second word: ")
	val second = readln().lowercase()
	val result = first anagramOf second
	print("${first} and $second are ")
	if (!result) print("not ")
	println("anagrams")
}