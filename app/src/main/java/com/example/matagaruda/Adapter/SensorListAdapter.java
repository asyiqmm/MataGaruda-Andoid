package com.example.matagaruda.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.matagaruda.Models.Sensor;
import com.example.matagaruda.R;

import java.util.List;

public class SensorListAdapter extends RecyclerView.Adapter<SensorListAdapter.SensorViewHolder> {
    private Context context;
    private List<Sensor> sensors;

    public SensorListAdapter(Context context, List<Sensor> sensors){
        this.context = context;
        this.sensors = sensors;
    }

    public SensorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_sensor_item,viewGroup,false);
        return new SensorViewHolder(view);
    }

    public void onBindViewHolder (SensorListAdapter.SensorViewHolder holder, int position){
        if (sensors != null){
            final Sensor sensor = sensors.get(position);
            holder.txtDevice_id.setText("Device ID: "+sensor.getDeviceId());
            holder.txtDeviceName.setText("Device Name: "+sensor.getDeviceName());
            holder.txtHostname.setText("Hostname: "+sensor.getHostname());
            holder.txtLokasi.setText("Location: "+sensor.getLocation());
            holder.txtSensor_Key.setText("Sensor Key: "+sensor.getSensorKey());
        }
    }
    @Override
    public int getItemCount() {
        if (sensors == null)
            return 0;
        else {
            return sensors.size();
        }
    }
    public class SensorViewHolder extends RecyclerView.ViewHolder {
        TextView txtDevice_id, txtDeviceName,txtHostname, txtLokasi, txtSensor_Key;
        public SensorViewHolder(View itemView){
            super(itemView);
            txtDevice_id = (TextView) itemView.findViewById(R.id.txtDeviceId);
            txtDeviceName = (TextView) itemView.findViewById(R.id.txtDeviceName);
            txtHostname = (TextView) itemView.findViewById(R.id.txtHostname);
            txtLokasi = (TextView) itemView.findViewById(R.id.txtLokasi);
            txtSensor_Key = (TextView) itemView.findViewById(R.id.txtSensorKey);

        }
    }
}
