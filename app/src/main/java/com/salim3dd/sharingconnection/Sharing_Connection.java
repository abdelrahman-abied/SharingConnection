package com.salim3dd.sharingconnection;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Sharing_Connection extends Intent {
    public Context context;

    public Sharing_Connection(Context context) {
        this.context = context;
    }


    public void MoreApp() {
        Intent morapp = new Intent(Intent.ACTION_VIEW);
        morapp.setData(Uri.parse("https://play.google.com/store/apps/developer?id=youraddress"));
        context.startActivity(morapp);

    }

    public void Rate_App() {
        Intent Rate_App = new Intent(Intent.ACTION_VIEW);
        Rate_App.setData(Uri.parse("market://details?id="+context.getPackageName()));
        context.startActivity(Rate_App);
    }

    public void Share_App() {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, context.getString(R.string.app_name) + "\n" + "https://play.google.com/store/apps/details?id="+context.getPackageName());
        Intent.createChooser(share, "مشاركة التطبيق");
        context.startActivity(share);

    }

    public void Send_Email() {
        try {
            String[] to = {"YourEmail@gmail.com"};
            Intent SendEmail = new Intent(Intent.ACTION_SEND);
            SendEmail.putExtra(Intent.EXTRA_EMAIL, to);
            SendEmail.putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.app_name));
            SendEmail.putExtra(Intent.EXTRA_TEXT, "السلام عليكم ورحمة الله وبركاته معي اقتراح للتطبيق وهو :");
            SendEmail.setType("message/rfc822");
            Intent.createChooser(SendEmail, "Send Email");
            context.startActivity(SendEmail);

        }catch (Exception e){
            Toast.makeText(context, "عفوا لا يوجد تطبيق مراسلة في جهازك", Toast.LENGTH_SHORT).show();

        }
    }

    public  void Share_TXT(String textTOshare) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,textTOshare );
        Intent.createChooser(share, "مشاركة نص");
        context.startActivity(share);
      }



    public void showInfo() {

        try {
            InputStream inputStream = context.getAssets().open("help.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader BR = new BufferedReader(inputStreamReader);
            String line;
            StringBuilder msg = new StringBuilder();
            while ((line = BR.readLine()) != null) {
                msg.append(line + "\n");
            }
            AlertDialog.Builder build = new AlertDialog.Builder(context);
            build.setTitle("مساعدة");
            build.setIcon(R.mipmap.ic_launcher);
            build.setMessage(Html.fromHtml(msg + ""));
            build.setNegativeButton("إغلاق", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    //Negative
                }
            }).show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
