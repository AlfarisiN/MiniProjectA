package com.android.mobilemarcom.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.model.ModelSouvenir;
import com.android.mobilemarcom.viewholder.ViewHolderSouvenir;

import java.util.List;

public class SouvenirListAdapter extends RecyclerView.Adapter<ViewHolderSouvenir> {
    private Context context;
    private List<ModelSouvenir> souvenirList;

    public SouvenirListAdapter(Context context, List<ModelSouvenir> souvenirList) {
        this.context = context;
        this.souvenirList = souvenirList;
    }

    @NonNull
    @Override
    public ViewHolderSouvenir onCreateViewHolder(ViewGroup parent, int viewType) {
        View customView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.custom_souvenir_list,
                parent,
                false
        );
        return new ViewHolderSouvenir(customView);
    }

    @Override
    public void onBindViewHolder(ViewHolderSouvenir holder, final int position) {
        final ModelSouvenir souvenir = souvenirList.get(position);
        holder.setModelSouvenir(context, souvenir);
    }

    @Override
    public int getItemCount() {
        if(souvenirList != null){
            return souvenirList.size();
        }
        return 0;
    }

    public void filterList(List<ModelSouvenir> filterList){
        souvenirList = filterList;
        notifyDataSetChanged();
    }
}
