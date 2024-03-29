package com.blacklightning.parkhere;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Jason Liu on 11/1/2017.
 */

public class ParkingListingActivity extends AppCompatActivity implements View.OnClickListener{
    Button bSearch;
    ListView listViewer;
    ListAdapter listAdapter;
    private ArrayList<ParkingSpace> listings;
    private static FirebaseAuth firebaseAuth;
    private static FirebaseUser currentUser;
    private static DatabaseReference mDB;
    private Map<String, Object> parkingSpotList;


    public String queryResult;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_parking_spot);

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        mDB = FirebaseDatabase.getInstance().getReference();

        DatabaseReference ref = mDB.child("parkingspot" );
        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get map of users in datasnapshot
                        parkingSpotList = (Map<String,Object>) dataSnapshot.getValue();
                        for(Object spaces : parkingSpotList.values()){


                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });

//        listViewer = (ListView) findViewById(R.id.park);
//        listViewer.setAdapter(listAdapter);

        bSearch = (Button) findViewById(R.id.searchButton);
    }

    @Override
    public void onClick(View v) {
        Log.d("TEST","Something Clicked");

        if(v == bSearch){


        }
    }
}