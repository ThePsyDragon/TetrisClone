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
@SuppressWarnings("unused")
public class Tiles extends GameObject{
		//Global Variables
	  //Static
	    //Public
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
	      private static String OBlockTex = "OBlock";
	      private static String TBlockTex = "TBlock";
	      private static String SBlockTex = "SBlock";
	      private static String ZBlockTex = "ZBlock";
	      private static String IBlockTex = "IBlock";
	      private static String JBlockTex = "JBlock";
	      private static String LBlockTex = "LBlock";
	      private static String EmptyTex = "EmptyBlock";
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
	    			GameField.Tiles[i][k].Draw();
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
