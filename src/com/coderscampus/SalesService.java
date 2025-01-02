package com.coderscampus;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesService {
	
	public Map<Integer, List<Sales>> salesGroupBy(String filePath) {
	
	FileService fileService = new FileService();
	List<Sales> salesRawData = fileService.read(filePath); 
	Map<Integer, List<Sales>> groupedByYear = salesRawData.stream()
			  .collect(Collectors.groupingBy(Sales::getYear));
	
//	Map<Integer, List<Sales>> modelData = salesRawData.stream()  
//		.collect(Collectors.groupingBy(Sales::getYear, Collectors.toList()));
	
	System.out.println(groupedByYear);
	return groupedByYear;
	
	}	
}
