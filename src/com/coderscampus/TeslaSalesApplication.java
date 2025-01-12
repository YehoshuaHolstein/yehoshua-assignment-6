package com.coderscampus;

import java.util.List;

public class TeslaSalesApplication {

	public static void main(String[] args) {
		FileService fileService = new FileService();
		SalesService salesService = new SalesService();
		
		String[] models = {"3", "S", "X"};
		
		for (String model : models) {
			List<Sales> data = fileService.read("model" + model + ".csv");
			salesService.generateReport(data, model);
		}
			
	}

}
