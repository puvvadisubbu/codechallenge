import java.util.Collection;

public class PrintDataReport implements DataReport {

    /**
     * print data based on requirements
     * if you need to enhance write a different method to print and invoke it from here.
     */
    public void printData(Collection<GeoZoneData> geoZoneDataMap,
                          Collection<ContractData> contractDataMap) {
        // print per contract related data
        if (contractDataMap.isEmpty()) {
            System.out.println("No contract data");
        } else {
            contractDataMap.forEach(this::printContractData);
        }
        // print per zone related data
        if (geoZoneDataMap.isEmpty()) {
            System.out.println("No geo zone data");
        } else {
            geoZoneDataMap.forEach(this::printGeoZoneData);
        }
    }

    public void printGeoZoneData(GeoZoneData geoZoneData) {
        System.out.println("*******************************************");
        System.out.println("The data for geo zone\033[1m "+ geoZoneData.getGeoZone() +" \033[0m");
        System.out.println("***********************************************");
        System.out.println("Has " + geoZoneData.getCustomerIds().size() + " unique customerId(s)");
        System.out.println("Average build duration is " +  geoZoneData.getAvgBuildTime() + "s");
        System.out.println(geoZoneData.getCustomerIds() + " unique customer(s)");
    }

    public void printContractData(ContractData contractData) {
        System.out.println("*******************************************");
        System.out.println("The data for contract\033[1m "+ contractData.getContractId() +" \033[0m");
        System.out.println("***********************************************");
        System.out.println("Has " + contractData.getCustomerIds().size() + " unique customer(s)");
    }
}