package com.bytedance.toutiao.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.CommonViewHolder> {

    protected Context mContext;
    //所有 item 的数据集合
    protected List mDatas;
    //item 布局文件 id
    protected int mLayoutId;
    protected LayoutInflater mInflater;
    // mvvm绑定的viewModel引用
    private int mVariableId;

    public CommonAdapter(Context mContext, List mDatas, int mLayoutId, int mVariableId) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        this.mLayoutId = mLayoutId;
        mInflater = LayoutInflater.from(mContext);
        this.mVariableId = mVariableId;
    }

    @NonNull
    @Override
    public CommonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), mLayoutId, parent, false);
        CommonViewHolder myHolder = new CommonViewHolder(binding.getRoot());
        myHolder.setBinding(binding);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommonViewHolder holder, int position) {
        holder.binding.setVariable(mVariableId,mDatas.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return null == mDatas ? 0 : mDatas.size();
    }

    class CommonViewHolder extends RecyclerView.ViewHolder{

        ViewDataBinding binding;

        public CommonViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ViewDataBinding getBinding(){
            return binding;
        }

        public void setBinding(ViewDataBinding binding){
            this.binding = binding;
        }

    }

}
