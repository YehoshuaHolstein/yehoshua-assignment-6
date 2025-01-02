package com.coderscampus;

public class TeslaSalesApplication {

	public static void main(String[] args) {
		System.out.println("Model 3 Yearly Sales Report");
		System.out.println("---------------------");
		SalesService salesService = new SalesService();
		salesService.salesGroupBy("model3.csv");
	
	}

}
