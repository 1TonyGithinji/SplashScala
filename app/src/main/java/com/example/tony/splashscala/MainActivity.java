package com.example.tony.splashscala;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView mImage;
    Button abdalla, camera;
    private static final int CAMERA_REQUEST = 1888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button abdallah = (Button) findViewById(R.id.abdallah);
        Button camera = (Button) findViewById(R.id.camera);
        mImage = (ImageView) findViewById(R.id.imageView2);
        abdallah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scalai = new Intent(Intent.ACTION_SEND);
                scalai.setType("text/plain");
                String FileShare = "Body here";
                String shareSub = "Subject Here";
                scalai.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                scalai.putExtra(Intent.EXTRA_SUBJECT, FileShare);
                startActivity(Intent.createChooser(scalai, "Share With"));
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camerat = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camerat, CAMERA_REQUEST);
            }
        });
    }

    public void onActivityResult(int request, int result, Intent data) {
        if (request == CAMERA_REQUEST && request == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            mImage.setImageBitmap(photo);
        }
    }
}

