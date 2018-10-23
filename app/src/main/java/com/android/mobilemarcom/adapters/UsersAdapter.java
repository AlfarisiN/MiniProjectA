package com.android.mobilemarcom.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.viewholder.ViewHolderUser;

public class UsersAdapter extends RecyclerView.Adapter<ViewHolderUser> {
    private Context context;
    private String[] EMP_NAMES;
    private String[] USERNAME;
    private String[] ROLE;
    private String[] STATUS;
    public UsersAdapter(Context context,String[] EMP_NAMES,String[] USERNAME, String[] ROLE,String[] STATUS) {
        this.context = context;
        this.EMP_NAMES = EMP_NAMES;
        this.USERNAME = USERNAME;
        this.ROLE = ROLE;
        this.STATUS = STATUS;
    }

    @NonNull
    @Override
    public ViewHolderUser onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_user,viewGroup,false);
        return new ViewHolderUser(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderUser viewHolder, int i) {
        if(EMP_NAMES.length>0){
            String employe_name = EMP_NAMES[i];
            String username_employe = USERNAME[i];
            String role_employe = ROLE[i];
            String status_employe = STATUS[i];
            viewHolder.setModel(context,employe_name,username_employe,role_employe,status_employe);
            System.out.println(EMP_NAMES.length);
        }
    }

    @Override
    public int getItemCount() {
        if(EMP_NAMES!=null){
            return EMP_NAMES.length;
        }else{
            return 0;
        }

    }
}
