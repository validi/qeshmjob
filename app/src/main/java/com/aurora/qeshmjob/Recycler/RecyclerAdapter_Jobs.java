package com.aurora.qeshmjob.Recycler;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.aurora.qeshmjob.Info.InfoJop;
import com.aurora.qeshmjob.R;

import java.util.ArrayList;


/**
 * Created by a.validi on 8/3/2018.
 */

public class RecyclerAdapter_Jobs extends RecyclerView.Adapter<RecyclerAdapter_Jobs.ViewHolder> {
    ArrayList<InfoJop> requestItems;
    private Context context;
    Clik_Item clik_item;


    public RecyclerAdapter_Jobs(Context context, ArrayList<InfoJop> requestItems, Clik_Item clik_item) {
        this.context = context;
        this.requestItems = requestItems;
        this.clik_item = clik_item;


    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtFatherName;
        TextView txtName;
        TextView txtAvg;

        LinearLayout lay;


        public ViewHolder(View itemView) {
            super(itemView);

            // txtFatherName = (TextView) itemView.findViewById(R.id.txtFatherName);
           // txtName = (TextView) itemView.findViewById(R.id.tv_text);
            // txtAvg = (TextView) itemView.findViewById(R.id.txtAvg);
          //  lay = (LinearLayout) itemView.findViewById(R.id.lay);

        }

        @Override
        public void onClick(View v) {


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_job, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final InfoJop Item = requestItems.get(position);

        // holder.txtFatherName.setText("فرزند: "+Item.getFatherName()+"");
        //  holder.txtAvg.setText("سن: "+Item.getAvg()+"");
      //  holder.txtName.setText(Item.getName());




//        holder.txtName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                clik_item.Onrecived(Item);
//            }
//        });


//        holder.crd.setVisibility(View.INVISIBLE);
//        Handler handler=new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                holder.crd.setVisibility(View.VISIBLE);
//                YoYo.with(Techniques.SlideInDown).duration(100).playOn(holder.crd);
//            }
//        },Integer.parseInt((position+2)+"0"));


    }


    @Override
    public int getItemCount() {
        return requestItems.size();

    }

    public interface Clik_Item {
        void Onrecived(InfoJop InfoJop);
    }


}
