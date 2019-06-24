package com.example.matagaruda.Models;

public class Events {
    int id;
    String time;
    String signature_id;
    String alert_message;
    String ip_source;
    String ip_destination;
    String sensor;
    String protocol;
    int attacker_port;
    int attacked_port;

    public Events(int id, String time, String signature_id, String alert_message, String ip_source, String ip_destination, String sensor, String protocol, int attacker_port, int attacked_port) {
        this.id = id;
        this.time = time;
        this.signature_id = signature_id;
        this.alert_message = alert_message;
        this.ip_source = ip_source;
        this.ip_destination = ip_destination;
        this.sensor = sensor;
        this.protocol = protocol;
        this.attacker_port = attacker_port;
        this.attacked_port = attacked_port;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSignature_id() {
        return signature_id;
    }

    public void setSignature_id(String signature_id) {
        this.signature_id = signature_id;
    }

    public String getAlert_message() {
        return alert_message;
    }

    public void setAlert_message(String alert_message) {
        this.alert_message = alert_message;
    }

    public String getIp_source() {
        return ip_source;
    }

    public void setIp_source(String ip_source) {
        this.ip_source = ip_source;
    }

    public String getIp_destination() {
        return ip_destination;
    }

    public void setIp_destination(String ip_destination) {
        this.ip_destination = ip_destination;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getAttacker_port() {
        return attacker_port;
    }

    public void setAttacker_port(int attacker_port) {
        this.attacker_port = attacker_port;
    }

    public int getAttacked_port() {
        return attacked_port;
    }

    public void setAttacked_port(int attacked_port) {
        this.attacked_port = attacked_port;
    }
}
