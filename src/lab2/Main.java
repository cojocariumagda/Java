package lab2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Depot d1 = new Depot("D1");
        Depot d2 = new Depot("D2");

        /*Vehicle v1 = new Vehicle("V1", Vehicle.VehicleType.BUS);
        Vehicle v2 = new Vehicle("V2", Vehicle.VehicleType.TRUCK);
        Vehicle v3 = new Vehicle("V3", Vehicle.VehicleType.DRONE);*/

        Client c1 = new Client("C1", 1);
        Client c2 = new Client("C3", 2);
        Client c3 = new Client("C2", 1);
        Client c4 = new Client("C4", 2);
        Client c5 = new Client("C5", 3);

       /* Vehicle v4 = new Vehicle("V4", Vehicle.VehicleType.CAR);
        Vehicle v5 = new Vehicle("V4", Vehicle.VehicleType.DRONE);*/

       /*Vehicle v1 = new Car("Car1");
       Vehicle v2 = new Truck("Truck2");
       Vehicle v3 = new Drone("Drone3");
       Vehicle v4 = new Car("Car4");
       Vehicle v5 = new Drone("Drone5");*/
       Vehicle v1 = new Car ("V1 - Car");
       Vehicle v2 = new Truck ("V2 - Truck");
       Vehicle v3 = new Drone ("V3 - Drone");

        /*d1.addVehicle(v1);
        d1.addVehicle(v4);
        d1.addVehicle(v5);

        d2.addVehicle(v2);
        d2.addVehicle(v3);*/

        d1.addVehicle(v1);
        d1.addVehicle(v2);

        d2.addVehicle(v3);

        Problem p1 = new Problem();
        p1.addDepot(d1);
        p1.addDepot(d2);

        p1.addClient(c1);
        p1.addClient(c2);
        p1.addClient(c3);
        p1.addClient(c4);
        p1.addClient(c5);

        Solution s1  = new Solution();
        System.out.println("All the vehicles from all depots are: " + p1.getVehicles());

        for ( Tour currentTour : s1.getSolution(p1))
        {
            System.out.println(currentTour.getStartDepot().getName() + " " + currentTour.getTour());
        }

       /* System.out.println(d1);
        System.out.println(d2);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);*/

    }
}
