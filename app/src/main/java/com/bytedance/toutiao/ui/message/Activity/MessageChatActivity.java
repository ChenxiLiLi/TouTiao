package com.bytedance.toutiao.ui.message.Activity;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.View;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.bean.MessageChatModel;
import com.bytedance.toutiao.databinding.ActivityMessageChatBinding;
import com.bytedance.toutiao.ui.message.adapter.MessageChatAdapt;
import com.bytedance.toutiao.viewmodel.MessageCommentViewModel;

import java.util.ArrayList;
import java.util.List;

public class MessageChatActivity extends BaseActivity<MessageCommentViewModel, ActivityMessageChatBinding> {
    private Context context;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private List<MessageChatModel> msgList = new ArrayList<>();
    private MessageChatAdapt messageChatAdapt;
    private String name;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_message_chat;
    }

    @Override
    protected void processLogic() {
        initMsgs();
        name = getIntent().getStringExtra("title");
        recyclerView = findViewById(R.id.message_item);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        messageChatAdapt = new MessageChatAdapt(msgList,this,name);
        recyclerView.setAdapter(messageChatAdapt);
        mViewModel = ViewModelProviders.of(this).get(MessageCommentViewModel.class);
        binding.title.setText(name);

    }

    @Override
    protected void setListener() {
        binding.messageSentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = binding.messageInput.getText().toString();
                //判断输入框内容非空
                if (!"".equals(content)){
                    MessageChatModel msg = new MessageChatModel(content,MessageChatModel.TYPE_SENT);
                    msgList.add(msg);
                    messageChatAdapt.notifyItemInserted(msgList.size()-1);//当有新消息时，刷新listView中的显示
                    recyclerView.scrollToPosition(msgList.size()-1);//将LIstView定位到最后一行
                    binding.messageInput.setText("");//清空输入框中的内容
                }
            }
        });
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void initMsgs() {
        MessageChatModel msg1 = new MessageChatModel("Hello，我的第一条信息",MessageChatModel.TYPE_RECEIVED);
        msgList.add(msg1);
        MessageChatModel msg2 = new MessageChatModel("Hi，我的第二条信息",MessageChatModel.TYPE_SENT);
        msgList.add(msg2);
        MessageChatModel msg3 = new MessageChatModel("看来你没什么事，再见",MessageChatModel.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
