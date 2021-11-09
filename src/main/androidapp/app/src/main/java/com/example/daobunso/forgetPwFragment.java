package com.example.daobunso;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daobunso.network.RemoteAccess;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class forgetPwFragment extends Fragment {

    private Activity activity;
    private EditText etAC;
    private EditText etmail;

    private String AC;
    private String email;
    private Bundle bundle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_forget_pw, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        etAC = view.findViewById(R.id.etAC);
        etmail = view.findViewById(R.id.etmail);


        view.findViewById(R.id.emailbutton).setOnClickListener(v -> {

            AC = etAC.getText().toString().trim();
            email = etmail.getText().toString().trim();


            //判斷使用者是否有輸入值
            if (AC.isEmpty()) {
                etAC.setError("ACCOUNT is empty");
            }
            if (email.isEmpty()) {
                etmail.setError("EMAIL is empty");
                return;
            }

            Log.v("帳號email:",AC+" / "+email);
            //都有值的話，執行checkPwEmail方法
            checkPwEmail();


        });

    }

    private void checkPwEmail() {
        Log.v("帳號email:",AC+" / "+email);
        String url = "http://10.0.2.2:8080/app/forgetPw";

        if (RemoteAccess.networkConnected(activity)) {

            JsonObject jsonObject = new JsonObject();
//            jsonObject.addProperty("account",AC);
//            jsonObject.addProperty("email",email);

            String result = RemoteAccess.getRemoteData(url, jsonObject.toString()); //與後端連線

            Gson gson = new Gson();
            String response = gson.fromJson(result, String.class);

            Log.v("ResponsefromServer:",response);


//            if(response.equals("成功寄出信件")){
//
//                Toast.makeText(activity, "已成功寄出信件至"+email, Toast.LENGTH_SHORT).show();
//
//            }
//            else if(response.equals("email與註冊時不一樣")){
////                Toast.makeText(activity, "email與註冊時不一樣", Toast.LENGTH_SHORT).show();
//                etmail.setError("email與註冊時不一樣");
//            }
//            else if(response.equals("無此帳號")){
////                Toast.makeText(activity, "無此帳號", Toast.LENGTH_SHORT).show();
//                etAC.setError("無此帳號");
//            }
//            else{
//                Log.v("ResponsefromServer:","memberNull");
//            }

        }
        else {
            Toast.makeText(activity, R.string.textNoNetwork, Toast.LENGTH_SHORT).show();
        }

    }
}