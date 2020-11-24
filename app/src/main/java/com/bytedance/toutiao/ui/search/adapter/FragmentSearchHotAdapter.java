package com.bytedance.toutiao.ui.search.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.SearchHotModel;
import com.bytedance.toutiao.databinding.ItemSearchHotBinding;

import java.util.ArrayList;
import java.util.List;

public class FragmentSearchHotAdapter extends RecyclerView.Adapter<FragmentSearchHotAdapter.ViewHolder> {
    private Context context;
    private List<SearchHotModel> searchHotList;

    public FragmentSearchHotAdapter(Context context, List<SearchHotModel> searchHotList) {
        this.context = context;
        this.searchHotList = searchHotList;
    }

    @NonNull
    @Override
    public FragmentSearchHotAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_search_hot, parent, false);
        FragmentSearchHotAdapter.ViewHolder myHolder = new FragmentSearchHotAdapter.ViewHolder(binding.getRoot());
        myHolder.setBinding(binding);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentSearchHotAdapter.ViewHolder holder, int position) {
        ItemSearchHotBinding binding = (ItemSearchHotBinding) holder.getBinding();
        binding.itemTitle.setText(searchHotList.get(position).getEventTitle());
        binding.itemRead.setText(searchHotList.get(position).getEventReadNum());
        binding.itemRanking.setText(searchHotList.get(position).getEventHotRanking());
    }

    @Override
    public int getItemCount() {
        return searchHotList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        ViewDataBinding binding;
        public ViewDataBinding getBinding(){
            return binding;
        }

        public void setBinding(ViewDataBinding binding){
            this.binding = binding;
        }
    }
}
