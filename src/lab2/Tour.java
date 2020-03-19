package lab2;

import java.util.ArrayList;
import java.util.List;

public class Tour {
    private Depot startDepot;
    private List<Client> tour = new ArrayList<Client>();

    public Depot getStartDepot() {
        return startDepot;
    }

    public void setStartDepot(Depot startDepot) {
        this.startDepot = startDepot;
    }

    public List<Client> getTour() {
        return tour;
    }

    public void setTour(List<Client> tour) {
        this.tour = tour;
    }

    public void addTour(Client newClient)
    {
        this.tour.add(newClient);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "startDepot=" + startDepot +
                ", tour=" + tour +
                '}';
    }
}
