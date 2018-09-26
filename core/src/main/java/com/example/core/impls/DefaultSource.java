package com.example.core.impls;

import com.example.core.abstracts.AbstractTreeNode;
import com.example.core.interfaces.Source;
import com.example.core.interfaces.TreeNode;
import com.example.core.enums.OperationType;

import java.util.List;

public class DefaultSource extends AbstractTreeNode implements Source {

    private OperationType operationType;

    public DefaultSource() {
    }

    public DefaultSource(String name) {
        super(name);
    }

    public DefaultSource(List<TreeNode> childs) {
        super(childs);
    }

    public DefaultSource(String name, long id) {
        super(name, id);
    }

    public DefaultSource(long id, List<TreeNode> childs, TreeNode parent, String name) {
        super(id, childs, parent, name);
    }

    public DefaultSource(String name, long id, OperationType operationType) {
        super(name, id);
        this.operationType = operationType;
    }


    @Override
    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        if (!hasParent()) {// если есть родитель - то оставить его OperationType - можно также выбрасывать исключение, если не совпадают типы
            this.operationType = operationType;
        }
    }

    @Override
    public void add(TreeNode child) {

        // TODO применить паттерн
        // для дочернего элемента устанавливаем тип операции родительского элемента
        if (child instanceof DefaultSource){
            ((DefaultSource)child).setOperationType(operationType);
        }

        super.add(child);
    }

    @Override
    public void setParent(TreeNode parent) {
        if (parent instanceof DefaultSource){
            operationType = ((DefaultSource)parent).getOperationType();// при установке родителя - автоматически проставляем тип операции как у родителя
        }
        super.setParent(parent);
    }
}
