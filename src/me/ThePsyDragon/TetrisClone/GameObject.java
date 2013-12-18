package me.ThePsyDragon.TetrisClone;

import java.io.File;
import java.io.IOException;

import me.ThePsyDragon.Board.Position;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.*;
import org.newdawn.slick.util.ResourceLoader;

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
	// Global Variables
	// Absolute Path
	public static String AbsoluteFilePath;
	// Static Priorities
	public static int Ultra_Priority = 0;
	public static int Background_Priority = 10;
	public static int High_Priority = 20;
	public static int Medium_Priority = 30;
	public static int Low_Priority = 40;
	public static int Final_Priority = 50;
	// Currently Bound Texture
	public static Texture BoundTexture;
	// Quad Corners
	private Position TLCorner;
	private Position TRCorner;
	private Position BLCorner;
	private Position BRCorner;
	// Object Texture

	private Texture Texture;
	// Priority
	private int Priority;

	// Constructor
	public GameObject(Position tlcorner, Position trcorner, Position blcorner,
			Position brcorner, int priority, String texture) {
		TLCorner = tlcorner;
		TRCorner = trcorner;
		BRCorner = brcorner;
		BLCorner = blcorner;
		Priority = priority;
		try {
			Texture = TextureLoader.getTexture("PNG",
					ResourceLoader.getResourceAsStream(AbsoluteFilePath + File.separator + "res" + File.separator + texture + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	// Draw
	public void Draw() {
		if (!BoundTexture.equals(Texture)) {
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, Texture.getTextureID());
		}
		GL11.glBegin(GL11.GL_QUADS);
		//Top Left
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2i(TLCorner.getX(), TLCorner.getY());
		//Top Right
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2i(TRCorner.getX(), TRCorner.getY());
		//Bottom Right
		GL11.glTexCoord2f(1,1);
		GL11.glVertex2i(BRCorner.getX(), BRCorner.getY());
		//Bottom Left
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2i(BLCorner.getX(), BLCorner.getY());
		GL11.glEnd();
	}

	// getPriority
	public int getPriority() {
		return Priority;
	}

	// getCorners
	public Position getTLCorner() {
		return TLCorner;
	}

	public Position getTRCorner() {
		return TRCorner;
	}

	public Position getBLCorner() {
		return BLCorner;
	}

	public Position getBRCorner() {
		return BRCorner;
	}

	// setCorners
	public void setTLCorner(Position tlcorner) {
		TLCorner = tlcorner;
	}

	public void setTRCorner(Position trcorner) {
		TRCorner = trcorner;
	}

	public void setBLCorner(Position blcorner) {
		BLCorner = blcorner;
	}

	public void setBRCorner(Position brcorner) {
		BRCorner = brcorner;
	}

	// setPriority
	public void setPriority(int priority) {
		Priority = priority;
	}

	// getTextures
	public Texture getTexture() {
		return Texture;
	}

	// setTextures
	public void setTexture(String texture) {
		try {
			Texture = TextureLoader.getTexture("PNG",
					ResourceLoader.getResourceAsStream(AbsoluteFilePath + File.separator + "res" + File.separator + texture + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}