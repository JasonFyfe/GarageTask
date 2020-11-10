package com.qa.qacommunity.garagetask;

import java.util.UUID;

public abstract class Vehicle
{
    private String id;
    private String ownerName;
    private VEHICLE_TYPE vehicleType;
    private int repairCost;

    protected enum VEHICLE_TYPE
    {
        CAR, MOTORBIKE, VAN
    }

    public Vehicle(String ownerName, VEHICLE_TYPE vehicleType)
    {
        this.id = UUID.randomUUID().toString().substring(0, 6);
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public String getId()
    {
        return id;
    }

    public String getOwnerName()
    {
        return ownerName;
    }

    public VEHICLE_TYPE getVehicleType()
    {
        return vehicleType;
    }

    public int getRepairCost() { return repairCost; }

    public void setRepairCost(int repairCost) { this.repairCost = repairCost; }

}
