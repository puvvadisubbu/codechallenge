import java.util.*;

public class ProcessDataWrapper {

    public static String[] stringToValuesArray(String input) {
        input = input.trim();
        if (input.length() == 0) {
            return new String[0];
        }
        return input.split(",");
    }

    public static CustomerData stringToCustomerData(String input) {
        String[] customerDataValues = stringToValuesArray(input);

        if (validateCustomerData(customerDataValues, input)){
            return new CustomerData(stringToValuesArray(input));
        }
        return null;
    }

    public static boolean validateCustomerData(String[] customerDataValues, String input) {
        if (customerDataValues.length < 6){
            System.out.println("\n");
            System.out.println(input + " has less than required data, skipping it for data process");
            return false;
        }
        return true;
    }

    public static void populateCustomerPerGeoZone(CustomerData data, Map<String, GeoZoneData> geoZoneDataMap) {
        if (data == null) {
            return;
        }

        if (geoZoneDataMap.get(data.getGeoZone()) != null) {
            GeoZoneData geoZoneData = geoZoneDataMap.get(data.getGeoZone());
            geoZoneData.getCustomerIds().add(data.getCustomerId());
            geoZoneData.getContractIds().add(data.getContractId());
            geoZoneData.setAvgBuildTime((geoZoneData.getAvgBuildTime()+ data.getBuildDuration())/2);
        } else {
            GeoZoneData geoZoneData = new GeoZoneData();
            geoZoneData.setGeoZone(data.getGeoZone());
            geoZoneData.setAvgBuildTime(data.getBuildDuration());
            geoZoneData.setContractIds(new TreeSet<>(){{
                add(data.getContractId());
            }});
            geoZoneData.setCustomerIds(new TreeSet<>(){{
                add(data.getCustomerId());
            }});
            geoZoneDataMap.put(data.getGeoZone(), geoZoneData);
        }
    }

    public static void populateCustomerPerContract (CustomerData data, Map<String, ContractData> contractDataMap){
        if (data == null) {
            return;
        }

        if (contractDataMap.get(data.getContractId()) != null) {
            ContractData contractData = contractDataMap.get(data.getContractId());
            contractData.getCustomerIds().add(data.getCustomerId());
            contractData.setAvgBuildTime((contractData.getAvgBuildTime()+ data.getBuildDuration())/2);
        } else {
            ContractData contractData = new ContractData();
            contractData.setGeoZone(data.getGeoZone());
            contractData.setAvgBuildTime(data.getBuildDuration());
            contractData.setContractId(data.getContractId());
            contractData.setCustomerIds(new TreeSet<>(){{
                add(data.getCustomerId());
            }});
            contractDataMap.put(data.getContractId(), contractData);
        }
    }
}