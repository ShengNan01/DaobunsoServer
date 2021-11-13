package com.example.daobunso.myOrder;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daobunso.R;
import com.example.daobunso.myOrder.myOrderBean;
import com.example.daobunso.network.RemoteAccess;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class myorderFragment extends Fragment {

    Context context;
    private Activity activity;
    private String account;
    private String OderId;




    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            account = bundle.getString("account");
            Log.d("myorderFragment_account", account);
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_myorder, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())); //
        List<String[]> OB = getOrderBean();
        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new MyOrderAdapter(getContext(), OB));
        } else {
            recyclerView.getAdapter().notifyDataSetChanged();
        }

        getOrderBean();

        view.findViewById(R.id.ivHome).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_myorderFragment_to_indexFragment));

        view.findViewById(R.id.ivShippingcart).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_myorderFragment_to_serviceFragment));

    }


//    // 內部類別MyOrderAdapter
    private static class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyViewHolder> {
        Context context;
        List<String[]> OB;
       View itemView;


        public MyOrderAdapter(Context context, List<String[]> OB) {
            this.context = context;
            this.OB = OB;
        }

        @Override
        public int getItemCount() {
            return OB.size();
        }

        //adapter裡的內部類別MyViewHolder
        private static class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tvOderId;
            TextView tvOrderDate;
            TextView tvSum;

            public MyViewHolder(View itemView) {
                super(itemView);

                tvOderId = itemView.findViewById(R.id.tvOderId);
                tvOrderDate = itemView.findViewById(R.id.tvOrderDate);
                tvSum = itemView.findViewById(R.id.tvSum);

            }
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            itemView = LayoutInflater.from(context).inflate(R.layout.myorder_list_view, viewGroup, false);


            // 這邊才開始載入myorder_list_view(RecyclerView的每一個小view)
            // 評論按鈕是依附在myorder_list_view裡的元件，所以要在這裡才能findViewById
            // 點選了comment按鈕，會跳轉到commentFragment那一頁
            Bundle bundle = new Bundle();


            itemView.findViewById(R.id.commentBtn).setOnClickListener(v -> {

                Navigation.findNavController(v).navigate(R.id.action_myorderFragment_to_commentFragment, bundle);
            });

//            //點選每一筆資料會跳轉到orderDetail頁面
            itemView.setOnClickListener(v -> {

                Navigation.findNavController(v).navigate(R.id.action_myorderFragment_to_orderDetailFragment, bundle);
            });


            return new MyViewHolder(itemView);


        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int index) {
            final String[] orderBean = OB.get(index);

            viewHolder.tvOderId
                    .setText(" 訂單編號: " + orderBean[0]);
            viewHolder.tvOrderDate
                    .setText(" 訂購日期: " + orderBean[1]);

            viewHolder.tvSum
                    .setText(" 總金額: " + orderBean[2]);

            Bundle bundle = new Bundle();
            bundle.putString("orderId",orderBean[0]);

            //點選每一筆資料會跳轉到orderDetail頁面
            itemView.setOnClickListener(v -> {
                Navigation.findNavController(v).navigate(R.id.action_myorderFragment_to_orderDetailFragment, bundle);
            });

        }
    }

    private List<String[]>  getOrderBean(){

        List<String[]> OB = new ArrayList<>();


        String url = "http://10.0.2.2:8080/app/getOrderBeans";

//            if (RemoteAccess.networkConnected(activity)) {

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("account",account);

            String result = RemoteAccess.getRemoteData(url, jsonObject.toString()); //與後端連線
            Log.d("hsi", result);

            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();


            Type type = new TypeToken<List<String[]>>() {}.getType();
            OB = gson.fromJson(result, type);

                if (OB.size() > 0) {
                    return OB;
                } else {
                    Toast.makeText(activity, "查無訂單", Toast.LENGTH_SHORT).show();
                }
                return OB;
 }
}