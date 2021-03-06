package org.droidplanner.core.drone;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.droidplanner.core.drone.DroneInterfaces.DroneEventsType;
import org.droidplanner.core.drone.DroneInterfaces.OnDroneListener;
import org.droidplanner.core.model.Drone;

public class DroneEvents extends DroneVariable {

	public DroneEvents(Drone myDrone) {
		super(myDrone);
	}

	private final ConcurrentLinkedQueue<OnDroneListener> droneListeners = new ConcurrentLinkedQueue<OnDroneListener>();

	public void addDroneListener(OnDroneListener listener) {
		if (listener != null & !droneListeners.contains(listener))
			droneListeners.add(listener);
	}

	public void removeDroneListener(OnDroneListener listener) {
		if (listener != null && droneListeners.contains(listener))
			droneListeners.remove(listener);
	}

	public void notifyDroneEvent(DroneEventsType event) {
        if (event != null && !droneListeners.isEmpty()) {
            for (OnDroneListener listener : droneListeners) {
                listener.onDroneEvent(event, myDrone);
            }
        }
	}
}
