package fr.efrei.tp1.bo;

import java.util.Date;

import androidx.room.TypeConverter;
import com.google.gson.Gson;

public class Converters {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static User[] fromString(String usersJson) {
        if (usersJson == null) return null;

        Gson gson = new Gson();
        User[] users = gson.fromJson(usersJson, User[].class);
        return users;
    }

    @TypeConverter
    public static String toString(User[] user) {
        if (user == null) return null;

        Gson gson = new Gson();
        String usersJson = gson.toJson(user);
        return usersJson;
    }
}
