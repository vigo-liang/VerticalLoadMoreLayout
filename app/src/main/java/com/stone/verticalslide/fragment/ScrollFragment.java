package com.stone.verticalslide.fragment;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stone.verticalslide.R;

public class ScrollFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.vertical_scrollview_fragment, null);
		TextView oldTextView = (TextView) rootView
				.findViewById(R.id.old_textview);
		oldTextView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		return rootView;
	}
}
