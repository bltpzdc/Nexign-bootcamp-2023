package phoneNumberFactory;

import tools.data.PhoneNumber;

public interface PhoneNumberFactory {
    PhoneNumber createPhoneNumber(String[] fields);
}
