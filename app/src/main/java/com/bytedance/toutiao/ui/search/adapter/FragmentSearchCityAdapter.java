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
import com.bytedance.toutiao.bean.SearchCityModel;
import com.bytedance.toutiao.databinding.ItemSearchCityBinding;
import com.bytedance.toutiao.ui.search.fragment.FragmentSearchCity;

import java.util.List;

public class FragmentSearchCityAdapter extends RecyclerView.Adapter<FragmentSearchCityAdapter.ViewHolder> {
    private Context context;
    private List<SearchCityModel> searchCityList;

    public FragmentSearchCityAdapter(Context context, List<SearchCityModel> searchCityList) {
        this.context = context;
        this.searchCityList = searchCityList;
    }

    @NonNull
    @Override
    public FragmentSearchCityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_search_city, parent, false);
        FragmentSearchCityAdapter.ViewHolder myHolder = new FragmentSearchCityAdapter.ViewHolder(binding.getRoot());
        myHolder.setBinding(binding);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentSearchCityAdapter.ViewHolder holder, int position) {
        ItemSearchCityBinding binding = (ItemSearchCityBinding) holder.getBinding();
        binding.itemTitle.setText(searchCityList.get(position).getEventTitle());
        binding.itemRead.setText(searchCityList.get(position).getEventReadNum());
        binding.itemRanking.setText(searchCityList.get(position).getEventCityRanking());
    }

    @Override
    public int getItemCount() {
        return searchCityList.size();
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
