// Task 5.3.2: dice rolling simulation
import kotlin.random.Random

fun rollDie(sides: Int = 6, rollCount: Int = 1) {
    if (sides in setOf(4, 6, 8, 10, 12, 20)) {
        println("Rolling $rollCount d$sides...")
        var result = 0;
		for (i in 1..rollCount) {
			result += Random.nextInt(1, sides + 1)
		}
        println("You rolled $result")
    }
    else {
        println("Error: cannot have a $sides-sided die")
    }
}

fun main(){
	rollDie(6, 3)
	rollDie(20, 2)
	rollDie(10)
	rollDie(5)
	rollDie()  
	rollDie(rollCount = 4)
	rollDie(rollCount = 2, sides = 12)
}