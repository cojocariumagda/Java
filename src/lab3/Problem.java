package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem {
    //private double capacity;
    private Knapsack knapsack = new Knapsack();
    private List<Item> listItems = new ArrayList<Item>();

    /*public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }*/

    public List<Item> getListItems() {
        return listItems;
    }

    public void setListItems(List<Item> listItems) {
        this.listItems = listItems;
    }

    public Knapsack getKnapsack() {
        return knapsack;
    }

    public void setKnapsack(Knapsack knapsack) {
        this.knapsack = knapsack;
    }

    public void addItem(Item newItem)
    {
        if(listItems.contains(newItem))
            System.out.println("Item " + newItem.getName() + "already exists");
        else
            listItems.add(newItem);
    }

    public void sortItems()
    {
        java.util.Collections.sort(listItems, new Comparator<Item>() {
            @Override
            public int compare(Item item, Item t1) {
                return item.getName().compareTo(t1.getName());
            }
        });
    }

    @Override
    public String toString() {
        String items = "";
        sortItems();
        for (int i=0; i<listItems.size(); i++)
        {
            items += listItems.get(i).getName();
            items += ", ";
        }
        return "Problem{" + knapsack +
                ", listItems=" + items +
                '}';
    }
}
