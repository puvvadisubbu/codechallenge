import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessData {
    public static void main(String[] args) throws IOException {
        System.out.println("*****************************************");
        System.out.println("Press enter key with empty value to exit");
        System.out.println("Please follow the order of input as below");
        System.out.println("*****************************************");
        System.out.println("customerId,contractId,geozone,teamcode,projectcode,buildduration");
        System.out.println("example: 2343225,2345,us_east,RedTeam,ProjectApple,3445s");
        System.out.println("*********************************************************");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<CustomerData>> customerDataMap = new HashMap<>();

        while (true) {
            String line = in.readLine();
            if (line.equals("")) {
                break;
            }
            ProcessDataWrapper.populateCustomerMap(line, customerDataMap);
        }
        ProcessDataReport.processDataForReport(customerDataMap);
        ProcessDataReport.printData();
    }
}