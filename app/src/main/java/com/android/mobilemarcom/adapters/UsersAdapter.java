package com.android.mobilemarcom.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.filter.Userfilter;
import com.android.mobilemarcom.model.User;
import com.android.mobilemarcom.viewholder.ViewHolderUser;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<ViewHolderUser> implements Filterable {
    private Context context;
    public ArrayList<User> userArrayList,filterList;
    public Userfilter filter;

    public UsersAdapter(Context context,ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
        this.filterList = userArrayList;
    }

    public UsersAdapter(Context context, String[] id, String[] fullname, String[] company, String[] status) {
    }

    @NonNull
    @Override
    public ViewHolderUser onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_user,viewGroup,false);
        return new ViewHolderUser(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderUser viewHolder, int i) {
        User user = userArrayList.get(i);
        viewHolder.setModel(context,user);
//        if(EMP_NAMES.length>0){
//            String employe_name = EMP_NAMES[i];
//            String username_employe = USERNAME[i];
//            String role_employe = ROLE[i];
//            String status_employe = STATUS[i];
//            viewHolder.setModel(context,employe_name,username_employe,role_employe,status_employe);
//            System.out.println(EMP_NAMES.length);
//        }
    }

    @Override
    public int getItemCount() {
        if(userArrayList!=null){
            return userArrayList.size();
        }else{
            return 0;
        }

    }

    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new Userfilter(filterList,this);
        }

        return filter;
    }
}
