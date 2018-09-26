package com.example.core.dao.interfaces;

import com.example.core.exceptions.CurrencyException;
import com.example.core.interfaces.Storage;

import java.math.BigDecimal;
import java.util.Currency;

public interface StorageDAO extends CommonDAO<Storage> {

    // boolean - чтобы удостовериться, что операция прошла успешно
    boolean addCurrency(Storage storage, Currency currency, BigDecimal initAmount) throws CurrencyException;
    boolean deleteCurrency(Storage storage, Currency currency) throws CurrencyException;
    boolean updateAmount(Storage storage, Currency currency, BigDecimal amount);// сюда входит прибавить, отнять и обновить
}

