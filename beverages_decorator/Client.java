package beverages_decorator;

public class Client {

	public static void main(String[] args) {

		// Simple cappuccino
		Beverage coffee1 = new Cappuccino();
		printReceipt(coffee1);

		// Cappuccino with milk and sugar
		Beverage coffee2 = new Cappuccino();
		coffee2 = new Milk(coffee2);
		coffee2 = new Sugar(coffee2);
		printReceipt(coffee2);

		// Latte with double mocha and milk
		Beverage coffee3 = new Latte();
		coffee3 = new Mocha(coffee3);
		coffee3 = new Mocha(coffee3);
		coffee3 = new Milk(coffee3);
		printReceipt(coffee3);
	}

	private static void printReceipt(Beverage beverage) {
		System.out.println("--- Receipt ---");
		System.out.println("Items: " + beverage.getDescription());
		System.out.println("Total: " + beverage.cost());
		System.out.println();
	}

}