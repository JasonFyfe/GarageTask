package com.qa.qacommunity.garagetask;

public class Car extends Vehicle
{
    private CAR_TYPE carType;

    protected enum CAR_TYPE
    {
        HATCHBACK, SALOON, ESTATE
    }

    // Constructors
    public Car(String ownerName, CAR_TYPE carType)
    {
        super(ownerName, VEHICLE_TYPE.CAR);
        this.carType = carType;
    }

    // Getters
    public CAR_TYPE getCarType()
    {
        return carType;
    }
}
