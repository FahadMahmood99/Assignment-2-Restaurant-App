package com.example.assignment2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView ratingview,nameview,locationview,phoneview,descriptionview;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        ratingview=itemView.findViewById(R.id.rating);
        nameview=itemView.findViewById(R.id.name);
        locationview=itemView.findViewById(R.id.location);
        phoneview=itemView.findViewById(R.id.phone);
        descriptionview=itemView.findViewById(R.id.description);

    }
}
