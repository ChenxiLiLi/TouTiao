package com.bytedance.toutiao.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.ui.login.LoginActivity;

public class ToLoginfragment extends BaseBottomSheetDialog {

    private View view;
    private Button toLogin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_to_login, container);
        toLogin = view.findViewById(R.id.btn_to_login);
        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toLogin = new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(toLogin);
            }
        });
        return view;
    }
}
