package aplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Item;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		String[] itemSource = new String[] {"TV LED ,1290.99 ,1", "Video Game Char ,350.50 ,3", "Samsung Galaxy 9 ,850.00 ,2"};
		String pathSource = "c:\\temp\\source.txt";
		String pathSummary = "c:\\temp\\out\\summary.csv";
		List<Item> list = new ArrayList<>();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathSource))) {
			for (String items : itemSource) {
				bw.write(items);
				bw.newLine();
				String[] itemVect = items.split(" ,");
				String name = itemVect[0];
				double price = Double.parseDouble(itemVect[1]);
				int quantity = Integer.parseInt(itemVect[2]);
				list.add(new Item(name, price, quantity));
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathSummary))) {
			for (Item i : list) {
				bw.write(i.getName() + "," + i.totalPrice());
				bw.newLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
