package com.qa.qacommunity.garagetask;

public class Van extends Vehicle
{
    private int weightCapacity;

    public Van(String ownerName, int weightCapacity)
    {
        super(ownerName, VEHICLE_TYPE.VAN);
        this.weightCapacity = weightCapacity;
    }

    public int getWeightCapacity() { return weightCapacity; }
}
