package com.coderscampus;

import java.util.List;
import java.util.Map;

public class TeslaSalesApplication {

	public static void main(String[] args) {
		SalesService salesService = new SalesService();
		salesService.salesGroupBy("model3.csv");
	
	}

}
