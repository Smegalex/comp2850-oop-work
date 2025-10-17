// Task 7.7.1: stats for a numeric dataset
fun readData() = buildList {
    // Print a prompt for the user
	println("Enter numbers, type 'q' to stop:")

    // Write a loop to read the numbers
	while (true) {
		val input = readln()
		if (input.lowercase() == "q") break
		val number = input.toDoubleOrNull()
		if (number != null) {
    		// Inside this loop, call add() to add a number to list
			add(number)
		} else {
			println("Invalid input, please enter a number or 'q' to quit.")
		}
	}
}

fun List<Double>.median(): Double {
	// Sort the list and find the median value
	val sortedList = this.sorted()
	val size = sortedList.size
	return if (size % 2 == 1) {
		sortedList[size / 2]
	} else {
		(sortedList[size / 2 - 1] + sortedList[size / 2]) / 2
	}
}

fun List<Double>.displayStatistics() {
	// Print the statistics: count, min, max, sum, average, median
	if (this.isEmpty()) {
		println("No data available to display statistics.")
		return
	}
	val min = this.min() ?: 0.0
	val max = this.max() ?: 0.0
	val mean = this.average()
	val median = this.median()

	println("Min: $min")
	println("Max: $max")
	println("Average: %.2f".format(mean))
	println("Median: $median")
}

fun main() {
	val data = readData()
	data.displayStatistics()
}