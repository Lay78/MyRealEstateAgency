package fr.efrei.tp1.bo;


import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
final public class Property implements Serializable {

    public Property(@NonNull String name, @NonNull String type, double price, int surface, int number_rooms, @NonNull String description, @NonNull String address, double latitude, double longitude, @NonNull Date date_creation, @NonNull Date date_last_update, boolean sold, @NonNull User user) {
        //we set the id to 0 because 0 is considerating  as not-set while inserting the item
        id = 0;
        this.type = type;
        this.price = price;
        this.surface = surface;
        this.number_rooms = number_rooms;
        this.description = description;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date_creation = date_creation;
        this.date_last_update = date_last_update;
        this.sold = sold;
        this.user = user;
    }

    public Property() {

    }

    //This class is used in order to sort a property
    public static final class PropertyComparator
            implements Comparator<Property>
    {

        @Override
        public int compare(Property o1, Property o2) {
            return o1.address.compareTo(o2.address);
        }
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String type;

    public double price;

    public int surface;

    public int number_rooms;

    @NonNull
    public String description;

    @NonNull
    public String address;

    public double latitude;

    public double longitude;

    @NonNull
    public Date date_creation;

    @NonNull
    public Date date_last_update;

    public boolean sold;

    @NonNull
    public User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return id == property.id &&
                Double.compare(property.price, price) == 0 &&
                surface == property.surface &&
                number_rooms == property.number_rooms &&
                Double.compare(property.latitude, latitude) == 0 &&
                Double.compare(property.longitude, longitude) == 0 &&
                sold == property.sold &&
                type.equals(property.type) &&
                description.equals(property.description) &&
                address.equals(property.address) &&
                date_creation.equals(property.date_creation) &&
                date_last_update.equals(property.date_last_update) &&
                user.equals(property.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, price, surface, number_rooms, description, address, latitude, longitude, date_creation, date_last_update, sold, user);
    }
}
