package com.example.daobunso.member;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.daobunso.R;

public class memberFragment extends Fragment {
    private Activity activity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity.setTitle("Member Management");
        return inflater.inflate(R.layout.fragment_member, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.cbShowPassword).setOnClickListener(v->{
            EditText psw = view.findViewById(R.id.editTextTextPassword);
            CheckBox checkBox = view.findViewById(R.id.cbShowPassword);
            if(checkBox.isChecked()) {
                psw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }else{
                psw.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });
        view.findViewById(R.id.tvModifyPassword).setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_memberFragment_to_changePasswordFragment);
        });


        //右上角，回購物車
        view.findViewById(R.id.imgshoppingcart_changePwd).setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_memberFragment_to_serviceFragment);
        });

        //右上角，回首頁
        view.findViewById(R.id.imgHome_changePwd).setOnClickListener(v2 -> {
            Navigation.findNavController(v2).popBackStack(R.id.indexFragment, false);
        });
    }
}