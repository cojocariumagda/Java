package lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hospital implements Comparable<Hospital>{
    private String name;
    private Integer capacity;
    private List<Resident> hospitalPreferences = new ArrayList<Resident>();
    Map<Hospital, List<Resident>> hospitalListMap = new HashMap<>();

    public Hospital(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Resident> getHospitalPreferences() {
        return hospitalPreferences;
    }

    public void setHospitalPreferences(List<Resident> hospitalPreferences) {
        this.hospitalPreferences = hospitalPreferences;
    }

    public void addHospitalPreferences(Resident newResident)
    {
        this.hospitalPreferences.add(newResident);
    }

    public Map<Hospital, List<Resident>> getHospitalListMap() {
        return hospitalListMap;
    }

    public void setHospitalListMap(Map<Hospital, List<Resident>> hospitalListMap) {
        this.hospitalListMap = hospitalListMap;
    }

    public void putHospitalListMap(Map<Hospital, List<Resident>> hospitalListMap, Hospital hospital, List<Resident> hospitalPreferences)
    {
        hospitalListMap.put(hospital, hospitalPreferences);
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public int compareTo(Hospital hospital) {
        return name.compareTo(hospital.name);
    }
}
