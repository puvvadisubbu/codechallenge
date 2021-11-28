import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ProcessData {
    public static void main(String[] args) throws IOException {

        System.out.println("*****************************************");
        System.out.println("\033[1mInstructions to process\033[0m");
        System.out.println("1. To exit and print data - Press enter key with empty value");
        System.out.println("2. Please follow the order of input as below");
        System.out.println("*****************************************");
        System.out.println("customerId,contractId,geozone,teamcode,projectcode,buildduration");
        System.out.println("example: 2343225,2345,us_east,RedTeam,ProjectApple,3445s");
        System.out.println("*********************************************************");

        //read each line as one entry
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //Geo zone data avg time and customer ids and contractIds
        Map<String, GeoZoneData> geoZoneDataMap = new HashMap<>(0);

        //Per contract data
        Map<String, ContractData> contractDataMap = new HashMap<>(0);

        while (true) {
            String line = in.readLine();
            // to break the data input
            if (line.equals("")) {
                break;
            }
            //prepare data map for the data processing
            CustomerData customerData = ProcessDataWrapper.stringToCustomerData(line);
            ProcessDataWrapper.populateCustomerPerGeoZone(customerData, geoZoneDataMap);
            ProcessDataWrapper.populateCustomerPerContract(customerData, contractDataMap);
        }
        //instantiate data report print class
        PrintDataReport printDataReport = new PrintDataReport();

        //print data that is required
        printDataReport.printData(geoZoneDataMap.values(), contractDataMap.values());
    }
}