package com.ralph.second;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 果占先 on 2016/6/12.
 */
public class Ex53Activity extends BaseActivity {
    EditText phone;
    EditText city;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex53_layout);

        phone = (EditText) findViewById(R.id.phone);
        city = (EditText) findViewById(R.id.city);
    }

    public void findPhoneCity(View view)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Ex53BaiduPhone baidu = retrofit.create(Ex53BaiduPhone.class);
        Call<PhoneCity> call = baidu.getPhoneInfo("562bafef6007883e2e8fffbbdfa9e6ac",phone.getText().toString());

        call.enqueue(new Callback<PhoneCity>() {
            @Override
            public void onResponse(Call<PhoneCity> call, Response<PhoneCity> response) {
                PhoneCity pc = response.body();
                city.setText(pc.getRetData().getProvince()+""+pc.getRetData().getCity()+""+pc.getRetData().getSupplier());
            }

            @Override
            public void onFailure(Call<PhoneCity> call, Throwable t) {

            }
        });
    }
}
