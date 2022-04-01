package com.coderscampus.assignment6;

import java.time.Month;
import java.util.Date;

public class DateSale {

	String monthYear;
	Integer sales;
	int year;
	Month month;
	// int month;

	DateSale() {
		// System.out.println("DateSale created");
	}

	// DateSale(String date, String sales){
	DateSale(String monthYear, Integer sales) {
		this.monthYear = monthYear;
		this.sales = sales;
	}

//	public DateSale(String monthYear, Integer sales, int month, int year) {
//		this.monthYear = monthYear;
//		this.sales = sales;
//		this.month = month;
//		this.year = year;
//	}

	public DateSale(String monthYear, Integer sales, Month month, int year) {

		this.monthYear = monthYear;
		this.sales = sales;
		this.month = month;
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

//	public int getMonth() {
//		return month;
//	}

//	public void setMonth(int month) {
//		this.month = month;
//	}

	public String getDate() {
		return monthYear;
	}

	public void setDate(String date) {
		this.monthYear = date;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "DateSale [monthYear=" + monthYear + ", sales=" + sales + ", month=" + month + ", year=" + year + "]";
	}

}
