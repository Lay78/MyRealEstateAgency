package fr.efrei.tp1.service;

import java.util.List;
import fr.efrei.tp1.bo.Property;

//Interface used in order to implement correctly the repository pattern
public interface IPropertyService
{
    /**
     * Get all properties
     *
     * @return {@link List}
     */
    List<Property> getProperties();

    /**
     * Deletes a property
     *
     * @param property
     */
    void deleteProperty(Property property);

    /**
     * Add a property
     *
     * @param property
     */
    void addProperty(Property property);

    /**
     * Get all properties sorted by name
     *
     * @return {@link List}
     */
    List<Property> sortPropertiesByName();
}
