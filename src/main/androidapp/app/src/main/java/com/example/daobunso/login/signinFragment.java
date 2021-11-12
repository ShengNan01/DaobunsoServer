package com.example.daobunso.login;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daobunso.R;
import com.example.daobunso.member.MemberBean;
import com.example.daobunso.network.RemoteAccess;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;


public class signinFragment extends Fragment {

    private Activity activity; //　取得本Fragment所依從的Activity(不是繼承關係!)
    private LoginBean loginbean;
    private Bundle bundle;
    private String account;
    private String password;
    private InfoBeanApp infoBeanApp;
    private EditText etAccount;
    private EditText etPassword;
    private CheckBox checkBoxRememberme;
    private final static String PREFERENCES_NAME = "preferences";
    private final static String DEFAULT_ACCOUNT = "";
    private final static String DEFAULT_PASSWORD = "";
    private SharedPreferences preferences;
    private String RememberAccount;
    private String RememberPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity(); //取得本Fragment所依從的Activity(不是繼承關係!)

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //findViewById (帳號/密碼)
        etAccount = view.findViewById(R.id.etAccount);
        etPassword = view.findViewById(R.id.etPassword);
        checkBoxRememberme = view.findViewById(R.id.checkBoxRememberme);

        // 如果preferences檔有紀錄帳密。就顯示該組帳密
        preferences = activity.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        RememberAccount = preferences.getString("account", DEFAULT_ACCOUNT);
        RememberPassword = preferences.getString("password", DEFAULT_PASSWORD);
        if(!RememberAccount.equals(DEFAULT_ACCOUNT)&&!RememberPassword.equals(DEFAULT_PASSWORD)){
            etAccount.setText(RememberAccount);
            etPassword.setText(RememberPassword);
        }

        // 點選 login 按鈕
        // 撈出使用者輸入的帳密
        view.findViewById(R.id.tvLogin).setOnClickListener(v -> {

            account = etAccount.getText().toString().trim();
            password = etPassword.getText().toString().trim();


            //判斷使用者是否有輸入值
            if (account.isEmpty()) {
                etAccount.setError("ACCOUNT is empty");
            }
            if (password.isEmpty()) {
                etPassword.setError("PASSWORD is empty");
                return;
            }

            //都有值的話，執行login方法
            login(view);

        });

        // 點選 建立帳號 連結
        view.findViewById(R.id.tvCreateAccount).setOnClickListener(v -> {
            bundle = new Bundle(); // Bundle用來把本頁資料傳到下一頁去
            Navigation.findNavController(view).navigate(R.id.action_signinFragment_to_createAccountFragment, bundle);
        });

        //點選 忘記密碼 連結
        view.findViewById(R.id.tvForgetPW).setOnClickListener(v -> {
            bundle = new Bundle(); // Bundle用來把本頁資料傳到下一頁去
            Navigation.findNavController(view).navigate(R.id.action_signinFragment_to_forgetPwFragment, bundle);
        });
    }

    private void login(View view) {
        String url = "http://10.0.2.2:8080/app/logincheck";

        if (RemoteAccess.networkConnected(activity)) {

//            loginbean = new LoginBean(account,password);
            JsonObject jsonObject = new JsonObject();
//            jsonObject.addProperty("loginBean", new Gson().toJson(loginbean));
            jsonObject.addProperty("account",account);
            jsonObject.addProperty("password",password);

            String result = RemoteAccess.getRemoteData(url, jsonObject.toString()); //與後端連線
            Log.v("ResponsefromServer:",result);


            if(result.equals("OK")){
                savePreferenceOnlyAccountPw(); //只要有登入成功，就先把acount記錄在prefernce檔裡，方便之後的頁面撈取。
                if(checkBoxRememberme.isChecked()){ // 如果使用者有勾選記住我，就把值記錄在preferences檔裡。
                    if(!RememberAccount.equals(DEFAULT_ACCOUNT)||!RememberPassword.equals(DEFAULT_PASSWORD)){
                        etAccount.setText(DEFAULT_ACCOUNT);
                        etPassword.setText(DEFAULT_PASSWORD);  //如果preferences檔裡有值，就先把值清掉，等等才能紀錄新值
                    }
                    preferences = activity.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
                    savePreferences();
                }
                bundle = new Bundle(); // Bundle用來把本頁資料傳到下一頁去
//                // 確認登入帳密正確，正確的話把帳密加入bundle
//                bundle.putString("account", account);
//                bundle.putString("password", password);
                Navigation.findNavController(view).navigate(R.id.action_signinFragment_to_indexFragment, bundle);
            }
            else{
                etAccount.setError("帳號或密碼輸入錯誤");
                etPassword.setError("帳號或密碼輸入錯誤");
            }
        }
        else {
            Toast.makeText(activity, R.string.textNoNetwork, Toast.LENGTH_SHORT).show();
        }
    }

    private void savePreferences() {

        preferences.edit()
                .putString("account", account)
                .putString("password", password)
                .apply();
    }

    private void savePreferenceOnlyAccountPw() {

        preferences.edit()
                .putString("accountInfo", account)
                .putString("passwordInfo", password)
                .apply();
    }



}