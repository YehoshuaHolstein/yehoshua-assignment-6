package com.coderscampus;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesService {
	
	public void generateReport(List<Sales> salesData, String model) {	
		
		System.out.println("Model " + model + " Yearly Sales Report");
		System.out.println("---------------------");
		
		Map<Integer, Integer> groupedByYear = salesData.stream().collect
			  (Collectors.groupingBy(Sales::getYear,
				Collectors.summingInt(Sales::getSalesAmount)));
		groupedByYear
			.forEach((key, value) -> System.out.println(key + " -> " + value));
        System.out.println();          
        
        outputBestWorstMonth(salesData, model);
                
	}
	
	private void outputBestWorstMonth(List<Sales> salesData, String model) {
		Map<YearMonth, Integer> monthData = salesData.stream()
                .collect(Collectors.toMap(Sales::getmonthYear, Sales::getSalesAmount));
		
		YearMonth maxKey = monthData.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        
        
        YearMonth minKey = monthData.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        
        System.out.println("The best month for Model " + model + " was: " + maxKey);
        System.out.println("The worst month for Model "  + model + " was: " + minKey);
        System.out.println();
	}

}
