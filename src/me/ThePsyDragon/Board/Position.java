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
	public Position(int x, int y){
		X = x;
		Y = y;
	}
	public int getX(){
		return X;
	}
	public int getY(){
		return Y;
	}
	public void setX(int x){
		X = x;
		if(X == 0){
			X = 1;
		}
	}
	public void setY(int y){
		Y = y;
		if(Y == 0){
			Y = 1;
		}
	}
}
