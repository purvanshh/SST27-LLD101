package beverages_decorator;

public class Latte extends Beverage {

	@Override
	public String getDescription() {
		return "Latte";
	}

	@Override
	public int cost() {
		return 20;
	}

}