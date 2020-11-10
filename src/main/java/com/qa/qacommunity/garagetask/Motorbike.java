package com.qa.qacommunity.garagetask;

public class Motorbike extends Vehicle
{
    private MANUFACTURER manufacturer;

    protected enum MANUFACTURER
    {
        YAMAHA, MITSUBISHI, HONDA
    }

    public Motorbike(String ownerName, MANUFACTURER manufacturer)
    {
        super(ownerName, VEHICLE_TYPE.MOTORBIKE);
        this.manufacturer = manufacturer;
    }

    public MANUFACTURER getManufacturer() { return manufacturer; }
}
