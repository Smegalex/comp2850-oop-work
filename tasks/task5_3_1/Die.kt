// Task 5.1.2: die rolling simulation
import kotlin.random.Random

fun rollDie(sides: Int = 6) {
    if (sides in setOf(4, 6, 8, 10, 12, 20)) {
        println("Rolling a d$sides...")
        val result = Random.nextInt(1, sides + 1)
        println("You rolled $result")
    }
    else {
        println("Error: cannot have a $sides-sided die")
    }
}

fun readInt(prompt: String): Int? {
	print(prompt)
	return readln().toIntOrNull()
}

fun main(){
	val sides = readInt("Enter the number of sides on the die (enter for D6): ")
    if (sides == null) {
        rollDie()
    } else {
        rollDie(sides)
    }
}