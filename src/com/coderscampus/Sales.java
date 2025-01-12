package com.coderscampus;

import java.time.YearMonth;

public class Sales {

	private YearMonth monthYear;
	private int salesAmount;

	public Sales(YearMonth monthYear, int salesAmount) {
		this.monthYear = monthYear;
		this.salesAmount = salesAmount;
	}

	public YearMonth getmonthYear() {return monthYear;}
	public void setMonthYear(YearMonth monthYear) {this.monthYear = monthYear;}	
	public int getSalesAmount() {return salesAmount;}
	public void setSalesAmount(int salesAmount) {this.salesAmount = salesAmount;}
	
	public int getYear() {return monthYear.getYear();}

	@Override
	public String toString() {return "Sales [monthYear=" + monthYear + ", salesAmount=" + salesAmount + "]";}

}
