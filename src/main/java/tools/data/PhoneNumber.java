package tools.data;

import java.util.Objects;

public class PhoneNumber {
    private String number;
    private int tariff;
    private int tariffMinutes;

    public String getNumber() {
        return number;
    }

    public int getTariff() {
        return tariff;
    }

    public int getTariffMinutes() {
        return tariffMinutes;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setTariff(int tariff) {
        this.tariff = tariff;
    }

    public void setTariffMinutes(int tariffMinutes) {
        this.tariffMinutes = tariffMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return tariff == that.tariff && number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, tariff);
    }
}
