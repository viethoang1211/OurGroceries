package com.example.ourgroceries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BranchList extends AppCompatActivity {
    int message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_list);
    }
    public void ond1branch(View view){
        message= 1;
        Intent intent = new Intent(this, BranchInfo.class);
        intent.putExtra(BranchInfo.EXTRA_MESSAGE,message);
        startActivity(intent);
    }
    public void ond10branch(View view){
        message= 2;
        Intent intent = new Intent(this, BranchInfo.class);
        intent.putExtra(BranchInfo.EXTRA_MESSAGE,message);
        startActivity(intent);
    }
    public void ond5branch(View view){
        message= 3;
        Intent intent = new Intent(this, BranchInfo.class);
        intent.putExtra(BranchInfo.EXTRA_MESSAGE,message);
        startActivity(intent);
    }
    public void ondtbbranch(View view){
        message= 4;
        Intent intent = new Intent(this, BranchInfo.class);
        intent.putExtra(BranchInfo.EXTRA_MESSAGE,message);
        startActivity(intent);
    }
    public void onshowmaps(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void onbackbuttonlist(View view) {
        finish();
    }
}