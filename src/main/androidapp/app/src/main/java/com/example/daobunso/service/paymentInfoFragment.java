package com.example.daobunso.service;


import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.content.SharedPreferences;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.daobunso.MainActivity;
import com.example.daobunso.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class paymentInfoFragment extends Fragment {
    private MainActivity activity;
    private String paymentType;
    private String TaxNumber;
    private String companyTitle;
    private String serviceType;
    private String serviceTime;
    private String startDate;
    private String endDate;
    private String contact;
    private String phone;
    private String address;
    private String sum;
    private String spPaymentMethod;
    private SharedPreferences preferences;
    private String account;
    private final static String PREFERENCES_NAME = "preferences";


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

        TextView tvServicePerson = view.findViewById(R.id.tvServicePerson);
        TextView tvServiceType = view.findViewById(R.id.tvServiceType);
        TextView tvAddress = view.findViewById(R.id.tvAddress);
        TextView tvServiceTime = view.findViewById(R.id.tvServiceTime);
        TextView tv_OrderDate = view.findViewById(R.id.tv_OrderDate);
        TextView tvStartDate = view.findViewById(R.id.tvStartDate);
        TextView tvEndDate = view.findViewById(R.id.tvEndDate);
        TextView tvTotalPrice = view.findViewById(R.id.tvTotalPrice);


        Bundle bundle = getArguments();
        if (bundle != null) {
            spPaymentMethod = bundle.getString("spPaymentMethod");
            TaxNumber = bundle.getString("TaxNumber");
            companyTitle = bundle.getString("companyTitle");
            serviceTime = bundle.getString("serviceTime");
            serviceType = bundle.getString("serviceType");
            startDate = bundle.getString("startDate");
            endDate = bundle.getString("endDate");
            contact = bundle.getString("contact");
            phone = bundle.getString("phone");
            address = bundle.getString("address");
            sum = bundle.getString("sum");
        }

        //從preference檔，取出account
        preferences = activity.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        account = preferences.getString("accountInfo","訪客");

        //以今日日期為orderDate
        Calendar cl = Calendar.getInstance();
        java.util.Date date1 =cl.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String orderDate = sdf.format(date1);

        tvServicePerson.setText(account);
        tvServiceType.setText(serviceType);
        tvAddress.setText(address);
        tvServiceTime.setText(serviceTime);
        tv_OrderDate.setText(orderDate);
        tvStartDate.setText(startDate);
        tvEndDate.setText(endDate);
        tvTotalPrice.setText("NTD "+sum);

        Bundle bundle1 = new Bundle();// Bundle用來把本頁資料傳到下一頁去

        //回首頁
        view.findViewById(R.id.btnToIndexPage).setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_paymentInfoFragment_to_indexFragment,bundle1);
        });

    }

}