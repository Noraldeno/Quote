package quote;


public class Accessories implements Hardware {
	private int quantity;
	private String describe;
	private double price;
	
	/**
	 * Constructs an Accessories object
	 * 
	 * @param quantity The amount of items
	 * @param price    The cost of each item
	 * @param info     Description of the item
	 */
	public Accessories(int quantity, double price, String info){
		this.quantity = quantity;
		this.price = price;
		describe = info;
	}
	
	/**
	 * Returns the price of each item
	 * 
	 * @return price
	 */
	public double price(){
		return price;
	}
	
	/**
	 * Returns quantity of each item
	 * 
	 * @return quantity
	 */
	public int quantity(){
		return quantity;
	}
	/**
	 * Returns the description of each item
	 * 
	 * @return describe
	 */
	public String description(){
		return describe;
	}
	
	/**
	 * Calculates the price * quantity.
	 * @return price * total price
	 */
	public double totPrice(){
		return (price * quantity);
	}
	
	/**
	 * Prints out information of an item
	 * 
	 * @return String of quantity, price per unit
	 * description and extended amount
	 */
	@Override
	public String toString(){
		return String.format("%30d | $%29.2f | %30s | $%29.2f |\n", 
				quantity, price, describe, totPrice());
	}
	
}
