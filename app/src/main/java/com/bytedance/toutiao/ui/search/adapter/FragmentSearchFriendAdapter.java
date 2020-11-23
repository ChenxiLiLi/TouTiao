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
import com.bytedance.toutiao.bean.SearchFriendModel;
import com.bytedance.toutiao.databinding.ItemSearchFriendBinding;
import com.bytedance.toutiao.ui.search.fragment.FragmentSearchFriend;

import java.util.List;

public class FragmentSearchFriendAdapter extends RecyclerView.Adapter<FragmentSearchFriendAdapter.ViewHolder> {
    private Context context;
    private List<SearchFriendModel> searchFriendList;

    public FragmentSearchFriendAdapter(Context context, List<SearchFriendModel> searchFriendList) {
        this.context = context;
        this.searchFriendList = searchFriendList;
    }

    @NonNull
    @Override
    public FragmentSearchFriendAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_search_friend, parent, false);
        FragmentSearchFriendAdapter.ViewHolder myHolder = new FragmentSearchFriendAdapter.ViewHolder(binding.getRoot());
        myHolder.setBinding(binding);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentSearchFriendAdapter.ViewHolder holder, int position) {
        ItemSearchFriendBinding binding = (ItemSearchFriendBinding) holder.getBinding();
        binding.itemTitle.setText(searchFriendList.get(position).getEventTitle());
        binding.itemRead.setText(searchFriendList.get(position).getEventReadNum());
        binding.itemRanking.setText(searchFriendList.get(position).getEventFriendRanking());
    }

    @Override
    public int getItemCount() {
        return searchFriendList.size();
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
