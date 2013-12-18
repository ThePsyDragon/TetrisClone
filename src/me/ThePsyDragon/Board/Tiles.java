package me.ThePsyDragon.Board;

import me.ThePsyDragon.TetrisClone.GameObject;

/*
Description: 
  Static
    - Contains an ArrayList representing each game board tile.
    - Enumeration of Tile Types
    - All Available tile Textures
  Object
    - Object Represents status of a single game board tile
    Attributes
      - Tile Type
      - Tile Texture
    Functions
      - getType()
 */
public class Tiles extends GameObject{
		//Global Variables
	  //Static
	    //Public
	      //Array of all Tiles; X,Y
	      public static Tiles[][] Tiles = new Tiles[10][20];
	      //Enumeration of Tile Types
	      public static int Empty = 1;
	      public static int OBlock = 2;
	      public static int TBlock = 3;
	      public static int SBlock = 4;
	      public static int ZBlock = 5;
	      public static int IBlock = 6;
	      public static int JBlock = 7;
	      public static int LBlock = 8;
	      //Block Textures
	      private static String OBlockTex = "";
	      private static String TBlockTex = "";
	      private static String SBlockTex = "";
	      private static String ZBlockTex = "";
	      private static String IBlockTex = "";
	      private static String JBlockTex = "";
	      private static String LBlockTex = "";
	      private static String EmptyTex = "";
	      //Render Control
	      public static boolean RenderTiles = false;
	  //Non-Static
	    //Private
	      
	  //Constructor
	    public Tiles(Position tlcorner, Position trcorner, Position blcorner, Position brcorner, int priority, String texture) {
	  		super(tlcorner, trcorner, blcorner, brcorner, priority, texture);
	  	}
	    
	  //Draw All Tiles
	    public static void DrawAll(){
	    	for(int i = 0; i<10;i++){
	    		for(int k = 0; k<20;k++){
	    			Tiles[i][k].Draw();
	    		}
	    	}
	    }
	  //Initialize
	    public static void Initialize(){
	    	for(int i = 0; i<10;i++){
	    		for(int k = 0; k<20;k++){
	    			//Tiles[i][k] = new Tiles(tlcorner,trcorner,blcorner,brcorner,priority,texture);
	    		}
	    	}
	    }
}
