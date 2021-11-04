package com.example.daobunso.member;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.daobunso.R;


public class ChangePasswordFragment extends Fragment {
    private Activity activity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
        return inflater.inflate(R.layout.fragment_change_password, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity.setTitle("Change Password Page");
        view.findViewById(R.id.cbShowPassword_ChangePwdPage).setOnClickListener(view1 -> {
            EditText oldpsw = view.findViewById(R.id.etPassword);
            EditText newpsw = view.findViewById(R.id.etNewPassword);
            CheckBox checkBox = view.findViewById(R.id.cbShowPassword_ChangePwdPage);
            if(checkBox.isChecked()) {
                oldpsw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                newpsw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }else{
                oldpsw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                newpsw.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });
        view.findViewById(R.id.imgHome_changePwd).setOnClickListener(v2 -> {
            Navigation.findNavController(v2).popBackStack(R.id.indexFragment, false);
        });
        TextView btnConfirmChangePwd = view.findViewById(R.id.btnbtnConfirmChangePassword);
        btnConfirmChangePwd.setOnClickListener(v3 ->{
            new AlertDialog.Builder(activity).setTitle("Change Password")
                    .setIcon(R.drawable.logo1)
                    .setMessage("Are you sure you want to change the  password?")
                    .setPositiveButton("Yes", (dialog, which) -> Navigation.findNavController(view)
                            .popBackStack(R.id.indexFragment, false)) //連到資料庫修改密碼
                    .setNegativeButton("No", (dialog, which) -> dialog.cancel())
                    .setCancelable(false)
                    .show();
//            Toast.makeText(activity, "Password Changed!",Toast.LENGTH_SHORT).show()
        });


    }
}