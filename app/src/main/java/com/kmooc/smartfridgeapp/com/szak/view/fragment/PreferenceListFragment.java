package com.kmooc.smartfridgeapp.com.szak.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.kmooc.smartfridgeapp.R;
import com.kmooc.smartfridgeapp.com.szak.util.FragmentNames;

public class PreferenceListFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.settings_fragment, container, false);
        setListeners();

        return view;
    }

    private void setListeners() {
        ListView lstVwPreferencesList = view.findViewById(R.id.lstVwPreferencesList);
    }
}
