package com.example.imarisha.Data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Stores the user type only using sharedprefernces
 */
public class UserType {
    Context context;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    final String prefname="Userdata";

    public UserType(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(prefname,0);
        editor = preferences.edit();
    }
    public String UserName(){
        return preferences.getString("UserName","Nurse");
    }
    public void SetUserName(String name){
        editor.putString("UserName",name);
    }
   public  boolean isNurse(){
        return preferences.getBoolean("isNurse",false);
   }
   public  boolean isAdmin(){
      return preferences.getBoolean("isAdmin",false);
   }
   public void setisNurse(){
        editor  = preferences.edit();
        editor.putBoolean("isNurse",true);
        editor.apply();
   }
   public  void setisAdmin(){
        editor.putBoolean("isAdmin",true);
        editor.apply();
   }
}
