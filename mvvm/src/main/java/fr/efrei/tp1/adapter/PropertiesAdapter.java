package fr.efrei.tp1.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import fr.efrei.tp1.R;
import fr.efrei.tp1.bo.Property;
import fr.efrei.tp1.view.UserDetailActivity;

public final class PropertiesAdapter
        extends RecyclerView.Adapter<PropertiesAdapter.PropertyViewHolder>
{

    //The ViewHolder class
    //Each Widget is created as an attribut in order to update the UI
    public static final class PropertyViewHolder
            extends RecyclerView.ViewHolder
    {

        private final TextView name;

        private final TextView phoneNumber;

        private final TextView address;

        private final TextView about;

        public PropertyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            //We find the references of the widgets
            name = itemView.findViewById(R.id.name);
            phoneNumber = itemView.findViewById(R.id.phoneNumber);
            address = itemView.findViewById(R.id.address);
            about = itemView.findViewById(R.id.about);
        }

        public void update(final Property user)
        {
            //We update the UI binding the current user to the current item
            /*name.setText(user.name);
            phoneNumber.setText(user.phoneNumber);
            address.setText(user.address);
            about.setText(user.about);

            //We handle the click on the current item in order to display a new activity
            itemView.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View v)
                {
                    //We create the intent that display the UserDetailActivity.
                    //The current user is added as an extra
                    //The User class implement the "Serializable" interface so I can put the whole object as an extra
                    final Intent intent = new Intent(itemView.getContext(), UserDetailActivity.class);
                    intent.putExtra(UserDetailActivity.USER_EXTRA, user);

                    itemView.getContext().startActivity(intent);
                }

            });*/
        }

    }

    private final List<Property> properties;

    public PropertiesAdapter(List<Property> properties)
    {
        this.properties = properties;
    }

    @NonNull
    @Override
    public PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //We create the ViewHolder
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_user, parent, false);
        return new PropertyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyViewHolder holder, int position)
    {
        //We update the ViewHolder
        holder.update(properties.get(position));
    }

    @Override
    public int getItemCount()
    {
        return properties.size();
    }

}
