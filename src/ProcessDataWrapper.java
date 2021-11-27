import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProcessDataWrapper {

    public static String[] stringToValuesArray(String input) {
        input = input.trim();
        if (input.length() == 0) {
            return new String[0];
        }
        String[] parts = input.split(",");
        return parts;
    }

    public static CustomerData stringToCustomerData(String input) {
        String[] customerDataValues = stringToValuesArray(input);

        if (validateCustomerData(customerDataValues, input)){
            return new CustomerData(stringToValuesArray(input));
        }
        return null;
    }

    public static void populateCustomerMap(String input, Map<String, List<CustomerData>> customerDataMap) {
        CustomerData data = stringToCustomerData(input);
        if (data == null) {
            return;
        }
        if (customerDataMap.get(data.getGeoZone()) != null) {
            customerDataMap.get(data.getGeoZone()).add(data);
        } else {
            customerDataMap.put(data.getGeoZone(), new ArrayList<>() {{
                add(data);
            }});
        }
    }

    public static boolean validateCustomerData(String[] customerDataValues, String input) {
        if (customerDataValues.length < 6){
            System.out.println("");
            System.out.println(input + " has less than required data, skipping it for data process");
            return false;
        }
        return true;
    }
}