package com.codecool.shop.model;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminLog {
    private static String userdID;
    private static Object object;
    private static String action;
    private static SimpleDateFormat formatter;
    private static String currentTime;
    private static String result = "";


    private static String getJSON(String userdID, String action){
        formatter= new SimpleDateFormat("[dd-MM-yyyy HH:mm:ss]");
        currentTime = formatter.format(new Date());
        setUserdID(userdID);
        setAction(action);
        String result = "";
        Gson gson = new Gson();
        result += gson.toJson(currentTime);
        result += gson.toJson(userdID);
        result += gson.toJson(action);
        System.out.println(result);
        return result;
    }

    private static String getJSON(String userdID, Object object, String action){
        formatter = new SimpleDateFormat("[dd-MM-yyyy HH:mm:ss]");
        currentTime = formatter.format(new Date());
        setUserdID(userdID);
        setAction(action);
        Gson gson = new Gson();
        result += gson.toJson(String.format("Time: %s UserID: %s Action: %s Data: %s",currentTime,userdID,action,object));
        System.out.println(result);
        return result;
    }

    private static void writeJSON(){}

    public static void saveToJSON(String userdID, String action){
        getJSON(userdID, action);
//        writeJSON();
    }

    public static void saveToJSON(String userdID, Object object, String action){
        getJSON(userdID, object, action);
//        writeJSON();
    }

    public static String getUserdID() {
        return userdID;
    }

    public static void setUserdID(String userdID) {
        AdminLog.userdID = userdID;
    }

    public static Object getObject() {
        return object;
    }

    public static void setObject(Object object) {
        AdminLog.object = object;
    }

    public static String getAction() {
        return action;
    }

    public static void setAction(String action) {
        AdminLog.action = action;
    }
}
