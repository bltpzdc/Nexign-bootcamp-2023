package applicationManager;

import billCreator.BillCreator;
import callFactory.CallBuilder;
import fileReader.FileReader;
import phoneNumberFactory.PhoneNumberBuilder;
import tools.data.Call;
import tools.data.PhoneNumber;
import tools.numberStorage.NumberStorage;

import java.io.IOException;
import java.util.*;

public class ApplicationManager {
    private final FileReader reader;
    private final CallBuilder callBuilder;
    private final PhoneNumberBuilder numberBuilder;
    private final NumberStorage numberStorage;
    private final BillCreator billCreator;
    private Map<PhoneNumber, Integer> minutesStorage;
    public ApplicationManager(FileReader reader, CallBuilder callBuilder, PhoneNumberBuilder numberBuilder, NumberStorage numberStorage, BillCreator billCreator){
        this.reader = reader;
        this.callBuilder = callBuilder;
        this.numberBuilder = numberBuilder;
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
                PhoneNumber number = numberBuilder.createPhoneNumber(data);
                Call call = callBuilder.createCall(data);
                if (numberStorage.containsNumber(number)) numberStorage.addCall(number, call);
                else {
                    List<Call> calls = new ArrayList<>();
                    calls.add(call);
                    numberStorage.putNumber(number, calls);
                }
            }
            reader.close();
        } catch (IOException e){
            System.err.println("Error occurred while reading or closing CDR file.");
            return;
        }
        billCreator.createBills(numberStorage);
    }
}
