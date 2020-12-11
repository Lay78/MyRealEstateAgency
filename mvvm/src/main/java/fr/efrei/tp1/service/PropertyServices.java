package fr.efrei.tp1.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.efrei.tp1.bo.Property;

public class PropertyServices implements IPropertyService
{
    private final List<Property> properties = new ArrayList<>();

    @Override
    public List<Property> getProperties()
    {
        return properties;
    }

    @Override
    public void deleteProperty(Property property)
    {
        properties.remove(property);
    }

    @Override
    public void addProperty(Property property)
    {
        properties.add(property);
    }

    @Override
    public List<Property> sortPropertiesByName()
    {
        final List<Property> sortedProperties = new ArrayList<>(properties);

        Collections.sort(sortedProperties, new Property.PropertyComparator());

        return sortedProperties;
    }
}
