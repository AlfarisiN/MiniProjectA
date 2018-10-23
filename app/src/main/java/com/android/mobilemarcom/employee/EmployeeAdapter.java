package com.android.mobilemarcom.employee;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.viewholder.ViewHolderUser;

public class EmployeeAdapter extends RecyclerView.Adapter<ViewHolderUser> {
    private Context context;
    private String[] ID;
    private String[] FULLNAME;
    private String[] COMPANY;
    private String[] STATUS;
    public EmployeeAdapter(Context context,String[] ID,String[] FULLNAME, String[] COMPANY,String[] STATUS) {
        this.context = context;
        this.ID = ID;
        this.FULLNAME = FULLNAME;
        this.COMPANY = COMPANY;
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
        if(ID.length>0){
            String id_employee = ID[i];
            String fullname_employee = FULLNAME[i];
            String company_employe = COMPANY[i];
            String status_employe = STATUS[i];
            viewHolder.setModel(context,id_employee,fullname_employee,company_employe,status_employe);
            System.out.println(ID.length);
        }
    }

    @Override
    public int getItemCount() {
        if(ID!=null){
            return ID.length;
        }else{
            return 0;
        }

    }
}
