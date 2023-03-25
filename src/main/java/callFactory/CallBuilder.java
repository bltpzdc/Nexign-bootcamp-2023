package callFactory;

import tools.data.Call;

public interface CallBuilder {
    Call createCall(String[] fields);
}
