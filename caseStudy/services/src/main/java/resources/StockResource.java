/**
 * Copyright 2018 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package resources;

@Path("stock")
public class StockResource {

    @GET
    @Path("stockTicker/{stockTicker}/startDate/{startDate}/endDate/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    // Your service should return data based on 3 inputs
    // Stock ticker, start date and end date
    public List<Company> getStock(@PathParam("stockTicker") String ticker, @PathParam("startDate") String startdate, @PathParam("endDate") String enddate) throws IOException, ParseException {
        Date sd = DATEFORMAT.parse(startdate);
        Date ed = DATEFORMAT.parse(enddate);
        
        FileJSONReaderStock stockReader = new FileJSONReaderStock();
        List<Stock> stocks = stockReader.getStocks();

        // Find the correct company
        FileJSONReaderCompany companyReader = new FileJSONReaderCompany();
        List<Company> companies = companyReader.getCompanies();
        Company targetCompany;

        for (int i=0; i < companies.length; i++) {
            if (companies[i].get_sym().equalsIgnoreCase(ticker)) {
                targetCompany = companies[i];
                break;
            }
        }

        // Find the correct stock from stocks list
        Stock targetStock;
        for (Stock s : stocks) {
            if (s.getName().equalsIgnoreCase(ticker)) {
                targetStock = s;
                break;
            }
        }

        // Check that correct stock has been found
        if (targetStock == null) {
            throw new IllegalArgumentException("stock ticker invalid in stock get request");
        }

        // Find the stock values between the start and end dates
        boolean continue = true;
        String currentDate = startdate;
        String month = currentDate.substring(0, 1);
        String currentMonthEnd = getMonthEndDate(month);
        JSONObject output = new JSONObject();
        List<Integer> outputStockPrices = new ArrayList<Integer>();

        while (continue) {
            if (currentDate.equalsIgnoreCase(endDate)) {
                continue = false;
                break;
            }

            HashMap<String, Integer> dailyClosePrices = targetStock.get_prices();
            outputStockPrices.add(dailyClosePrices.get(currentDate));

            // Update current date
            if (currentDate.substring(3, 4).equals(currentMonthEnd)) {
                // Check if we have reached the end of the month
                month = getNextDay(month);
                String day = "01";
                currentDate = month + "/" + day + "/" + currentDate.substring(6);
            }
            else {
                currentDate = month + "/" + getNextDay(currentDate.substring(3, 4)) + "/" + currentDate.substring(6);
            }
            System.out.println(currentDate);
        }

        // Return a JSONObject
        output.put("y", outputStockPrices.toArray(new Integer[outputStockPrices.size()]));
        return output;
    }

    private String getMonthEndDate(String month) {
        if (months.equals("01") || month.equals("03") || month.equals("05") || month.equals("07") || month.equals("08")
                || month.equals("10") || month.equals("12")) {
            return "31";
        }
        if (month == 2) return "28";
        if (month.equals("04") || month.equals("06") || month.equals("09") || month.equals("11")) return "30";

    }

    private String getNextDay(String day) {
        int currentDay = Integer.parseInt(day, 10);
        int nextDay = currentDay + 1;
        String output = nextDay.toString();
        if (nextDay < 10) {
            output = "0" + output;
        }
        return output;
    }


}
