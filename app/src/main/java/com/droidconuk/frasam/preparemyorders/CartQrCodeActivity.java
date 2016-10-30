package com.droidconuk.frasam.preparemyorders;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity
public class CartQrCodeActivity extends AppCompatActivity {

    public final static int WHITE = 0xFFFFFFFF;
    public final static int BLACK = 0xFF000000;
    public final static int WIDTH = 1000;

    @ViewById
    protected ImageView qrcode_imageview;

    @ViewById
    protected TextView cartCodeTextView;

    @Extra
    String cartId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_qr_code);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Cart code");
        setSupportActionBar(toolbar);
        cartCodeTextView.setText(cartId);
        Bitmap bitmap;

        try {
            bitmap = encodeAsBitmap(cartId);
            qrcode_imageview.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }


    Bitmap encodeAsBitmap(String str) throws WriterException {
        BitMatrix result;
        try {
            result = new MultiFormatWriter().encode(str,
                    BarcodeFormat.QR_CODE, WIDTH, WIDTH, null);
        } catch (IllegalArgumentException iae) {
            // Unsupported format
            return null;
        }
        int w = result.getWidth();
        int h = result.getHeight();
        int[] pixels = new int[w * h];
        for (int y = 0; y < h; y++) {
            int offset = y * w;
            for (int x = 0; x < w; x++) {
                pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, w, 0, 0, w, h);
        return bitmap;
    }
}
