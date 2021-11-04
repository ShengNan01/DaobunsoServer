package com.example.daobunso;

public class CheckPassword {

    public static boolean CheckPassword(String password)
    {
        final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%!^'\"]).{8,})";

        if (password.matches(PASSWORD_PATTERN))
        {
            return true;// password合法，返回true
        }
        else
        {
            return false;// password不合法，返回false
        }
    }
}
