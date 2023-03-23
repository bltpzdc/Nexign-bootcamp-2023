package tools.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class PhoneNumber {
    private String number;
    private int tariff;
    private int tariffMinutes;

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
