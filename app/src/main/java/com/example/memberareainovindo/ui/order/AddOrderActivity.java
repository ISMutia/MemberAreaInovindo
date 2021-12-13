package com.example.memberareainovindo.ui.order;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.Model.body.OrderAddBody;
import com.example.memberareainovindo.Model.response.orderAdd.OrderAddResponse;
import com.example.memberareainovindo.Model.response.orderForm.DomainItem;
import com.example.memberareainovindo.Model.response.orderForm.FormResponse;
import com.example.memberareainovindo.Model.response.orderForm.PriceItem;
import com.example.memberareainovindo.data.SessionManager;
import com.example.memberareainovindo.databinding.ActivityAddOrderBinding;
import com.example.memberareainovindo.ui.paket.InfoPaketActivity;
import com.gzeinnumer.ad.AdapterAutoCompleteText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddOrderActivity extends AppCompatActivity {

    private ActivityAddOrderBinding binding;
    private SessionManager mSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mSessionManager = new SessionManager(this);

        initView();
        initOnClick();
    }

    private void initView() {
        loadFormData();
    }

    private void initOnClick() {
        binding.txtInfo.setOnClickListener(v -> {
            Intent gotoinfo = new Intent(AddOrderActivity.this, InfoPaketActivity.class);
            startActivity(gotoinfo);
        });

        binding.btnSubmitOrder.setOnClickListener(v -> {
            cekForm();
        });
    }

    private void cekForm() {
        if (binding.edtProjectName.getText().toString().length() == 0) {
            Toast.makeText(this, "project name tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else if (binding.actPrice.getText().toString().length() == 0) {
            Toast.makeText(this, "Price tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else if (binding.actDomain.getText().toString().length() == 0) {
            Toast.makeText(this, "Domain tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else {
            sendData();
            Toast.makeText(this, "Simpan  data", Toast.LENGTH_SHORT).show();

        }
    }

    private void sendData() {
        String id = mSessionManager.getId();

        OrderAddBody body = new OrderAddBody();
        body.setMulaiP("2021-10-01");
        body.setSelesaiP("2021-10-01");
        body.setLamaDomain("2021-10-01");
        body.setIdDomain(idDomain+"");
        body.setIdPrice(idPrice+"");
        body.setIdCustomers(id);
        body.setProjectName(binding.edtProjectName.getText().toString());
        body.setLamaP("2 bulan");

        RetroServer.getInstance()
                .orderAdd(body)
                .enqueue(new Callback<OrderAddResponse>() {
                    @Override
                    public void onResponse(Call<OrderAddResponse> call, Response<OrderAddResponse> response) {
                        if (response.body().getStatus().equals("success")){
                            Toast.makeText(AddOrderActivity.this, "data sukses disimpan", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<OrderAddResponse> call, Throwable t) {

                    }
                });
    }

    int idDomain = 0;

    private void openDialogDomain() {
        AdapterAutoCompleteText<DomainItem> adapter = new AdapterAutoCompleteText<DomainItem>(getApplicationContext(), domain);
        binding.actDomain.setAdapter(adapter);
        binding.actDomain.setFreezesText(false);

        binding.actDomain.setOnItemClickListener((parent, view, position, id) -> {
            idDomain = domain.get(position).getId();
            binding.actDomain.setText(domain.get(position).getName(), false);
        });
    }

    int idPrice = 0;

    private void openDialogPrice() {
        AdapterAutoCompleteText<PriceItem> adapter = new AdapterAutoCompleteText<PriceItem>(getApplicationContext(), price);
        binding.actPrice.setAdapter(adapter);
        binding.actPrice.setFreezesText(false);

        binding.actPrice.setOnItemClickListener((parent, view, position, id) -> {
            idPrice = price.get(position).getId();
            binding.actPrice.setText(price.get(position).getName(), false);
        });
    }

    private List<PriceItem> price = new ArrayList<>();

    private List<DomainItem> domain = new ArrayList<>();

    private void loadFormData() {
        RetroServer.getInstance()
                .orderGetForm()
                .enqueue(new Callback<FormResponse>() {
                    @Override
                    public void onResponse(Call<FormResponse> call, Response<FormResponse> response) {
                        //Toast.makeText(AddOrderActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                        if (response.body().getStatus().equals("success")) {
                            price = response.body().getPrice();
                            domain = response.body().getDomain();

                            openDialogPrice();
                            openDialogDomain();
                            Toast.makeText(AddOrderActivity.this, "data loaded", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<FormResponse> call, Throwable t) {

                    }
                });
    }

}