package com.android.mobilemarcom.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.model.ModelSouvenir;

public class ViewHolderSouvenir extends RecyclerView.ViewHolder {
    private TextView souvenir_list_code, souvenir_list_name, souvenir_list_quantity, souvenir_list_status;
    private Button btn_souvenir_option;

    public ViewHolderSouvenir(@NonNull View itemView) {
        super(itemView);

        souvenir_list_code = (TextView) itemView.findViewById(R.id.souvenir_list_code);
        souvenir_list_name = (TextView) itemView.findViewById(R.id.souvenir_list_name);
        souvenir_list_quantity = (TextView) itemView.findViewById(R.id.souvenir_list_quantity);
        souvenir_list_status = (TextView) itemView.findViewById(R.id.souvenir_list_status);
        btn_souvenir_option = (Button) itemView.findViewById(R.id.btn_souvenir_option);
        btn_souvenir_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
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
    }
}
