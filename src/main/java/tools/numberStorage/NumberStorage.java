package tools.numberStorage;

import tools.data.Call;
import tools.data.PhoneNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface NumberStorage {
    boolean containsNumber(PhoneNumber number);
    void putNumber(PhoneNumber number, List<Call> calls);
    void addCall(PhoneNumber number, Call call);
    Set<PhoneNumber> getNumbers();
    List<Call> getCalls(PhoneNumber number);
}
