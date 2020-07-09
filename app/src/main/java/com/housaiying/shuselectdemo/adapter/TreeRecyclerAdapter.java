package com.housaiying.shuselectdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.housaiying.shuselectdemo.R;
import com.multilevel.treelist.Node;

import java.util.List;

/**
 * Created by housaiying on 2020/1/6
 */
public class TreeRecyclerAdapter extends com.multilevel.treelist.TreeRecyclerAdapter {

    public TreeRecyclerAdapter(RecyclerView mTree, Context context, List<Node> datas, int defaultExpandLevel, int iconExpand, int iconNoExpand) {
        super(mTree, context, datas, defaultExpandLevel, iconExpand, iconNoExpand);
    }

    public TreeRecyclerAdapter(RecyclerView mTree, Context context, List<Node> datas, int defaultExpandLevel) {
        super(mTree, context, datas, defaultExpandLevel);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHoder(View.inflate(mContext, R.layout.tree_item, null));
    }

    @Override
    public void onBindViewHolder(final Node node, RecyclerView.ViewHolder holder, int position) {

        final MyHoder viewHolder = (MyHoder) holder;
        //todo do something
        viewHolder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChecked(node, viewHolder.cb.isChecked());
            }
        });

        if (node.isChecked()) {
            viewHolder.cb.setChecked(true);
        } else {
            viewHolder.cb.setChecked(false);
        }

        if (node.getIcon() == -1) {
            viewHolder.icon.setVisibility(View.INVISIBLE);
        } else {
            viewHolder.icon.setVisibility(View.VISIBLE);
            viewHolder.icon.setImageResource(node.getIcon());
        }

        viewHolder.label.setText(node.getName());


    }

    class MyHoder extends RecyclerView.ViewHolder {

        public CheckBox cb;

        public TextView label;

        public ImageView icon;

        public MyHoder(View itemView) {
            super(itemView);

            cb = itemView
                    .findViewById(R.id.cb_select_tree);
            label = itemView
                    .findViewById(R.id.id_treenode_label);
            icon = itemView.findViewById(R.id.icon);

        }

    }
}
