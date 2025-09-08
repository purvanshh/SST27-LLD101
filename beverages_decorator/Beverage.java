package beverages_decorator;

public abstract class Beverage {

	/**
	 * Human-friendly description used in a receipt.
	 */
	public String getDescription() {
		return "Unknown Beverage";
	}

	/**
	 * Total cost in integer units (example: cents or simple units used here).
	 */
	public abstract int cost();

}