package com.example.felix.retrofit;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listview = findViewById(R.id.listView);
        final ListView listview2 = findViewById(R.id.listView2);
        final Button countryBtn = (Button) findViewById(R.id.countryBtn);
        final Button symbolBtn = (Button) findViewById(R.id.symbolBtn);

        //retrofit builder
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GetData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        countryBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                GetData api = retrofit.create(GetData.class); //creates interface
                Call<CurrencyList> call = api.getMethodList(); //uses call method in Interface

                    call.enqueue(new Callback<CurrencyList>() {
                        @Override
                        public void onResponse(Call<CurrencyList> call, Response<CurrencyList> response) {
                            CurrencyList createList = response.body();
                            String []  countryArray = new String[createList.Currencies.length];

                            for (int i=0; i < createList.Currencies.length; i++){
                                countryArray[i] = createList.Currencies[i].getCountry();  //gets desired attribute from JSON object in URL and stores into array
                            }

                            listview.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                                    android.R.layout.simple_list_item_1, countryArray) );
                        }

                        @Override
                        public void onFailure(Call<CurrencyList> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
            }
        });


        symbolBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                GetData api = retrofit.create(GetData.class); //creates interface
                Call<CurrencyList> call = api.getMethodList(); //uses call method in Interface

                call.enqueue(new Callback<CurrencyList>() {
                    @Override
                    public void onResponse(Call<CurrencyList> call, Response<CurrencyList> response) {
                        CurrencyList createList2 = response.body();
                        String []  symbolArray = new String[createList2.Currencies.length];

                        for (int i=0; i < createList2.Currencies.length; i++){
                            symbolArray[i] = createList2.Currencies[i].getSymbol();  //gets desired attribute from JSON object in URL and stores into array
                        }

                        listview2.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                                android.R.layout.simple_list_item_1, symbolArray) );
                    }

                    @Override
                    public void onFailure(Call<CurrencyList> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }





}
