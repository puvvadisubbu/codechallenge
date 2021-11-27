import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessDataReport {
    static Map<String, Integer> avgBuildTime = new HashMap<>(0);
    static Map<String, List<String>> customerIdsPerZone = new HashMap<>(0);
    static Map<String, List<String>> customerIdsPerContract = new HashMap<>(0);

    public static void processDataForReport(Map<String, List<CustomerData>> customerDataMap) {
        for (String name : customerDataMap.keySet()) {
            prepareDataForReport(customerDataMap.get(name), name);
        }
    }

    /**
     * calculates avg build times
     * prepare customerIds per geo zone
     * prepare customerIds per contract
     * if you need to enhance write a different method to prepare data and invoke it from here.
     * @param customerDataList
     * @param name
     */
    private static void prepareDataForReport(List<CustomerData> customerDataList, String name) {
        customerDataList.forEach(customerData -> {
            calculateAvgBuildTimes(avgBuildTime, name, customerData);
            customerIdsPerZone(customerIdsPerZone, name, customerData);
            customerIdsPerContract(customerIdsPerContract, customerData);
        });
    }

    /**
     * print data based on requirements
     * if you need to enhance write a different method to print and invoke it from here.
     */
    public static void printData() {
        printCustomerIdsPerContract(customerIdsPerContract);
        printCusomerIdsPerZone(customerIdsPerZone);
        printAvgBuildTimePerZone(avgBuildTime);
        printUniqueCustomerIdsPerZone(customerIdsPerZone);
    }

    private static void printUniqueCustomerIdsPerZone(Map<String, List<String>> customerIdsPerZone) {
        System.out.println("*******************************************");
        System.out.println("\033[1mThe list of unique customerId for each geo zone\033[0m");
        System.out.println("***********************************************");
        for (String zoneId : customerIdsPerZone.keySet()) {
            System.out.println(zoneId + " has customers " + customerIdsPerZone.get(zoneId));
        }
    }

    private static void printAvgBuildTimePerZone(Map<String, Integer> avgBuildTime) {
        System.out.println("*************************************************");
        System.out.println("\033[1mThe average build duration for each geo zone\033[0m");
        System.out.println("*******************************************");
        for (String zoneId : avgBuildTime.keySet()) {
            System.out.println("average build duration for " + zoneId + " is " + avgBuildTime.get(zoneId) + "s");
        }
    }

    private static void printCusomerIdsPerZone(Map<String, List<String>> customerIdsPerZone) {
        System.out.println("****************************************************");
        System.out.println("\033[1mThe number of unique customerId for each geo zone\033[0m");
        System.out.println("*************************************************");
        for (String zoneId : customerIdsPerZone.keySet()) {
            System.out.println(zoneId + " has " + customerIdsPerZone.get(zoneId).size() +
                    " unique customerIds");
        }
    }

    private static void printCustomerIdsPerContract(Map<String, List<String>> customerIdsPerContract) {
        System.out.println("****************************************************");
        System.out.println("\033[1mThe number of unique customerId for each contractId\033[0m");
        System.out.println("****************************************************");
        for (String contractId : customerIdsPerContract.keySet()) {
            System.out.println("contract " + contractId + " has " + customerIdsPerContract.get(contractId).size() +
                    " unique customerIds");
        }
    }

    private static void customerIdsPerContract(Map<String, List<String>> customerIdsPerContract, CustomerData customerData) {
        if (customerIdsPerContract.get(customerData.getContractId()) != null &&
                !customerIdsPerContract.get(customerData.getContractId()).contains(customerData.getCustomerId())) {
            customerIdsPerContract.get(customerData.getContractId()).add(customerData.getCustomerId());
        } else {
            customerIdsPerContract.put(customerData.getContractId(), new ArrayList<>() {{
                add(customerData.getCustomerId());
            }});
        }
    }

    private static void calculateAvgBuildTimes(Map<String, Integer> avgBuildTime, String name, CustomerData customerData) {
        avgBuildTime.put(name,
                avgBuildTime.get(name) != null ?
                        ((avgBuildTime.get(name) + customerData.getBuildDuration()) / 2) :
                        customerData.getBuildDuration());
    }

    private static void customerIdsPerZone(Map<String, List<String>> customerIdsPerZone, String name, CustomerData customerData) {
        if (customerIdsPerZone.get(name) != null &&
                !customerIdsPerZone.get(name).contains(customerData.getCustomerId())) {
            customerIdsPerZone.get(name).add(customerData.getCustomerId());
        } else {
            customerIdsPerZone.put(name, new ArrayList<>() {{
                add(customerData.getCustomerId());
            }});
        }
    }
}