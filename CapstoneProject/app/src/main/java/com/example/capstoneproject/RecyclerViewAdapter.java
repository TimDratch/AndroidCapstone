package com.example.capstoneproject;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mAge = new ArrayList<>();
    private ArrayList<String> mBreed = new ArrayList<>();
    private Context mContext;
    public RecyclerViewAdapter(Context context, ArrayList<String> imageNames, ArrayList<String> images, ArrayList<String> age,  ArrayList<String> breed){
        mImageNames = imageNames;
        mImages = images;
        mContext = context;
        mAge = age;
        mBreed = breed;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: ");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);
        holder.image_name.setText(mImageNames.get(position));
    holder.parent_layout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: clicked on :" +mImageNames.get(position));
            Toast.makeText(mContext, mImageNames.get(position),Toast.LENGTH_SHORT ).show();
            Intent intent = new Intent(mContext, GalleryActivity.class);
            intent.putExtra("image_url",mImages.get(position));
            intent.putExtra("image_name",mImageNames.get(position));
            intent.putExtra("age",mAge.get(position));
            intent.putExtra("breed",mBreed.get(position));

            mContext.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView image_name;
        TextView breed;
        TextView age;
        RelativeLayout parent_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            image_name = itemView.findViewById(R.id.image_name);
            parent_layout = itemView.findViewById(R.id.parent_layout);
            age = itemView.findViewById(R.id.age);
            breed = itemView.findViewById(R.id.breed);
        }
    }
}
