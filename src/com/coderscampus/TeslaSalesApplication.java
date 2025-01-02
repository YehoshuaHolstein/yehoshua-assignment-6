package com.coderscampus;

import java.util.List;

public class TeslaSalesApplication {

	public static void main(String[] args) {
		FileService fileService = new FileService();
		SalesService salesService = new SalesService();
		
		System.out.println("Model 3 Yearly Sales Report");
		System.out.println("---------------------");
		List<Sales> model3Data = fileService.read("model3.csv");
		salesService.salesGroupBy(model3Data);
		System.out.println("The best month for Model 3 was: " + salesService.salesMaxMonth(model3Data));
        System.out.println("The worst month for Model 3 was: " + salesService.salesMinMonth(model3Data));
		System.out.println("");
		
		System.out.println("Model S Yearly Sales Report");
		System.out.println("---------------------");
		List<Sales> modelSData = fileService.read("modelS.csv");
		salesService.salesGroupBy(modelSData);
		System.out.println("The best month for Model S was: " + salesService.salesMaxMonth(modelSData));
        System.out.println("The worst month for Model S was: " + salesService.salesMinMonth(modelSData));
		System.out.println("");
		
		System.out.println("Model X Yearly Sales Report");
		System.out.println("---------------------");
		List<Sales> modelXData = fileService.read("modelX.csv");
		salesService.salesGroupBy(modelSData);
		System.out.println("The best month for Model X was: " + salesService.salesMaxMonth(modelXData));
        System.out.println("The worst month for Model X was: " + salesService.salesMinMonth(modelXData));
		System.out.println("");
	
	}

}
