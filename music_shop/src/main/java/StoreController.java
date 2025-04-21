import java.util.ArrayList;
import java.util.Scanner;

public class StoreController {
	public static void addNewProduct(ArrayList<SmartphoneInventoryModel>smartphoneInventory)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter model code:");
		String modelCode = scanner.next();
		
		for (SmartphoneInventoryModel smartphone : smartphoneInventory)
		{
			if (smartphone.getModelCode().equals(modelCode))
			{
				System.out.println("Product with model code " + modelCode + " already exists.");
				return;
			}
		}
		
		System.out.println("Enter name:");
		String name = scanner.next();
		
		System.out.println("Enter display size:");
		double displaySize = scanner.nextDouble();
		
		System.out.println("Enter price:");
		double price = scanner.nextDouble();
		
		System.out.println("Enter memory:");
		int memory = scanner.nextInt();
		
		System.out.println("Enter RAM:");
		int ram = scanner.nextInt();
		
		SmartphoneInventoryModel smartphone = new SmartphoneInventoryModel(modelCode, name, displaySize, price, memory, ram);
		smartphoneInventory.add(smartphone);
		
		System.out.println("Smartphone added successfully!");
	}
	
	public static void deleteProduct(ArrayList<SmartphoneInventoryModel>smartphoneInventory)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter model code to delete:");
		String modelCode = scanner.next();
		
		int indexToRemove = -1;
		for (int i = 0; i < smartphoneInventory.size(); i++)
		{
			if (smartphoneInventory.get(i).getModelCode().equals(modelCode))
			{
				indexToRemove = i;
				break;
			}
		}
		
		if (indexToRemove != -1)
		{
			smartphoneInventory.remove(indexToRemove);
			System.out.println("Smartphone with model code " + modelCode + " deleted successfully!");
		}
		
		else
		{
			System.out.println("Smartphone with model code " + modelCode + " not found.");
		}
	}
	
	public static void updateProduct(ArrayList<SmartphoneInventoryModel> smartphoneInventory) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter model code to update:");

		String modelCode = scanner.next();


		// Find the index of the smartphone with the provided model code

		int indexToUpdate = -1;

		for (int i = 0; i < smartphoneInventory.size(); i++) {

		if (smartphoneInventory.get(i).getModelCode().equals(modelCode)) {

		indexToUpdate = i;

		break;

		}

		} 
		if (indexToUpdate != -1) {

			System.out.println("Enter new name:");

			String newName = scanner.next();


			System.out.println("Enter new display size:");

			double newDisplaySize = scanner.nextDouble();


			System.out.println("Enter new price:");

			double newPrice = scanner.nextDouble();


			System.out.println("Enter new memory:");

			int newMemory = scanner.nextInt();


			System.out.println("Enter new RAM:");

			int newRam = scanner.nextInt();


			// Use SmartphoneInventoryModel to collect and update the data

			SmartphoneInventoryModel updatedSmartphone = new SmartphoneInventoryModel(

			modelCode, newName, newDisplaySize, newPrice, newMemory, newRam);


			// Update the modified data in ArrayList<SmartphoneInventoryModel>

			smartphoneInventory.set(indexToUpdate, updatedSmartphone);


			System.out.println("Smartphone with model code " + modelCode + " updated successfully!");

			}else {

System.out.println("Smartphone with model code " + modelCode + " not found.");

}

}
	public static void getSmartphoneInfo(ArrayList<SmartphoneInventoryModel> smartphoneInventory) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter model code to get information:");

		String modelCode = scanner.next();


		// Find the smartphone with the provided model code

		for (SmartphoneInventoryModel smartphone : smartphoneInventory) {

		if (smartphone.getModelCode().equals(modelCode)) {

		// Display the information about the smartphone

		System.out.println("Model Code: " + smartphone.getModelCode());
		System.out.println("Name: " + smartphone.getName());
		System.out.println("Display Size: " + smartphone.getDisplaySize());
		System.out.println("Price: " + smartphone.getPrice());
		System.out.println("Memory: " + smartphone.getMemory());
		System.out.println("RAM: " + smartphone.getRam());
		return;

		}

		}
		//Display a message if the smartphone is not found

		System.out.println("Smartphone with model code " + modelCode + " not found.");

		}
}
