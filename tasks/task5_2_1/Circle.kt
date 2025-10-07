// Task 5.2.1: geometric properties of circles
import kotlin.math.PI

fun circleArea(radius: Double) = PI * radius * radius
fun circlePerimeter(radius: Double) = 2 * PI * radius

fun readDouble(prompt: String): Double {
	print(prompt)
	return readln().toDouble()
}

fun main() {
	val radius = readDouble("Enter circle radius: ")
	val area = circleArea(radius)
	val perimeter = circlePerimeter(radius)
	println("Circle area: %.4f".format(area))
	println("Circle perimeter: %.4f".format(perimeter))
}