package com.example.matagaruda.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.matagaruda.Models.Events;
import com.example.matagaruda.R;

import java.util.List;

public class EventsAdapter extends ArrayAdapter<Events> {
    List<Events> listEvents;
    Context context;
    int layout;
    public EventsAdapter(Context context, int layout, List<Events> listEvents){
        super(context,layout,listEvents);
        this.context=context;
        this.layout=layout;
        this.listEvents=listEvents;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        EventsHolder holder;
        if (v == null){
            LayoutInflater vi=((Activity)context).getLayoutInflater();
            v=vi.inflate(layout,parent,false);
            holder = new EventsHolder();
            holder.id=(TextView) v.findViewById(R.id.ipSource);
            holder.time=(TextView) v.findViewById(R.id.time);
            holder.signature = (TextView) v.findViewById(R.id.signatureId);
            holder.sensor = (TextView) v.findViewById(R.id.sensor);
            holder.attacker_port = (TextView) v.findViewById(R.id.attacker);
            holder.attacked = (TextView) v.findViewById(R.id.attacked);
            v.setTag(holder);
        }else {
            holder=(EventsHolder) v.getTag();
        }
        Events events = listEvents.get(position);
        holder.id.setText(String.valueOf(events.getId()));
        holder.time.setText(events.getTime());
        holder.signature.setText(events.getSignature_id());
        holder.sensor.setText(events.getSensor());
        holder.attacker_port.setText(String.valueOf(events.getAttacker_port()));
        holder.attacked.setText(String.valueOf(events.getAttacked_port()));
        return v;
    }
    static class EventsHolder{
        TextView id;
        TextView time;
        TextView signature;
        TextView sensor;
        TextView attacker_port;
        TextView attacked;
    }
}
