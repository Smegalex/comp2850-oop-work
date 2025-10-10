// Task 7.3.1: list element access
fun main(){
	val numbers = mutableListOf(9, 3, 6, 2, 8, 5)
	println(numbers)
	println(numbers[0])
	println(numbers.get(0))
	// println(numbers[10]) // IndexOutOfBoundsException
	println(numbers.slice(2..4))
	println(numbers.first())
	println(numbers.last())
	numbers[0] = 10
	println(numbers)
	numbers.add(1)
	println(numbers)
	numbers.add(0, 8)
	println(numbers)
	numbers.removeAt(2)
	println(numbers)
	numbers.remove(5)
	println(numbers)
	numbers.removeAll {it == 8 }
	println(numbers)

	val sublist = mutableListOf(2, 3, 5)
	numbers.addAll(sublist)
	println(numbers)
	sublist.add(72)
	numbers.removeAll(sublist)
	println(numbers)
	numbers.clear()
	println(numbers)

	// val empty = mutableListOf<Int>()
	// println(empty.first())
	// println(empty.last())
	
}