fun main(){
	println("PIZZA MENU\n\n" +
	"(a) Margherita\n" +
	"(b) Pepperoni\n" +
	"(c) Hawaiian\n" +
	"(d) Veggie\n")

	var validChoice = false;

	while (!validChoice) {
		print("Choose your pizza (a-d): ")
		val choice = readln().lowercase()

		if (choice.length ==1 && choice[0] in 'a'..'d') {
			println("Order accepted")
			validChoice = true;
			// when (choice[0]) {
			// 	'a' -> println("You ordered a Margherita pizza.")
			// 	'b' -> println("You ordered a Pepperoni pizza.")
			// 	'c' -> println("You ordered a Hawaiian pizza.")
			// 	'd' -> println("You ordered a Veggie pizza.")
			// }
		} else {
			println("Invalid choice")
		}
	}
}