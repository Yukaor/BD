package com.madmaxi.bd;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class ImageTools {

    private static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }


    public static void chargeImageOptimisee(String path,
                                            ImageView iv,
                                            int reqWidth,
                                            int reqHeight,
                                            AssetManager amgr) {


        /* on récupère les paramétres de base de l'image */
        BitmapFactory.Options o=new  BitmapFactory.Options();
        o.inJustDecodeBounds = true; //ce parametre empeche decodexxx d'allouer de la mémoire
        try {
            InputStream ims = amgr.open(path);
            BitmapFactory.decodeStream(ims, null, o);

            /*on resample*/
            // Calculate inSampleSize
            o.inSampleSize = calculateInSampleSize(o, reqWidth, reqHeight);
            // Decode bitmap with inSampleSize set
            o.inJustDecodeBounds = false;
            Bitmap b = BitmapFactory.decodeStream(ims, null, o);

            /*enfin,on set la view*/
            iv.setImageBitmap(b);
        }catch (IOException x){
            Log.e("ImageTools","Erreur de chargemment du fichier image");
        }

    }
}