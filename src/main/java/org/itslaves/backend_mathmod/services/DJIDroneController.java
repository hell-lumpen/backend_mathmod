package org.itslaves.backend_mathmod.services;

import org.itslaves.backend_mathmod.utils.Point;
import org.springframework.stereotype.Service;

@Service
public class DJIDroneController implements IDroneController {
    @Override
    public void takeoff() {

    }

    @Override
    public void flyTo(Point point) {

    }

    @Override
    public void takePhoto() {

    }

    @Override
    public void startRecord() {

    }

    @Override
    public void stopRecord() {

    }

    @Override
    public void land() {

    }

    @Override
    public Point getCurrentPosition() {
        return null;
    }

    @Override
    public float getCurrentAltitude() {
        return 0;
    }

    @Override
    public int getFlightTimeRemaining() {
        return 0;
    }

    @Override
    public int getBatteryLevel() {
        return 0;
    }

    @Override
    public String getStatus() {
        return null;
    }
}
