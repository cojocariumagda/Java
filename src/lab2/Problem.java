package lab2;

import java.util.ArrayList;
import java.util.List;

public class Problem {
    public List<Depot> listDepots= new ArrayList<Depot>();
    public List<Client> listClients = new ArrayList<Client>();

    public Problem() {
    }

    public void addDepot(Depot newDepot)
    {
        if(listDepots.contains(newDepot))
            System.out.println("Depot " + newDepot.getName() + " already exists");
        else
            listDepots.add(newDepot);
    }

    public void addClient(Client newClient)
    {
        if(listClients.contains(newClient))
            System.out.println("Client " + newClient.getName() + "already exists");
        else
            listClients.add(newClient);
    }

    public List<Vehicle> getVehicles()
    {
        List<Vehicle> listVehicle = new ArrayList<Vehicle>();
        for(Depot tempDepot : listDepots)
        {
            listVehicle.addAll(tempDepot.getListVehicle());
        }
        return listVehicle;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "listDepots=" + listDepots +
                ", listClients=" + listClients +
                '}';
    }

}
