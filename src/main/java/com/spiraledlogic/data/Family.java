package com.spiraledlogic.data;

import com.spiraledlogic.model.Hour;

import java.util.Map;

public interface Family {
    Map<Hour, Integer> getRates();
}
