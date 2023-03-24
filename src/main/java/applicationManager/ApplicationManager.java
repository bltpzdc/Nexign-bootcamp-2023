package applicationManager;

import billCreator.BillCreator;
import billCreator.BillCreatorV1;
import callFactory.CallFactory;
import callFactory.CallFactoryV1;
import fileReader.FileReader;
import phoneNumberFactory.PhoneNumberFactory;
import tools.data.Call;
import tools.data.PhoneNumber;
import tools.numberStorage.NumberStorage;
import tools.numberStorage.NumberStorageV1;

import java.io.IOException;
import java.util.*;

public class ApplicationManager {
    private final FileReader reader;
    private final CallFactory callFactory;
    private final PhoneNumberFactory numberFactory;
    private final NumberStorage numberStorage;
    private final BillCreator billCreator;
    private Map<PhoneNumber, Integer> minutesStorage;
    public ApplicationManager(FileReader reader, CallFactory callFactory, PhoneNumberFactory numberFactory, NumberStorage numberStorage, BillCreator billCreator){
        this.reader = reader;
        this.callFactory = callFactory;
        this.numberFactory = numberFactory;
        this.numberStorage = numberStorage;
        this.billCreator = billCreator;
        minutesStorage = new HashMap<>();
    }

    public void manage(){
        if (!reader.init()) return;
        String buffer;
        try {
            while ((buffer = reader.nextLine()) != null) {
                String[] data = buffer.trim().split(", ");
                PhoneNumber number = numberFactory.createPhoneNumber(data);
                Call call = callFactory.createCall(data);
                if (numberStorage.containsNumber(number)) numberStorage.addCall(number, call);
                else {
                    List<Call> calls = new ArrayList<>();
                    calls.add(call);
                    numberStorage.putNumber(number, calls);
                }
            }
        } catch (IOException e){
            System.err.println("Error occurred while reading CDR file.");
            return;
        }
        billCreator.createBills(numberStorage);
    }
}
