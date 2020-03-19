package lab4;

import java.util.*;

public class Resident {
    private String name;
    private List<Hospital> residentPreferences = new ArrayList<Hospital>();


    /*public Map<Resident, List<Hospital>> getResidentListMap() {
        return residentListMap;
    }

    public void setResidentListMap(Map<Resident, List<Hospital>> residentListMap) {
        this.residentListMap = residentListMap;
    }

    public void putResidentListMap(Resident resident, List<Hospital> residentPreferences)
    {

        //this.residentListMap.put(resident, residentPreferences);
        //this.residentListMap.get(resident).add(residentPreferences);
    }*/

    public Resident(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hospital> getResidentPreferences() {
        return residentPreferences;
    }

    public void setResidentPreferences(List<Hospital> residentPreferences) {
        this.residentPreferences = residentPreferences;
    }

    public void addResidentPreferences(Hospital newHospital)
    {
        this.residentPreferences.add(newHospital);
    }

    /*@Override
    public String toString() {
        return "\nResident{" +
                "name='" + name + '\'' +
                ", residentPreferences=" + residentPreferences +
                ", residentListMap=" + residentListMap +
                '}' ;
    }*/

    @Override
    public String toString() {
        return "Resident{" +
                "name='" + name + '\'' + '}' ;
    }
}
