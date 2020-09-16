package com.workorder.app.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.workorder.app.R;
import com.workorder.app.Util;
import com.workorder.app.pojo.docPOJO.AttachementPOJO;
import com.workorder.app.pojo.survey.SurveyPOJO;
import com.workorder.app.util.SubmitSurveyAns;
import com.workorder.app.webservicecallback.OnTaskCompleted;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SurveyAdapter extends RecyclerView.Adapter<SurveyAdapter.QuestionListAdapter> {
    Context context;
    List<SurveyPOJO> attachementPOJOList;
    private RatingSelectionInterface ratingSelectionInterface;
    int pos;
    private Map<String, String> map=new HashMap<>();
    public static Map<String, SubmitSurveyAns> map1=new HashMap<>();


    public SurveyAdapter(Context context, List<SurveyPOJO> attachementPOJOList,int pos,RatingSelectionInterface ratingSelectionInterface,Map<String, String> map) {
        this.context = context;
        this.attachementPOJOList=attachementPOJOList;
        this.pos=pos;
        this.ratingSelectionInterface=ratingSelectionInterface;
        this.map=map;
    }

    @NonNull
    @Override
    public QuestionListAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.survey_adapter, parent, false);

        return new QuestionListAdapter(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuestionListAdapter holder, final int position) {

        try {
            int p=pos+1;
            holder.ques.setText(attachementPOJOList.get(pos).getTitle());

//            for( int i = 0; i <=attachementPOJOList.get(pos).getSurveyquestPOJOS().size(); i++) {
//                final CheckBox cb = new CheckBox(context);
//                cb.setText(attachementPOJOList.get(pos).getSurveyquestPOJOS().get(i).getTitle());
//                cb.setPadding(0,0,0,5);
//                ColorStateList darkStateList = ContextCompat.getColorStateList(context, R.color.checkbox_tinit_dark_theme);
//                CompoundButtonCompat.setButtonTintList(cb, darkStateList);
//                cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
//                {                    @Override
//                    public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
//
//                        String string = buttonView.getText().toString();
//
//                        if(!isChecked){
//
//                        }
//                        else
//                        {
//                            SubmitSurveyAns informationBean = new SubmitSurveyAns(attachementPOJOList.get(pos).getQuestionID(), attachementPOJOList.get(pos).getSurveyquestPOJOS().get(position).getAnswerID(), attachementPOJOList.get(pos).getSurveyAID(), attachementPOJOList.get(pos).getSurveyID(), attachementPOJOList.get(pos).getSurveyquestPOJOS().get(position).getSurveyQID());
//                            map1.put(attachementPOJOList.get(pos).getQuestionID(), informationBean);
//                          //  notifyDataSetChanged();
//                            Log.v("shalu1",map1.toString());
//                            try{
//
//                                ratingSelectionInterface.itemselect(attachementPOJOList.get(pos).getQuestionID(), string, attachementPOJOList.get(pos).getSurveyAID(), attachementPOJOList.get(pos).getSurveyID(), attachementPOJOList.get(pos).getSurveyquestPOJOS().get(pos).getSurveyQID());
//                            }catch (Exception ee){}
//
//                        }
//                    }
//                });
//                holder.check.addView(cb);
//
//            }

            if(attachementPOJOList.get(pos).getQuestionTypeName().equalsIgnoreCase("FreeText")){
                holder.radioGroup.setVisibility(View.GONE);
                holder.freetext.setVisibility(View.VISIBLE);


            }else {
                holder.radioGroup.setVisibility(View.VISIBLE);
                holder.freetext.setVisibility(View.GONE);
            }

            holder.edittext.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    ratingSelectionInterface.itemselect(attachementPOJOList.get(pos).getQuestionID(), attachementPOJOList.get(pos).getSurveyquestPOJOS().get(position).getAnswerID(), attachementPOJOList.get(pos).getQuestionTypeName(), attachementPOJOList.get(pos).getSurveyID(), holder.edittext.getText().toString());

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    ratingSelectionInterface.itemselect(attachementPOJOList.get(pos).getQuestionID(), attachementPOJOList.get(pos).getSurveyquestPOJOS().get(position).getAnswerID(), attachementPOJOList.get(pos).getQuestionTypeName(), attachementPOJOList.get(pos).getSurveyID(), holder.edittext.getText().toString());

                }
            });

            RadioButton[] rb = new RadioButton[attachementPOJOList.get(pos).getSurveyquestPOJOS().size()];

            for (int i = 0; i < attachementPOJOList.get(pos).getSurveyquestPOJOS().size(); i++) {
                rb[i] = new RadioButton(context);
                rb[i].setTextSize(16f);
                rb[i].setPadding(0,0,0,5);
                ColorStateList darkStateList = ContextCompat.getColorStateList(context, R.color.checkbox_tinit_dark_theme);
                CompoundButtonCompat.setButtonTintList(rb[i], darkStateList);
                rb[i].setText(attachementPOJOList.get(pos).getSurveyquestPOJOS().get(i).getTitle());
                holder.radioGroup.addView(rb[i]);
            }

            for (Map.Entry mEntry: map.entrySet())
            {
                if (mEntry.getKey().equals(attachementPOJOList.get(pos).getQuestionID()))
                {
                    try {
                        String srValue=mEntry.getValue().toString();
                        String aa = srValue.substring(srValue.indexOf(",") + 1);
                        String surveyAnswerID = Util.before(aa, ",");
                        String aaa = aa.substring(aa.indexOf(",") + 1);
                        String surveyID = Util.before(aaa, ",");
                        String selecion = Util.after(aaa, ",");
                         for (int i = 0; i < attachementPOJOList.get(pos).getSurveyquestPOJOS().size(); i++) {
                            Log.v("value",selecion+"    "+attachementPOJOList.get(pos).getSurveyquestPOJOS().get(i).getTitle());
                            if(attachementPOJOList.get(pos).getSurveyquestPOJOS().get(i).getTitle().equalsIgnoreCase(selecion)){
                                rb[i].setChecked(true);
                            }
                         }
                        if(attachementPOJOList.get(pos).getQuestionID() == mEntry.getKey()){
                            holder.edittext.setText(selecion);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            Log.v("map",map.toString());


        }catch (Exception e){

        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public class QuestionListAdapter extends RecyclerView.ViewHolder implements RadioGroup.OnCheckedChangeListener{
        TextView ques;
        RadioGroup radioGroup;
        LinearLayout check;
        LinearLayout freetext;
        EditText edittext;

        public QuestionListAdapter(@NonNull View itemView) {
            super(itemView);
            ques = itemView.findViewById(R.id.ques);
            check = itemView.findViewById(R.id.check);
            freetext = itemView.findViewById(R.id.freetext);
            radioGroup = itemView.findViewById(R.id.radiogroup);
            edittext = itemView.findViewById(R.id.edittext);
            radioGroup.setOnCheckedChangeListener(this);
        }

        @Override
        public void onCheckedChanged(RadioGroup group, int i) {
            int index = getLayoutPosition();
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(context, "Please select answer", Toast.LENGTH_LONG).show();
            } else {
                try {
                    int radioButtonId = group.getCheckedRadioButtonId();
                    View radio = group.findViewById(radioButtonId);
                    int position = group.indexOfChild(radio);
                    RadioButton butt = (RadioButton) radioGroup.getChildAt(position);
                    String  selection = (String) butt.getText();
                    Log.e("Selected", "" + selection);
                    ratingSelectionInterface.itemselect(attachementPOJOList.get(pos).getQuestionID(), attachementPOJOList.get(pos).getSurveyquestPOJOS().get(index).getAnswerID(), attachementPOJOList.get(pos).getSurveyAID(), attachementPOJOList.get(pos).getSurveyID(), selection);
                    Log.v("score", ratingSelectionInterface.toString());


                } catch (Exception e) {

                }
            }
        }
    }

    public interface RatingSelectionInterface {
        void itemselect( String questionID ,String answerID,String surveyAnswerID, String surveyID, String aswer);
        void itemUnSelect(int questionID);
    }

}
