package com.example.daobunso.myOrder;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daobunso.R;
import com.example.daobunso.myOrder.myOrderBean;

import java.util.ArrayList;
import java.util.List;


public class myorderFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_myorder, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<myOrderBean> OB = getOrderBean();
        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new MyOrderAdapter(getContext(), OB));
        }

        view.findViewById(R.id.ivHome).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_myorderFragment_to_indexFragment));

        view.findViewById(R.id.ivShippingcart).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_myorderFragment_to_serviceFragment));

    }




    // 內部類別MyOrderAdapter
    private static class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyViewHolder> {
        Context context;
        List<myOrderBean> OB;
        public MyOrderAdapter(Context context, List<myOrderBean> OB) {
            this.context = context;
            this.OB = OB;
        }

        @Override
        public int getItemCount() {
            return OB.size();
        }

        //adapter裡的內部類別MyViewHolder
        private static class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tvOrderListView;
            public MyViewHolder(View itemView) {
                super(itemView);

                tvOrderListView = itemView.findViewById(R.id.tvOrderListView);

            }
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.myorder_list_view, viewGroup, false);

            // 這邊才開始載入myorder_list_view(RecyclerView的每一個小view)
            // 評論按鈕是依附在myorder_list_view裡的元件，所以要在這裡才能findViewById
            // 點選了comment按鈕，會跳轉到commentFragment那一頁
            Bundle bundle = new Bundle();
            itemView.findViewById(R.id.commentBtn).setOnClickListener(v -> {

                Navigation.findNavController(v).navigate(R.id.action_myorderFragment_to_commentFragment,bundle);
            });


            return new MyViewHolder(itemView);


        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int index) {
            final myOrderBean orderBean = OB.get(index);

            viewHolder.tvOrderListView
                    .setText(orderBean.getOrederId()+" "+orderBean.getType()+" "+orderBean.getContact()+" "+orderBean.getPhone());

        }
    }

        private List<myOrderBean> getOrderBean() {
            List<myOrderBean> OB = new ArrayList<>();
            OB.add(new myOrderBean( 1, "一次性","米小暑","091234342"));
            OB.add(new myOrderBean( 2,"包月","米小暑","090893473"));
            OB.add(new myOrderBean( 3, "社區型","米小暑","0987466644"));
            OB.add(new myOrderBean( 4, "社區型","米小暑","0987466644"));
            OB.add(new myOrderBean( 5, "社區型","米小暑","0987466644"));
            return OB;
        }
}