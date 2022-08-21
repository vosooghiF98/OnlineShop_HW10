package org.maktab.Entity.SuperClass;

import java.util.ArrayList;
import java.util.List;

public abstract class MyList<T> {
    private List<T> myList = new ArrayList<>();
    public void add(T t){
        myList.add(t);
    }
    public void delete(T t){
        myList.remove(t);
    }
    public boolean contains(T t){
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

    public List<T> getMyList() {
        return myList;
    }
}
