package callFactory;

import tools.data.Call;

public interface CallFactory {
    Call createCall(String[] fields);
}
