package com.rtlab.babyname;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static com.rtlab.babyname.R.layout.newlist_row;

//the class is responsible for displaying the names and descriptions
public class SecondAdapter extends BaseAdapter {

    Context context;
    ArrayList<Name> list;
    SaveUtil sv = new SaveUtil();

    public SecondAdapter(Context context, ArrayList<Name> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.indexOf(list.get(position));
    }

    static class SecViewHolder{

        TextView entryName;
        TextView entryDesc;
        Button entryFavBtn;
    }

    //creates and returns the view to be displayed in the listview.
    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {

        SecViewHolder holder = new SecViewHolder();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(newlist_row, null);

            holder.entryName = convertView.findViewById(R.id.newListNameTV);
            holder.entryDesc = convertView.findViewById(R.id.newListDescTV);
            holder.entryFavBtn = convertView.findViewById(R.id.newListFavBtn);
            Effect.buttonEffect(holder.entryFavBtn);


            convertView.setTag(holder);
        }else{
            holder = (SecViewHolder) convertView.getTag();
        }


        holder.entryName.setText(list.get(position).getName());
        //cut the  equal sign
        holder.entryDesc.setText(list.get(position).getMeaning().substring(1));
        holder.entryFavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> namList = new ArrayList<>();
                namList.add(list.get(position).getName() + list.get(position).getMeaning());
                sv.saveNames(view.getContext(), namList, sv.NAMES_LIST);
            }
        });

        return convertView;
    }
}
