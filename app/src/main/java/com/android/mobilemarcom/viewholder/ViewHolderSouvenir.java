package com.android.mobilemarcom.viewholder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.model.ModelSouvenir;
import com.android.mobilemarcom.souvenir.EditSouvenirActivity;

public class ViewHolderSouvenir extends RecyclerView.ViewHolder {
    private TextView souvenir_list_code, souvenir_list_name, souvenir_list_quantity, souvenir_list_status;
    private ImageView image_souvenir_option;
    private Context context;

    public ViewHolderSouvenir(@NonNull View itemView) {
        super(itemView);
        
        souvenir_list_code = (TextView) itemView.findViewById(R.id.souvenir_list_code);
        souvenir_list_name = (TextView) itemView.findViewById(R.id.souvenir_list_name);
        souvenir_list_quantity = (TextView) itemView.findViewById(R.id.souvenir_list_quantity);
        souvenir_list_status = (TextView) itemView.findViewById(R.id.souvenir_list_status);
        image_souvenir_option = (ImageView) itemView.findViewById(R.id.image_souvenir_option);

    }


    public void setModelSouvenir(Context context, ModelSouvenir souvenir){
        //set Code
        String code = souvenir.getCode_souvenir();
        souvenir_list_code.setText(code);

        //set Name
        String name = souvenir.getName_souvenir();
        souvenir_list_name.setText(name);

        //set quantity
        String quantity = souvenir.getQuantity();
        souvenir_list_quantity.setText(quantity);

        //set Status
        String status = souvenir.getStatus();
        souvenir_list_status.setText(status);

        image_souvenir_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
