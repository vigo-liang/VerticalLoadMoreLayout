package com.stone.verticalslide.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stone.verticalslide.R;
import com.stone.verticalslide.vericalView.VericalFristRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * frist
 */
public class RecylerFristFragment extends Fragment {

    private VericalFristRecyclerView recyclerView;
    private List<String> stringList;
    private List<String> bottmString;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.verical_recylerview_frist_fragment, container, false);
        recyclerView = (VericalFristRecyclerView) view.findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        stringList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            stringList.add("this content is item" + i);
        }

        bottmString = new ArrayList<>();
        bottmString.add("下面有美女，查看更多");

        stringList.addAll(bottmString);

        recyclerView.setAdapter(new myAdapter());

    }


    class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.recyclerview_item_layout, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.mTextView.setText(stringList.get(position));
        }

        @Override
        public int getItemCount() {
            return stringList.size();
        }

        //自定义的ViewHolder，持有每个Item的的所有界面元素
        class ViewHolder extends RecyclerView.ViewHolder {

            public TextView mTextView;

            public ViewHolder(View view) {
                super(view);
                mTextView = (TextView) view.findViewById(R.id.recylerView_text);
            }
        }
    }


}
