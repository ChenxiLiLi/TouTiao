package com.bytedance.toutiao.ui.message.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.MessageChatModel;
import com.bytedance.toutiao.ui.message.adapter.MessageChatAdapt;
import com.bytedance.toutiao.ui.person.AuthorActivity;

import java.util.ArrayList;
import java.util.List;

public class MessageChatActivity extends AppCompatActivity {

    private List<MessageChatModel> msgList = new ArrayList<>();
    @SuppressLint("WrongViewCast")
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MessageChatAdapt adapter;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_chat);
        inputText = (EditText) findViewById(R.id.message_input);
        send = (Button) findViewById(R.id.message_sent_btn);
        msgRecyclerView = (RecyclerView)findViewById(R.id.message_item);
        initMsgs();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MessageChatAdapt(msgList,this);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                //判断输入框内容非空
                if (!"".equals(content)){
                    MessageChatModel msg = new MessageChatModel(content,MessageChatModel.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);//当有新消息时，刷新listView中的显示
                    msgRecyclerView.scrollToPosition(msgList.size()-1);//将LIstView定位到最后一行
                    inputText.setText("");//清空输入框中的内容
                }
            }
        });
        ImageView view = (ImageView) findViewById(R.id.back);
        view.setOnClickListener(new View.OnClickListener() {
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
