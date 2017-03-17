package quote;

import java.util.ArrayList;
import java.util.ListIterator;

public class Quote {
	// Initialize ArrayList
	private ArrayList<Accessories> AList = new ArrayList<Accessories>();
	
	/**
	 * Adds a new hardware accessory object to ArrayList
	 * 
	 * @param quantity The quantity of hardware items
	 * @param price    The price of each hardware items
	 * @param describe The description of hardware items
	 */
	public void add(int quantity, double price, String describe){
		AList.add(new Accessories(quantity, price, describe));
	}
	
	public void remove(int count){
		AList.remove(count);
	}
	
	public void choice(){
		System.out.println("What do you want to do?\n"
				+ "A. Redo add hardware\n"
				+ "B. Add More\n"
				+ "C. Get Total\n");
	}
	
	public void print(int quantity, double price, String describe){
		System.out.printf("Quantity: %5d | Price per unit: $%5.2f | Description: %5s | Extended Amount: $%5.2f |\n",  
				quantity, price, describe, quantity * price);
	}
	
	/**
	 * Adds up the total of the quote. Calculates the sales tax,
	 * and the grand total of the whole quote. Uses an 
	 * iterator to add each item price.
	 * Prints out each item price, description and quantity
	 * as well as the sub-total, tax, and grand total.
	 */
	public void total(){
		double totalPrice = 0;
		double salesTax = 0;
		int total = 0;
		ListIterator<Accessories> it = AList.listIterator();
		
		System.out.printf("%30s | %30s | %30s | %30s |\n", "Quantity", "Price per Unit", "Description", "Extended Amount");
		while(it.hasNext()){
			totalPrice += it.next().totPrice();
			System.out.print(it.previous().toString());
			total += it.next().quantity();
		}
		
		double sub = totalPrice;
		salesTax = totalPrice * 0.085;
		totalPrice = salesTax + totalPrice;
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%15s: %13d |"
				+ "%16s: %13.2f |"
				+ "%14s: %15.2f |"
				+ "%15s: %14.2f |\n\n", 
				"Total", total, "Quote Subtotal", sub, "Sales Tax", salesTax, "Grand Total", totalPrice);
		
		if (totalPrice >= 1000){
			System.out.println("Greater than $1000. Do not use BPO.");
		}
		else{
			System.out.println("Less than $1000. Use BPO.");
		}
	
	}
}
