package com.example.jspweb.Logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Storage implements Serializable {

    public static List<ServerResponse> store = new ArrayList<>();


    public Storage(){}


    public List<ServerResponse> getStore() {
        return store;
    }

    public void addToStore(ServerResponse serverResponse) {
        store.add(serverResponse);
    }

    public void clearStore () {
        store.clear();
    }

}