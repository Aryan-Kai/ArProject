package com.example.arapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;

public class book_activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

//        PdfRenderer renderer = new PdfRenderer(getSeekableFileDescriptor());
//        final int pageCount = renderer.getPageCount();
//        for (int i = 0; i < pageCount; i++) {
//            PdfRenderer.Page page = renderer.openPage(i);
//
//            // say we render for showing on the screen
//            ((PdfRenderer.Page) page).render(mBitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
//
//            // do stuff with the bitmap
//
//            // close the page
//            page.close();
//        }
//        PdfRenderer.Page rendererPage=renderer.openPage(1);
//        int rendererPageWidth=rendererPage.getWidth();
//        int rendererPageHeight=rendererPage.getHeight();
//        Bitmap bitmap= Bitmap.createBitmap(rendererPageWidth,rendererPageHeight,Bitmap.Config.ARGB_8888);
//        rendererPage.render(bitmap,null,null,PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
//        pdfView.setImageBitmap(bitmap);
//        rendererPage.close();
//        renderer.close();
//        fileDescriptor.close();


        // close the renderer
//        renderer.close();
    }
}