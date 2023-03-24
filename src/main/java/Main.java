import applicationManager.ApplicationManager;
import billCreator.BillCreator;
import billCreator.BillCreatorV1;
import billPrinter.BillPrinter;
import billPrinter.BillPrinterV1;
import callFactory.CallFactory;
import callFactory.CallFactoryV1;
import fileReader.CDRFileReaderV1;
import fileReader.FileReader;
import phoneNumberFactory.PhoneNumberFactory;
import phoneNumberFactory.PhoneNumberFactoryV1;
import tools.numberStorage.NumberStorage;
import tools.numberStorage.NumberStorageV1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader reader = new CDRFileReaderV1("cdr.txt");
        CallFactory callFactory = new CallFactoryV1();
        PhoneNumberFactory numberFactory = new PhoneNumberFactoryV1();
        NumberStorage numberStorage = new NumberStorageV1();
        BillPrinter billPrinter = new BillPrinterV1();
        BillCreator billCreator = new BillCreatorV1(billPrinter);
        ApplicationManager manager = new ApplicationManager(reader, callFactory, numberFactory, numberStorage, billCreator);
        manager.manage();
    }
}
