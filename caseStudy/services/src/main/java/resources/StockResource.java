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


// TODO - add your @Path here
@Path("stock")
public class StockResource {

    // TODO - Add a @GET resource to get stock data
    @GET
    @Path("stockTicker/{stockTicker}/startDat/{startDate}/endDate/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    // Your service should return data based on 3 inputs
    // Stock ticker, start date and end date
    public List<Company> getCompany(@PathParam("stockTicker") String ticker, @PathParam("startDate") String startdate, @PathParam("endDate") String enddate) throws IOException, ParseException {
        Date sd = DATEFORMAT.parse(startdate);
        Date ed = DATEFORMAT.parse(enddate);
        
        List<Stock> stocks = new ArrayList<>();
        stocks = FileJSONReaderStock.getStocks();

        for (int i=0; i < companies.length; i++) {
            if (companies[i].get_sym().equalsIgnoreCases(ticker)) {  
                return companies[i];
            }
        }
        return null;
    }


}
