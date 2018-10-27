package com.yello.storgetest;

import android.content.Context;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this, new String[]
                {
                        android.Manifest.permission.READ_EXTERNAL_STORAGE,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, 100);

        writeToFile();
//        readFromFile();
    }

    private void readFromFile() {
        try
        {
            File SDCard = Environment.getExternalStorageDirectory();
            Log.i("gohary", SDCard.toString());
            File readFile = new File(SDCard, "z.txt");
            StringBuilder text = new StringBuilder();

            try {
                BufferedReader br = new BufferedReader(new FileReader(readFile));
                String line;

                while ((line = br.readLine()) != null) {
                    text.append(line);
                    text.append('\n');
                }
                br.close();
                Log.i("gohary", text.toString());
            }
            catch (IOException e) {
                Log.i("gohary", "error: "  + e);
                //You'll need to add proper error handling here
            }


        }
        catch (Exception e)
        {
            Log.i("gohary", "error: "  + e);
        }

    }

    private void writeToFile()
    {
        File folder = null;
        File outputFile = null;
        folder = new File(Environment.getExternalStorageDirectory() + "/"
                + "G");

        if (!folder.exists())
        {
            folder.mkdirs();
            Log.i("Gohary", "Directory Created.");
        }
        outputFile = new File(folder, "hamada.txt");

        if (!outputFile.exists())
        {
            try {
                outputFile.createNewFile();
                Log.i("Gohary", "File Created");
            } catch (IOException e) {
                Log.i("Gohary", "Error File Created" + e);
        }

        }

        try {
            FileOutputStream openedFile = new FileOutputStream(outputFile, true);
            OutputStreamWriter myPen = new OutputStreamWriter(openedFile);
            myPen.append("Ziko23");
            myPen.close();
            openedFile.flush();
            openedFile.close();
            Log.i("Gohary", "Written");
        }
        catch (Exception e)
        {
            Log.i("Gohary", "Error File Writing" + e);
        }

    }
}
