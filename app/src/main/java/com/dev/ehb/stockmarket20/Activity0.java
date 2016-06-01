package com.dev.ehb.stockmarket20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.lang.Math;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Activity0 extends AppCompatActivity {
    public ArrayList<String> arr1 = new ArrayList<String>();
    TextView tv1;
    TextView tv2;
    public String rName;
    public String rPrice;
    public String rNum;
    public String rTotal;
    public String temp;
    public String temp2;
    private int first = 0;
    private int secound = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_0);
        tv2 = (TextView) findViewById(R.id.moneyMade);
        tv1 = (TextView) findViewById(R.id.pList);
    }
    public void setScreen () {
        //Toast.makeText(this, String.valueOf(this.moneyTemp), Toast.LENGTH_LONG).show();
        double r1 = ((MyAppApplication) this.getApplication()).getMoney();
        double rounded = Math.round( r1 * 100.0) / 100;
        if( ((MyAppApplication) this.getApplication()).getMoney() < 0 ) {
            tv2.setText("You owe: " + String.valueOf(rounded));
        }
        else {
            tv2.setText(String.valueOf(rounded));
        }

        MainActivity ma1 = new MainActivity();
            arr1.add(rName);
            arr1.add(rPrice);
            arr1.add(rNum);
            arr1.add(rTotal);
        temp2 = "";
        for(String e: arr1) {
            if(first == 0) {
                temp2 = temp2 + e + " ";
                //temp2 = temp2.substring(4, temp2.length());
                first = 1;
            }
            else {
                //tv1.setText("");
                temp2 = temp2 + e + " ";
            }
        }
        temp = temp2 + " \n";

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
