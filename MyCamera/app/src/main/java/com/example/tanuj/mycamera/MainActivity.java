package com.example.tanuj.mycamera;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    static final int REQUEST_IMAGE_CAPTURE=1;
    ImageView myImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myButton = (Button)findViewById(R.id.myButton);
        myImageView = (ImageView) findViewById(R.id.myImageView);
        //checking if device has a camera
        if(!hasCamera()) {
            myButton.setEnabled(false);
        }
    }

    boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    //launching camera
    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//intent to launch camera
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);//starts methods after starting intent
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //check no errors and image has been taken
        if(requestCode == REQUEST_IMAGE_CAPTURE )
        {
            //get the photo and display
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap)extras.get("data");
            myImageView.setImageBitmap(photo);
        }
    }
}
