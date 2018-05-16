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
 * This class will define a company and its attributes
 * Look at resources/data/companyInfo.json
 */
public class Company {

    // TODO - Think back to your modelling session
    // Define the attributes of a Company based on the
    // provided data in resources/data
    private String symbol;
    private String name;
    private String headquartersCity;
    private String headquartersStateOrCountry;
    private int numberOfEmployees;
    private String sector;
    private String industry;
    
    //constructor of Company constructor 
    public Company(String sym, String name, String hqC,String hqSC, int number, String sec, String indus){
            symbol=sym;
            this.name=name;
            headquartersCity=hqC;
            headquartersStateOrCountry=hqSC;
            numberOfEmployees=number;
            sector=sec;
            industry=indus;
            
    }

    // TODO - add getter and setter methods for your attributes
    public String get_sym() {
        return symbol;
    }

    public String get_name() {
        return name;
    }

    public String get_hqC() {
        return hqCity;
    }

    public String get_hqSC() {
        return hqStateOrCountry;
    }

    public int get_number() {
        return number_of_employee;
    }

    public String get_sec() {
        return sector;
    }

    public String get_indus() {
        return industry;
    }

    public void set_sym(String sym) {
        symbol = sym;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public void set_hqC(String hqC) {
        hqCity = hqC;
    }    

    public void set_hqSC(String hqSC) {
        hqStateOrCountry = hqSC;
    }

    public void set_number(int number) {
        number = number_of_employee;
    }

    public void set_sec(String sec) {
        sector = sec;
    }

    public void set_indus(String indus) {
        industry = indus;
    }
}
