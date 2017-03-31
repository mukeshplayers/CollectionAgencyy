package com.collectionagency.collectionagency.agent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.collectionagency.collectionagency.R;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgentNotificationDetail extends AppCompatActivity implements View.OnClickListener{

    String custid, name, mobile, amount, address, area, city, state, pincode, email;

    TextView tvcustid, tvname, tvmobile, tvamount, tvaddress, tvarea, tvcity, tvstate, tvpincode, tvemail;
    File myFile;
    Button savepdf, viewpdf;

    private Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 32, Font.BOLD);
    private Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 28);
    private Font copyrightFont = new Font(Font.FontFamily.TIMES_ROMAN, 25);
    private Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 40, Font.BOLD);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agent_notification_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Details");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        custid = getIntent().getStringExtra("customerid");
        name = getIntent().getStringExtra("name");
        mobile = getIntent().getStringExtra("mobile");
        amount = getIntent().getStringExtra("amount");
        address = getIntent().getStringExtra("address");
        area = getIntent().getStringExtra("area");
        city = getIntent().getStringExtra("city");
        state = getIntent().getStringExtra("state");
        pincode = getIntent().getStringExtra("pincode");
        email = getIntent().getStringExtra("email");

        Log.d("CustomerID:", "CustomerID: "+custid);

        tvcustid = (TextView)findViewById(R.id.tv_custid);
        tvname = (TextView)findViewById(R.id.tv_custname);
        tvmobile = (TextView)findViewById(R.id.tv_custmobile);
        tvamount = (TextView)findViewById(R.id.tv_custamount);
        tvaddress = (TextView)findViewById(R.id.tv_custaddress);
        tvarea = (TextView)findViewById(R.id.tv_custarea);
        tvcity = (TextView)findViewById(R.id.tv_custcity);
        tvstate = (TextView)findViewById(R.id.tv_custstate);
        tvpincode = (TextView)findViewById(R.id.tv_custpincode);
        tvemail = (TextView)findViewById(R.id.tv_custemail);

        tvcustid.setText("Customer ID: "+custid);
        tvname.setText("Name: "+name);
        tvmobile.setText("Mobile No: "+mobile);
        tvamount.setText("Amount: "+amount);
        tvaddress.setText("Address: "+address);
        tvarea.setText("Area: "+area);
        tvcity.setText("City: "+city);
        tvstate.setText("State: "+state);
        tvpincode.setText("Pincode: "+pincode);
        tvemail.setText("Email: "+email);


        savepdf = (Button)findViewById(R.id.btn_paynow);
        viewpdf = (Button)findViewById(R.id.btn_viewpdf);

        savepdf.setOnClickListener(this);
        viewpdf.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_paynow) {
            try {
                createPDF();
                Toast.makeText(AgentNotificationDetail.this, "Congrats! Bill Paid.", Toast.LENGTH_SHORT).show();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (view.getId() == R.id.btn_viewpdf)
        {
            try {
                    Uri path = Uri.fromFile(myFile);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(path,"application/pdf");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
            }
            catch (Exception e){
                Toast.makeText(AgentNotificationDetail.this, "Sorry! You either haven't paid or bill isn't generated.", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void createPDF() throws IOException, DocumentException{

        File ourpdfFolder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "Payment");

        if (!ourpdfFolder.exists()){
            ourpdfFolder.mkdir();
        }

        Date date = new Date();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(date);

        myFile = new File(ourpdfFolder + timeStamp + ".pdf");

        OutputStream outputStream = new FileOutputStream(myFile);

        com.itextpdf.text.Document document = new com.itextpdf.text.Document();
        PdfWriter.getInstance(document, outputStream);

        document.open();

        Drawable d = getResources ().getDrawable (R.drawable.logo_collection_agency_tranparent);
        Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 10, stream);
        byte[] bitmapData = stream.toByteArray();

        Image image = Image.getInstance(bitmapData);
        image.scaleAbsolute(140f,140f);
        image.setAlignment(Element.ALIGN_CENTER);
        document.add(image);

        Paragraph paragraph = new Paragraph("Collection Agency",titleFont);

        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.setPaddingTop(20);
        document.add(paragraph);

        paragraph = new Paragraph("Customer ID: " +custid, normalFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);

        paragraph = new Paragraph("Customer Name: "+name, normalFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);

        paragraph = new Paragraph("Mobile No: "+mobile, normalFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);

        paragraph = new Paragraph("Address: "+address, normalFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);

        paragraph = new Paragraph("Area: "+area, normalFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);

        paragraph = new Paragraph("City: "+city, normalFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);

        paragraph = new Paragraph("State: "+state, normalFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);

        paragraph = new Paragraph("Picode: "+pincode, normalFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);

        paragraph = new Paragraph("Email: " +email, normalFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);

        paragraph = new Paragraph("Amount Paid: "+amount, catFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);

        paragraph = new Paragraph("© CollectionAgency 2017",copyrightFont);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);

        document.close();
    }
}