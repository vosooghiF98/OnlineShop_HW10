package org.maktab.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class MyList<T> {
    List<T> myList = new ArrayList<>();
    protected void add(T t){
        myList.add(t);
    }
    protected void delete(T t){
        myList.remove(t);
    }
    protected boolean contains(T t){
        return myList.contains(t);
    }
    @Override
    public String toString() {
        String temp = null;
        for (int i = 0; i < myList.size(); i++) {
            temp += (i+1) + "- " + myList.get(i).toString();
        }
        return temp;
    }
}
