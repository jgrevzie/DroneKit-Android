package org.droidplanner.core.drone.variables;

import org.droidplanner.core.drone.DroneInterfaces.DroneEventsType;
import org.droidplanner.core.drone.DroneVariable;
import org.droidplanner.core.model.Drone;

public class MissionStats extends DroneVariable {
    private double distanceToWp = 0;
    private short currentWP = -1;

    public MissionStats(Drone myDrone) {
        super(myDrone);
    }

    public void setDistanceToWp(double disttowp) {
        this.distanceToWp = disttowp;
    }

    public void setWpno(short seq) {
        if (seq != currentWP) {
            this.currentWP = seq;
            myDrone.notifyDroneEvent(DroneEventsType.MISSION_WP_UPDATE);
        }
    }

    public int getCurrentWP() {
        return currentWP;
    }

    public double getDistanceToWP() {
        return distanceToWp;
    }

}
