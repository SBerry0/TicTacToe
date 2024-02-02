/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */
import java.awt.*;
public class Square {

    private Image marker;
    private int x;
    private int y;
    private boolean isWinningSquare;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param x the row the square is in
     * @param y the column the square is in
     */
    public Square(int x, int y) {
        this.x = x;
        this.y = y;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public Image getMarker() {
        return this.marker;
    }

    public void setMarker(Image marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }


    public void draw(Graphics g, TicTacToeViewer window) {
        g.setColor(Color.black);
        g.drawRect(x, y, TicTacToe.SIDE_LENGTH, TicTacToe.SIDE_LENGTH);
        if (isWinningSquare) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, TicTacToe.SIDE_LENGTH, TicTacToe.SIDE_LENGTH);
        }
        g.drawImage(marker, x, y, TicTacToe.SIDE_LENGTH, TicTacToe.SIDE_LENGTH, window);
    }

    /**
     * @return the marker for the square
     */
    public String toString(TicTacToeViewer window) {
        return this.marker.getHeight(window) == 400 ? "O" : this.marker.getHeight(window) == 1000 ? "" : "X";
    }
}
