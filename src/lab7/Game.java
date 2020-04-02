package lab7;

public class Game {
    public static void main(String[] args) {
        Player player1 = new Player("Gigi", 20);
        Player player2 = new Player("Magda", 25);
        Player player3 = new Player("Nicoleta", 30);
        Board board = new Board();
        board.setNumberOfTokens(10);
        board.setNumberOfPlayers(4);
        board.setMaxValueOfToken(7);

        int numberOfPlayers = board.getNumberOfPlayers();
        int numberOfTokens = board.getNumberOfTokens();
        int maxToken = board.getMaxValueOfToken();

        //create tokens for board
        for (int counter = 1; counter <= numberOfTokens; counter++)
        {
            Token currentToken = new Token();
            if (counter<=maxToken)
            {
                currentToken.setValueToken(counter);
            }
            else
            {
                currentToken.setValueToken(0);
            }
            board.addToken(currentToken);
        }

        System.out.println("A inceput jocul");
        player1.setBoard(board);
        player2.setBoard(board);
        player3.setBoard(board);
        new Thread(player1).start();
        new Thread(player2).start();
        new Thread(player3).start();

    }


}
