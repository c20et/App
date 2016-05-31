package com.dev.ehb.stockmarket20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Activity0 extends AppCompatActivity {
    public static double money = 10000;
    public ArrayList<String> arr1 = new ArrayList<String>();
    TextView tv1;
    TextView tv2;
    public String rName;
    public String rPrice;
    public String rNum;
    public String rTotal;
    public String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_0);
        tv1 = (TextView) findViewById(R.id.pList);
    }
    public void setScreen () {
        if (tv2 != null) {
            tv2.setText(String.valueOf(money));
        }

        MainActivity ma1 = new MainActivity();

            arr1.add(rName);
            arr1.add(rPrice);
            arr1.add(rNum);
            arr1.add(rTotal);

        for(String e: arr1) {
            temp = temp + e + " ";
        }
        if (tv1 != null) {
            tv1.setText( temp );
        }

        //tv1.setText( temp1 + "\n" );
    }
    public void sendM1(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivityForResult(i, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == MainActivity.RESULT_OK){
                rName = data.getStringExtra("r1");
                rPrice = data.getStringExtra("r2");
                rNum = data.getStringExtra("r3");
                rTotal = data.getStringExtra("r4");
                //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                setScreen();
            }
            if (resultCode == MainActivity.RESULT_CANCELED) {
                //Write your code if there's no result
                setScreen();
            }
        }
    }//onActivityResult

}
