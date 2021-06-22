package com.codecool.shop.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

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

    private static void getJSON(String userdID, Product object, String action){
        formatter = new SimpleDateFormat("[dd-MM-yyyy HH:mm:ss]");
        currentTime = formatter.format(new Date());
        setUserdID(userdID);
        setAction(action);
        String json = String.format("{\"Time\": \"%s\",\"UserID\": \"%s\",\"Action\": \"%s\"}", currentTime,userdID,action);
        String prd = String.format("{\"Product Id\": \"%s\",{\"name\": \"%s\",\"defaultPrice\": \"%s\",\"Supplier\": \"%s\",\"Category\": \"%s\"}", object.getId(),object.getName(),object.getDefaultPrice(),object.getSupplier().getName(),object.getProductCategory().getName());
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
//        JsonObject jsonObject2 = new JsonParser().parse(prd).getAsJsonObject();
        Gson gson = new Gson();
        jsonObject.add("product",new JsonParser().parse(gson.toJson(object)));
        System.out.println(jsonObject);
    }

    private static void writeJSON(){}

    public static void saveToJSON(String userdID, String action){
        getJSON(userdID, action);
//        writeJSON();
    }

    public static void saveToJSON(String userdID, Product object, String action){
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
