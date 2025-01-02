package com.coderscampus;

import java.time.Month;
import java.time.YearMonth;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalesService {
	
	public void salesGroupBy(String filePath) {
	
		FileService fileService = new FileService();
		List<Sales> salesData = fileService.read(filePath); 
		
		Map<Integer, Integer> groupedByYear = salesData.stream().collect
			  (Collectors.groupingBy(Sales::getYear,
				Collectors.summingInt(Sales::getSalesAmount)));
		groupedByYear
			.forEach((key, value) -> System.out.println(key + " -> " + value));
		
        System.out.println("");
                
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
        
        System.out.println("The best month for Model 3 was: " + maxKey);
        System.out.println("The worst month for Model 3 was: " + minKey);
        
	}	
}
