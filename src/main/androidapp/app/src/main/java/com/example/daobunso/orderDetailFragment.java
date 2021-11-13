package com.example.daobunso;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daobunso.myOrder.myorderFragment;
import com.example.daobunso.network.RemoteAccess;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class orderDetailFragment extends Fragment {

    private Activity activity;
    private String orderId;

    private RecyclerView recyclerView;
    List<String[]> odb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //過上一頁傳過來的Bundle拿到orderId
        Bundle bundle = getArguments();
        if (bundle != null) {
            orderId = bundle.getString("orderId");
            Log.d("orderDetail_orderId", orderId);
        }

        return inflater.inflate(R.layout.fragment_order_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(1,
                        StaggeredGridLayoutManager.HORIZONTAL));
        odb = getOrderDetail();


        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new orderDetailAdapter(getContext(), odb));
        } else {
            recyclerView.getAdapter().notifyDataSetChanged();
        }

        // 不處理捲動事件所以監聽器設為null
        recyclerView.setOnFlingListener(null);
        // 如果希望一次滑動一頁資料，要加上PagerSnapHelper物件
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);


//        // 點擊「First」按鈕會切換到第1筆資料
//        view.findViewById(R.id.btFirst).setOnClickListener(v ->
//                recyclerView.smoothScrollToPosition(0));
//        // 點擊「Last」按鈕會切換到最後一筆資料
//        view.findViewById(R.id.btLast).setOnClickListener(v ->
//                recyclerView.smoothScrollToPosition(odb.size() - 1));


        view.findViewById(R.id.ivHome).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_orderDetailFragment_to_indexFragment));

        view.findViewById(R.id.ivShippingcart).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_orderDetailFragment_to_serviceFragment));

    }

    private static class orderDetailAdapter extends RecyclerView.Adapter<orderDetailAdapter.MyViewHolder> {
        private final Context context;
        private List<String[]> odb;

        orderDetailAdapter(Context context, List<String[]> odb) {
            this.context = context;
            this.odb = odb;
        }

        static class MyViewHolder extends RecyclerView.ViewHolder {

            TextView id,orderdetail_id, orderdetail_quantity,orderdetail_type,orderdetail_sd,orderdetail_ed;

            MyViewHolder(View itemView) {
                super(itemView);

                id = itemView.findViewById(R.id.tvCommenttitletks);
                orderdetail_id = itemView.findViewById(R.id.orderdetail_id);
                orderdetail_quantity = itemView.findViewById(R.id.orderdetail_quantity);
                orderdetail_type = itemView.findViewById(R.id.orderdetail_type);
                orderdetail_sd = itemView.findViewById(R.id.orderdetail_sd);
                orderdetail_ed = itemView.findViewById(R.id.orderdetail_ed);
            }
        }

        @Override
        public int getItemCount() {
            return odb.size();
        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View itemView = LayoutInflater.from(context).
                    inflate(R.layout.orderdetail_item_view, viewGroup, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
            final String[] ODB = odb.get(position);

            viewHolder.id.setText((position+1)+" / "+odb.size());
            viewHolder.orderdetail_id.setText(ODB[0]);
            viewHolder.orderdetail_quantity.setText(ODB[1]);
            viewHolder.orderdetail_type.setText(ODB[2]);
            viewHolder.orderdetail_sd.setText(ODB[3]);
            viewHolder.orderdetail_ed.setText(ODB[4]);

        }
    }


    private List<String[]> getOrderDetail() {

        java.util.List<String[]> odb = new ArrayList<>();

        String url = "http://10.0.2.2:8080/app/orderDetail";

//            if (RemoteAccess.networkConnected(activity)) {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("orderId",orderId);

        String result = RemoteAccess.getRemoteData(url, jsonObject.toString()); //與後端連線
        Log.d("hsi_orderId", result);

        Gson gson = new Gson();

        Type type = new TypeToken<List<String[]>>() {}.getType();
        odb = gson.fromJson(result, type);

        if (odb.size() > 0) {
            return odb;
        } else {
            Toast.makeText(activity, "查無訂單", Toast.LENGTH_SHORT).show();
        }
        return odb;
    }
}