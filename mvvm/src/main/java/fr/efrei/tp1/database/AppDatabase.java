package fr.efrei.tp1.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import fr.efrei.tp1.bo.Converters;
import fr.efrei.tp1.bo.Property;
import fr.efrei.tp1.dao.PropertyDao;

@Database(entities = {Property.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract PropertyDao propertyDao();
}