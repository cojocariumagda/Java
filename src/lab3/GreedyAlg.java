package lab3;

import java.util.Comparator;
import java.util.List;

public class GreedyAlg implements Algorithm{

    public void sortItemsByValue(List<Item>  listItems)
    {
        java.util.Collections.sort(listItems, new Comparator<Item>() {
            @Override
            public int compare(Item item, Item t1) {
                return Double.compare(t1.getWeight(), item.getWeight());
            }
        });
    }
    @Override
    public void run(Problem problem) {
        Knapsack knapsack = new Knapsack();
        knapsack.setCapacity(problem.getKnapsack().getCapacity());
        sortItemsByValue(problem.getListItems());
        int currentWeight = 0, currentItem = 0;
        while (currentWeight < problem.getKnapsack().getCapacity() && currentItem!=problem.getListItems().size()-1)
        {
            if (currentWeight + problem.getListItems().get(currentItem).getWeight() > knapsack.getCapacity())
            {
                currentItem++;
            }
            else
            {
                knapsack.addItem(problem.getListItems().get(currentItem));
                currentWeight += problem.getListItems().get(currentItem).getWeight();
                currentItem++;
            }
        }
        problem.setKnapsack(knapsack);
    }
}
