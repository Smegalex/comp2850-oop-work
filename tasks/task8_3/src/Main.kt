// Task 8.3: weather station temperature analysis program
//import fetchData


fun main() {
    // Add code here to:
    //   - Fetch data
    //   - Find records with lowest and and highest temperatures
    //   - Compute average temperature
    //   - Display all of these statistics
    val dataset = fetchData()

    val lowest = dataset.minBy { it.second }
    val highest = dataset.maxBy { it.second }

    val average = dataset.sumOf {it.second}/dataset.size

    println("Highest temp recorded at $highest")
    println("Lowest temp recorded at $lowest")
    println("Average temp recorded is %.2f".format(average))
    // val average 
}
