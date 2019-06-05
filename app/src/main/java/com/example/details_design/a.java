package com.example.details_design;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class a extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
    /*    Handler hander = new Handler(){
            public void handleMessage(Message m){
                Intent intent = new Intent (MyActivity.this, Next.class);
                startActivity(intent);
            }
        };
        pubilc void onCreate(Bundle ic)
        {
            //your code setContentView() etc....
            Thread toRun = new Thread()
            {
                public void run()
                {
                    hander.sendMessage(1);
                }
            }
            toRun.start();
        }*/
    }
}
