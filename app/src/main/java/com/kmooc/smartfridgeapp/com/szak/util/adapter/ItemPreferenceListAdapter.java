package com.kmooc.smartfridgeapp.com.szak.util.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.kmooc.smartfridgeapp.R;
import com.kmooc.smartfridgeapp.com.szak.model.ItemPreference;

import java.util.ArrayList;

public class ItemPreferenceListAdapter extends ArrayAdapter<ItemPreference> implements View.OnClickListener {
    public boolean editable = false;
    public ItemPreferenceListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    private ArrayList<ItemPreference> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtProductNamePreferenceList;
        TextView txtProductAssociatedFridgeNamePreferenceList;
        TextView txtProductOperatorAndValueStringPreferenceList;
        ImageView imgListItemPreferenceList;
    }

    public ItemPreferenceListAdapter(ArrayList<ItemPreference> data, Context context) {
        super(context, R.layout.anim_list_preference_item, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        ItemPreference dataModel=(ItemPreference) object;

        if (editable) {
            // TODO open new fragment where the preferenceItem is the one clicked here
        }
    }


    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ItemPreference itemPreference = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.anim_list_preference_item, parent, false);
            viewHolder.txtProductNamePreferenceList = (TextView) convertView.findViewById(R.id.txtProductNamePreferenceList);
            viewHolder.txtProductAssociatedFridgeNamePreferenceList = (TextView) convertView.findViewById(R.id.txtProductAssociatedFridgeNamePreferenceList);
            viewHolder.txtProductOperatorAndValueStringPreferenceList = (TextView) convertView.findViewById(R.id.txtProductOperatorAndValueStringPreferenceList);
            viewHolder.imgListItemPreferenceList = (ImageView) convertView.findViewById(R.id.imgListItemPreferenceList);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.from_bottom_to_up_anim : R.anim.from_top_to_bottom_anim);
        result.startAnimation(animation);
        lastPosition = position;

        //viewHolder.txtProductNamePreferenceList.setText();
        //viewHolder.txtProductAssociatedFridgeNamePreferenceList.setText(dataModel.getType());
        //viewHolder.txtProductOperatorAndValueStringPreferenceList.setText(dataModel.getVersion_number());
        //viewHolder.imgListItemPreferenceList.setOnClickListener(this);
        //viewHolder.imgListItemPreferenceList.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
