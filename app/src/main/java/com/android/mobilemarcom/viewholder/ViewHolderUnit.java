package com.android.mobilemarcom.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.model.ModelUnit;

public class ViewHolderUnit extends RecyclerView.ViewHolder {
    private TextView unitListCode, unitListName, unitListQty, unitListStatus;
    private Button unitBurgerOption;

    public ViewHolderUnit(@NonNull final View itemView) {
        super(itemView);

        unitListCode = (TextView) itemView.findViewById(R.id.unitCodeName);
        unitListName = (TextView) itemView.findViewById(R.id.unitName);
        unitListQty = (TextView) itemView.findViewById(R.id.unitQuantity);
        unitListStatus = (TextView) itemView.findViewById(R.id.unitStatus);
        unitBurgerOption = (Button) itemView.findViewById(R.id.unitBurger);
        unitBurgerOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu = new PopupMenu(itemView.getContext(),unitBurgerOption);
                popupMenu.getMenuInflater()
                        .inflate(R.menu.popup_menu_unit_burger,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if(menuItem.getTitle() == "Edit"){
                            Toast.makeText(itemView.getContext(),"Diem dulu",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(itemView.getContext(),"kepo",Toast.LENGTH_LONG).show();
                        }

                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    public void setModelUnit(Context context, ModelUnit unit){
        //set Code
        String code = unit.getUnitCode();
        unitListCode.setText(code);

        //set Name
        String name = unit.getUnitName();
        unitListName.setText(name);

        //set quantity
        int quantity = unit.getUnitQty();
        unitListQty.setText(quantity+"");

        //set Status
        String status = unit.getUntiStatus();
        unitListStatus.setText(status);
    }
}

