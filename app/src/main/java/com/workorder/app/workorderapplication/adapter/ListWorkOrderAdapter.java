package com.workorder.app.workorderapplication.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.util.UtilityFunction;
import com.workorder.app.workorderapplication.activity.History;
import com.workorder.app.workorderapplication.activity.MaterialUsedList;
import com.workorder.app.workorderapplication.activity.SearchWorkOrder;
import com.workorder.app.workorderapplication.activity.Swmslist;
import com.workorder.app.workorderapplication.activity.UpdateWorkOrder;
import com.workorder.app.workorderapplication.activity.WorkOrderAllocationList;
import com.workorder.app.workorderapplication.filter.WorkOrderFilter;
import com.workorder.app.workorderapplication.model.workOrderModel.WorkOrderResponseModel;
import com.workorder.app.workorderapplication.remote.ApiServicesWorkOrder;
import com.workorder.app.workorderapplication.remote.NetworkWorkOrder;
import com.workorder.app.workorderapplication.remote.PreferenceManagerWorkOrder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListWorkOrderAdapter extends RecyclerView.Adapter<ListWorkOrderAdapter.MyViewHolder> implements Filterable {
    Context mContext;
    ClickListener mClickListner;
    public List<WorkOrderResponseModel> myTaskList,filterList;
    WorkOrderFilter filter;
    String rolename,WorkOrderId,companyid;
    PreferenceManagerWorkOrder preferenceManagerWorkOrder;


    public ListWorkOrderAdapter(Context context, List<WorkOrderResponseModel> list) {
        this.myTaskList = list;
        this.filterList=myTaskList;
        this.mContext = context;
    }
    public void setClicklistener(ClickListener clickListner) {
        this.mClickListner = clickListner;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_work_order, parent, false);

        return new MyViewHolder(mContext,itemView, viewType,mClickListner);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(mContext);

        if (myTaskList.size() != 0) {
            if(preferenceManagerWorkOrder.getKey_User_Role().equals("Contractor")){
                holder.worker.setVisibility(View.VISIBLE);
            }
            if(preferenceManagerWorkOrder.getKey_User_Role().equals("Worker")){
                /*holder.material.setVisibility(View.VISIBLE);*/
                holder.deletewo.setVisibility(View.INVISIBLE);
                holder.history.setVisibility(View.INVISIBLE);
                holder.worker.setVisibility(View.INVISIBLE);
            }
            if(preferenceManagerWorkOrder.getKey_User_Role().equals("Client")){
                /*holder.material.setVisibility(View.VISIBLE);*/
                holder.swms.setVisibility(View.VISIBLE);
            }else {
                holder.swms.setVisibility(View.GONE);
            }
         final WorkOrderResponseModel item = myTaskList.get(position);
            if(item.getWorkOrderId()!=null)
            {
                holder.priority.setText(item.getPriority());
                holder.client_nme.setText(item.getClientName());
                String date=item.getDueDate();
              //  String[]dat=date.split("T");
              //  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                //Date date1=null;
              //  try {
                 //   date1 = simpleDateFormat.parse(dat[0]);

               // } catch (ParseException e) {
                 //   e.printStackTrace();
               // }
              //  SimpleDateFormat newformat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
               // String dateInReqFormat = newformat.format(date1);
                holder.due_date.setText(UtilityFunction.getSplitedDate(date));
                holder.desc.setText(item.getDescription());
                String wostatus=item.getStatus();
                    holder.statu.setText(wostatus);
                WorkOrderId=item.getWorkOrderId();
                holder.warning.setText(item.getWarningText());
                holder.wo_nmbr.setText(item.getWorkOrderNumber());

                holder.history.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String woId=item.getWorkOrderId();
                        Bundle bundle=new Bundle();
                        bundle.putString("WorkOrderId",woId);
                        Intent intent=new Intent(v.getContext(),History.class);
                        intent.putExtras(bundle);
                        v.getContext().startActivity(intent);
                    }
                });
                holder.material.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String woId=item.getWorkOrderId();
                        Bundle bundle=new Bundle();
                        bundle.putString("WorkOrderId",woId);
                        Intent intent=new Intent(v.getContext(),MaterialUsedList.class);
                        intent.putExtras(bundle);
                        v.getContext().startActivity(intent);
                    }
                });

                holder.swms.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(view.getContext(), Swmslist.class);
                      //  intent.putExtra("id",item.get);
                        intent.putExtra("wid",item.getWorkOrderNumber());
                        view.getContext().startActivity(intent);
                    }
                });
                holder.worker.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String woId=item.getWorkOrderId();
                        Bundle bundle=new Bundle();
                        bundle.putString("WorkOrderId",woId);
                        Intent intent=new Intent(v.getContext(),WorkOrderAllocationList.class);
                        intent.putExtras(bundle);
                        v.getContext().startActivity(intent);
                    }
                });

                holder.deletewo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setTitle("Delete?");
                        //Setting message manually and performing action on button click
                        builder.setMessage("Are you sure to delete this item?");
                        //This will not allow to close dialogbox until user selects an option
                        builder.setCancelable(false);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(mContext, "Delete", Toast.LENGTH_SHORT).show();
                                WorkOrderId=item.getWorkOrderId();
                                deleteWorkOrder();
                                v.getContext().startActivity(new Intent(v.getContext(),SearchWorkOrder.class));
                                //builder.finish();
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                Toast.makeText(mContext, "Cancel", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        });

                        //Creating dialog box
                        AlertDialog alert = builder.create();
                        //Setting the title manually
                        //alert.setTitle("AlertDialogExample");
                        alert.show();
                    }
                });

                holder.updatewo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String WorkOrderId=item.getWorkOrderId();
                        Bundle bundle=new Bundle();
                        bundle.putString("WorkOrderId",WorkOrderId);
                        Intent intent=new Intent(v.getContext(),UpdateWorkOrder.class);
                        intent.putExtras(bundle);
//                        intent.putExtra("list",arrayList);
//                        intent.putExtra("contrctTreeList",contrctTrees);
                        v.getContext().startActivity(intent);
                    }
                });
            }
        }
    }
    private void deleteWorkOrder()
    {
            ApiServicesWorkOrder apiServicesWorkOrder = NetworkWorkOrder.getInstance().getApiServicesWorkOrder();
            final Call<String> deleteWorkOrder= apiServicesWorkOrder.delete("application/json","api/order/DeleteWorkOrderDetails?WorkOrderId="+WorkOrderId+"&CompanyId="+companyid);
            deleteWorkOrder.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if(response.body()!=null)
                    {
                        String result=response.body();
                        Toast.makeText(mContext, ""+result, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println(t.getMessage() + t.getLocalizedMessage());
                }
            });
    }
    @Override
    public int getItemCount() {
        return myTaskList.size();
    }

    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new WorkOrderFilter(this,filterList);
        }
        return filter;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView workOrder, statu, due_date, client_nme, desc, wo_nmbr, asset_ne,priority,warning;
        Integer position;
      public ImageButton updatewo,deletewo,worker,material,history,workerUpdate,swms;
        Context context;
        ClickListener clickListener;
        public MyViewHolder(Context context, final View itemView, Integer viewType, final ClickListener clickListener) {
            super(itemView);
            position = viewType;
            this.context=context;
            this.clickListener=clickListener;
            preferenceManagerWorkOrder = PreferenceManagerWorkOrder.getInstance(mContext);
            companyid= preferenceManagerWorkOrder.getKey_Person_Company_Id();
            rolename= preferenceManagerWorkOrder.getKey_User_Name();

            desc = itemView.findViewById(R.id.desc);
            swms = itemView.findViewById(R.id.swms);
            client_nme = itemView.findViewById(R.id.client_name);
            warning = itemView.findViewById(R.id.warning);
            due_date = itemView.findViewById(R.id.due_date);
            statu = itemView.findViewById(R.id.status);
            priority= itemView.findViewById(R.id.priority);
            wo_nmbr = itemView.findViewById(R.id.work_order_no);
            deletewo=itemView.findViewById(R.id.deleteWorkOrder);
            updatewo=itemView.findViewById(R.id.updateworkOrder);
            material=itemView.findViewById(R.id.materialused);
            history=itemView.findViewById(R.id.histroyWorkOrder);
            worker=itemView.findViewById(R.id.addWorker);
            workerUpdate = itemView.findViewById(R.id.updateworkOrder);

        }

    }
}
