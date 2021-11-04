package com.example.daobunso.service;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ClipData;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.daobunso.MainActivity;
import com.example.daobunso.R;
import com.google.android.material.appbar.AppBarLayout;

import java.util.Calendar;


public  class serviceFragment extends Fragment implements
        AdapterView.OnItemSelectedListener,DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    //不能設定成abstract，不然跑不出來==
    private MainActivity activity;//取得本fragment所依從的Activity(非繼承關係)
    //    private Activity activity;//取得本fragment所依從的Activity(非繼承關係)
    private TextView tvMessage;
    private EditText etDate;
    private int year, month, day;
    private View actionHome;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();//取得本Fragment 所依從的Activity(不是繼承關係)

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState) {
        super.onCreateView(inflater, container, saveInstanceState);
//        activity.setTitle(("服務選擇"));//DAOBUNSO服務頁面
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_service, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(view, saveInstanceState);
        Bundle bundle = new Bundle();// Bundle用來把本頁資料傳到下一頁去

//        日期id，並新增showNow()，
        etDate = view.findViewById(R.id.etDate);
//        showNow();
        //設定限制選取的日期區間
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
            EditText etDate = view.findViewById(R.id.etDate);
            EditText etAddress = view.findViewById(R.id.etAddress);
            EditText etContactPerson = view.findViewById(R.id.etContactPerson);
            EditText etContactPhone = view.findViewById(R.id.etContactPhone);
            String date = etDate.getText().toString().trim();
            String address = etAddress.getText().toString().trim();
            String contact = etContactPerson.getText().toString().trim();
            String phone = etContactPhone.getText().toString().trim();
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
            btnToNewOrder.setOnClickListener(v1 -> {
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
        etDate.setText(new StringBuilder().append(year).append("-")
                .append(pad(month + 1)).append("-").append(day));
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



    //><
    @Override
    public void onItemSelected(
            AdapterView<?> parent, View view, int position, long id) {
        tvMessage.setText(parent.getItemAtPosition(position).toString());
        Log.d("selected", "已選擇服務");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        tvMessage.setText("請選擇服務!");
        Log.d("noSelected", "請選擇服務");
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }
}