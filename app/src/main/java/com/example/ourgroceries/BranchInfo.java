package com.example.ourgroceries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BranchInfo extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "message";
    int message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_info);
        Intent intent = getIntent();
        message = intent.getIntExtra(EXTRA_MESSAGE, 1);
        TextView name = findViewById(R.id.dname);
        TextView address = findViewById(R.id.address);
        TextView OperaTime = findViewById(R.id.operatetime);
        TextView DaysOff = findViewById(R.id.daysoff);
        ImageView image= findViewById(R.id.dimage);
        if (message == 1) {
            image.setImageResource(R.drawable.d1branch);
            name.setText("District 1 Branch");
            address.setText("2 Nguyễn Bỉnh Khiêm, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh, Việt Nam");
            OperaTime.setText("7:00-20:00");
            DaysOff.setText("Saturday - Sunday");
        } else if (message == 2) {
            image.setImageResource(R.drawable.d10branch);
            name.setText("District 10 Branch");
            address.setText("517/19 Nguyễn Tri Phương, Phường 9, Quận 10, Thành phố Hồ Chí Minh, Việt Nam");
            OperaTime.setText("8:00-22:00");
            DaysOff.setText("Sunday");
        } else if (message == 3) {
            image.setImageResource(R.drawable.d5branch);
            name.setText("District 5 Branch");
            address.setText("227 Nguyễn Văn Cừ, Phường 4, Quận 5, Thành phố Hồ Chí Minh, Việt Nam");
            OperaTime.setText("6:30-21:00");
            DaysOff.setText("None");
        }
        else if (message == 4) {
            image.setImageResource(R.drawable.dtbbranch);
            name.setText("District Tan Binh Branch");
            address.setText("Trường Sơn, Phường 2, Tân Bình, Thành phố Hồ Chí Minh, Việt Nam");
            OperaTime.setText("24/7");
            DaysOff.setText("Sunday");
        }

    }

    public void onbackbuttoninfo(View view) {
        finish();
    }

    public void onshow1map(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra(BranchInfo.EXTRA_MESSAGE,message);
        startActivity(intent);
    }
}