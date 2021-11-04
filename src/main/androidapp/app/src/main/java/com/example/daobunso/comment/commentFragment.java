package com.example.daobunso.comment;

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
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.daobunso.R;
import com.example.daobunso.login.InfoBeanApp;
import com.example.daobunso.login.LoginBean;
import com.example.daobunso.network.RemoteAccess;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class commentFragment extends Fragment {
    private Activity activity;
    private CommentBean commentBean;
    private Integer star;
    private EditText etComment;
    private RatingBar ratingBar;
    private String comment;
    private SharedPreferences preferences;
    private String account;
    private final static String PREFERENCES_NAME = "preferences";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity.setTitle((R.string.comment));
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ratingBar = view.findViewById(R.id.rbStars);
        etComment = view.findViewById(R.id.etComment);



        ratingBar.setOnRatingBarChangeListener((ratBar, rating, fromUser) -> {
//            star = String.valueOf(rating);
              star = (int)rating;
        });


        //從preference檔，取出account
        preferences = activity.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        account = preferences.getString("accountInfo","訪客");




        //點擊按鈕之後才取值
        view.findViewById(R.id.btnCommentsubmit).setOnClickListener(v -> {
            comment = etComment.getText().toString().trim();
            commentBean = new CommentBean(null,account,star,null,comment);
            comment(commentBean);
            Navigation.findNavController(v).navigate(R.id.action_commentFragment_to_thanksFragment);
        });


        // 右上角回首頁、shoppingCart
        view.findViewById(R.id.ivHome).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_commentFragment_to_indexFragment));

        view.findViewById(R.id.ivShippingcart).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_commentFragment_to_serviceFragment));

    }

    private void comment(CommentBean commentBean) {
        String url = "http://10.0.2.2:8080/Daobunso_Project/CommentServletAPP";

        if (RemoteAccess.networkConnected(activity)) {

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("action", "commentInsert");
            jsonObject.addProperty("commentBean", new Gson().toJson(commentBean));

            String result = RemoteAccess.getRemoteData(url, jsonObject.toString()); //與後端連線

            Gson gson = new Gson();
            String response = gson.fromJson(result, String.class);

            if(response.equals("評論成功")){
                Toast.makeText(activity,"評論成功", Toast.LENGTH_SHORT).show();
            }

        }
        else {
            Toast.makeText(activity, R.string.textNoNetwork, Toast.LENGTH_SHORT).show();
        }
    }


}