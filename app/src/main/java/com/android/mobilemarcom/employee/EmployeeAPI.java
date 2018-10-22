package com.android.mobilemarcom.employee;

public class EmployeeAPI {
    private static String BASE_URL_API_2 = "https://reqres.in/api/";

    public static RequestAPIServices2 getAPIServices2(){
        return RetrofitClient2.getClient(BASE_URL_API_2).create(RequestAPIServices2.class);
    }
}
