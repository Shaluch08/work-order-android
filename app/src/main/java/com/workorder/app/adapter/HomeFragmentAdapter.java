package com.workorder.app.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.workorder.app.R;
import com.workorder.app.pojo.GetSiteByIdPOJO;
import com.workorder.app.util.Constants;
import com.workorder.app.util.UtilityFunction;

import java.util.List;

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.HomeFragmentHolder> {
    Context context;
    List<GetSiteByIdPOJO> getSiteByIdPOJOS;

    public HomeFragmentAdapter(Context context, List<GetSiteByIdPOJO> getLocationPOJOList) {
        this.context = context;
        this.getSiteByIdPOJOS = getLocationPOJOList;
    }



    @Override
    public HomeFragmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.rv_task_list, parent, false);
        return new HomeFragmentHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeFragmentHolder holder, int position) {
        try {
            final GetSiteByIdPOJO getSiteByIdPOJO=getSiteByIdPOJOS.get(position);
            holder.tv_client.setText(getSiteByIdPOJO.getRiskAssesmentPOJO().getWorkOrderNumber());
            holder.tv_company.setText(getSiteByIdPOJO.getRiskAssesmentPOJO().getCompany());
            holder.tv_building.setText(getSiteByIdPOJO.getSiteLocationPOJO().getBuildingName());
         //  String address=getSiteByIdPOJO.getAddress1()+", "+getSiteByIdPOJO.getAddress2()+", "+getSiteByIdPOJO.getCity()+", "+getSiteByIdPOJO.getState()+", "+getSiteByIdPOJO.getPostCode()+", "+getSiteByIdPOJO.getCountry();
            holder.tv_address.setText(getSiteByIdPOJO.getSiteLocationPOJO().getFormatAddress());

            holder.iv_show_direction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String distance=  UtilityFunction.calculateDistance(Constants.CURRENT_LAT,Constants.CURRENT_LNG,getSiteByIdPOJO.getSiteLocationPOJO().getLatitude(),getSiteByIdPOJO.getSiteLocationPOJO().getLongitude(), Constants.PROVIDER);

                    Constants.DISTANCE=distance;
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?saddr="+ Constants.CURRENT_LAT +","+Constants.CURRENT_LNG+"&daddr="+getSiteByIdPOJO.getSiteLocationPOJO().getLatitude()+","+getSiteByIdPOJO.getSiteLocationPOJO().getLongitude()));///*28.7893,79.0250*/
                    //28.5355,77.3910

                    context.startActivity(intent);
                   /* Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?saddr=28.5355,77.3910&daddr=28.7893,79.0250"));
                    context.startActivity(intent);*/
                }
            });

            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
              /*      Intent intent=new Intent(context, ShowClientHomeActivity.class);
                    intent.putExtra("GetSitePOJO",getSiteByIdPOJO);
                    context.startActivity(intent);*/
                }
            });

        }catch (Exception e)
        {
            Log.d("HomeAdapter",e.toString());
        }

    }

    @Override
    public int getItemCount() {
        return getSiteByIdPOJOS.size();
    }

    public class HomeFragmentHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView tv_client;
        TextView tv_company;
        TextView tv_building;
        TextView tv_address;
        ImageView iv_show_direction;
        public HomeFragmentHolder(View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.card_frag_home);
            tv_client=itemView.findViewById(R.id.tv_home_frag_client);
            tv_company=itemView.findViewById(R.id.tv_home_frag_company);
            tv_building=itemView.findViewById(R.id.tv_home_frag_building);
            tv_address=itemView.findViewById(R.id.tv_home_frag_address);
            iv_show_direction=itemView.findViewById(R.id.iv_frag_home_direction);

        }
    }



}
