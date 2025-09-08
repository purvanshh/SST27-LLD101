package beverages_decorator;

public class Cappuccino extends Beverage{

	@Override
	public String getDescription() {
		return "Cappuccino";
	}

	@Override
	public int cost() {
		return 10;
	}

}