package com.example.daobunso.member;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.SharedPreferences;
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
    private EditText psw;
    private EditText act;
    private final static String PREFERENCES_NAME = "preferences";
    private final static String DEFAULT_ACCOUNT = "";
    private final static String DEFAULT_PASSWORD = "";
    private SharedPreferences preferences;
    private String RememberAccount;
    private String RememberPassword;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_member, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        psw = view.findViewById(R.id.editTextTextPassword);
        act = view.findViewById(R.id.textMemberAccount);

        //從preference檔裡抓出account、password
        preferences = activity.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        RememberAccount = preferences.getString("accountInfo", DEFAULT_ACCOUNT);
        RememberPassword = preferences.getString("passwordInfo", DEFAULT_PASSWORD);

        psw.setText(RememberPassword);
        act.setText(RememberAccount);

        view.findViewById(R.id.cbShowPassword).setOnClickListener(v->{

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