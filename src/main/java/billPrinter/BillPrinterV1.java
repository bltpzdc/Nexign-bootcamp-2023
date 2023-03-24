package billPrinter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BillPrinterV1 implements BillPrinter{
    @Override
    public void printBill(String number, String bill){
        try {
            Files.write(Paths.get("reports/report_" + number + ".txt"), bill.getBytes());
        } catch (IOException e) {
            System.err.println("Error occurred while creating report about number: " + number +".");
        }
    }
}
