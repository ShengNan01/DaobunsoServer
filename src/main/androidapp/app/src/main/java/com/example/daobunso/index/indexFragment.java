package com.example.daobunso.index;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.SharedPreferences;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import androidx.navigation.Navigation;


import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import com.example.daobunso.R;


public class indexFragment<onViewCreated> extends Fragment {

    private Activity activity; //　取得本Fragment所依從的Activity(不是繼承關係!)
    private SharedPreferences preferences;
    private final static String PREFERENCES_NAME = "preferences";
    String account;
    String password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity(); //取得本Fragment所依從的Activity(不是繼承關係!)

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        activity.setTitle((R.string.textIndex)); //DAOBUNSO(首頁TITLE)


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_index, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        preferences = activity.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        account = preferences.getString("accountInfo","");
        password = preferences.getString("passwordInfo","");

        Bundle bundle = new Bundle(); // Bundle用來把本頁資料傳到下一頁去
        bundle.putString("account", account);
        bundle.putString("password", password);

        // 點選 MyOrder 我的訂單
        view.findViewById(R.id.tvMyOrder).setOnClickListener(v -> {

            Navigation.findNavController(v).navigate(R.id.action_indexFragment_to_myorderFragment, bundle);
        });


        // 點選 service 服務
        view.findViewById(R.id.tvService).setOnClickListener(v -> {

            Navigation.findNavController(v).navigate(R.id.action_indexFragment_to_serviceFragment, bundle);
        });


        // 點選 member 會員
        view.findViewById(R.id.tvMember).setOnClickListener(v -> {

            Navigation.findNavController(v).navigate(R.id.action_indexFragment_to_memberFragment, bundle);
        });


        // 點選 comment 評論
        view.findViewById(R.id.tvComment).setOnClickListener(v -> {

            Navigation.findNavController(v).navigate(R.id.action_indexFragment_to_commentFragment, bundle);
        });


        //點選 logout 會跳轉到登入畫面，並且會同時將記在preference檔裡的個人資訊刪除
        view.findViewById(R.id.tvLogout).setOnClickListener(v -> {
            preferences = activity.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);

            preferences.edit()
                    .putString("accountInfo", "")
                    .putString("password", "")
                    .putString("account", "")
                    .apply();


            Navigation.findNavController(v).navigate(R.id.action_indexFragment_to_signinFragment, bundle);
        });


    }

    @Override
    public void onResume() {
        super.onResume();
    }
}