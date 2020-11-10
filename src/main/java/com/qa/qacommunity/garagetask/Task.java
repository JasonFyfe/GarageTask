package com.qa.qacommunity.garagetask;

import java.util.Scanner;

public class Task
{
    private static Garage garage = new Garage();

    public static void start()
    {
        menu();
    }

    private static void menu()
    {
        int menuSelection = 0;
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        while (menuSelection != 6)
        {
            System.out.println(garage.allVehicles.size());
            System.out.println("Please select from the following:");
            System.out.println("1. Book in Vehicle");
            System.out.println("2. Generate Bill for Customer");
            System.out.println("3. Book out Vehicle");
            System.out.println("4. Generate all Bills");
            System.out.println("5. Remove all Vehicles");
            System.out.println("6. Exit Application");

            menuSelection = sc.nextInt();

            switch (menuSelection)
            {
                case 1:
                {
                    addVehicle();
                    break;
                }
                case 2:
                {
                    System.out.println("What is the customer's name?");
                    String name = sc.next();
                    garage.setVehicleByID(garage.getIDByCustomerName(name));
                    garage.calculateBill();
                    System.out.println("Repair Cost: " + garage.selectedVehicle.getRepairCost());
                    break;
                }
                case 3:
                {
                    System.out.println("What is the customer's name?");
                    String name = sc.next();
                    garage.setVehicleByID(garage.getIDByCustomerName(name));
                    garage.removeVehicle();
                    break;
                }
                case 4:
                {
                    garage.calculateAllBills();
                    for (Vehicle v : garage.allVehicles)
                    {
                        System.out.println("Owner: " + v.getOwnerName() + " Cost: " + v.getRepairCost());
                    }
                    break;
                }
                case 5:
                {
                    garage.emptyGarage();
                    break;
                }
                case 6:
                {
                    break;
                }
            }
        }

    }

    private static void addVehicle()
    {
        Scanner scanner = new Scanner(System.in);
        String customerName;
        int vehicleType;
        Car.CAR_TYPE carType;
        Motorbike.MANUFACTURER manufacturer;

        System.out.println("What is the customer's name?");
        customerName = scanner.nextLine();

        System.out.println("What is the type of vehicle?");
        System.out.println("1. Car");
        System.out.println("2. Motorbike");
        System.out.println("3. Van");
        vehicleType = scanner.nextInt();

        switch (vehicleType)
        {
            case 1:
            {
                System.out.println("What type of car?");
                System.out.println("1. Hatchback");
                System.out.println("2. Saloon");
                System.out.println("3. Estate");
                int select = scanner.nextInt();

                if (select == 1)
                {
                    carType = Car.CAR_TYPE.HATCHBACK;
                }
                else if (select == 2)
                {
                    carType = Car.CAR_TYPE.SALOON;
                }
                else
                {
                    carType = Car.CAR_TYPE.ESTATE;
                }
                addCar(customerName, carType);
                break;
            }
            case 2:
            {
                System.out.println("What make of bike?");
                System.out.println("1. Yamaha");
                System.out.println("2. Mitsubishi");
                System.out.println("3. Honda");
                int select = scanner.nextInt();

                if (select == 1)
                {
                    manufacturer = Motorbike.MANUFACTURER.YAMAHA;
                }
                else if (select == 2)
                {
                    manufacturer = Motorbike.MANUFACTURER.MITSUBISHI;
                }
                else
                {
                    manufacturer = Motorbike.MANUFACTURER.HONDA;
                }
                addMotorbike(customerName, manufacturer);
                break;
            }
            case 3:
            {
                System.out.println("What is the weight capacity of the Van?");
                int weight = scanner.nextInt();
                addVan(customerName, weight);
                break;
            }
        }
    }

    private static void addCar(String name, Car.CAR_TYPE carType)
    {//name, carType
        garage.addVehicle(new Car(name, carType));
    }

    private static void addMotorbike(String name, Motorbike.MANUFACTURER manufacturer)
    {//name, manufacturer
        garage.addVehicle(new Motorbike(name, manufacturer));
    }

    private static void addVan(String name, int weight)
    {//name, weightCapacity
        garage.addVehicle(new Van(name, weight));
    }
}
