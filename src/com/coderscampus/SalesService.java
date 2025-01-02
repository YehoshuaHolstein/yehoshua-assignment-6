package com.coderscampus;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesService {
	
	public void salesGroupBy(List<Sales> salesData) {		
		Map<Integer, Integer> groupedByYear = salesData.stream().collect
			  (Collectors.groupingBy(Sales::getYear,
				Collectors.summingInt(Sales::getSalesAmount)));
		groupedByYear
			.forEach((key, value) -> System.out.println(key + " -> " + value));
		
        System.out.println("");
                      
	}

	public YearMonth salesMaxMonth(List<Sales> salesData) {
		Map<YearMonth, Integer> monthData = salesData.stream()
                .collect(Collectors.toMap(Sales::getmonthYear, Sales::getSalesAmount));
        
        YearMonth maxKey = monthData.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        
        return maxKey;
	}

	public YearMonth salesMinMonth(List<Sales> salesData) {
		Map<YearMonth, Integer> monthData = salesData.stream()
                .collect(Collectors.toMap(Sales::getmonthYear, Sales::getSalesAmount));
        
        YearMonth minKey = monthData.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        
        return minKey;

	}	
}
