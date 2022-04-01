package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class FileServiceImpl extends DateSale implements FileService {

	@Override
	public List<DateSale> readFile(String fileName) {

		BufferedReader fileReader = null;

		File file = new File(fileName);
		try {
			fileReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String line = null;
		String[] lineData = null;
		// create a students array
		List<DateSale> dateSales = new ArrayList<>();
		LocalDate ld = null;
		int i = 0;
		try {
			while ((line = fileReader.readLine()) != null) {
				if (i > 0) {

					lineData = line.split(",");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy").withLocale(Locale.US);

					ld = LocalDate.parse("01-" + lineData[0].split("-")[0] + "-" + lineData[0].split("-")[1],
							formatter);
//					DateSale dateSale = new DateSale(lineData[0], Integer.valueOf(lineData[1]), ld.getMonthValue(),
//							ld.getYear());
					DateSale dateSale = new DateSale(lineData[0], Integer.valueOf(lineData[1]), ld.getMonth(),
							ld.getYear());

					dateSales.add(dateSale);
				}
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sumSalesByYear(dateSales);

		getBestAndWorstMonthSale(dateSales);

		return dateSales;
	}

	public void getBestAndWorstMonthSale(List<DateSale> dateSales) {
		String worstMonth = null;
		String bestMonth = null;
		IntSummaryStatistics stats = dateSales.stream()
				.mapToInt((x) -> x.getSales()).summaryStatistics();
		for (DateSale dateSale : dateSales) {
			if (dateSale.getSales().equals(stats.getMax())) {
				bestMonth = dateSale.getYear() + "-" + dateSale.getMonth().getDisplayName(TextStyle.SHORT, Locale.US);
			}

			if (dateSale.getSales().equals(stats.getMin())) {
				worstMonth = dateSale.getYear() + "-" + dateSale.getMonth().getDisplayName(TextStyle.SHORT, Locale.US);
			}
		}
		System.out.println("");
		System.out.println("The best month for Model 3 was: " + bestMonth);
		System.out.println("The worst month for Model 3 was: " + worstMonth);
	}

	public void sumSalesByYear(List<DateSale> dateSales) {
		// sum sales by years
		Map<Integer, Integer> sumGroupByYear = dateSales.stream()
				.collect(Collectors.groupingBy(DateSale::getYear, Collectors.summingInt(DateSale::getSales)));
		// Display: sum sales by years
		sumGroupByYear.forEach((key, value) -> System.out.println(key + "-> " + value));
	}

	


}