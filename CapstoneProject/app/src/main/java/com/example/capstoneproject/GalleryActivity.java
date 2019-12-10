package com.example.capstoneproject;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {
    private static final String TAG = "GalleryActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started ");
    getIncomingIntent();
    }
    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents");
        if (getIntent().hasExtra("image_url")&& getIntent().hasExtra("image_name")){
            Log.d(TAG, "getIncomingIntent: found intent extras");
            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String age = getIntent().getStringExtra("age");
            String breed = getIntent().getStringExtra("breed");
        setImage(imageUrl, imageName, age, breed);
        }
        
    }
    private void    setImage(String imageUrl, String imageName, String mAge, String mBreed){
        Log.d(TAG, "setImage: setting image and name to widgets");
        TextView name = findViewById(R.id.image_description);
        TextView age = findViewById(R.id.age);
        TextView breed = findViewById(R.id.breed);
        name.setText(imageName);
        age.setText(mAge);
        breed.setText(mBreed);

        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);



    }
}
