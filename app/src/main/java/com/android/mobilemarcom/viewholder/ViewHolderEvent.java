package com.android.mobilemarcom.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.model.ModelEvent;
import com.android.mobilemarcom.model.ModelUnit;

/**
 * Created by Irfan Naufal Ridi on 24/10/2018.
 */

public class ViewHolderEvent extends RecyclerView.ViewHolder {

    private TextView eventListCode, eventListName, eventStartDateList, eventListStatus;
    private ImageView eventBurgerOption;

    public ViewHolderEvent(final View itemView) {
        super(itemView);

        eventListCode = (TextView)itemView.findViewById(R.id.eventCodeName);
        eventListName = (TextView)itemView.findViewById(R.id.eventName);
        eventStartDateList = (TextView)itemView.findViewById(R.id.eventStartDate);
        eventListStatus= (TextView)itemView.findViewById(R.id.eventStatus);
        eventBurgerOption = (ImageView)itemView.findViewById(R.id.eventBurger);

        eventBurgerOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(itemView.getContext(),eventBurgerOption);
                popupMenu.getMenuInflater()
                        .inflate(R.menu.popup_menu_event_burger,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if(menuItem.getTitle() == "editEvent"){
                            Toast.makeText(itemView.getContext(),"Diem dulu",Toast.LENGTH_LONG).show();
                        }
                        else if(menuItem.getTitle() == "approvalEvent"){
                            Toast.makeText(itemView.getContext(),"Diem dulu dong",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(itemView.getContext(),"kepo",Toast.LENGTH_LONG).show();
                        }

                        return true;
                    }
                });
                popupMenu.show();

            }
        });

    }

    public void setModelEvent(Context context, ModelEvent event){
        //set Code
        String code = event.getEventCode();
        eventListCode.setText(code);

        //set Name
        String name = event.getEventName();
        eventListName.setText(name);

        //set quantity
        String startDate = event.getEventStartDate();
        eventStartDateList.setText(startDate+"");

        //set Status
        String status = event.getEventStatus();
        eventListStatus.setText(status);
    }
}

