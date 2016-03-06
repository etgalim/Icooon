package com.etgalim.ikon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {


    private Firebase mRef;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        ImageView bg_imageView = (ImageView) findViewById(R.id.thumbnail);

        Picasso.with(this)
                .load("http://gdj.gdj.netdna-cdn.com/wp-content/uploads/2011/03/background-pattern-design-31.jpg")
                .into(bg_imageView);
    }


    @Override
    protected void onStart() {
        super.onStart();
        final TextView designer_name = (TextView) findViewById(R.id.d_name);
        final TextView main_url = (TextView) findViewById(R.id.url);

        mRef = new Firebase("https://ikon.firebaseio.com/designer_name");

            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String designerName = (String) dataSnapshot.getValue();
                    designer_name.setText(designerName);
                }


                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

        mRef = new Firebase("https://ikon.firebaseio.com/url");

            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String designer_url = (String) dataSnapshot.getValue();
                    main_url.setText(designer_url);
                }


                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

    }

}


