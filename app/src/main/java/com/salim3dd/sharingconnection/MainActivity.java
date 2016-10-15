package com.salim3dd.sharingconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Sharing_Connection btn_Con = new Sharing_Connection(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void btn_help(View view) {
        btn_Con.showInfo();

    }

    public void btn_MoreApp(View view) {
        btn_Con.MoreApp();
    }

    public void btn_share_app(View view) {
        btn_Con.Share_App();
    }

    public void btn_Rate(View view) {
        btn_Con.Rate_App();
    }

    public void btn_SendEmail(View view) {
        btn_Con.Send_Email();
    }

    public void btn_share_Text(View view) {
        btn_Con.Share_TXT("مشارك اي نص");
    }
}
