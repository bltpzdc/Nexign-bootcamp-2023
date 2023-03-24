package billPrinter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BillPrinterV1 implements BillPrinter{
    @Override
    public void printBill(String number, String bill) throws IOException {
        Files.write(Paths.get("reports/report_" + number), bill.getBytes());
    }
}
