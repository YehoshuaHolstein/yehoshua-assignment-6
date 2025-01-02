package com.coderscampus;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class FileService {
	
	public List<Sales> read(String filePath) {
	
	String line;
	int index = 0;
	
	Sales[] teslaData = new Sales[32];
		
	try (
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
		bufferedReader.readLine();
		while ((line = bufferedReader.readLine()) != null) {
			String[] salesData = line.split(",");
			String dateString = salesData[0];
			
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy");
            YearMonth yearMonth = YearMonth.parse(dateString, formatter);
            System.out.println(yearMonth); 

			int salesInt = Integer.parseInt(salesData[1]);
			Sales sales = new Sales(yearMonth, salesInt);
			teslaData[index] = sales;
			index++;
			}
		} catch (IOException e) {
			System.out.println("There was a problem: " + e.getMessage());
	}
	
	List<Sales> salesModelData = Arrays.asList(teslaData);

	return salesModelData;
	
	}
}