package com.jacemcpherson.moviedbexample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;


public class ImageLoader extends AsyncTask<String, Void, Bitmap> {

    ImageView mImageView;

    public ImageLoader(ImageView imageView) {
        mImageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        String urlString = params[0];

        Bitmap bitmap = null;
        try {
            InputStream in = new java.net.URL(urlString).openStream();
            bitmap = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        mImageView.setImageBitmap(bitmap);
    }
}
