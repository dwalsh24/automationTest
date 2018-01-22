package com.skybet.automation.framework.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

	public String findDataForTestCase(String input) {
		String testCase = input.substring(1, input.indexOf(",")).toLowerCase();
		String heading = input.substring(input.indexOf(",")+1);
		System.out.println("Finding data for " + testCase + " " + heading);
		String data = null;
		try {
			FileReader fileReader = new FileReader("./src/test/resources/com/skybet/automation/framework/datafiles/httpTestData.csv");
			BufferedReader reader = new BufferedReader(fileReader);
			String[] headings = reader.readLine().split(",");
			int columnNumber = 0;
			for(int i = 0; i < headings.length; i++) {
				if(headings[i].equals(heading)) {
					columnNumber = i;
					break;
				}
			}
			
			String currentLine = null;
			while((currentLine = reader.readLine()) != null) {
				if(currentLine.toLowerCase().startsWith(testCase)) {
					String[] lineArray = currentLine.split(",");
					data = lineArray[columnNumber];
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Datasheet returned : " + data);
		return data;
	}
}
