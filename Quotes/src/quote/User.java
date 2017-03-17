package quote;

import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		
		//	Initialize Scanner
		Scanner sc = new Scanner(System.in);
		
		// Declare Hardware Variables
		String describe = " ";
		double price = 0.0;
		int quantity = 0;
		String check;
		
		// Initialize Hardware Count
		int count = 1;
		
		// Initialize Quote Object
		Quote newQuote = new Quote();
		
//=========================================================================//
		// Take in hardware information
		System.out.print("Hello! Enter item information...\n\n");
		
		while(true){
			System.out.printf("****Item #%d****\n", count++);
			System.out.print("Please enter description: ");
			describe = sc.nextLine();
			
			System.out.print("Please enter price: ");
			try {
				price = Double.parseDouble(sc.nextLine());
			}
			catch (NumberFormatException e){
				e.printStackTrace();
			}
			
			System.out.print("Please enter quantity: ");
			try {
				quantity = Integer.parseInt(sc.nextLine());
			}
			catch (NumberFormatException e){
				e.printStackTrace();
			}
			
			// Add Hardware into quote
			newQuote.add(quantity, price, describe);
			if(quantity == 1)
				System.out.printf("Added %d hardware item to quote...\n", quantity);
			else
				System.out.printf("Added %d hardware items to quote...\n", quantity);
			
			System.out.println("\n\nHere is the added hardware...");
			newQuote.print(quantity, price, describe);
			newQuote.choice();
			check = sc.nextLine();
			
			if (check.equalsIgnoreCase("A")){
				newQuote.remove(count - 2);
				count--;
			}
			else if (check.equalsIgnoreCase("B")){
				continue;
			}
			else if(check.equalsIgnoreCase("C")){
				break;
			}
			
			System.out.println("--------------------------------------");
			
		}
		
		// Add Up Hardware Quote
		newQuote.total();
	}

}
