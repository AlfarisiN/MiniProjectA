package com.android.mobilemarcom.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mobilemarcom.R;

public class ViewHolderEmployee extends RecyclerView.ViewHolder {
    private TextView empId,fullname,company,status;
    private ImageView imageUser;

    public ViewHolderEmployee(@NonNull View itemView) {
        super(itemView);
        empId = (TextView) itemView.findViewById(R.id.empName);
        fullname = (TextView) itemView.findViewById(R.id.username);
        company = (TextView) itemView.findViewById(R.id.role);
        status = (TextView) itemView.findViewById(R.id.status);
        imageUser = (ImageView) itemView.findViewById(R.id.imageUser);
    }

    public void setModel(final Context context, String employee_id, String employee_fulname, String employee_company, String employee_status){
        empId.setText(employee_id);
        fullname.setText(employee_fulname);
        company.setText(employee_company);
        status.setText(employee_status);
        imageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context,imageUser);
                popupMenu.getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.edit:
                                Toast.makeText(context,"Anda memilih edit",Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.deactive:
                                Toast.makeText(context,"Anda memilih Deactive",Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
    }
}

