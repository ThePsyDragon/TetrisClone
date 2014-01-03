package me.ThePsyDragon.Board;

import java.io.File;
import me.ThePsyDragon.TetrisClone.GameObject;

public class GameField extends GameObject{
	//Static Variables
	  //Array of all Tiles; X,Y
    public static Tiles[][] Tiles = new Tiles[10][20];
    //Corners of Game Field
    public static Position TLCorner = new Position(80,590);
    public static Position TRCorner = new Position(350,590);
    public static Position BRCorner = new Position(350,50);
    public static Position BLCorner = new Position(80,50);
    //Tile Sizes
    private static String Texture = "gfx" + File.separator + "board";
    
    public GameField() {
		super(TLCorner, TRCorner, BLCorner, BRCorner, Medium_Priority, Texture);
	}
}
