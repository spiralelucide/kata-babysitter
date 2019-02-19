package com.spiraledlogic.data;

import com.spiraledlogic.model.Hour;
import com.spiraledlogic.model.Period;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@EqualsAndHashCode
public final class FamilyA implements Family {

    public static final String NAME = "A";
    private final Map<Hour, Integer> rates;

    public FamilyA() {
        Map<Hour, Integer> rates = new LinkedHashMap<>();
        rates.put(new Hour(5, Period.pm), 15);
        rates.put(new Hour(6, Period.pm), 15);
        rates.put(new Hour(7, Period.pm), 15);
        rates.put(new Hour(8, Period.pm), 15);
        rates.put(new Hour(9, Period.pm), 15);
        rates.put(new Hour(10, Period.pm), 15);
        rates.put(new Hour(11, Period.pm), 20);
        rates.put(new Hour(12, Period.am), 20);
        rates.put(new Hour(1, Period.am), 20);
        rates.put(new Hour(2, Period.am), 20);
        rates.put(new Hour(3, Period.am), 20);
        rates.put(new Hour(4, Period.am), 20);
        this.rates = Collections.unmodifiableMap(rates);
    }

}
