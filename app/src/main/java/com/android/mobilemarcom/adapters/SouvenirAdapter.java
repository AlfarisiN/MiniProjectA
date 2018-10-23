package com.android.mobilemarcom.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.model.ModelSouvenir.SouvenirList;
import com.android.mobilemarcom.viewholder.ViewHolderSouvenir;

import java.util.List;

public class SouvenirAdapter extends RecyclerView.Adapter<ViewHolderSouvenir> {
    private Context context;
    private List<SouvenirList> souvenirList;

<<<<<<< HEAD:app/src/main/java/com/android/mobilemarcom/adapters/SouvenirAdapter.java
    public SouvenirAdapter(Context context, List<ModelSouvenir> souvenirList) {
=======
    public SouvenirAdapter(Context context, List<SouvenirList> souvenirList) {
>>>>>>> 5d4151802a82ed4af11b963c20140995aa0a1a07:app/src/main/java/com/android/mobilemarcom/adapters/SouvenirAdapter.java
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
    public void onBindViewHolder(final ViewHolderSouvenir holder, final int position) {
<<<<<<< HEAD:app/src/main/java/com/android/mobilemarcom/adapters/SouvenirAdapter.java
        final ModelSouvenir souvenir = souvenirList.get(position);
=======
        final SouvenirList souvenir = souvenirList.get(position);
>>>>>>> 5d4151802a82ed4af11b963c20140995aa0a1a07:app/src/main/java/com/android/mobilemarcom/adapters/SouvenirAdapter.java
        holder.setModelSouvenir(context, souvenir);

    }

    @Override
    public int getItemCount() {
        if(souvenirList != null){
            return souvenirList.size();
        }
        return 0;
    }

    public void filterList(List<SouvenirList> filterList){
        souvenirList = filterList;
        notifyDataSetChanged();
    }
}
