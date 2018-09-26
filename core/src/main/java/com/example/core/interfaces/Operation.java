package com.example.core.interfaces;

import com.example.core.enums.OperationType;

import java.util.Calendar;

public interface Operation extends Comparable<Operation>{

    long getId();

    void setId(long id);

    OperationType getOperationType();

    Calendar getDateTime();

    String getDescription();
}
