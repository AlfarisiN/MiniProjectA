package com.android.mobilemarcom.retrofit;

/**
 * Created by Irfan Naufal Ridi on 11/10/2018.
 */

public class APIUtilities {

    public static final String BASE_URL = "http://139.162.5.173:8080/";
    public static final String CONTENT_HEADER = "application/json";
    public static final String AUTHORIZATION_UNIT_DEACTIVE = "ZQNOFY4FVX77MELCTMDNZIHHLSCDPYX5IIRIY5LCHT18BIDD94HU49H6STZD2ACTR8QUD4OGJ75SWKWJYKP2NCZ2O1C3QNMX76GLAZNBPXOKCAAVI1T2XENTVW4XPIHI";
    public static final String AUTHORIZATION_UNIT_SEARCH = "JCZXSHTUOIW5PAAGXIYZFTTX43KGRGJGFKL8DLMPJUMNFRIYOSTZUSL2157WV2MKY8CNNJDP8SAYN1KHHGBHV0B2W1UFPCR4APQKYEW6HJVFM98F4KY5T0QVWRGZXRTP";
    public static final String AUTHORIZATION_UNIT_EDIT = "ZQNOFY4FVX77MELCTMDNZIHHLSCDPYX5IIRIY5LCHT18BIDD94HU49H6STZD2ACTR8QUD4OGJ75SWKWJYKP2NCZ2O1C3QNMX76GLAZNBPXOKCAAVI1T2XENTVW4XPIHI";

    public static RequestAPIServices getApiServeices(){

        return RetrofitClient.getClient(BASE_URL).create(RequestAPIServices.class);
    }

}