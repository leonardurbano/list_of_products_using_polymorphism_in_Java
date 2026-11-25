package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int numberProducts = sc.nextInt();
		
		for (int i = 1; i <= numberProducts; i++) {
			System.out.printf("Product #%d data:%n", i);
			System.out.print("Common, userd or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.next();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(ch == 'c') {
				list.add(new Product(name, price));
			}else if (ch == 'i') {
				System.out.print("Customs Fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}else {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				String data = sc.next();
				list.add(new UsedProduct(name, price, LocalDate.from(dtf.parse(data))));
			}
			
		}
		
		System.out.println("------------------------------------------");
		System.out.println("PRICE TAGS:");
		System.out.println("------------------------------------------");
		
		for (Product product : list) {
			System.out.println(product.priceTag());
		}
		
		sc.close();
	}

}
