package com.android.mobilemarcom.viewholder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.model.ModelUnit;
import com.android.mobilemarcom.unit.UnitFragment;
import com.android.mobilemarcom.unit.modelunit.DataList;

public class ViewHolderUnit extends RecyclerView.ViewHolder {
    private TextView unitListCode, unitListName, unitListQty, unitListStatus;
    private ImageView unitBurgerOption;

    private Context context;

    public ViewHolderUnit(@NonNull final View itemView) {
        super(itemView);

        context = itemView.getContext();
        unitListCode = (TextView) itemView.findViewById(R.id.unitCodeName);
        unitListName = (TextView) itemView.findViewById(R.id.unitName);
        unitListQty = (TextView) itemView.findViewById(R.id.unitQuantity);
        unitListStatus = (TextView) itemView.findViewById(R.id.unitStatus);
        unitBurgerOption = (ImageView) itemView.findViewById(R.id.unitBurger);

    }

    public void setModelUnit(Context context, DataList unit){
        //set Code
        String code = unit.getCode();
        unitListCode.setText(code);

        //set Name
        Object name = unit.getName();
        unitListName.setText("Null :(");

        //set quantity
        String quantity = unit.getDescription();
        unitListQty.setText(quantity);

        //set Status
        boolean status = unit.getIsDelete();
        if(!status){
            unitListStatus.setText("Aktif");
        }
        else{
            unitListStatus.setText("Deactive");
        }

    }

    public void unitDeactiveAndEdit(DataList unit){
        final DataList tempDataHolder = unit;

        unitBurgerOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu = new PopupMenu(itemView.getContext(),unitBurgerOption);
                popupMenu.getMenuInflater()
                        .inflate(R.menu.popup_menu_unit_burger,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Log.e("dem",menuItem.getTitle()+"");
                        if(menuItem.getTitle().toString().equals("Edit")){
                            UnitFragment.editUnit(tempDataHolder);
                        }
                        else{
                            UnitFragment.deactiveUnit(tempDataHolder);
                        }

                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}

