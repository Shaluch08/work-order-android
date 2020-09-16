package com.workorder.app.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

public class SiteLocationAdapter extends RecyclerView.Adapter<SiteLocationAdapter.SiteLocationHolder> {

    Context context;
    List<GetSiteByIdPOJO> getSiteByIdPOJOS;

    public SiteLocationAdapter(Context context, List<GetSiteByIdPOJO> getLocationPOJOList) {
        this.context = context;
        this.getSiteByIdPOJOS = getLocationPOJOList;
    }


    @Override
    public SiteLocationHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.inflate_site_location, viewGroup, false);
        return new SiteLocationHolder(view);
    }

    @Override
    public void onBindViewHolder(SiteLocationHolder holder, int i) {
        try {
            final GetSiteByIdPOJO getSiteByIdPOJO=getSiteByIdPOJOS.get(i);
          //  String address=getSiteByIdPOJO.getAddress1()+", "+getSiteByIdPOJO.getAddress2()+", "+getSiteByIdPOJO.getCity()+" "+getSiteByIdPOJO.getPostCode();
            holder.tv_address.setText(getSiteByIdPOJO.getSiteLocationPOJO().getFormatAddress());
            holder.tv_site_name.setText(getSiteByIdPOJO.getSiteLocationPOJO().getSiteName());
            holder.tv_building.setText(getSiteByIdPOJO.getSiteLocationPOJO().getBuildingName());
         //   holder.tv_building.setText(getSiteByIdPOJO.getAddress1());
            String distance=  UtilityFunction.calculateDistance(Constants.CURRENT_LAT,Constants.CURRENT_LNG,getSiteByIdPOJO.getSiteLocationPOJO().getLatitude(),getSiteByIdPOJO.getSiteLocationPOJO().getLongitude(), Constants.PROVIDER);

            Constants.DISTANCE=distance;
            if (Double.parseDouble(distance)<=300)
            {
                holder.tv_go_on_site.setText("Go On Site");
                holder.tv_go_on_site.setBackgroundResource(R.drawable.go_on_site_bg_design);
            }else {
                holder.tv_go_on_site.setText("Go Off Site");
                holder.tv_go_on_site.setBackgroundResource(R.drawable.inflate_go_on_site_red);
            }

            holder.iv_direction.setOnClickListener(new View.OnClickListener() {
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

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
               /*     Intent intent=new Intent(context, ShowClientHomeActivity.class);
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

    public class SiteLocationHolder extends RecyclerView.ViewHolder {
        TextView tv_address;
        TextView tv_site_name;
        TextView tv_go_on_site;
        TextView tv_building;
        ImageView iv_direction;

        public SiteLocationHolder(View itemView) {
            super(itemView);
            tv_address=itemView.findViewById(R.id.tv_iflate_site_location_address);
            tv_site_name=itemView.findViewById(R.id.tv_iflate_site_location_site_name);
            tv_go_on_site=itemView.findViewById(R.id.tv_site_location_go_on_site);
            tv_building=itemView.findViewById(R.id.tv_iflate_site_location_building);
            iv_direction=itemView.findViewById(R.id.iv_iflate_site_location_direction);


        }
    }
}
