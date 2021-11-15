package com.example.daobunso.service;

import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daobunso.MainActivity;
import com.example.daobunso.R;
import com.example.daobunso.network.RemoteAccess;
import com.google.gson.JsonObject;


public class confirmOrderFragment extends Fragment {
    private MainActivity activity;
    private Spinner spinner;
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
    private Bundle bundle1;
    private String memberId;


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

        Bundle bundle = getArguments();
        if (bundle != null) {
            memberId = bundle.getString("memberId");
            serviceType = bundle.getString("serviceType");
            serviceTime = bundle.getString("serviceTime");
            startDate = bundle.getString("startDate");
            endDate = bundle.getString("endDate");
            contact = bundle.getString("contact");
            phone = bundle.getString("phone");
            address = bundle.getString("address");
            sum = bundle.getString("sum");

            Log.d("newOrderFragment", serviceType+serviceTime+startDate);
        }

        EditText etTaxNumber = view.findViewById(R.id.etTaxNumber);//獲取到spacer1
        EditText etCompanyTitle = view.findViewById(R.id.etCompanyTitle);//獲取到spacer1
        TaxNumber = etTaxNumber.getText().toString().trim();
        companyTitle = etCompanyTitle.getText().toString().trim();


        Resources res =getResources();
        String[] spPaymentMethod =res.getStringArray(R.array.spPaymentMethod);
        spinner = (Spinner) view.findViewById(R.id.spPaymentMethod);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,spPaymentMethod);//建立Arrayadapter介面卡
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//點選spinner物件
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                paymentType= spinner.getItemAtPosition(i).toString();
//                Toast.makeText(activity,text,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        bundle1 = new Bundle();// Bundle用來把本頁資料傳到下一頁去
        bundle1.putString("spPaymentMethod",paymentType);
        bundle1.putString("TaxNumber",TaxNumber);
        bundle1.putString("companyTitle",companyTitle);
        bundle1.putString("serviceTime",serviceTime);
        bundle1.putString("serviceType",serviceType);
        bundle1.putString("startDate",startDate);
        bundle1.putString("endDate",endDate);
        bundle1.putString("contact",contact);
        bundle1.putString("phone",phone);
        bundle1.putString("address",address);
        bundle1.putString("sum",sum);
//        bundle1.putString("companyTitle",companyTitle);

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
                        .setPositiveButton("Yes", (dialog, which) -> insertOrder(view))//導向付款頁面
                        .setNegativeButton("No", (dialog, which) -> dialog.cancel())//關閉對話視窗
                        .setCancelable(false)//必須點擊按鈕方能關閉，預設為true
                        .show();
            });



            //右上角，回首頁
            view.findViewById(R.id.homepage_btn_confirm_order).setOnClickListener(v->{
                Navigation.findNavController(v).navigate(R.id.action_confirmOrderFragment_to_indexFragment);
            });
        }

    private void insertOrder(View view) {

        String url = "http://10.0.2.2:8080/app/insertOrderMaster";

        if (RemoteAccess.networkConnected(activity)) {
            JsonObject jsonObject = new JsonObject();

            jsonObject.addProperty("memberId", memberId);
            jsonObject.addProperty("address", address);
            jsonObject.addProperty("phone", phone);
            jsonObject.addProperty("contact", contact);
            jsonObject.addProperty("timeForGarbage", serviceTime);
            jsonObject.addProperty("sum", sum);
            jsonObject.addProperty("payType", paymentType);
            jsonObject.addProperty("taxIDnumber", TaxNumber);
            jsonObject.addProperty("companyTitle", companyTitle);
            jsonObject.addProperty("scheduleGarbage", "未完成");

            JsonObject jsonObject_detail = new JsonObject();
            jsonObject_detail.addProperty("quantity", "1");
            jsonObject_detail.addProperty("item_Type", serviceType);
            jsonObject_detail.addProperty("garbage_Start_Date", startDate);
            jsonObject_detail.addProperty("garbage_End_Date", endDate);

//            int count;
            String result_master = RemoteAccess.getRemoteData(url, jsonObject.toString());
            if(result_master.contains("已新增至訂單主檔")){
               String[] result_master_array = result_master.split("-");
               String OrderId = result_master_array[1];
                jsonObject_detail.addProperty("fk_order_bean_orderno", OrderId);

                String url_detail = "http://10.0.2.2:8080/app/insertOrderDetail";
                String result_detail = RemoteAccess.getRemoteData(url_detail, jsonObject_detail.toString());
                if(result_detail.equals("已新增至訂單detail檔")){
                    //跳轉到下一個頁面
                    Navigation.findNavController(view)
                            .navigate(R.id.action_confirmOrderFragment_to_paymentInfoFragment, bundle1);
                }
                else{
                    Toast.makeText(activity,"訂單detail檔建立失敗", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(activity,"訂單主檔建立失敗", Toast.LENGTH_SHORT).show();
            }





        }
        else {
            Toast.makeText(activity, R.string.textNoNetwork, Toast.LENGTH_SHORT).show();
        }








    }
}

