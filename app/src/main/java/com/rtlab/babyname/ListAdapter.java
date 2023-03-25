package com.rtlab.babyname;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> list;
    SaveUtil sv = new SaveUtil();

    public ListAdapter(Context context, ArrayList<String> list) {
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

    static class ViewHolder{

        TextView name;
        Button copy;
        ImageView delete;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.favrows2, null);

            holder.name = (TextView) convertView.findViewById(R.id.favNameTextView);
            //added
            final ViewHolder finalHolder = holder;
            holder.name.setOnClickListener(new View.OnClickListener() {
                boolean started = false;
                @Override
                public void onClick(View view) {
                    if(!started){
                        finalHolder.name.setSelected(true);
                        started = true;
                    }else {
                        finalHolder.name.setSelected(false);
                        started = false;
                    }
                }
            });
            //added
            holder.copy = convertView.findViewById(R.id.copyFavBtn);
            holder.copy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClipboardManager clipboard = (ClipboardManager) view.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = null;
                    clip = ClipData.newPlainText("meta", finalHolder.name.getText().toString());
                    clipboard.setPrimaryClip(clip);
                }
            });
            //
            holder.delete = (ImageView) convertView.findViewById(R.id.deleteImageView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }


        holder.name.setText(list.get(position));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(position);
                sv.replaceNames(view.getContext(), list, sv.NAMES_LIST);
                notifyDataSetChanged();

            }
        });


        return convertView;
    }
}

