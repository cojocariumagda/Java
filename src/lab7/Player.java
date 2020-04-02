package lab7;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable{
    private String name;
    private int ID;
    private List<Token> tokenListPlayer = new ArrayList<>();
    private Board board;

    public Player(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public void run() {
        while(board.getNumberOfTokens()!=0)
        {
            try
            {
                Token extractedToken = board.getToken();
                tokenListPlayer.add(extractedToken);
                System.out.println("Playerul " + name + " cu ID-ul " + ID + " a extras tokenul " + extractedToken.getValueToken());
            }
            catch (NullPointerException e)
            {
                System.out.println(e.toString());
                System.out.println("Problem on the board");
            }
        }
    }
}
