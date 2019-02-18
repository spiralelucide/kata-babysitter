package data;

import lombok.Getter;
import model.Hour;
import model.Period;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Getter
public final class FamilyC implements Family {

    private final Map<Hour, Integer> rates;

    public FamilyC() {
        Map<Hour, Integer> rates = new HashMap<>();
        rates.put(new Hour(5, Period.pm), 21);
        rates.put(new Hour(6, Period.pm), 21);
        rates.put(new Hour(7, Period.pm), 21);
        rates.put(new Hour(8, Period.pm), 21);
        rates.put(new Hour(9, Period.pm), 15);
        rates.put(new Hour(10, Period.pm), 15);
        rates.put(new Hour(11, Period.pm), 15);
        rates.put(new Hour(12, Period.am), 15);
        rates.put(new Hour(1, Period.am), 15);
        rates.put(new Hour(2, Period.am), 15);
        rates.put(new Hour(3, Period.am), 15);
        rates.put(new Hour(4, Period.am), 15);
        this.rates = Collections.unmodifiableMap(rates);
    }

}
