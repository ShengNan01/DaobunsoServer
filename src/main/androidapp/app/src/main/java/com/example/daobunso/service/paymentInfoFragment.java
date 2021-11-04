package com.example.daobunso.service;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.daobunso.MainActivity;
import com.example.daobunso.R;


public class paymentInfoFragment extends Fragment {
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
        return inflater.inflate(R.layout.fragment_payment_info, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(view, saveInstanceState);
        Bundle bundle = new Bundle();// Bundle用來把本頁資料傳到下一頁去

        //回首頁
        view.findViewById(R.id.btnToIndexPage).setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_paymentInfoFragment_to_indexFragment);
        });

    }

}