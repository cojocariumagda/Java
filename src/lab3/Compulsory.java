package lab3;

public class Compulsory {
    public static void main(String[] args) {
        Problem problem = new Problem();
        //problem.setCapacity(10);
        Knapsack knapsack = new Knapsack();
        knapsack.setCapacity(10);

        problem.setKnapsack(knapsack);


        Book item1 = new Book("Dragon Rising");


        item1.setPageNumber(3);
        item1.setValue(5);

        problem.addItem(item1);

        Book item2 = new Book("A Blade in the Dark");


        item2.setPageNumber(3);
        item2.setValue(5);

        problem.addItem(item2);

        Food item3 = new Food("Cabbage");

        item3.setWeight(2);
        item3.setValue(4);

        problem.addItem(item3);

        Food item4 = new Food("Rabbit");

        item4.setWeight(2);
        item4.setValue(4);

        problem.addItem(item4);

        Weapon item5 = new Weapon(Weapon.WeaponType.SWORD);
        item5.setWeight(5);
        item5.setValue(10);

        problem.addItem(item5);

        System.out.println(problem);

        //Optional

        GreedyAlg resolve = new GreedyAlg();

        resolve.run(problem);

        System.out.println(problem.getKnapsack());


    }
}
