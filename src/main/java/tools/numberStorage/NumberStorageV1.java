package tools.numberStorage;

import lombok.Getter;
import tools.data.Call;
import tools.data.PhoneNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberStorageV1 {
    @Getter
    private Map<PhoneNumber, List<Call>> storage;

    public NumberStorageV1(){
        storage = new HashMap<>();
    }

    public boolean containsNumber(PhoneNumber number){
        return storage.containsKey(number);
    }

    public void putNumber(PhoneNumber number, List<Call> calls){
        storage.put(number, calls);
    }

    public void addCall(PhoneNumber number, Call call){
        List<Call> calls = storage.get(number);
        calls.add(call);
        storage.put(number, calls);
    }
}
