package com.example.daobunso.member;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
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

import com.example.daobunso.CheckPassword;
import com.example.daobunso.R;
import com.example.daobunso.network.RemoteAccess;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class ChangePasswordFragment extends Fragment {
    private Activity activity;
    private String oldpw;
    private String newsw;
    private EditText oldpsw;
    private EditText newpsw;
    private SharedPreferences preferences;
    private final static String PREFERENCES_NAME = "preferences";
    private String RememberAccount;
    private String RememberPassword;
    private final static String DEFAULT_ACCOUNT = "";
    private final static String DEFAULT_PASSWORD = "";


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

        oldpsw = view.findViewById(R.id.etPassword);
        newpsw = view.findViewById(R.id.etNewPassword);

        //從preference檔案裡取出登入時入的password
        preferences = activity.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        RememberAccount = preferences.getString("accountInfo", DEFAULT_ACCOUNT);
        RememberPassword = preferences.getString("passwordInfo", DEFAULT_PASSWORD);

        oldpsw.setText(RememberPassword);

        // 隱藏密碼
        view.findViewById(R.id.cbShowPassword_ChangePwdPage).setOnClickListener(view1 -> {

            CheckBox checkBox = view.findViewById(R.id.cbShowPassword_ChangePwdPage);
            if(checkBox.isChecked()) {
                oldpsw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                newpsw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }else{
                oldpsw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                newpsw.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });

        //回首頁
        view.findViewById(R.id.imgHome_changePwd).setOnClickListener(v2 -> {
            Navigation.findNavController(v2).popBackStack(R.id.indexFragment, false);
        });

        //點選更改密碼按鈕，先確認有輸入值
        TextView btnConfirmChangePwd = view.findViewById(R.id.btnbtnConfirmChangePassword);
        btnConfirmChangePwd.setOnClickListener(v3 ->{
            newsw = newpsw.getText().toString().trim();
            if (newsw.isEmpty()) {
                newpsw.setError(" 未填入新密碼 ");
                return;
            }

            if(CheckPassword.CheckPassword(newsw)){  // 驗證密碼格式

                //如果password格式正確，就跳出確認要更改密碼的小視窗
                new AlertDialog.Builder(activity).setTitle("Change Password")
                        .setIcon(R.drawable.logo1)
                        .setMessage("確定更改密碼?")
                        .setPositiveButton("Yes", (dialog, which) -> changePw(view)) //連到資料庫修改密碼
                        .setNegativeButton("No", (dialog, which) -> dialog.cancel())
                        .setCancelable(false)
                        .show();
            }
            else{
                Toast.makeText(activity, "密碼欄位長度不能小於八個字元，且必須由大寫字母、小寫字母、數字與 !@#$%!^'組成\"", Toast.LENGTH_SHORT).show();
                return;
            }

        });
    }

    private void changePw(View view) {

        String url = "http://10.0.2.2:8080/app/changPw";

        if (RemoteAccess.networkConnected(activity)) {

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("password", newsw);
            jsonObject.addProperty("account", RememberAccount);

            String result = RemoteAccess.getRemoteData(url, jsonObject.toString()); //與後端連線，更改密碼

            Gson gson = new Gson();
            String response = gson.fromJson(result, String.class);

            //更改密碼成功 --> 跳出小視窗，提醒user將跳轉回首頁
            if(response.equals("更改密碼成功")){
                new AlertDialog.Builder(activity).setTitle("Change Password")
                        .setIcon(R.drawable.logo1)
                        .setMessage("更改密碼成功，將回到首頁")
                        .setPositiveButton("Yes", (dialog, which) -> Navigation.findNavController(view).popBackStack(R.id.indexFragment, false)) //跳轉至首頁
                        .setNegativeButton("No", (dialog, which) -> dialog.cancel())
                        .setCancelable(false)
                        .show();

            }
            else{
                Toast.makeText(activity,"更改密碼失敗", Toast.LENGTH_SHORT).show();
            }

        }
        else {
            Toast.makeText(activity, R.string.textNoNetwork, Toast.LENGTH_SHORT).show();
        }
    }
}