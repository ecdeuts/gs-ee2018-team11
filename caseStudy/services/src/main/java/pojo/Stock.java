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

package pojo;

/**
 * This class will define a company's end-of-day stock price
 * Look at resources/data/historicalStockData.json
 */
public class Stock {

    // TODO - Think back to your modelling session
    // Define the attributes of a stock price based on the
    // provided data in resources/data
    private String name;
    private HashMap<String, Integer> dailyClosePrice;

    public Stock(String name, HashMap<String, Integer> prices) {
        this.name = name;
        dailyClosePrice = prices;
    } 

    // TODO - add getter and setter methods for your attributes

    public String get_name() {
        return this.name;
    }

    public HashMap<String, Integer> get_prices() {
        return this.dailyClosePrice;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public void set_prices(HashTree<String, Integer> prices) {
        dailyClosePrice = prices;
    }
}
