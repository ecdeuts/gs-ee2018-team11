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

package utility;

/**
 * Utility class to validate inputs
 */
public class InputValidator {

    // TODO - write a method that will validate your JSON input files

    // TODO - write a method that will validate the inputs to the Company Resource
   List<Company> companies = new ArrayList<Company>();
   companies = FileJSONReaderCompany.getCompanies();

   public static boolean check_name(String name) {
       if name == null {
           return false;
       }
       for (int i = 0; i < companies.length; i++) {
           if name.equals(companies[i].get_sym() {
               return true;
            }
        }
        return false;
    }


    // TODO - write a method that will validate the inputs to the Stock Resource
    public static boolean check_date(String start, String end) {
        if ((start == null) || (end == null)) {
            return false;
        }

        String[] st = start.split("/");
        String[] ed = end.split("/");

        if ((Integer.parseInt(st[2]) != 2018) || (Integer.parseInt(ed[2]) != 2018) || (Integer.parseInt(st[2]) > Integer.parseInt(ed[2]))) {
            return false;
        }
        else if (Integer.parseInt(st[0]) > Integer.parseInt(ed[0])) {
            return false;
        }
        else if (Integer.parseInt(st[0]) == Integer.parseInt(ed[0])) {
            if (Integer.parseInt(st[1]) > Integer.parseInt(ed[1])) {
                return false;
            }
        }
        return true;
    }
}
