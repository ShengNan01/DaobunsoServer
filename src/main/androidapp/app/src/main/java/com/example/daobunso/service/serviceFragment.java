package com.example.daobunso.service;

import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.daobunso.MainActivity;
import com.example.daobunso.R;
import com.google.android.material.appbar.AppBarLayout;

import java.sql.Date;
import java.util.Calendar;


public  class serviceFragment extends Fragment implements
        /*AdapterView.OnItemSelectedListener,*/ DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    //不能設定成abstract，不然跑不出來==
    private MainActivity activity;//取得本fragment所依從的Activity(非繼承關係)
    //    private Activity activity;//取得本fragment所依從的Activity(非繼承關係)
    private TextView tvMessage;
    private int year, month, day;
    private View actionHome;
    private Spinner spinner_serviceType;
    private Spinner spinner_serviceTime;
    private EditText etDate;
    private EditText etAddress;
    private EditText etContactPerson;
    private EditText etContactPhone;
    private String date;
    private String address;
    private String contact;
    private String phone;
    Bundle bundle;
    private final static String PREFERENCES_NAME = "preferences";
    private SharedPreferences preferences;
    private String serviceType;
    private String serviceTime;
    private String memberId;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();//取得本Fragment 所依從的Activity(不是繼承關係)

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState) {
        super.onCreateView(inflater, container, saveInstanceState);

        return inflater.inflate(R.layout.fragment_service, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(view, saveInstanceState);

        etDate = view.findViewById(R.id.etDate);
        etAddress = view.findViewById(R.id.etAddress);
        etContactPerson = view.findViewById(R.id.etContactPerson);
        etContactPhone = view.findViewById(R.id.etContactPhone);

// ============================= 服務類型下拉式選單(spinner) ===================================
        Resources res =getResources();
        String[] spServiceType =res.getStringArray(R.array.spServiceType);
        spinner_serviceType = (Spinner) view.findViewById(R.id.spServiceType);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),R.layout.myspinner,spServiceType);//建立Arrayadapter介面卡
        spinner_serviceType.setAdapter(adapter);
        spinner_serviceType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//點選spinner物件
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                serviceType = spinner_serviceType.getItemAtPosition(i).toString();
                Toast.makeText(activity,serviceType,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

// ============================= 服務時段下拉式選單(spinner) ===================================
        String[] spServiceTime =res.getStringArray(R.array.spServiceTime);
        spinner_serviceTime = (Spinner) view.findViewById(R.id.spServiceTime);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(),R.layout.myspinner,spServiceTime);//建立Arrayadapter介面卡
        spinner_serviceTime.setAdapter(adapter1);
        spinner_serviceTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//點選spinner物件
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                serviceTime = spinner_serviceTime.getItemAtPosition(i).toString();
                Toast.makeText(activity,serviceTime,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


// =================================== 選擇日期 ============================================

        showNow();

        //選取日期
        ImageButton btnCalendar = view.findViewById(R.id.btnCalendar);
        btnCalendar.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog =
                    new DatePickerDialog(activity, this, year, month, day);
            //取得DataPicker物件方可設定可選取之日期區間
            DatePicker datePicker = datePickerDialog.getDatePicker();
            //設定可選取的開始日為今日
            Calendar calendar = Calendar.getInstance();
            datePicker.setMinDate(calendar.getTimeInMillis());
            //設定可選取的結束日為三個月後
            calendar.add(Calendar.MONTH, 3);
            datePicker.setMaxDate(calendar.getTimeInMillis());
            //最後呼叫show()顯示
            datePickerDialog.show();
        });



        //右上角，回首頁
        view.findViewById(R.id.homepage_btn_service).setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_serviceFragment_to_indexFragment2);
        });


        //AlertDialog
        // 點選送出進入服務訂單頁面
        TextView btnToNewOrder = view.findViewById((R.id.btnToNewOrder));
        btnToNewOrder.setOnClickListener(v -> {


            address = etAddress.getText().toString().trim();
            contact = etContactPerson.getText().toString().trim();
            phone = etContactPhone.getText().toString().trim();
            //判斷使用者是否有輸入值
            if (date.isEmpty()) {
                etDate.setError("Date is empty ");
            }
            if (address.isEmpty()) {
                etAddress.setError("Address is empty ");
            }
            if (contact.isEmpty()) {
                etContactPerson.setError("ContactPerson is empty ");
            }
            if (phone.isEmpty()) {
                etContactPhone.setError("ContactPhone is empty ");
            }
            ;
            if (date.isEmpty() || address.isEmpty() || contact.isEmpty() || phone.isEmpty()) {
                etDate.setError(" 請填寫完整資料 ");
                etAddress.setError("請填寫完整資料");
                etContactPerson.setError("請填寫完整資料 ");
                etContactPhone.setError("請填寫完整資料 ");

                return;

            }
            bundle = new Bundle();
            //從preference檔，取出memberId
            preferences = activity.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
            memberId = preferences.getString("memberIdInfo","0");
            bundle.putString("memberId",memberId);
            bundle.putString("startDate",date);
            bundle.putString("address",address);
            bundle.putString("contact",contact);
            bundle.putString("phone",phone);
            bundle.putString("serviceTime",serviceTime);
            bundle.putString("serviceType",serviceType);


            new AlertDialog.Builder(activity)
                        //設定標題
                        .setTitle("訂單確認")
                        //設定圖示
                        .setIcon(R.drawable.logo1)
                        //設定訊息文字
                        .setMessage("是否確定送出訂單")
                        //設定positive與negative按鈕上面的文字與點擊事件監聽器
                        .setPositiveButton("Yes", (dialog, which) -> Navigation.findNavController(v)
                                .navigate(R.id.action_serviceFragment_to_newOrderFragment, bundle))//導向付款頁面
                        .setNegativeButton("No", (dialog, which) -> dialog.cancel())//關閉對話視窗
                        .setCancelable(false)//必須點擊按鈕方能關閉，預設為true
                        .show();
        });
    }//onViewCreated內


    /* 覆寫OnDateSetListener.onDateSet()以處理日期挑選完成事件。
       日期挑選完成會呼叫此方法，並傳入選取的年月日 */
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        updateDisplay();
    }

    //  取得現在日期時間並呼叫UpdateDisplay()顯示在etView上
    private void showNow() {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        updateDisplay();
    }


    /* 將指定的日期顯示在etTextView上。
  一月的值是0而非1，所以「month + 1」後才顯示 */
    private void updateDisplay() {
        date = new StringBuilder().append(year).append("-")
                .append(pad(month + 1)).append("-").append(day).toString();
        etDate.setText(date);

    }

    /* 若數字有十位數，直接顯示；
      若只有個位數則補0後再顯示，例如7會改成07後再顯示 */
    private String pad(int number) {
        if (number >= 10) {
            return String.valueOf(number);
        } else {
            return "0" + number;
        }
    }



    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }


}