package com.qa.qacommunity.garagetask;

import java.util.List;
import java.util.ArrayList;

public class Garage
{
    public List<Vehicle> allVehicles = new ArrayList<>();
    public Vehicle selectedVehicle;

    public void addVehicle(Vehicle vehicle)
    {
        allVehicles.add(vehicle);
    }

    public void removeVehicle()
    {
        allVehicles.remove(selectedVehicle);
    }

    public void calculateBill()
    {
        switch (selectedVehicle.getVehicleType())
        {
            case CAR:
            {
                selectedVehicle.setRepairCost(200);
            }
            case MOTORBIKE:
            {
                selectedVehicle.setRepairCost(25*5);
            }
            case VAN:
            {
                selectedVehicle.setRepairCost(1000/5);
            }
        }
    }

    public void calculateAllBills()
    {
        for (Vehicle v : allVehicles)
        {
            selectedVehicle = v;
            calculateBill();
        }
    }

    public void emptyGarage()
    {
        allVehicles.removeAll(allVehicles);
    }

    public String getIDByCustomerName(String name)
    {
        for (Vehicle v : allVehicles)
        {
            if (v.getOwnerName().equals(name))
            {
                return v.getId();
            }
        }
        return "######";
    }

    public void setVehicleByID(String id)
    {
        for (Vehicle v : allVehicles)
        {
            if (v.getId().equals(id))
            {
                selectedVehicle = v;
            }
        }
    }
}








