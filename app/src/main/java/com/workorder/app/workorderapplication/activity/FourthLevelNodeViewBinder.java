package com.workorder.app.workorderapplication.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.workorder.app.R;
import com.workorder.app.workorderapplication.treeview.TreeNode;
import com.workorder.app.workorderapplication.treeview.base.CheckableNodeViewBinder;

import java.io.InputStream;

/**
 * Created by Bharat Tripathi on 24-May-18.
 */

public class FourthLevelNodeViewBinder extends CheckableNodeViewBinder {
    TextView textView;
    ImageView imageView;

    public FourthLevelNodeViewBinder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.node_name_view);
       imageView = (ImageView) itemView.findViewById(R.id.arrow_img);
    }

    @Override
    public int getCheckableViewId() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_fourth_level;
    }

    @Override
    public void bindView(final TreeNode treeNode) {
        String treeText=treeNode.getValue().toString();
        Log.d("Treetext",treeText);
        String[] parts=treeText.split("\t");
        String parts1=parts[0];

            //String parts2=parts[1];
            textView.setText(parts1);
            imageView.setRotation(treeNode.isExpanded() ? 90 : 0);

           if (parts.length>1) {
               image(parts[1]);
           }



    }
    private void image(String image)
    {
        new DownloadImageTask((ImageView) itemView.findViewById(R.id.image))
                .execute(image);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    @Override
    public void onNodeToggled(TreeNode treeNode, boolean expand) {
        if (expand) {
            imageView.animate().rotation(90).setDuration(200).start();
        } else {
            imageView.animate().rotation(0).setDuration(200).start();
        }
    }
}
