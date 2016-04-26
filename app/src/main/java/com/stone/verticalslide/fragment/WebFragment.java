package com.stone.verticalslide.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stone.verticalslide.vericalView.VericalWebView;
import com.stone.verticalslide.R;

public class WebFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.vertical_webview_fragment, null);
        VericalWebView webview = (VericalWebView) rootView.findViewById(R.id.fragment3_webview);
        webview.loadUrl("http://m.zol.com/tuan/");
        return rootView;
    }

}
