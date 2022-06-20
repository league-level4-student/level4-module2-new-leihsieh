package _06_Console_Store;

import java.util.Scanner;

public class ConsoleStore {

	/*
	 * Write a program that simulates shopping in a store using the Scanner and the
	 * classes in Generics_Store.
	 * 
	 * Note: You may need to modify existing code in Generics Store and/or add
	 * additional items and pictures to fulfill all the requirements. You are also
	 * free to add any additional methods or classes in Console Store that might be
	 * helpful to you.
	 * 
	 * Requirements:
	 * 
	 * -Use Ternary operators in place of simple if/else statements and do-while
	 * loops instead of while loops where appropriate.
	 * 
	 * - There should be at least four unique items the user can buy. These can be
	 * food items, nonfood items or both.
	 * 
	 * - The user should have a stipend of money to spend and each item should have
	 * its own price.
	 * 
	 * -The user should have the ability to add items to their cart, remove items,
	 * view items or check out.
	 * 
	 * -The program should continue until the user chooses to check out.
	 * 
	 * -When the user checks out you should let them know if they do not have enough
	 * money to purchase all their items and offer to put items back.
	 * 
	 * -If the user successfully purchases the items you should remove the amount
	 * from their stipend, show them the pictures of what they bought and print out
	 * a receipt showing their name, the individual prices of the items and their
	 * total.
	 */
	
	public static void main(String[] args) {
		boolean checkedOut = false;
		Cart<Candy> candy = new Cart<Candy>();
		Cart<Cereal> cereal = new Cart<Cereal>();
		Cart<Cake> cake = new Cart<Cake>();
		Cart<Chips> chips = new Cart<Chips>();
		int bal = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name:");
		String name = sc.next();
		System.out.println("You have a total of $20.");
		do {
			System.out.println("\nWhat would you like to do? (add, remove, view, checkout)");
			String action = sc.next();
			if(action.equalsIgnoreCase("add")) {
				System.out.println(
						"What would you like to add to your cart?\nCandy($3), Cereal($8), Cake($12), Chips($5)");
				String add = sc.next();
				System.out.println("add: " + add);
				if (add.equalsIgnoreCase("candy")) {
					candy.add(new Candy());
					System.out.println("Candy has been added to your cart");
					bal+=3;
				}
				else if (add.equalsIgnoreCase("cereal")) {
					cereal.add(new Cereal());
					System.out.println("Cereal has been added to your cart");
					bal+=8;
				}
				else if (add.equalsIgnoreCase("cake")) {
					cake.add(new Cake());
					System.out.println("Cake has been added to your cart");
					bal+=12;
				}
				else if (add.equalsIgnoreCase("chips")){
					chips.add(new Chips());
					System.out.println("Chips have been added to your cart");
					bal+=5;
				}
				else {
					System.out.println("That is not a valid item.");
				}
			}
			else if (action.equalsIgnoreCase("remove")) {
				System.out.println("Which item would you like to remove?");
				String remove = sc.next();
				String[] carts = {"candy", "cereal", "cake", "chips"};
				if(remove.equals(carts[0]) && candy.length() != 0) {
					candy.remove();
					System.out.println("You have removed 1 candy from your cart.");
				}
				else if(remove.equals(carts[1]) && cereal.length() != 0) {
					cereal.remove();
					System.out.println("You have removed 1 candy from your cart.");
				}
				else if(remove.equals(carts[2]) && cake.length() != 0) {
					cake.remove();
					System.out.println("You have removed 1 candy from your cart.");
				}
				else if(remove.equals(carts[3]) && chips.length() != 0) {
					chips.remove();
					System.out.println("You have removed 1 candy from your cart.");
				}
				else {
					System.out.println("You don't have any " + remove + " in your cart.\n");
				}
			}
			else if (action.equalsIgnoreCase("view")) {
				if(candy.get(0) != null) {
					candy.showCart();
				}
				if(cereal.get(0) != null) {
					cereal.showCart();
				}
				if(cake.get(0) != null) {
					cake.showCart();
				}
				if(chips.get(0) != null) {
					chips.showCart();
				}
			}
			else if (action.equalsIgnoreCase("checkout")) {
				if(bal>20) {
					System.out.println("Your item total is greater than $20. Consider removing some items to be able to check out.");
				}
				else if(bal == 0) {
					System.out.println("You have no items in your cart.\n");
				}
				else {
					checkedOut = true;
					System.out.println("\nReceipt:\nName: " + name + "\nTotal: $" + bal);
					if(candy.get(0) != null) {
						candy.showCart();
					}
					if(cereal.get(0) != null) {
						cereal.showCart();
					}
					if(cake.get(0) != null) {
						cake.showCart();
					}
					if(chips.get(0) != null) {
						chips.showCart();
					}
				}
				
			}
			else {
				System.out.println("Please enter a valid command. ");
			}
		} while (!checkedOut);
	}

}
