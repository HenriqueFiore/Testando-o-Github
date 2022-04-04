package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

public static void main(String[] args) throws ParseException {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	
	System.out.println("Enter client date: ");
	System.out.print("Name: ");
	String name = sc.nextLine();
	System.out.print("Email: ");
	String email = sc.nextLine();
	System.out.print("Birth Date: ");
	Date birth = sdf.parse(sc.next());
	Client client = new Client(name, email, birth);
	
	System.out.println("Enter Order Data:");
	System.out.print("Status: ");
	OrderStatus status = OrderStatus.valueOf(sc.next());
	
	Order order = new Order(birth, status, client);
	
	System.out.print("How many items to this order? ");
	int n = sc.nextInt();
	
	for (int i=1;i<=n;i++) {
		sc.nextLine();
		System.out.println("Enter #" + i + " item data:");
		System.out.print("Product name: ");
		String pname = sc.nextLine();
		System.out.print("Product price: ");
		double price = sc.nextDouble();
		System.out.print("Quantity: ");
		int quantity = sc.nextInt();
		
		Product product = new Product(pname, price);
		OrderItem it = new OrderItem(quantity, price, product);
		order.addItem(it);
	}
	
	System.out.println();
	System.out.println("Order Sumary:");
	System.out.println(order.toString());
	
	sc.close();
}

}
