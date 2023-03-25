package builders.phoneNumberBuilder;

import tools.data.PhoneNumber;

public interface PhoneNumberBuilder {
    PhoneNumber createPhoneNumber(String[] fields);
}
