// Task 7.7.2: contact database, using a map
fun main() {
	val contacts = mutableMapOf<String, String>()
	while (true) {
		println("Enter a name or 'q' to stop: ")
		val name = readln().lowercase()
		if (name == "q") break
		if (contacts.containsKey(name)) {
			println("Phone number of $name is ${contacts[name]}\n")
		} else {
			println("Enter phone number of $name to add to the database: ")
			val number = readln()
			contacts[name] = number
			println("New entry added\n")
		}
	}
}