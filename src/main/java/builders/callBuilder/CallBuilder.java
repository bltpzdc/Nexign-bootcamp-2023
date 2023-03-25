package builders.callBuilder;

import tools.data.Call;

public interface CallBuilder {
    Call createCall(String[] fields);
}
