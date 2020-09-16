package com.workorder.app.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.pojo.docPOJO.AttachementPOJO;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UrlClass;

import java.util.List;
import java.util.Map;

import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;

public class ShowDocumentActivity extends AppCompatActivity implements DownloadFile.Listener {
    String url;
    String workorderno;
    String pdfName;
    FloatingActionButton signFab;
    Integer taskId=0;
    private PDFPagerAdapter adapter;
    private FrameLayout fl_container;
    private RemotePDFViewPager viewPager;
    private ProgressBar progress;
    String user_id;
    String status;
    AttachementPOJO attachementPOJO;
    ImageView iv_back;
    TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_document);
        fl_container=findViewById(R.id.frameContainer);
        progress=findViewById(R.id.progressbar);
        signFab = findViewById(R.id.fab_sign);
        iv_back=findViewById(R.id.iv_back);
        tv_title=findViewById(R.id.tv_activity_name);

         try {
             workorderno=getIntent().getStringExtra("workorderno");
             attachementPOJO= (AttachementPOJO) getIntent().getSerializableExtra("Attachment");
           /*  if (attachementPOJO.getStatus().equals("1"))
             {*/
                 signFab.show();
           /*  }else {
                 signFab.hide();
             }*/

             pdfName=attachementPOJO.getDocumentPdfUrl();
             tv_title.setText(pdfName);
             url= "http://109.228.49.117:8095/uploads/templates/PDF/";
             Log.d("UrlBefore",url);
             url=url+pdfName;
             Log.d("PdfUrl",url);

             final ProgressDialog progressDialog = new ProgressDialog(this);
             progressDialog.setMessage("Please wait..");
             progressDialog.setCancelable(false);
             progressDialog.show();

             String url1 = Uri.encode(url);
             String finalUrl = "http://docs.google.com/viewer?url=" + url1 + "&embedded=true";
             final WebView webView = findViewById(R.id.webView);

             WebSettings webSettings = webView.getSettings();
             webSettings.setBuiltInZoomControls(true);
             webSettings.setJavaScriptEnabled(true);
             webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

             webView.getSettings().setBuiltInZoomControls(true);
             webView.getSettings().setDisplayZoomControls(false);
            // webView.getSettings().setUseWideViewPort(true);
           //  webView.getSettings().setLoadWithOverviewMode(true);
             webView.loadUrl(finalUrl);
             webView.loadUrl("javascript:(function() { " +
                     "document.querySelector('[role=\"toolbar\"]').remove();})()");


             webView.setWebViewClient(new WebViewClient() {

                 @Override
                 public void onPageFinished(WebView view, String url) {
                     view.getSettings().setLoadsImagesAutomatically(true);
                     webView.setVisibility(View.VISIBLE);
                     //progressView.setVisibility(View.VISIBLE);

                     if (progressDialog.isShowing()) {
                         progressDialog.dismiss();
                     }

                     webView.loadUrl("javascript:(function() { " +
                             "document.querySelector('[role=\"toolbar\"]').remove();})()");

                 }

                 @Override
                 public void onPageStarted(WebView view, String url, Bitmap favicon) {

                 }

                 @Override
                 public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                     Toast.makeText(getApplicationContext(), description, Toast.LENGTH_SHORT).show();
                     Log.e("error", description);

                 }
             });



             try {
                 viewPager = new RemotePDFViewPager(this,url,this);
                 viewPager.getOffscreenPageLimit();
             }catch (Exception e)
             {
                 Log.d("Exception",e.toString());
             }


         }catch (Exception e)
         {
             Log.d("ShowException",e.toString());

         }




    iv_back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    });



    signFab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (attachementPOJO.getStatus().equals("4")){
                opentThanksYesClickDialog1("SWMS template already signed");
            }else {
                Intent intent = new Intent(ShowDocumentActivity.this, SignatureActivity.class);
                //Intent intent = new Intent(MapsActivity.this, ShowDocListActivity.class);
                intent.putExtra("AssesmentPOJO", attachementPOJO);
                // startActivity(intent);
                startActivity(intent);
            }


        }
    });

    }

    public void opentThanksYesClickDialog1(String message) {
        final Dialog dialog = new Dialog(ShowDocumentActivity.this);
        dialog.setContentView(R.layout.inflate_home_thanks_yes_click);
        TextView tv_type = dialog.findViewById(R.id.tv_alert_type);
        TextView tv_ok = dialog.findViewById(R.id.tv_ok_thanks);
        tv_type.setText("Alert");
        TextView tv_message = dialog.findViewById(R.id.tv_message_thanks);
        tv_message.setText(message);

        dialog.show();
        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (adapter!=null){
            adapter.close();
        }
    }
    @Override
    public void onSuccess(String url, String destinationPath) {
       try {
           System.out.println(url+"  Ashish:"+destinationPath);
           progress.setVisibility(View.GONE);
           adapter=new PDFPagerAdapter(this,destinationPath);
           viewPager.setAdapter(adapter);
           fl_container.addView(viewPager);

        //   viewPager.setMinimumHeight(250);
     //      viewPager.setMinimumWidth(300);
         //  viewPager.onInterceptHoverEvent(MotionEvent.obtain())

           //fl_container.setFitsSystemWindows(true);
       }catch (Exception e)
       {
          Log.d("Exception",e.toString());
       }


    }

    @Override
    public void onFailure(Exception e) {
        Toast.makeText(this, "Pdf Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProgressUpdate(int progress, int total) {

        if(progress<total&& this.progress.getVisibility()==View.GONE){
            this.progress.setVisibility(View.VISIBLE);
        }
    }

   /* @Override
    public boolean onTouch(View v, MotionEvent event) {
        viewPager.onInterceptHoverEvent(event);
        return true;
    }
*/

   /* @Override
    public boolean onTouchEvent(MotionEvent event) {
        try {

            viewPager.onInterceptHoverEvent(event);
            viewPager.setMinimumHeight(250);
            viewPager.setMinimumWidth(300);

        }catch (Exception e)
        {
            Log.d("ZoomException",e.toString());
        }

        return  true;
       // return super.onTouchEvent(event);

    }*/
}
