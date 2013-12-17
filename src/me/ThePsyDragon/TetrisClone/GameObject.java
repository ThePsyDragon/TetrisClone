package me.ThePsyDragon.TetrisClone;

import org.lwjgl.opengl.GL11.*;
/*
 * Description:
 *   Base class for all rendered objects in the program.
 *   Non-Static:
 *     Functions:
 *       - Draw()
 *       - getCorners()
 *       - setCorners()
 *       - getPriority()
 *       - setPriority()
 *     Attributes:
 *       - Texture
 *       - Corner Co-ords
 *       - Draw Priority
 *   Static:
 *     Attributes:
 *       - Priorities
 */
public class GameObject {
	//Global Variables
	//Static Priorities
	public static int Ultra_Priority = 0;
	public static int Background_Priority = 10;
	public static int High_Priority = 20;
	public static int Medium_Priority = 30;
	public static int Low_Priority = 40;
	public static int Final_Priority = 50;
	//Quad Corners
	private int TLCorner = 0;
	private int TRCorner = 0;
	private int BLCorner = 0;
	private int BRCorner = 0;
	//Object Texture
	private String Texture = "";
	//Priority
	private int Priority;
	//Constructor
	public GameObject(int tlcorner, int trcorner, int blcorner, int brcorner, int priority, String texture){
		TLCorner = tlcorner;
		TRCorner = trcorner;
		BRCorner = brcorner;
		BLCorner = blcorner;
		Priority = priority;
		Texture = texture;
	}
	
	//Draw
	public void Draw(){
		//glBegin(GL_QUADS);
		
	}
	
	//getPriority
	public int getPriority(){
		return Priority;
	}
	
	//getCorners
	public int getTLCorner(){
		return TLCorner;
	}
	public int getTRCorner(){
		return TRCorner;
	}
	public int getBLCorner(){
		return BLCorner;
	}
	public int getBRCorner(){
		return BRCorner;
	}
	//setCorners
	public void setTLCorner(int tlcorner){
		 TLCorner = tlcorner;
	}
	public void setTRCorner(int trcorner){
		TRCorner = trcorner;
	}
	public void setBLCorner(int blcorner){
		BLCorner = blcorner;
	}
	public void setBRCorner(int brcorner){
		BRCorner = brcorner;
	}
	//setPriority
	public void setPriority(int priority){
		Priority = priority;
	}
}