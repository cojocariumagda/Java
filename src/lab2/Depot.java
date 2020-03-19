package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Depot {
    private String name;
    private List<Vehicle> listVehicle = new ArrayList<Vehicle>();
    private boolean used = false;

    public Depot(String name) {
        this.name = name;
    }


    public List<Vehicle> getListVehicle() {
        return listVehicle;
    }

    public void addVehicle(Vehicle newVehicle) {
        if (listVehicle.contains(newVehicle))
            System.out.println("Vehicle " + newVehicle.getName() + " already exists in " + this.name);
        else
            listVehicle.add(newVehicle);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Depot{" +
                "name='" + name + '\'' + "listOfVehicles='" + listVehicle +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        //if the object is compared with itself then return true
        if (this == o) return true;
        //check if o is an instance of depot or not "null instanceof [type]" return false
        if (!(o instanceof Depot)) return false;
        //typecast o to complex so that we can compare data members
        Depot depot = (Depot) o;
        //compare the data members and return accordingly
        return Objects.equals(getName(), depot.getName()) ||
                Objects.equals(getListVehicle(), depot.getListVehicle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getListVehicle());
    }
}
