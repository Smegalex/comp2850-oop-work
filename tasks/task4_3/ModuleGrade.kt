import kotlin.system.exitProcess
import kotlin.math.roundToInt

fun main(args: Array<String>) {
	if (args.size != 3){
		println("Please provide exactly three arguments")
		exitProcess(1)
	}

	val averageMark = ((args[0].toDouble() + args[1].toDouble() + args[2].toDouble()) / 3.0).roundToInt()

	var grade =
	when (averageMark) {
		in 70..100 -> "Distinction"
		in 40..69 -> "Pass"
		else -> "Fail"
	}

	println("$grade - $averageMark")
}