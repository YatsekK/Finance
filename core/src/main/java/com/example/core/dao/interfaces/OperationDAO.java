package com.example.core.dao.interfaces;

import com.example.core.enums.OperationType;
import com.example.core.interfaces.Operation;

import java.util.List;

public interface OperationDAO extends CommonDAO<Operation> {

    List<Operation> getList(OperationType operationType); // получить список операций определенного типа

}
