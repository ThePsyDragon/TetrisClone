package me.ThePsyDragon.Board;

import java.io.File;

import me.ThePsyDragon.TetrisClone.GameObject;

public class Background extends GameObject{
	//Static
	  //Variables
	    //Backgrounds
	      public static String Background1 = "gfx" + File.separator + "Backgrounds" + File.separator + "Background1";
	    //Current Background
	      public static String CurrentBackground = Background1;
	//Constructor
	public Background() {
		super(new Position(0,640), new Position(800, 640), new Position(0,0), new Position(800,0), GameObject.Background_Priority, CurrentBackground);
	}
}
