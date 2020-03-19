package lab2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {

    private Problem problem;
    private List<Tour> listTours = new ArrayList<Tour>();

    private void sortClients(List<Client> listClients)
    {
        listClients.sort(new Comparator<Client>() {
            @Override
            public int compare(Client client, Client t1) {
                return Integer.compare(client.getTime(), t1.getTime());
            }
        });
    }

    /**
     * @param problem
     * @return
     */
    public Depot getDepotForVehicle (Problem problem, Vehicle vehicle)
    {
        for (Depot currentDepot : problem.listDepots)
        {
            for (Vehicle currentVehicle : currentDepot.getListVehicle())
            {
                if (currentVehicle == vehicle)
                    return currentDepot;
            }
        }
        return null;
    }

    /**
     * @param problem
     * @return
     */
    public List<Tour> getSolution (Problem problem)
    {
        sortClients(problem.listClients);
        int maxTime = problem.listClients.get(problem.listClients.size()-1).getTime();
        int numberVehicles = problem.getVehicles().size();
        for (int currentVehicle = 0; currentVehicle <numberVehicles; currentVehicle++)
        {
            //System.out.println("Vehicle " + problem.getVehicles().get(currentVehicle).getName() + " has this these clients: ");
            Tour currentTour = new Tour();
            List<Client> currentListClient = new ArrayList<Client>();
            currentTour.setStartDepot(getDepotForVehicle(problem, problem.getVehicles().get(currentVehicle)));
            for (int currentTime = 1; currentTime <= maxTime; currentTime++)
            {
                for (Client currentClient : problem.listClients)
                {
                    if (currentClient.getTime() == currentTime && !currentClient.isAssign())
                    {
                        currentListClient.add(currentClient);
                        //System.out.println(currentClient.getName());
                        currentClient.setAssign(true);
                        break;
                    }
                }
            }
            currentTour.setTour(currentListClient);
            listTours.add(currentTour);
        }
        return listTours;
    }
}

