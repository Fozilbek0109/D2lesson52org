package com.example.d2lesson52;

import com.google.gson.Gson;

public class GsonSingleton {
    private static GsonSingleton gsonSingleton = new GsonSingleton();
    private static Gson gson;

    private GsonSingleton(){

    }

    public static GsonSingleton getInstance(){
        if (gson == null){
            gson = new Gson();
        }
            return gsonSingleton;
    }

    public   Gson getGson() {
        return gson;
    }
}
