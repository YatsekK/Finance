package com.example.core.start;

import com.example.core.dao.impls.OperationDAOImpl;
import com.example.core.dao.impls.SourceDAOImpl;
import com.example.core.dao.impls.StorageDAOImpl;
import com.example.core.decorator.OperationSync;
import com.example.core.decorator.SourceSync;
import com.example.core.decorator.StorageSync;
import com.example.core.enums.OperationType;
import com.example.core.impls.DefaultSource;
import com.example.core.impls.DefaultStorage;
import com.example.core.interfaces.Source;
import com.example.core.interfaces.Storage;

public class Start {
    public static void main(String[] args) {

        StorageSync storageSync = new StorageSync(new StorageDAOImpl());
        SourceSync sourceSync = new SourceSync(new SourceDAOImpl());
        OperationSync operationSync = new OperationSync(new OperationDAOImpl(sourceSync.getIdentityMap(), storageSync.getIdentityMap()), sourceSync, storageSync);

//        testSource(sourceSync);


        Storage parentStorage = storageSync.get(10);


        DefaultStorage storage = new DefaultStorage("def store");

//        try {
//            storage.addCurrency(Currency.getInstance("USD"), new BigDecimal(145));
//            storage.addCurrency(Currency.getInstance("RUB"), new BigDecimal(100));
//
//            storage.setParent(parentStorage);
//
//            storageSync.add(storage);
//
//            storageSync.deleteCurrency(storage, Currency.getInstance("USD"));


        storageSync.delete(storageSync.get(143));

//
//        } catch (CurrencyException e) {
//            e.printStackTrace();
//        }

    }

    private static void testSource(SourceSync sourceSync) {
        Source parentSource = sourceSync.get(4);

        DefaultSource s = new DefaultSource("test Source 2");
        s.setOperationType(OperationType.OUTCOME);
        s.setParent(parentSource);


        sourceSync.add(s);
        System.out.println("sourceSync = " + sourceSync.getAll());
    }
}
