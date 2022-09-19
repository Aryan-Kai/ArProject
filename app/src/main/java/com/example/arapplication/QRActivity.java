package com.example.arapplication;


import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;


public class QRActivity extends AppCompatActivity {

    String contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        scanqrcode();
    }

    private void scanqrcode() {
        ScanOptions scanOptions = new ScanOptions();
        scanOptions.setPrompt("Volume up to Flash On");
        scanOptions.setBeepEnabled(true);
        scanOptions.setCaptureActivity(CaptureCode.class);
        barcodelauncher.launch(scanOptions);

    }
    ActivityResultLauncher<ScanOptions> barcodelauncher = registerForActivityResult(new ScanContract(), result -> {
        if(result.getContents()!=null)
        {
            contents = result.getContents();
            AlertDialog.Builder builder = new AlertDialog.Builder(QRActivity.this);
            builder.setTitle("Information Obtained");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("Load Info", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent  = new Intent(QRActivity.this,ModelActivity.class);
                    intent.putExtra("model_name",contents);
                    startActivity(intent);
                    dialog.dismiss();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();
        }
        else
        {
            System.out.println("No contents");
        }
    });

}