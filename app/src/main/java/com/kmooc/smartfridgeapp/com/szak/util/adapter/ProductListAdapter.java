package com.kmooc.smartfridgeapp.com.szak.util.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.kmooc.smartfridgeapp.R;
import com.kmooc.smartfridgeapp.com.szak.model.Product;

import java.util.ArrayList;

public class ProductListAdapter extends ArrayAdapter<Product> implements View.OnClickListener {
    public boolean editable = false;
    public ProductListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    private ArrayList<Product> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtProductNameProductList, txtProductMeasurementUnitProductList, txtCaloriesPerUnitProductList, txtProductCategoryProductList;
        Button btnGetProductdescriptionProductList;
        ImageView imgProductProductList;
    }

    public ProductListAdapter(ArrayList<Product> data, Context context) {
        super(context, R.layout.anim_list_preference_item, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Product dataModel=(Product) object;

        if (editable) {
            // TODO open new fragment where the preferenceItem is the one clicked here
        }
    }


    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Product product = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.anim_list_preference_item, parent, false);
            viewHolder.txtProductNameProductList = (TextView) convertView.findViewById(R.id.txtProductNameProductList);
            viewHolder.txtProductMeasurementUnitProductList = (TextView) convertView.findViewById(R.id.txtProductMeasurementUnitProductList);
            viewHolder.txtCaloriesPerUnitProductList = (TextView) convertView.findViewById(R.id.txtCaloriesPerUnitProductList);
            viewHolder.txtProductCategoryProductList = convertView.findViewById(R.id.txtProductCategoryProductList);
            viewHolder.btnGetProductdescriptionProductList = convertView.findViewById(R.id.btnGetProductdescriptionProductList);
            viewHolder.imgProductProductList = (ImageView) convertView.findViewById(R.id.imgProductProductList);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.from_bottom_to_up_anim : R.anim.from_top_to_bottom_anim);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtProductNameProductList.setText(product.getName());
        viewHolder.txtProductMeasurementUnitProductList.setText(product.getUnit());
        viewHolder.txtCaloriesPerUnitProductList.setText(product.getCalories());
        viewHolder.txtProductCategoryProductList.setText(product.getCategory());
        // TODO continue here
        //viewHolder.imgListItemPreferenceList.setOnClickListener(this);
        //viewHolder.imgListItemPreferenceList.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
