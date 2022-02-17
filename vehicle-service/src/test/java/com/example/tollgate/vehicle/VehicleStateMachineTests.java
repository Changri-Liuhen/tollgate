package com.example.tollgate.vehicle;

import com.example.tollgate.model.Vehicle;
import com.example.tollgate.model.VehicleStateMachine;
import org.apache.commons.scxml2.model.ModelException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class VehicleStateMachineTests {

    @Test
    public void testVehicleStateMachineModel() throws ModelException {
        VehicleStateMachine v = new VehicleStateMachine(new Vehicle());
        Arrays.stream(v.getStates()).forEach(System.out::println);
        assert (v.getStates() != null);
    }
}
