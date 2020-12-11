package fr.efrei.tp1.repository;

import android.content.Context;

import java.util.List;

import androidx.room.Room;
import fr.efrei.tp1.bo.Property;
import fr.efrei.tp1.database.PropertyDatabase;

//This class implement the singleton pattern
public final class PropertyRepository
{

    private static volatile PropertyRepository instance;

    // We accept the "out-of-order writes" case
    public static PropertyRepository getInstance(Context context)
    {
        if (instance == null)
        {
            synchronized (PropertyRepository.class)
            {
                if (instance == null)
                {
                    instance = new PropertyRepository(context);
                }
            }
        }

        return instance;
    }

    private final PropertyDatabase propertyDatabase;

    private PropertyRepository(Context context)
    {
        propertyDatabase = Room.databaseBuilder(context, PropertyDatabase.class, "property-database").allowMainThreadQueries().build();
    }

    public List<Property> getProperties()
    {
        return propertyDatabase.propertyDao().getProperties();
    }

    public void deleteProperty(Property property)
    {
        propertyDatabase.propertyDao().deleteProperty(property);
    }

    public void addProperty(Property property)
    {
        propertyDatabase.propertyDao().addProperty(property);
    }

    public List<Property> sortPropertiesByName()
    {
        return propertyDatabase.propertyDao().sortPropertiesByName();
    }

}
