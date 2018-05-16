package main.java.utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileJSONReaderCompany {
	String fileStr; 
	JSONArray a;

	public FileJSONReaderCompany(String file) {
		this.fileStr = file;
		JSONParser parser = new JSONParser();
		try {
			a = (JSONArray) parser.parse(new FileReader(file));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

    // Returns a list of all companies 
	public List<Company> getCompanies() {
		List<Company> companyList = new ArrayList<Company>();

		for (Object o : a) {
			JSONObject company = (JSONObject) o;

            String symbol = (String) company.get("symbol");
            String name = (String) company.get("name");
            String headquartersCity = (String) company.get("headerquartersCity");
            String headquartersStateOrCountry = (String) company.get("headquartersStateOrCountry");
			
			Long numberOfEmployeesLong = (Long) company.get("numberOfEmployees");
			int numberOfEmployees = toIntExact(numberOfEmployeesLong);
            
            String sector = (String) company.get("sector");
            String industry = (String) company.get("industry");

			Company c = new Company(symbol, name, headquartersCity, headquartersStateOrCountry, numberOfEmployees, sector, industry);
			companyList.add(c);
		}
		return companyList;
	}
}