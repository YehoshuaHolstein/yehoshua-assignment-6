package com.coderscampus;

import java.time.Month;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesService {
	
	public void salesGroupBy(String filePath) {
	
		FileService fileService = new FileService();
		List<Sales> salesYearData = fileService.read(filePath); 
		
		Map<Integer, Integer> groupedByYear = salesYearData.stream().collect
			  (Collectors.groupingBy(Sales::getYear,
				Collectors.summingInt(Sales::getSalesAmount)));
		groupedByYear
			.forEach((key, value) -> System.out.println(key + " -> " + value));

        System.out.println("");
        
        List<Sales> salesMonthData = fileService.read(filePath); 
        Map<Month, Integer> groupedByMonth = salesMonthData.stream().collect
  			  (Collectors.groupingBy(Sales::getMonth,
  				Collectors.summingInt(Sales::getSalesAmount)));
        Month maxKey = Collections.max(groupedByMonth.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        Month minKey = Collections.min(groupedByMonth.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        
        System.out.println("The best month for Model 3 was: " + maxKey);
        System.out.println("The worst month for Model 3 was: " + minKey);
        
	}	
}
