package me.ThePsyDragon.Board;

/*Description:
 * Small wrapper for coordinates
 *    Attributes
 *      - X Co-ord
 *      - Y Co-ord
 *    Functions
 *      - getY
 *      - getX
 */
public class Position {
	//Global Variables
	private int X = 0;
	private int Y = 0;
	@SuppressWarnings("unused")
	public Position(int x, int y){
		int X = x;
		int Y = y;
	}
	public int getX(){
		return X;
	}
	public int getY(){
		return Y;
	}
}
