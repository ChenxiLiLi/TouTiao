package com.bytedance.toutiao.ui.message.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.MsgFocusModel;
import com.bytedance.toutiao.databinding.ItemMessageFocusBinding;

import java.util.List;

public class FragmentMessageFocusAdapter extends RecyclerView.Adapter<FragmentMessageFocusAdapter.ViewHolder> {
    private Context context;
    private List<MsgFocusModel> msgFocusList;

    public FragmentMessageFocusAdapter(Context context, List<MsgFocusModel> msgFocusList) {
        this.context = context;
        this.msgFocusList = msgFocusList;
    }

    @NonNull
    @Override
    public FragmentMessageFocusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_message_focus, parent, false);
        FragmentMessageFocusAdapter.ViewHolder myHolder = new FragmentMessageFocusAdapter.ViewHolder(binding.getRoot());
        myHolder.setBinding(binding);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentMessageFocusAdapter.ViewHolder holder, int position) {
        ItemMessageFocusBinding binding = (ItemMessageFocusBinding) holder.getBinding();
        binding.tvName.setText(msgFocusList.get(position).getMsgFocusEventName());
        binding.tvReadNum.setText(msgFocusList.get(position).getMsgFocusReadNum());
    }

    @Override
    public int getItemCount() {
        return msgFocusList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;
        public ViewDataBinding getBinding(){
            return binding;
        }

        public void setBinding(ViewDataBinding binding){
            this.binding = binding;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
