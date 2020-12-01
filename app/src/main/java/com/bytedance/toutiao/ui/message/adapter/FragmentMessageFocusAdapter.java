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
import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.databinding.ItemMessageFocusBinding;
import com.bytedance.toutiao.utils.ToastUtils;

import java.util.List;

public class FragmentMessageFocusAdapter extends RecyclerView.Adapter<FragmentMessageFocusAdapter.ViewHolder> {
    private Context context;
    private List<MessageCommentModel> msgFocusList;

    public FragmentMessageFocusAdapter(Context context, List<MessageCommentModel> msgFocusList) {
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
        final ItemMessageFocusBinding binding = (ItemMessageFocusBinding) holder.getBinding();
        binding.tvName.setText(msgFocusList.get(position).getMsgCommentName());
        binding.tvReadNum.setText(msgFocusList.get(position).getNum());
        binding.btnFocus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //if(listener.showToLoginFragment()){
                if (binding.btnFocus.getText().toString().indexOf("已关注") != -1 ){
                    binding.btnFocus.setText("关注");
                    binding.btnFocus.setTextColor(context.getResources().getColor(R.color.colorAccent));
                    binding.btnFocus.setBackgroundResource(R.mipmap.btn_all_blue);
                    ToastUtils.showToast("已取消关注");
                }else if (binding.btnFocus.getText().toString().indexOf("关注") != -1){
                    binding.btnFocus.setText("已关注");
                    binding.btnFocus.setTextColor(0xcc000000);
                    binding.btnFocus.setBackgroundResource(R.mipmap.btn_grey);
                    ToastUtils.showToast("关注成功");
                }

                //}
            }
        });
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
