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

fun List.median(): Double {
	// Sort the list and find the median value
	val sortedList = this.sorted()
	val size = sortedList.size
	return if (size % 2 == 1) {
		sortedList[size / 2]
	} else {
		(sortedList[size / 2 - 1] + sortedList[size / 2]) / 2
	}
}

