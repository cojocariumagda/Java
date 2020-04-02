package lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private List<Token> tokensList = new ArrayList<>();
    private int numberOfTokens;
    private int numberOfPlayers;
    private int maxValueOfToken;
    private boolean avaible = false;

    public synchronized Token getToken() {
        /*while (!avaible)
        {
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        avaible = false;
        notifyAll();*/
        Random rand = new Random();
        try{
            int numberRandom = rand.nextInt(numberOfTokens);
            Token currentToken = tokensList.get(numberRandom);
            tokensList.remove(numberRandom);
            numberOfTokens = tokensList.size();
            return currentToken;
        } catch (NullPointerException e)
        {
            System.out.println("No more token on the board");
            return null;
        }
    }

    public void addToken(Token token) {
        this.tokensList.add(token);
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getNumberOfTokens() {
        return numberOfTokens;
    }

    public void setNumberOfTokens(int numberOfTokens) {
        this.numberOfTokens = numberOfTokens;
    }
    public int getMaxValueOfToken() {
        return maxValueOfToken;
    }

    public void setMaxValueOfToken(int maxValueOfToken) {
        this.maxValueOfToken = maxValueOfToken;
    }

    public List<Token> getTokensList() {
        return tokensList;
    }

}
