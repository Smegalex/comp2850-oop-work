import kotlin.system.exitProcess
// Task 4.5: summing odd integers with a for loop
fun main() {
	print("Enter upper limit: ")
	val upperLimit = readln().toInt()

	if (upperLimit < 1 || upperLimit > 10000) {
		println("Upper limit must be between 1 and 10000.")
		exitProcess(1)
	}
	var sum = 0

	for (i in 1..upperLimit step 2) {
		sum += i
	}

	println("Sum of odd integers from 1 to $upperLimit is $sum")
}