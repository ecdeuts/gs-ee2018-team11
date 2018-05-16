package main.java.utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileJSONReaderStock {
	String fileStr; 
	JSONArray a;

	public FileJSONReaderStock(String file) {
		this.fileStr = file;
		JSONParser parser = new JSONParser();
		try {
			a = (JSONArray) parser.parse(new FileReader(file));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

    // Returns a list of all stocks
	public List<Stock> getStocks() {
        List<Stock> stockList = new ArrayList<Stock>();

        // Parse each company's stock listings
        for (Object o : a) {
            JSONObject stock = (JSONObject) o;

            String name = (String) stock.get("name");

            // Parse and create a hash table of stock values (key: stock date, value: stock price)
			HashMap<String, Integer> stockValues = new HashMap<String, Integer>();
            JSONObject stockValuesObj = (JSONObject) stock.get("dailyClosePrice");
			Iterator<?> keys = stockValuesObj.keys();

			while(keys.hasNext()) {
				String key = (String)keys.next();
				if (stockValuesObj.get(key) instanceof Integer) {
					stockValues.add(key, stockValuesObj.get(key));
				}
				else {
					System.out.println("error: the type of value in stock values is not of type Integer");
				}
			}
			Stock s = new Stock(name, stockValues);
			stockList.add(s);
        }
        return stockList;

    }
}