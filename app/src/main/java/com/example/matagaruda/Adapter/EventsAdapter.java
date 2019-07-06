package com.example.matagaruda.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.matagaruda.Models.Events;
import com.example.matagaruda.R;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsViewHolder> {
    private Context context;
    private List<Events> events;

    public EventsAdapter(Context context, List<Events> events) {
        this.context = context;
        this.events = events;
    }

    public EventsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_events_item, viewGroup, false);
        return new EventsViewHolder(view);
    }

    public void onBindViewHolder(EventsAdapter.EventsViewHolder holder, int position) {
        if (events != null) {
            final Events event = events.get(position);
            holder.time.setText(""+event.getDay() + "-" + event.getMonth() + "-" + event.getDay() + " " + event.getHour() + ":" + event.getMinute() + ":" + event.getSecond());
            holder.signature.setText(""+event.getSigGen());
            holder.alert.setText(""+event.getAlertMsg());
            holder.ipSrc.setText(""+event.getSrcIp());
            holder.ipDst.setText(""+event.getDestIp());
            holder.sensor.setText(""+event.getDeviceId());
            holder.protocol.setText(""+event.getProtocol());
            holder.attacker_port.setText(""+event.getSrcPort());
            holder.attacked.setText(""+event.getDestPort());
        }
    }

    @Override
    public int getItemCount() {
        if (events == null)
            return 0;
        else {
            return events.size();
        }
    }

    static class EventsViewHolder extends RecyclerView.ViewHolder {
        TextView alert, ipSrc, ipDst, protocol, time, signature, sensor, attacker_port, attacked;

        public EventsViewHolder(View convertView) {
            super(convertView);
            time = (TextView) convertView.findViewById(R.id.time);
            signature = (TextView) convertView.findViewById(R.id.signatureId);
            alert = (TextView) convertView.findViewById(R.id.alertMessage);
            ipSrc = (TextView) convertView.findViewById(R.id.ipSource);
            ipDst = (TextView) convertView.findViewById(R.id.ipDestination);
            sensor = (TextView) convertView.findViewById(R.id.sensor);
            protocol = (TextView) convertView.findViewById(R.id.protocol);
            attacker_port = (TextView) convertView.findViewById(R.id.attacker);
            attacked = (TextView) convertView.findViewById(R.id.attacked);
        }
    }
}
