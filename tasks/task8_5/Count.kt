fun String.howMany(include: (Char) -> Boolean): Int {
    var count = 0
    for (character in this) {
        if (include(character)) {
            count += 1
        }
    }
    return count
}

fun main() {
	val testString = "Lorem ipsum dolor sit amor..."
	println(testString.howMany{it.lowercase() in "check string"})
    println(testString.howMany{it.lowercase() in "abc"})
    println(testString.howMany{it.lowercase() != it.toString()})// how many uppercase
    println(testString.howMany{it.lowercase() < "n"}) // before n

}