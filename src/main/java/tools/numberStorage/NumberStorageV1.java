package tools.numberStorage;

import tools.data.Call;
import tools.data.PhoneNumber;

import java.util.*;

public class NumberStorageV1 implements NumberStorage{
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

    @Override
    public Set<PhoneNumber> getNumbers(){
        return storage.keySet();
    }

    @Override
    public List<Call> getCalls(PhoneNumber number) {
        return storage.get(number);
    }
}
