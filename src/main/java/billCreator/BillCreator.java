package billCreator;

import tools.numberStorage.NumberStorage;

import java.io.IOException;

public interface BillCreator {
    void createBills(NumberStorage storage) throws IOException;
}
