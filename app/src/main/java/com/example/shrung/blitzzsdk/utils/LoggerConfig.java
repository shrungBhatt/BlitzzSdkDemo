package com.example.shrung.blitzzsdk.utils;

import android.util.Log;

public class LoggerConfig {
    public static final String TAG = "LoggerConfig";


    private static boolean ON = true;

    public static void errorLog(String tag, String message){
        if(ON) {
            Log.e(tag,message);
        }

    }

    public static void infoLog(String tag, String message){
        if(ON){
            Log.i(tag,message);
        }
    }

    public static void toggleLogging(boolean toggle){
        ON = toggle;
    }

}
