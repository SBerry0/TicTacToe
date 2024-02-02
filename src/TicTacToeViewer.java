import javax.swing.*;
import java.awt.*;
public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class
    private Square[][] board;
    private TicTacToe game;

    public TicTacToeViewer(TicTacToe game) {
        this.game = game;
        this.board = game.getBoard();
        // Setup the window and the buffer strategy.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Knots and Crosses");
        this.setSize(TicTacToe.WINDOW_WIDTH, TicTacToe.WINDOW_HEIGHT);
        this.setVisible(true);
        createBufferStrategy(2);
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(0, 0, TicTacToe.WINDOW_WIDTH, TicTacToe.WINDOW_HEIGHT);
        g.setColor(Color.BLACK);
        for (int i = 0; i < TicTacToe.NUM_ROWS; i++) {
            for (int j = 0; j < TicTacToe.NUM_COLS; j++) {
                board[i][j].draw(g, this);
            }
        }
        for (int i = 0; i < TicTacToe.NUM_COLS; i++) {
            g.drawString(i + "", TicTacToe.STARTING_X_PADDING + TicTacToe.SIDE_LENGTH / 2 +
                                        i*TicTacToe.SIDE_LENGTH - 5, TicTacToe.STARTING_Y_PADDING - 20);
        }
        for (int i = 0; i < TicTacToe.NUM_ROWS; i++) {
            g.drawString(i + "", TicTacToe.STARTING_X_PADDING - 35, TicTacToe.STARTING_Y_PADDING +
                                        TicTacToe.SIDE_LENGTH / 2 + i*TicTacToe.SIDE_LENGTH + 7);
        }
        if (game.getGameOver()) {
            if (game.checkTie()) {
                g.drawString("Tie!", TicTacToe.STARTING_X_PADDING + 3*TicTacToe.SIDE_LENGTH/2,
                                    TicTacToe.STARTING_Y_PADDING + 3*TicTacToe.SIDE_LENGTH + 20);
            } else {
                g.drawImage(game.getWinner(),
                        TicTacToe.STARTING_X_PADDING + TicTacToe.SIDE_LENGTH*3/2 - TicTacToe.SIDE_LENGTH,
                        TicTacToe.STARTING_Y_PADDING + 3*TicTacToe.SIDE_LENGTH + 20,
                        TicTacToe.SIDE_LENGTH/2, TicTacToe.SIDE_LENGTH/2, this);
                g.setFont(new Font("Serif", Font.BOLD, 30));
                g.drawString(" Won!", TicTacToe.STARTING_X_PADDING + TicTacToe.SIDE_LENGTH*3/2 - TicTacToe.SIDE_LENGTH/2,
                        TicTacToe.STARTING_Y_PADDING + 3*TicTacToe.SIDE_LENGTH + TicTacToe.SIDE_LENGTH - 8);
            }
        }
    }
}
