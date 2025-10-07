// Task 5.4.1: string extension function
fun String.tooLong(): Boolean = this.length > 20

fun main(){
	print("Enter a string: ")
	val input = readln()
	if (input.tooLong()) println("The string is too long.")
}