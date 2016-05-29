package com.dev.ehb.stockmarket20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();
    }
    public void searchStock( String str ) {
        String stock1 = str;
        stock1 = stock1.toUpperCase();
        System.out.println("Waiting...");
        try{
            TimeUnit.SECONDS.sleep(9);

        }catch(InterruptedException e) {
            e.printStackTrace();
        }
        DaltonStock stocka = new DaltonStock(stock1);
        String str2 = "Last price: " + stocka.lastprice;
        Toast.makeText(getApplicationContext(), str2, Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), stocka.change, Toast.LENGTH_LONG).show();
    }
    public void setUp (){
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

        /* et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.this.a.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/
    }

}