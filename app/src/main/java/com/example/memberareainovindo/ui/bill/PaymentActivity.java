package com.example.memberareainovindo.ui.bill;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.loader.content.CursorLoader;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.Model.response.payment.PaymentResponse;
import com.example.memberareainovindo.Model.response.userProfile.ResponseProfile;
import com.example.memberareainovindo.ProfileActivity;
import com.example.memberareainovindo.R;
import com.example.memberareainovindo.databinding.ActivityOrderBinding;
import com.example.memberareainovindo.databinding.ActivityPaymentMethodBinding;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.memberareainovindo.ProfileActivity.verifyStoragePermissions;

public class PaymentActivity extends AppCompatActivity {
    private ActivityPaymentMethodBinding binding;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    String imagePath;
    ImageView imageView;
    TextView noBill;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentMethodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        verifyStoragePermissions(PaymentActivity.this);

        id = getIntent().getIntExtra("id", 0);
        //binding.txtbillno.setText(id);
        noBill = (TextView) findViewById(R.id.txtbillno);
        noBill.setText(id+"");
        //Toast.makeText(PaymentActivity.this, ""+id, Toast.LENGTH_SHORT).show();
        binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImagePopup(v);
            }
        });
    }
    private void uploadImage() {

        File file = new File(imagePath);

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

        MultipartBody.Part body =
                MultipartBody.Part.createFormData("bukti", file.getName(), requestFile);

        RetroServer.getInstance()
                .uploadPayment(body,id+"")
                .enqueue(new Callback<PaymentResponse>() {
                    @Override
                    public void onResponse(Call<PaymentResponse> call, Response<PaymentResponse> response) {
//                        Toast.makeText(LoginActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                        if (response.body().getStatus().equals("success")) {

                            Toast.makeText(PaymentActivity.this, "bukti berhasil di upload", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(PaymentActivity.this, "gagal", Toast.LENGTH_SHORT).show();
                        }
//                        binding.profilePhoto.setImageDrawable(null);
                        imagePath = null;

                    }

                    @Override
                    public void onFailure(Call<PaymentResponse> call, Throwable t) {
                        Toast.makeText(PaymentActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
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

                Glide.with(getApplicationContext()).load(new File(imagePath))
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .into(binding.imageView);
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