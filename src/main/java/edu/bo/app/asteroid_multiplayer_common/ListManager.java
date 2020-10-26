package edu.bo.app.asteroid_multiplayer_common;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListManager<T> {

    private volatile List<T> list = new LinkedList<>();

    private volatile Queue<T> listOfObjectsToAdd = new LinkedList<>();
    private volatile Queue<T> listOfObjectsToRemove = new LinkedList<>();

    public ListManager() {

    }

    public List<T> getList() {
        return list;
    }

    public void conductAdding() {
        T object;
        while ((object = listOfObjectsToAdd.poll()) != null) {
            list.add(object);
        }
    }

    public void conductRemoving() {
        T object;
        while ((object = listOfObjectsToRemove.poll()) != null) {
            list.remove(object);
        }
    }

    public void add(T object) {
        listOfObjectsToAdd.add(object);
    }

    public void remove(T object) {
        listOfObjectsToRemove.add(object);
    }

}
