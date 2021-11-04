package com.example.daobunso.service;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.daobunso.MainActivity;
import com.example.daobunso.R;


public class confirmOrderFragment extends Fragment {
    private MainActivity activity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();//取得本Fragment 所依從的Activity(不是繼承關係)

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirm_order, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(view, saveInstanceState);
        Bundle bundle = new Bundle();// Bundle用來把本頁資料傳到下一頁去



            //AlertDialog
            // 點選送出進入訂單明細頁面
            TextView btnToPayment = view.findViewById((R.id.btnToPayment));
            btnToPayment.setOnClickListener(v -> {
                new AlertDialog.Builder(activity)
                        //設定標題
                        .setTitle("訂單確認")
                        //設定圖示
                        .setIcon(R.drawable.logo1)
                        //設定訊息文字
                        .setMessage("是否確定送出訂單")
                        //設定positive與negative按鈕上面的文字與點擊事件監聽器
                        .setPositiveButton("Yes", (dialog, which) -> Navigation.findNavController(v)
                                .navigate(R.id.action_confirmOrderFragment_to_paymentInfoFragment, bundle))//導向付款頁面
                        .setNegativeButton("No", (dialog, which) -> dialog.cancel())//關閉對話視窗
                        .setCancelable(false)//必須點擊按鈕方能關閉，預設為true
                        .show();
            });

            //右上角，回首頁
            view.findViewById(R.id.homepage_btn_confirm_order).setOnClickListener(v->{
                Navigation.findNavController(v).navigate(R.id.action_confirmOrderFragment_to_indexFragment);
            });
        }
    }

