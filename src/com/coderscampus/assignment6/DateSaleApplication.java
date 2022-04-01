package com.coderscampus.assignment6;

public class DateSaleApplication {

	public static void main(String[] args) {
		FileService fileService = new FileServiceImpl();

		System.out.println("");
		System.out.println("Model 3 Yearly Sales Report\r\n" + "-------------------");
		fileService.readFile("model3.csv");

		System.out.println("");
		System.out.println("Model S Yearly Sales Report\r\n" + "-------------------");
		fileService.readFile("modelS.csv");

		System.out.println("");
		System.out.println("Model X Yearly Sales Report\r\n" + "-------------------");
		fileService.readFile("modelX.csv");

	}

}
