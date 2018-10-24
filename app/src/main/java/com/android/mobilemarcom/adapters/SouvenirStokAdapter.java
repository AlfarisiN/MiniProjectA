package com.android.mobilemarcom.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.model.ModelSouvenir.SouvenirList;
import com.android.mobilemarcom.model.ModelSouvenirStok.SouvenirStokList;
import com.android.mobilemarcom.t_souvenir.SouvenirStokAddItemActivity;

import java.util.List;

public class SouvenirStokAdapter extends RecyclerView.Adapter<SouvenirStokAdapter.CustomViewHolderSouvenirStok> {
    private List<SouvenirStokList> souvenir_stok;
    private Context mContext;

    public SouvenirStokAdapter(Context mContext, List<SouvenirStokList> souvenir_stok){
        this.mContext = mContext;
        this.souvenir_stok = souvenir_stok;
    }

    @Override
    public SouvenirStokAdapter.CustomViewHolderSouvenirStok onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_t_souvenir_list, parent, false);
        return new SouvenirStokAdapter.CustomViewHolderSouvenirStok(itemView);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolderSouvenirStok holder, int position) {
        final SouvenirStokList souvenirStok = souvenir_stok.get(position);
        holder.t_souvenir_list_code.setText(souvenirStok.getCode());
        holder.t_souvenir_received_date.setText(souvenirStok.received_date);
        holder.t_souvenir_received_by.setText(souvenirStok.received_by);
        holder.image_t_souvenir_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popupMenu = new PopupMenu(mContext,
                        holder.image_t_souvenir_option);
                popupMenu.getMenuInflater().inflate(R.menu.popup_additem, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(mContext, "Masuk Menu", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
            }
        });
    }


    @Override
    public int getItemCount() {
        if (souvenir_stok != null) {
            return souvenir_stok.size();
        } else {
            return 0;
        }
    }

    public class CustomViewHolderSouvenirStok extends RecyclerView.ViewHolder{
        private TextView t_souvenir_list_code, t_souvenir_received_date, t_souvenir_received_by;
        private ImageView image_t_souvenir_option;
        public CustomViewHolderSouvenirStok(View view){
            super(view);
            t_souvenir_list_code = (TextView) view.findViewById(R.id.t_souvenir_list_code);
            t_souvenir_received_date = (TextView) view.findViewById(R.id.t_souvenir_received_date);
            t_souvenir_received_by = (TextView) view.findViewById(R.id.t_souvenir_received_by);
            image_t_souvenir_option = (ImageView) view.findViewById(R.id.image_t_souvenir_option);
        }
    }

    private void optionMenuOpen(int id, int idSouvenirStok) {
        switch (id) {
            case R.id.addItem:
                Intent intent = new Intent(mContext, SouvenirStokAddItemActivity.class);
                mContext.startActivity(intent);
                break;
        }
    }

    public void filterList(List<SouvenirStokList> filterList){
        souvenir_stok = filterList;
        notifyDataSetChanged();
    }
}
