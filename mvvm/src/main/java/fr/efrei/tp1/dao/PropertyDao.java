package fr.efrei.tp1.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import fr.efrei.tp1.bo.Property;
import fr.efrei.tp1.service.IPropertyService;

@Dao
public interface PropertyDao
        extends IPropertyService
{

    @Override
    @Query("SELECT * FROM Property")
    List<Property> getProperties();

    @Override
    @Delete
    void deleteProperty(Property property);

    @Override
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addProperty(Property property);

    @Override
    @Query("SELECT * FROM Property ORDER BY address DESC")
    List<Property> sortPropertiesByName();

}
