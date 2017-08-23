package com.metacube.dao;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.metacube.model.Employee;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class EmployeeDao {
	List<Employee> employeeList = new ArrayList<Employee>();

	/**
	 * write to json file
	 */
	public void writeToFile(List<Employee> employeeList) {
		try (FileWriter file = new FileWriter(
				"C:/Users/Ram/Desktop/details.json",
				true);
			
				BufferedWriter bw = new BufferedWriter(file);
				PrintWriter out = new PrintWriter(bw)) {
			ObjectMapper mapper = new ObjectMapper();
			for (Employee temp : employeeList) {
				String jsonInString = mapper.writeValueAsString(temp);
				out.println(jsonInString);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * update the complete json file
	 * 
	 * @param employeeList
	 */
	public void writeAfterDelete(List<JSONObject> employeeList) {
		try (FileWriter file = new FileWriter(
				"C:/Users/Ram/Desktop/details.json");
				BufferedWriter bw = new BufferedWriter(file);
				PrintWriter out = new PrintWriter(bw)) {
			ObjectMapper mapper = new ObjectMapper();
			for (JSONObject temp : employeeList) {
				String jsonInString = mapper.writeValueAsString(temp);
				out.println(jsonInString);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @return list of json objects
	 * @throws org.json.simple.parser.ParseException
	 */
	public List<JSONObject> readFromFile()
			throws org.json.simple.parser.ParseException {
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		List<JSONObject> list = new ArrayList<JSONObject>();
		
		try {
			List<String> l = new ArrayList<String>();
			l = Files
					.readAllLines(Paths
							.get("C:/Users/RAM/Desktop/details.json"));
			for (String s : l) {
				obj = (JSONObject) parser.parse(s);
				list.add((JSONObject) obj);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @return list of employees
	 * @throws org.json.simple.parser.ParseException
	 */
	public List<Employee> getList()
			throws org.json.simple.parser.ParseException {
		readFromFile();
		return employeeList;
	}

}