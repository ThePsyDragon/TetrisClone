package me.ThePsyDragon.TetrisClone;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import me.ThePsyDragon.Board.Position;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

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
		setTexture(texture);
	}

	// Draw
	public void Draw() {
		Texture.bind();
		glBegin(GL_QUADS);
		// Top Left
		glTexCoord2f(0, 0);
		glVertex2i(TLCorner.getX(), TLCorner.getY());
		// Top Right
		glTexCoord2f(1, 0);
		glVertex2i(TRCorner.getX(), TRCorner.getY());
		// Bottom Right
		glTexCoord2f(1, 1);
		glVertex2i(BRCorner.getX(), BRCorner.getY());
		// Bottom Left
		glTexCoord2f(0, 1);
		glVertex2i(BLCorner.getX(), BLCorner.getY());
		glEnd();
		Texture.release();
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
			Texture = TextureLoader.getTexture("PNG", new FileInputStream(
					new File(AbsoluteFilePath + File.separator + "res"
							+ File.separator + texture + ".png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Size Adjustment
	public void AdjustToWindow() {
		if (Display.getHeight() != 0 && Display.getWidth() != 0) {
			double WModifier = (double) Display.getWidth() / TetrisClone.WWidth;
			double HModifier = (double) Display.getHeight()
					/ TetrisClone.WHeight;
			this.BLCorner.setX((int) (BLCorner.getX() * WModifier));
			this.BLCorner.setY((int) (BLCorner.getY() * HModifier));
			this.BRCorner.setX((int) (BRCorner.getX() * WModifier));
			this.BRCorner.setY((int) (BRCorner.getY() * HModifier));
			this.TLCorner.setX((int) (TLCorner.getX() * WModifier));
			this.TLCorner.setY((int) (TLCorner.getY() * HModifier));
			this.TRCorner.setX((int) (TRCorner.getX() * WModifier));
			this.TRCorner.setY((int) (TRCorner.getY() * HModifier));
			TetrisClone.WWidth = Display.getWidth();
			TetrisClone.WHeight = Display.getHeight();
			System.out.println("Debug: Display Height: " + TetrisClone.WHeight);
			System.out.println("Debug: TOP Y COORDS: " + TLCorner.getY() + " "
					+ TRCorner.getY());
			System.out.println("Debug: BOT Y COORDS: " + BLCorner.getY() + " "
					+ BRCorner.getY());
		}
	}
}