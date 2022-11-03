package com.shopping;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.shopping.Dao.DbConnection;

public class GroceryMainControl {
	static GroceryListData groc = new GroceryListData();

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		GroceryMainControl grocery = new GroceryMainControl();
		System.err.println("--------WELCOME TO ONLINE GROCERY SHOPPING--------");
		grocery.start();

	}

	public void start() throws Exception {
		try {
			FileInputStream file = new FileInputStream(
					"D:\\Eclipse\\eclipse\\com.oct\\src\\com\\shopping\\LoginDetails.properties");
			Properties prop = new Properties();
			prop.load(file);
			System.out.println("ENTER USERNAME: ");
			groc.setUserName(input.nextLine());
			if (prop.containsKey(groc.getUserName())) {
				System.out.println("ENTER YOUR PASSWORD: ");
				groc.setPassword(input.nextInt());
				if (prop.containsValue(String.valueOf(groc.getPassword()))) {
					System.out.println(
							"--------   GREETINGS   " + groc.getUserName() + "   WELCOME  TO  OUR  SHOPPING ---------");
					groceryList();
				} else {
					System.err.println("WRONG PASSWORD ! PLEASSE TRY AGAIN");
					start();
				}
			} else {
				System.err.println("WRONG USERNAME ! PLEASE TRY AGAIN");
				start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void groceryList() {
		try {
			Thread.sleep(2000);

			groc.getList().add("1.VEGETABLES");
			groc.getList().add("2.FRUITS");
			groc.getList().add("3.DAIRY");
			System.out.println("----------------------------");
			System.out.println("WE HAVE  " + groc.getList().size() + " CATEGORIES IN OUR LIST ");
			for (String string : groc.getList()) {
				System.out.println(string);
			}
			System.out.println("ENTER THE CHOICE: ");
			int scan = input.nextInt();
			switch (scan) {
			case 1:
				veg();
				break;
			case 2:
				fruits();
				break;
			case 3:
				dairy();
				break;
			}
			purchase();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void veg() {
		int i = 0;
		groc.getVegetables().put("tomato", 50);
		groc.getVegetables().put("brinjal", 30);
		groc.getVegetables().put("onion", 40);
		groc.getVegetables().put("carrot", 35);
		groc.getVegetables().put("potato", 55);
		System.out.println("--------------------------------");
		System.out.println("WE HAVE  " + groc.getVegetables().size() + " CATEGORIES IN OUR LIST ");
		for (Map.Entry<String, Integer> map : groc.getVegetables().entrySet()) {
			System.out.println((i + 1) + " . " + map.getKey() + " - " + " costs " + map.getValue() + ".Rs");
			i++;
		}

	}

	public static void fruits() {
		int i = 0;
		groc.getFruits().put("apple", 20);
		groc.getFruits().put("orange", 30);
		groc.getFruits().put("banana", 40);
		groc.getFruits().put("mango", 35);
		groc.getFruits().put("papaya", 38);

		System.out.println("WE HAVE  " + groc.getFruits().size() + " CATEGORIES IN OUR LIST ");
		for (Map.Entry<String, Integer> map1 : groc.getFruits().entrySet()) {
			System.out.println((i + 1) + " . " + map1.getKey() + " - " + " costs " + map1.getValue() + ".Rs");
			i++;
		}

	}

	public static void dairy() {
		int i = 0;
		groc.getDairy().put("curd", 10);
		groc.getDairy().put("buttermilk", 15);
		groc.getDairy().put("cheese", 25);
		groc.getDairy().put("butter", 30);
		System.out.println("-------------------------------");
		System.out.println("WE HAVE  " + groc.getDairy().size() + " CATEGORIES IN OUR LIST ");
		for (Map.Entry<String, Integer> map2 : groc.getDairy().entrySet()) {
			System.out.println((i + 1) + " . " + map2.getKey() + " - " + " costs " + map2.getValue() + ".Rs");
			i++;
		}
	}

	public static void purchase() {
		try {
			Thread.sleep(2500);
			boolean on = false;

			int choice = 0;
			printInfo();

			while (!on) {
				System.out.println("ENTER YOUR CHOICE OPTIONS: ");
				choice = input.nextInt();
				input.nextLine();

				switch (choice) {
				case 0:
					printInfo();
					break;
				case 1:
					addGrocereyItem();
					break;
				case 2:
					removeItem();
					break;
				case 3:
					viewCart();
					break;
				case 4:
					paymentGateway();
					break;
				case 5:
					on = true;
					System.err.println("     -----SHOPPING ENDED----     ");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printInfo() {
		try {
			Thread.sleep(2500);
			System.out.println("\nPRESS ");
			System.out.println("\t 0 - CHOICE OPTIONS");
			System.out.println("\t 1 - ADD ITEM TO THE LIST ");
			System.out.println("\t 2 - REMOVE AN ITEM ");
			System.out.println("\t 3 - VIEW CART ");
			System.out.println("\t 4 - PAYMENT GATEWAY ");
			System.out.println("\t 5 - QUIT THE APPLICATION ");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addItems(String item) throws Exception {

		if (groc.getVegetables().containsKey(item)) {
			groc.getCart().put(item, groc.getVegetables().get(item));
			System.out.println(item + " HAS ADDED TO YOUR CART");
			System.out.println();

			System.out.println("Do you wanna  Purchase on other categories 1.YES 2.NO");
			int st = input.nextInt();
			if (st == 1) {
				groc.getList().clear();
				groceryList();
			} else if (st == 2) {

				printInfo();
			}
		}

		if (groc.getFruits().containsKey(item)) {
			groc.getCart().put(item, groc.getFruits().get(item));
			System.out.println(item + " HAS ADDED TO YOUR CART");
			System.out.println();
			System.out.println("Do you wanna  Purchase on other categories 1.YES 2.NO");
			int st = input.nextInt();
			if (st == 1) {
				groc.getList().clear();
				groceryList();
			} else if (st == 2) {
				printInfo();
			}
		}

		if (groc.getDairy().containsKey(item)) {
			groc.getDairy().put(item, groc.getDairy().get(item));
			System.out.println(item + " HAS ADDED TO YOUR CART");
			System.out.println();
			System.out.println("Do you wanna  Purchase on other categories 1.YES 2.NO");
			int st = input.nextInt();
			if (st == 1) {
				groc.getList().clear();
				groceryList();
			} else if (st == 2) {

				printInfo();

			}
		}
	}

	public static void addGrocereyItem() {
		System.out.println();
		System.err.println("PLEASE ENTER THE GROCERY ITEM: ");
		try {
			addItems(input.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void removeItem() throws Exception {
		System.out.println("ENTER THE ITEM TO REMOVE: ");
		String itemNo = input.next();
		input.nextLine();
		if (groc.getCart().containsKey(itemNo)) {
			groc.getCart().remove(itemNo);
			System.out.println("THE ITEM HAS BEEN REMOVED");
		} else {
			System.err.println("ITEM NOT FOUND ");
			System.out.println();
			groceryList();
		}
	}

	public static void viewCart() {
		System.out.println("----------------------------");
		System.out.println("THE CART HAS " + groc.getCart().size() + " PRODUCTS");
		System.out.println();
		System.out.println("PRODUCTS IN CART ARE: " + groc.getCart());
		System.out.println();
	}

	public static void paymentGateway() {
		try {

			System.out.println();
			System.out.println("THE CART HAS " + groc.getCart().size() + " PRODUCTS");
			System.out.println();
			System.out.println("PRODUCTS IN CART ARE: " + groc.getCart());

			for (Map.Entry<String, Integer> string : groc.getCart().entrySet()) {
				System.out.println("product- " + string.getKey() + " price- " + "RS." + string.getValue());
				groc.setAmount(groc.getAmount() + string.getValue());
			}

			System.out.println("THE PURCHASE AMOUNT FOR THE FINAL PRODUCT is .Rs:  " + groc.getAmount());
			DbConnection db = new DbConnection();
			db.dbConnection(groc);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}