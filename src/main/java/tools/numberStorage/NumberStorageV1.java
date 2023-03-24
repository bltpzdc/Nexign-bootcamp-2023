package tools.numberStorage;

import lombok.Getter;
import lombok.ToString;
import tools.data.Call;
import tools.data.PhoneNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@ToString
public class NumberStorageV1 implements NumberStorage{
    @Getter
    private Map<PhoneNumber, List<Call>> storage;

    public NumberStorageV1(){
        storage = new HashMap<>();
    }
    @Override
    public boolean containsNumber(PhoneNumber number){
        return storage.containsKey(number);
    }

    @Override
    public void putNumber(PhoneNumber number, List<Call> calls){
        storage.put(number, calls);
    }

    @Override
    public void addCall(PhoneNumber number, Call call){
        List<Call> calls = storage.get(number);
        calls.add(call);
        storage.put(number, calls);
    }
}
