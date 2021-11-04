package com.example.daobunso;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daobunso.member.MemberBean;
import com.example.daobunso.network.RemoteAccess;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class createAccountFragment extends Fragment {

    private Activity activity;
    String newAccount;
    String newEmail;
    String newPassword;
    String passwordAgain;
    String UserName;
    Bundle bundle;
    MemberBean memberbean;
    private SharedPreferences preferences;
    private final static String PREFERENCES_NAME = "preferences";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bundle = new Bundle(); // Bundle用來把本頁資料傳到下一頁去

        //findViewById
        EditText tvUserName = view.findViewById(R.id.tvUserName);
        EditText etInsertAccount = view.findViewById(R.id.etInsertAccount);
        EditText etEmail = view.findViewById(R.id.etEmail);
        EditText etInsertPassword = view.findViewById(R.id.etInsertPassword);
        EditText etPasswordAgain = view.findViewById(R.id.etPasswordAgain);


        // 點選 create 按鈕
        view.findViewById(R.id.createAccountBtn).setOnClickListener(v -> {

            // 擷取使用者輸入的值
            newAccount = etInsertAccount.getText().toString().trim();
            newEmail = etEmail.getText().toString().trim();
            newPassword = etInsertPassword.getText().toString().trim();
            passwordAgain = etPasswordAgain.getText().toString().trim();
            UserName = tvUserName.getText().toString().trim();


            // 判斷使用者是否有輸入值
            if (UserName.isEmpty()) {
                tvUserName.setError(" NAME is empty ");
                return;
            }
            if (newAccount.isEmpty()) {
                etInsertAccount.setError("ACCOUNT is empty");
                return;
            }
            if (newEmail.isEmpty()) {
                etEmail.setError("EMAIL is empty ");
                return;
            }
            if (newPassword.isEmpty()) {
                etInsertPassword.setError("PASSWORD is empty ");
                return;
            }
            if (passwordAgain.isEmpty()) {
                etPasswordAgain.setError("PASSWORD AGAIN is empty ");
                return;
            }

            if (!passwordAgain.equals(newPassword)) {
                etPasswordAgain.setError("輸入的密碼不一致");
                return;
            }

            //email格式檢查
                if (CheckEmail.checkEmail(newEmail)) // 驗證郵箱格式
                {
                    if(CheckPassword.CheckPassword(newPassword)){  // 驗證密碼格式
                        //如果都有輸入、且email、password格式正確，就執行createAccount()
                        createAccount(view);
                    }
                    else{
                        Toast.makeText(activity, "密碼欄位長度不能小於八個字元，且必須由大寫字母、小寫字母、數字與 !@#$%!^'組成\"", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }
                else
                {
                    Toast.makeText(activity, "email格式不正確", Toast.LENGTH_SHORT).show();
                    return;
                }




        });

    }

    private void createAccount(View view) {
        String url = "http://10.0.2.2:8080/Daobunso_Project/RegisterServletApp";

        if (RemoteAccess.networkConnected(activity)) {

            memberbean = new MemberBean(null, newAccount, newEmail, newPassword, UserName, null);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("action", "memberInsert");
            jsonObject.addProperty("memberBean", new Gson().toJson(memberbean));

//            int count;
              RemoteAccess.getRemoteData(url, jsonObject.toString());
//            count = Integer.parseInt(result);
//            if (count == 0) {
//                Toast.makeText(activity, R.string.textInsertFail, Toast.LENGTH_SHORT).show(); //帳號新增失敗
//            } else {
//                Toast.makeText(activity, R.string.textInsertSuccess, Toast.LENGTH_SHORT).show(); // 帳號新增成功
//            }
        }
        else {
            Toast.makeText(activity, R.string.textNoNetwork, Toast.LENGTH_SHORT).show();
        }

        // 先跳出通知方框，再跳轉到主頁面
        bundle.putString("newPassword", newPassword);
        bundle.putString("newAccount", newAccount);
        bundle.putString("newEmail", newEmail);
        bundle.putString("UserName", UserName);

        //註冊成功，順便把account資訊記載到preference檔案裡，以便之後頁面撈取
        preferences = activity.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        savePreferenceOnlyAccount();


        new AlertDialog.Builder(activity) //內部類別，new後得到Builder物件
                // 設定標題
                .setTitle(R.string.textTitle)
                // 設定圖示
                .setIcon(R.drawable.logo)
                // 設定訊息文字
                .setMessage(R.string.textMessage)
                // 設定positive與negative按鈕上面的文字與點擊事件監聽器
                .setPositiveButton(R.string.textYes, (dialog, which) -> Navigation.findNavController(view).navigate(R.id.action_createAccountFragment_to_indexFragment, bundle)) // 結束此Activity頁面
                .setCancelable(false) // 必須點擊按鈕方能關閉，預設為true
                .show();


    }


    private void savePreferenceOnlyAccount() {

        preferences.edit()
                .putString("accountInfo", newAccount)
                .apply();
    }
}

