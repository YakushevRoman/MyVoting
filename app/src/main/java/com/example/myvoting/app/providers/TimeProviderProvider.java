package com.example.myvoting.app.providers;
/*
 *
 */
import com.example.myvoting.app.interafaces.providerInterfaces.ICurrentTimeProvider;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
/**
 * Provide time and date for Voting Entity
 */
public class TimeProviderProvider implements ICurrentTimeProvider {

    @Override
    public String getCurrentDate() {
        return new SimpleDateFormat ("dd-MM-yyyy", Locale.getDefault()).format(Calendar.getInstance().getTime());
    }

    @Override
    public String getCurrentTime() {
        return new SimpleDateFormat ("HH:mm:ss", Locale.getDefault()).format(Calendar.getInstance().getTime());
    }
}
