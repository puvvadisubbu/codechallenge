import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<CustomerData>> customerDataMap = new HashMap<>();

        while (true) {
            String line = in.readLine();
            // to break the data input
            if (line.equals("")) {
                break;
            }
            //prepare data map for the data processing
            ProcessDataWrapper.populateCustomerMap(line, customerDataMap);
        }
        //process data for the report as needed
        ProcessDataReport.processDataForReport(customerDataMap);
        //print data report as needed based on data prepared for report.
        ProcessDataReport.printData();
    }
}