package com.madmaxi.bd;

import android.content.res.AssetManager;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import org.w3c.dom.Document;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    TextView texteView;
    ImageView imageView;
    Button next;
    int Vignette = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Affection du fichier de layout
        setContentView(R.layout.activity_main);

        //Obtention des références sur les composants
        texteView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        next = (Button) findViewById(R.id.button);

        //Lorsque l'on appuie sur le bouton next, on change l'id de vignette.
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Vignette += 1;
                
                        
            }
        });

        AssetManager assetManager = getAssets();
        InputStream inputStream = null;
        Document doc=null;
        try {
            inputStream = assetManager.open("histoire.xml");
             doc= parseXML(inputStream);
            String textVignette = parser.getTextAtId(doc, ((String) Vignette));
            texteView.setText(textVignette);
        } catch (IOException e) {
            Log.e("tag", e.getMessage());
        }
    }

    public Document parseXML(InputStream source) {
        Document doc=null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(source);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("",e.toString());
        }
        return doc;
    }
}

