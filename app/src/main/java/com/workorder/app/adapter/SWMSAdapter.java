package com.workorder.app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.workorder.app.R;
import com.workorder.app.activity.MapsActivity;
import com.workorder.app.activity.ShowDocumentActivity;
import com.workorder.app.pojo.docPOJO.AttachementPOJO;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;

import java.util.List;
import java.util.Map;

public class SWMSAdapter extends RecyclerView.Adapter<SWMSAdapter.DocListViewHolder> {

    Context context;
    List<AttachementPOJO> attachementPOJOList;
    String workOrderNumber;
   // DocClickListner mclickListner;
   // List<Attachement> attachementList;

    public SWMSAdapter(Context context, List<AttachementPOJO> attachementPOJOList, String workOrderNumber) {
        this.context = context;
        this.attachementPOJOList=attachementPOJOList;
        this.workOrderNumber=workOrderNumber;
      //  this.mclickListner = clickListner;
      //  this.attachementList = attachement;
    }

    @Override
    public DocListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_doc_list, parent, false);

        return new DocListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DocListViewHolder holder, int position) {
        final AttachementPOJO attachementPOJO=attachementPOJOList.get(position);

        holder.tv_DocName.setText(attachementPOJO.getDocumentPdfUrl());
        holder.tv_doc_date.setText(UtilityFunction.getSplitedDate(attachementPOJO.getAttachementDate()));

        if (attachementPOJO.getStatus().equals("1"))
        {
         holder.tv_signed_status.setText("Available");
        }else if (attachementPOJO.getStatus().equals("2"))
        {
            holder.tv_signed_status.setText("Open");
        }else if (attachementPOJO.getStatus().equals("3"))
        {
            holder.tv_signed_status.setText("Cancel");
        }else if (attachementPOJO.getStatus().equals("4"))
        {
            holder.tv_signed_status.setText("Signed");
        }else {
            holder.tv_signed_status.setText("Assigned");
        }


            holder.openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, ShowDocumentActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("Attachment",attachementPOJO);
                intent.putExtra("workorderno",workOrderNumber);
              //  Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://109.228.49.117:8095/uploads/templates/PDF/"+attachementPOJO.getDocumentPdfUrl()));
                //context.startActivity(browserIntent);
                context.startActivity(intent);
               // Toast.makeText(context, ""+attachementPOJO.getDocumentPdfUrl(), Toast.LENGTH_SHORT).show();
            }
        });

        //Attachement item = attachementList.get(position);
      //  String assesmentDate = item.getAttachementDate();
       // String date = assesmentDate.substring(0, 10);
       // String time = assesmentDate.substring(11, 16);
       // holder.tv_DocName.setText(item.getDocumentPdfUrl());
       // holder.mDocInfo.setText(date);
    }

    @Override
    public int getItemCount() {
        return attachementPOJOList.size();
    }

    public class DocListViewHolder extends RecyclerView.ViewHolder {
        TextView tv_DocName;
        TextView tv_doc_date;
        TextView tv_signed_status;
        CardView taskCard;
     //   DocClickListner myclickListner;
        Integer position;
        Button openButton;
        ImageView downloadImage;

        public DocListViewHolder(View itemView) {
            super(itemView);
          //  position = viewType;
          //  this.myclickListner = clickListner;
            tv_DocName = itemView.findViewById(R.id.tv_doc_name);
            tv_doc_date = itemView.findViewById(R.id.tv_doc_date);
            tv_signed_status=itemView.findViewById(R.id.tv_signed_status);
            openButton = itemView.findViewById(R.id.btn_doc_open);
            downloadImage = itemView.findViewById(R.id.iv_doc_download);
            taskCard = itemView.findViewById(R.id.firstcard);
           // downloadImage.setOnClickListener(this);
            //openButton.setOnClickListener(this);
        }
/*
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.iv_doc_download:
                    myclickListner.docClick(getAdapterPosition());
                    break;

                case R.id.btn_doc_open:
                    myclickListner.openClick(getAdapterPosition());
                    break;
            }
        }*/
    }


   /* interface DocClickListner {

        void docClick(Integer position);


        void openClick(Integer position);
    }*/
}