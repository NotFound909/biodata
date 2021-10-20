package com.example.biodata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    Button btnTelpon,btnEmail,btnAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTelpon = findViewById(R.id.btn_Telpon);
        btnEmail = findViewById(R.id.btn_Email);
        btnAlamat = findViewById(R.id.btn_Alamat);

        btnTelpon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String Nomer = "089660676126";
                Intent Memanggil = new Intent(Intent.ACTION_DIAL);
                Memanggil.setData(Uri.fromParts("tel",Nomer,null));
                startActivity(Memanggil);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                String UriText = "mailto:" + Uri.encode("aryaerlangga14@gmail.com") ;
                Uri uri = Uri.parse(UriText);
                intent.setData(uri);
                startActivity(Intent.createChooser(intent,"send email"));
            }
        });

        btnAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:-6.610424, 108.419565");
                Intent rumah = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                rumah.setPackage("com.google.android.apps.maps");
                startActivity(rumah);

            }
        });

    }
}
