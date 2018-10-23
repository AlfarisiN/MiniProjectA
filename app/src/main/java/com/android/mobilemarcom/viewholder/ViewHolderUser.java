package com.android.mobilemarcom.viewholder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.model.User;
import com.android.mobilemarcom.user.EditUserActivity;

public class ViewHolderUser extends RecyclerView.ViewHolder {
    private TextView empName,username,role,status;
    private ImageView imageUser;

    public ViewHolderUser(@NonNull View itemView) {
        super(itemView);
        empName = (TextView) itemView.findViewById(R.id.empName);
        username = (TextView) itemView.findViewById(R.id.username);
        role = (TextView) itemView.findViewById(R.id.role);
        status = (TextView) itemView.findViewById(R.id.status);
        imageUser = (ImageView) itemView.findViewById(R.id.imageUser);
    }

    public void setModel(final Context context, User user){
        empName.setText(user.getEmp_name());
        username.setText(user.getUsername());
        role.setText(user.getRole());
        status.setText(user.getStatus());
        imageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context,imageUser);
                popupMenu.getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
<<<<<<< HEAD
                            case R.id.edit:
=======
<<<<<<< HEAD
                            case R.id.edit:
                                Intent in = new Intent(context, EditUserActivity.class);
                                context.startActivity(in);
=======
                            case R.id.edit:1
                                Intent in = new Intent(context, null);
                                context.startActivity(in);
>>>>>>> cc0e16d571c631ea55abfa9dc5f0b53c1c428852
                                Toast.makeText(context,"Anda memilih edit",Toast.LENGTH_SHORT).show();
>>>>>>> 19f7fef19d7ad7f6a1efee51f0c4c5962ee1102b
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
