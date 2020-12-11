package fr.efrei.tp1.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import fr.efrei.tp1.bo.Property;
import fr.efrei.tp1.dao.PropertyDao;

@Database(entities = { Property.class }, version = 1)
public abstract class PropertyDatabase
        extends RoomDatabase
{

    public abstract PropertyDao propertyDao();

}