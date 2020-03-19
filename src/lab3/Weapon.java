package lab3;

public class Weapon implements Item{
    public enum WeaponType{
       SWORD;
    }

    private WeaponType type; //name
    private double weight;
    private double value;

    public Weapon(WeaponType type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return type.name();
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "type=" + type +
                ", weight=" + weight +
                ", value=" + value +
                '}';
    }
}
