package com.example.myvoting.app.providers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Provide time and date for Voting Entity
 */
class TimeProvider {

    String getCurrentDate(){
        return new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Calendar.getInstance().getTime());
    }

    String getCurrentTime (){
        return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Calendar.getInstance().getTime());
    }
}
