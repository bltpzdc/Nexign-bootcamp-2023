package billPrinter;

import java.io.IOException;

public interface BillPrinter {
    void printBill(String number, String bill) throws IOException;
}
