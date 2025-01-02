package com.coderscampus;

import java.time.Month;
import java.time.YearMonth;

public class Sales {
	
	private YearMonth monthYear;
	private int salesAmount;
	
	public Sales(YearMonth monthYear, int salesAmount) {
		this.monthYear = monthYear;
		this.salesAmount = salesAmount;
	}
	
	public YearMonth getmonthYear() {
		return monthYear;
	}

	public int getYear() {
		return monthYear.getYear();
	}
	
	public Month getMonth() {
		return monthYear.getMonth();
	}
	
	public void setmonthYear(YearMonth monthYear) {
		this.monthYear = monthYear;
	}
	public int getSalesAmount() {
		return salesAmount;
	}
	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}

	@Override
	public String toString() {
		return "Sales [monthYear=" + monthYear + ", salesAmount=" + salesAmount + "]";
	}
	
	
	
}
