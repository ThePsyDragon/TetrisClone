package me.ThePsyDragon.Board;

import java.io.File;

import me.ThePsyDragon.TetrisClone.GameObject;

public class GameField extends GameObject{
	//Static Variables
	  //Array of all Tiles; X,Y
    public static Tiles[][] Tiles = new Tiles[10][20];
    //Corners of Game Field
    public static Position TLCorner = new Position(50,450);
    public static Position TRCorner = new Position(350,450);
    public static Position BRCorner = new Position(350,30);
    public static Position BLCorner = new Position(50,30);
    //Tile Sizes
    public static int TileSize = 30;
    private static String Texture = "gfx" + File.separator + "board";
    
    public GameField() {
		super(TLCorner, TRCorner, BLCorner, BRCorner, Medium_Priority, Texture);
	}
	
}
