package com.example.daobunso;

public class CheckEmail {

    public static boolean checkEmail(String email)
        {// 驗證郵箱的正規表示式
            String format = "\\p{Alpha}\\w{2,15}[@][a-z0-9]{3,}[.]\\p{Lower}{2,}";
    //p{Alpha}:內容是必選的，和字母字元[\p{Lower}\p{Upper}]等價。如：200896@163.com不是合法的。
    //w{2,15}: 2~15個[a-zA-Z_0-9]字元；w{}內容是必選的。 如：dyh@152.com是合法的。
    //[a-z0-9]{3,}：至少三個[a-z0-9]字元,[]內的是必選的；如：dyh200896@16.com是不合法的。
    //[.]:'.'號時必選的； 如：dyh200896@163com是不合法的。
    //p{Lower}{2,}小寫字母，兩個以上。如：dyh200896@163.c是不合法的。
            if (email.matches(format))
            {
                return true;// 郵箱名合法，返回true
            }
            else
            {
                return false;// 郵箱名不合法，返回false
            }
    }
}

