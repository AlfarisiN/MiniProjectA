package com.android.mobilemarcom.filter;

import android.widget.Filter;

import com.android.mobilemarcom.adapters.UsersAdapter;
import com.android.mobilemarcom.model.User;

import java.util.ArrayList;

public class Userfilter extends Filter {
    private UsersAdapter usersAdapter;
    private ArrayList<User> userArrayList;

    public Userfilter(ArrayList<User> userArrayList,UsersAdapter usersAdapter) {
        this.usersAdapter = usersAdapter;
        this.userArrayList = userArrayList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();

        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<User> filteredPlayers=new ArrayList<>();

            for (int i=0;i<userArrayList.size();i++)
            {
                //CHECK
                if(userArrayList.get(i).getEmp_name().toUpperCase().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredPlayers.add(userArrayList.get(i));
                }
            }

            results.count=filteredPlayers.size();
            results.values=filteredPlayers;
        }else
        {
            results.count=userArrayList.size();
            results.values=userArrayList;

        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        usersAdapter.userArrayList= (ArrayList<User>) results.values;

        //REFRESH
        usersAdapter.notifyDataSetChanged();
    }

}
