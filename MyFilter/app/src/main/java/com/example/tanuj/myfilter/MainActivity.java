package com.example.tanuj.myfilter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView myImageView;
    Drawable myImage;
    Bitmap bitmapImage;//use bitmap to play with pixels

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myImageView = (ImageView) findViewById(R.id.myImageView);

        /*Drawable[] layers = new Drawable[2];
        layers[0] = getDrawable(R.drawable.photo);
        layers[1] = getDrawable(R.drawable.filter);
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        myImageView.setImageDrawable(layerDrawable);
        */


        myImage = getDrawable(R.drawable.photo);
        bitmapImage = ((BitmapDrawable)myImage).getBitmap();    //converts jpeg to bitmap
        Bitmap newphoto = invertImage(bitmapImage);     //adding a filter
        myImageView.setImageBitmap(newphoto);

        //saving the image

        MediaStore.Images.Media.insertImage(getContentResolver(),newphoto,"title","description");
    }

    public static Bitmap invertImage(Bitmap original){
        //Creating a blank canvas
        Bitmap finalImage = Bitmap.createBitmap(original.getWidth(),original.getHeight(),original.getConfig());
        int A,R,G,B;
        int pixelColor;
        //create a loop to loop enire image pixels

        int height = original.getHeight();
        int width = original.getWidth();

        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                pixelColor = original.getPixel(x,y);
                A = Color.alpha(pixelColor);
                R = 255-Color.red(pixelColor);
                G = 255-Color.green(pixelColor);
                B = 255-Color.blue(pixelColor);
                finalImage.setPixel(x,y,Color.argb(A,R,G,B));
            }
        }
        return finalImage;
    }
}
