package lab4;

import javafx.css.converter.LadderConverter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Compulsory {
    public static void addInMapResident( Map<Resident, List<Hospital>> residentListMap, Resident resident, List<Hospital> residentPreferences)
    {
        residentListMap.put(resident, residentPreferences);
        resident.setResidentPreferences(residentPreferences);
    }

    public static void addInMapHospital( Map<Hospital, List<Resident>> hospitalListMap, Hospital hospital, List<Resident> hospitalPreferences)
    {
        hospitalListMap.put(hospital, hospitalPreferences);
        hospital.setHospitalPreferences(hospitalPreferences);
    }

    public static void main(String[] args) {
        Map<Resident, List<Hospital>> residentListMap = new HashMap<>();
        Map<Hospital, List<Resident>> hospitalListMap = new HashMap<>();

        var r = IntStream.rangeClosed(0, 3).mapToObj(i -> new Resident("R"+i)).toArray(Resident[]::new);
        var h = IntStream.rangeClosed(0, 2).mapToObj(j -> new Hospital("H"+j)).toArray(Hospital[]::new);
        List<Resident> residentList = new ArrayList<Resident>();
        Set<Hospital> hospitalTreeSet = new TreeSet<Hospital>();

        residentList.addAll(Arrays.asList(r));
        List<Resident> sortedResidentList = residentList.stream().sorted(Comparator.comparing(Resident::getName))
                                            .collect(Collectors.toList());
        h[0].setCapacity(1);
        h[1].setCapacity(2);
        h[2].setCapacity(2);

        hospitalTreeSet.addAll(Arrays.asList(h));

        System.out.println("Lista de rezidenti " + residentList);
        System.out.println();
        System.out.println("Lista de spitale " + hospitalTreeSet);

        //populating the map of residents
        addInMapResident(residentListMap, r[0], Arrays.asList(h[0], h[1], h[2]));
        addInMapResident(residentListMap, r[1], Arrays.asList(h[0], h[1], h[2]));
        addInMapResident(residentListMap, r[2], Arrays.asList(h[0], h[1]));
        addInMapResident(residentListMap, r[3], Arrays.asList(h[0], h[2]));

        System.out.println("\nMAP residents" + residentListMap );

        addInMapHospital(hospitalListMap, h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        addInMapHospital(hospitalListMap, h[1], Arrays.asList(r[0], r[2], r[1]));
        addInMapHospital(hospitalListMap, h[2], Arrays.asList(r[0], r[1], r[3]));

        System.out.println("\nMAP hospitals" + hospitalListMap);

        //collecting the residents who accept H0 and H2
        List<Hospital> target = Arrays.asList(h[0], h[2]);

        List<Resident> result = residentList.stream()
                .filter(res -> residentListMap.get(res).containsAll(target))
                .collect(Collectors.toList());

        System.out.println("\nResidents who accespt H0 and H2" + result);

        System.out.println("\nHospitals that have R0 as their top preference:");
        hospitalTreeSet.stream()
                .filter(res -> hospitalListMap.get(res).get(0).equals(r[0]))
                .forEach(System.out :: println);


    }
}
