package com.dev.ehb.stockmarket20;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    String[] stockList;
    ArrayAdapter a;
    EditText et1;
    String stock1 = "";
    DaltonStock stocka;
    TextView price;
    String str2;
    double tempPrice;
    int numBought;
    EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();
    }
    public void searchStock( String str ) {
        stock1 = str;
        stock1 = stock1.toUpperCase();
        System.out.println("Waiting...");
        price.setText("please wait...");
        try{
            TimeUnit.SECONDS.sleep(9);

        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        //DaltonStock stocka = new DaltonStock(stock1);
        new Background().execute();
        //String str2 = "Last price: " + stocka.lastprice;
        //Toast.makeText(getApplicationContext(), str2, Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), stocka.change, Toast.LENGTH_LONG).show();
    }

    class Background extends AsyncTask <Void, String, String> {

        @Override
        protected String doInBackground(Void... params) {
            stocka = new DaltonStock(stock1);
            return null;
        }
        @Override
        protected void onPostExecute(String result) {
            str2 = "" + stocka.lastprice;
            tempPrice = stocka.lastprice;
            price.setText(str2);
            //Toast.makeText(getApplicationContext(), str2, Toast.LENGTH_LONG).show();
        }
        @Override
        protected void onPreExecute(){
            price.setText("please wait...");
        }

    }
    public void addToList(View v) {
        numBought = Integer.parseInt(et2.getText().toString());
        double temp = ((MyAppApplication)getApplicationContext()).getMoney();
        ((MyAppApplication) this.getApplication()).setMoney(temp-(numBought*tempPrice));
        String fsName = stock1;
        String fsPrice = "current price: " +str2;
        String fsNum = "number bought: " + et2.getText().toString();
        String fsTotal = "value: " + (String.valueOf(numBought*tempPrice));
        Intent returnIntent = new Intent();
        returnIntent.putExtra("r1", fsName );
        returnIntent.putExtra("r2", fsPrice );
        returnIntent.putExtra("r3", fsNum );
        returnIntent.putExtra("r4", fsTotal );
        setResult(Activity0.RESULT_OK,returnIntent);
        finish();
    }

        public void setUp (){
            et2 = (EditText) this.findViewById(R.id.num1);
            price = (TextView) findViewById(R.id.tv1);
            stockList = new String[]{"stock1", "stock2", "stock3", "stock4", "stock5"};
            //ListView lv1 = (ListView) findViewById(R.id.lView1);
            a = new ArrayAdapter<String>(this, R.layout.list_item, R.id.stock_name, stockList);
            //lv1. setAdapter(a);
            et1 = (EditText) this.findViewById(R.id.search_stock);

            et1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        searchStock( et1.getText().toString() );
                        return true;
                    }
                    return false;
            }
        });
    }

}