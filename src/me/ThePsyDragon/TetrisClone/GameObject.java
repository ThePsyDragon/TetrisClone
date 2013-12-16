package me.ThePsyDragon.TetrisClone;
/*
 * Description:
 *   Base class for all rendered objects in the program.
 *   Public:
 *     Functions:
 *       - Draw()
 *     Attributes:
 *       - Texture
 *       - Corner Co-ords
 */
public class GameObject {
	//Global Variables
	private int TLCorner = 0;
	private int TRCorner = 0;
	private int BLCorner = 0;
	private int BRCorner = 0;
	private String Texture = "";
	
	//Constructor
	public GameObject(int tlcorner, int trcorner, int blcorner, int brcorner, String texture){
		TLCorner = tlcorner;
		TRCorner = trcorner;
		BRCorner = brcorner;
		BLCorner = blcorner;
		Texture = texture;
	}
	
	//Draw
	
}