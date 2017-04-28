package com.madmaxi.bd;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Document;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    TextView texteView;
    ImageView ImageView;
    String Vignette = "1-1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texteView = (TextView) findViewById(R.id.textView);

        AssetManager assetManager = getAssets();
        InputStream inputStream = null;
        Document doc=null;
        try {
            inputStream = assetManager.open("histoire.xml");
             doc= parseXML(inputStream);
            String textVignette = parser.getTextAtId(doc,Vignette);
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

