package phoneNumberFactory;

import tools.data.PhoneNumber;

public class PhoneNumberFactoryV1 implements PhoneNumberFactory {
    @Override
    public PhoneNumber createPhoneNumber(String[] fields) {
        PhoneNumber number = new PhoneNumber();
        number.setNumber(fields[1]);
        number.setTariff(Integer.parseInt(fields[4]));
        number.setTariffMinutes(tariffMinutes(number.getTariff()));
        return number;
    }

    private int tariffMinutes(int tariff){
        switch (tariff){
            case 3 -> {
                return 0;
            }
            case 6 -> {
                return 300;
            }
            case 11 -> {
                return 100;
            }
            default -> {
                return 1;
            }
        }
    }
}
