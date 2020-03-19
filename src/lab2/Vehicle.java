package lab2;

import java.util.Objects;

public abstract class  Vehicle {

    /*public enum VehicleType{
        CAR, TRUCK, DRONE;
    }*/

    private String name;
    protected String type;

    /*private VehicleType type;

    public Vehicle(String name, VehicleType type) {
        this.name = name;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name = '" + name + "', type = '" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(getName(), vehicle.getName());
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(getName(), getType());
    }*/
}
