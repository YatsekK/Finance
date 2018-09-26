package com.example.core.dao.interfaces;

import com.example.core.enums.OperationType;
import com.example.core.interfaces.Source;

import java.util.List;

public interface SourceDAO extends CommonDAO<Source> {

    List<Source> getList(OperationType operationType); // получить список корневых элементов деревьев для определённого типа операции

}
