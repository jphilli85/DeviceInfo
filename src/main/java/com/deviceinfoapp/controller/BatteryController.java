package com.deviceinfoapp.controller;

import android.content.Context;
import android.content.Intent;

import com.deviceinfoapp.element.Battery;
import com.deviceinfoapp.viewable.Item;
import com.deviceinfoapp.viewable.Item2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jake on 7/18/13.
 */
public class BatteryController extends ActiveElementController implements Battery.Callbacks {

    public interface Callbacks extends ActiveElementController.Callbacks {
        void onReceive(Context context, Intent intent);
    }

    public BatteryController(Context context, BatteryController.Callbacks callbacks) {
        super(context, callbacks);
        mElement = new Battery(context, this);
    }

    @Override
    public List<Item> getData() {
        Battery e = (Battery) mElement;
        int[] actions = new int[] {Battery.ACTION_BATTERY};

        List<Item> data = new ArrayList<Item>();

        data.add(new Item2("Level", e.getLevel() + "/" + e.getLevelMax(), actions));
        data.add(new Item2("Temperature (C)", String.valueOf(e.getTemperature()), actions));
        data.add(new Item2("Status", e.getChargingStatus(), actions));
        data.add(new Item2("Plugged In Status", e.getPluggedInStatus(), actions));
        data.add(new Item2("Voltage (mV)", String.valueOf(e.getVoltage()), actions));
        data.add(new Item2("Technology", e.getTechnology(), actions));
        data.add(new Item2("Health", e.getHealth(), actions));
//        data.add(new Item2("Battery Is Present", String.valueOf(e.isBatteryPresent())));

        return data;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ((Callbacks) mCallbacks).onReceive(context, intent);
    }
}
