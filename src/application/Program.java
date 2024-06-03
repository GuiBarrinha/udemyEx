package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enun.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter cliente data:  ");

		System.out.print("Name: ");
		String nameClient = sc.nextLine();

		System.out.print("Email: ");
		String emailClient = sc.nextLine();

		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());

		Client client = new Client(nameClient, emailClient, birthDate);
		
		
		System.out.println("Enter order data: ");

		System.out.print("Status: ");
		String status = sc.next();

		

		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);

		System.out.print("How many items to this order? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data");
			System.out.print("Product name: ");
			String nameProduct = sc.next();
			System.out.print("Product price: ");
			Double priceProduct = sc.nextDouble();
			
			Product product = new Product(nameProduct, priceProduct);
			
			System.out.print("Quantity: ");
			int quantityProduct = sc.nextInt();		

			OrderItem orderItem = new OrderItem(quantityProduct, priceProduct, product);
			order.addItem(orderItem);
		}
		System.out.println("Saida programa");
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);

	}

}
