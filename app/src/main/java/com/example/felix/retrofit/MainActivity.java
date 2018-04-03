package com.example.felix.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

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
        final Button callButton = (Button) findViewById(R.id.button);

        callButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                //retrofit builder
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(GetData.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                GetData api = retrofit.create(GetData.class);

                Call<List<Currencies>> call = api.getCurrencies(); //uses call method in Interface

                //calls the list from interface using getCurrencies method
                call.enqueue(new Callback<List<Currencies>>() { //after new press ctrl+space
                    @Override
                    public void onResponse(Call<List<Currencies>> call, Response<List<Currencies>> response) {
                        List<Currencies> currencyList = response.body();

                        String [] currencyName = new String[currencyList.size()];

                        for (int i=0; i <currencyList.size(); i++){
                            currencyName[i] = currencyList.get(i).toString();  //gets desired attribute from JSON object in URL and stores into array
                        }

                        listview.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, currencyName));
                    }

                    @Override
                    public void onFailure(Call<List<Currencies>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }


}
