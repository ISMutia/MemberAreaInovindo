package com.example.memberareainovindo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.Model.body.ProfileBody;
import com.example.memberareainovindo.Model.response.profile.ProfileResponse;
import com.example.memberareainovindo.Model.response.userProfile.ResponseProfile;
import com.example.memberareainovindo.data.SessionManager;
import com.example.memberareainovindo.databinding.ActivityProfileBinding;
import com.example.memberareainovindo.ui.dashboard.MainActivity;
import com.example.memberareainovindo.ui.login.LoginActivity;
import com.example.memberareainovindo.ui.notification.NotificationActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    String imagePath;


    private ActivityProfileBinding binding;
    private SessionManager mSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mSessionManager = new SessionManager(this);
        verifyStoragePermissions(ProfileActivity.this);

        initView();

        initOnClick();
        binding.profilePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showImagePopup(v);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.buttom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.notification:
                    Intent gotonotif = new Intent(ProfileActivity.this, NotificationActivity.class);
                    startActivity(gotonotif);
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.menu1:
                    Intent gotohome = new Intent(ProfileActivity.this, MainActivity.class);
                    startActivity(gotohome);
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.profile:
                    return true;
            }
            return false;
        });


    }

    private void uploadImage() {

        File file = new File(imagePath);

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

        MultipartBody.Part body =
                MultipartBody.Part.createFormData("gambar", file.getName(), requestFile);

        RetroServer.getInstance()
                .userUpdatePhoto(body, mSessionManager.getId())
                .enqueue(new Callback<ResponseProfile>() {
                    @Override
                    public void onResponse(Call<ResponseProfile> call, Response<ResponseProfile> response) {
//                        Toast.makeText(LoginActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                        if (response.body().getStatus().equals("success")) {

                            mSessionManager.setGambarUrl(response.body().getGambar_url());
                            Glide.with(getApplicationContext()).load(mSessionManager.getGambarUrl()).circleCrop()
                                    .into(binding.profilePhoto);

                            Toast.makeText(ProfileActivity.this, "profile berhasil di upload", Toast.LENGTH_SHORT).show();
                       } else {
                            Toast.makeText(ProfileActivity.this, "gagal", Toast.LENGTH_SHORT).show();
                        }
//                        binding.profilePhoto.setImageDrawable(null);
                        imagePath = null;

                    }

                    @Override
                    public void onFailure(Call<ResponseProfile> call, Throwable t) {
                        Toast.makeText(ProfileActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void initOnClick() {
        binding.btnOut.setOnClickListener(v -> {
            mSessionManager.logout();
            Intent gotologin = new Intent(ProfileActivity.this, LoginActivity.class);
            finishAffinity();
            startActivity(gotologin);
        });
        binding.txtDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }


    private void sendData() {
        ProfileBody body = new ProfileBody();

        body.setFullname(binding.edtFullname.getText().toString());
        body.setDateBirth(binding.edtDate.getText().toString());
        body.setEmail(binding.edtEmail.getText().toString());
        body.setContactWa(binding.edtKontak.getText().toString());
        body.setAddress(binding.edtAddress.getText().toString());


        //android
        //foto -> simpan di storage -> file path -> base64(foto)(encript)

        //api
        //base64(foto)(encript) -> decript -> image -> disimpan storage larvel -> file path ->  user(gambar)

        try {
            RetroServer.getInstance().userUpdate(body, mSessionManager.getId()).enqueue(new Callback<ProfileResponse>() {
                @Override
                public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {

                    if (response.body().getStatus().equals("success")) {
                        Toast.makeText(ProfileActivity.this, response.body().getMessage().toString(), Toast.LENGTH_SHORT).show();
                        mSessionManager.setFullname(response.body().getData().getFullname());
                        mSessionManager.setId(response.body().getData().getId() + "");
                        mSessionManager.setDatebirth(response.body().getData().getDateBirth());
                        mSessionManager.setEmail(response.body().getData().getEmail());
                        mSessionManager.setContactWa(response.body().getData().getContactWa());
                        mSessionManager.setAddress(response.body().getData().getAddress());
                    }
                }

                @Override
                public void onFailure(Call<ProfileResponse> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        binding.edtFullname.setText(mSessionManager.getFullname());
        binding.edtDate.setText(mSessionManager.getDateBirth());
        binding.edtEmail.setText(mSessionManager.getEmail());
        binding.edtKontak.setText(mSessionManager.getContactWa());
        binding.edtAddress.setText(mSessionManager.getAddress());

        if (mSessionManager.getGambarUrl()== null){
            Glide.with(getApplicationContext()).load(R.drawable.ic_account).circleCrop()
                    .into(binding.profilePhoto);
        }else {
            Glide.with(getApplicationContext()).load(mSessionManager.getGambarUrl()).circleCrop()
                    .into(binding.profilePhoto);
        }


    }

    public void showImagePopup(View view) {
        final Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_PICK);

        final Intent chooserIntent = Intent.createChooser(galleryIntent, "Choose image");
        startActivityForResult(chooserIntent, 100);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 100) {
            if (data == null) {
                Toast.makeText(getApplicationContext(), "Unable to pick image", Toast.LENGTH_LONG).show();
                return;
            }

            Uri imageUri = data.getData();
            //binding.profilePhoto.setImageURI(imageUri);

            Uri selectedImageUri = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImageUri, filePathColumn, null, null, null);

            if (cursor != null) {
                cursor.moveToFirst();


                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imagePath = getRealPathFromURI(imageUri);

                Glide.with(getApplicationContext()).load(new File(imagePath)).circleCrop()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .into(binding.profilePhoto);
                uploadImage();

//               Toast.makeText(getApplicationContext(),"Please reselect your image",Toast.LENGTH_LONG).show();
//               cursor.close();

            } else {

                Toast.makeText(getApplicationContext(), "Unable to load image", Toast.LENGTH_LONG).show();
            }
        }
    }

    private String getRealPathFromURI(Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(getApplicationContext(), contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }


}
