package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mAge = new ArrayList<>();
    private ArrayList<String> mBreed = new ArrayList<>();
    Button maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");
        maps = findViewById(R.id.map);

        maps.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });
    initImageBitMaps();
    }
    private void initImageBitMaps(){
        Log.d(TAG, "initImageBitMaps:Preparing bitmaps ");
        mImageUrls.add("https://www.wikihow.com/images/6/64/Stop-a-Dog-from-Jumping-Step-6-Version-2.jpg");
        mNames.add("Bella");
        mAge.add("10");
        mBreed.add("Female");
        mImageUrls.add("https://eileenanddogs.com/wp-content/uploads/2015/02/Summer-with-Hammer.jpg");
        mNames.add("Charlie");
        mAge.add("12");
        mBreed.add("Male");
        mImageUrls.add("https://www.dogsinmotion.com.au/wp-content/uploads/Dogs-in-Motion-Blog-Posts-1024x768.jpg");
        mNames.add("Luna");
        mAge.add("2");
        mBreed.add("Female");
        mImageUrls.add("https://www.unilad.co.uk/wp-content/uploads/2018/12/Terrier-Conker-at-Dogs-Trust-Loughborough.jpg");
        mNames.add("Lucy");
        mAge.add("4");
        mBreed.add("Female");
        mImageUrls.add("https://www.backpacker.com/.image/t_share/MTU2Mzk0NDU5ODQ2NjgxOTAz/23158166954_7643010070_k.jpg");
        mNames.add("Max");
        mAge.add("6");
        mBreed.add("Male");
        mImageUrls.add("https://photokaz.com/wp-content/uploads/2012/05/2012-05-05-Shelter-Dogs-1356-MKH-Edit_mini.jpg");
        mNames.add("Bailey");
        mAge.add("5");
        mBreed.add("Female");
        mImageUrls.add("https://1.bp.blogspot.com/-NL0QHNr7tSs/TpgHR7w8-aI/AAAAAAAAAqI/jY12zqL9CLU/s1600/20829205916-lovely+dog%2528vn801.com%2529.jpg");
        mNames.add("Cooper");
        mAge.add("12");
        mBreed.add("Male");
        mImageUrls.add("https://www.guidedogs.org/wp-content/uploads/2017/07/2O17-8819-purple-2-min.jpg");
        mNames.add("Daisy");
        mAge.add("11");
        mBreed.add("Female");
        mImageUrls.add("https://s3.amazonaws.com/sav3-assets/wp-content/uploads/2017/09/15130103/SA_DS_STATIC1_THUMBNAIL_DOGS_03.01.2017_1.jpg");
        mNames.add("Sadie");
        mAge.add("9");
        mBreed.add("Female");
        mImageUrls.add("https://www.guidedogs.org/wp-content/uploads/2018/01/Mobile.jpg");
        mNames.add("Buddy");
        mAge.add("45");
        mBreed.add("Male");
        mImageUrls.add("https://dailyegyptian.com/wp-content/uploads/2018/05/RGB_SIT_CH-1-900x850.jpg");
        mNames.add("Tucker");
        mAge.add("12");
        mBreed.add("Male");
        mImageUrls.add("https://dogsfordisabled.ie/dfd/wp-content/uploads/2018/10/liz.jpg");
        mNames.add("Bentley");
        mAge.add("11");
        mBreed.add("Male");
        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/8/86/Maltese_puppy.jpeg");
        mNames.add("Harley");
        mAge.add("11");
        mBreed.add("Male");
        mImageUrls.add("https://images.wagwalkingweb.com/media/articles/dog/fluid-therapy/fluid-therapy.jpg");
        mNames.add("Maggie");
        mAge.add("6");
        mBreed.add("Female");
    initRecyclerView();
    }
private void initRecyclerView(){
RecyclerView recyclerView = findViewById(R.id.recycler_view);
RecyclerViewAdapter adapter = new RecyclerViewAdapter( this, mNames, mImageUrls, mAge, mBreed);
recyclerView.setAdapter(adapter);
recyclerView.setLayoutManager(new LinearLayoutManager(this));

}
}
