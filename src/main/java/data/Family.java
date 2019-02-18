package data;

import model.Hour;

import java.util.Map;

public interface Family {
    Map<Hour, Integer> getRates();
}
