package me.ThePsyDragon.TetrisClone;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.util.*;

import me.ThePsyDragon.Board.GameField;
import me.ThePsyDragon.Board.Tiles;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.*;

/*Description:
 *    Main Class: Starting point for program.
 *      Houses main loop
 */

public class TetrisClone {
	// Global Variables
	// Debug
	int tickLength = 50;
	int tpsCounter = 0;
	long totalTPSCounter = 0;
	long tpsTimer = 0;
	long tpsTimer2 = 0;
	long tickTimer = 0;
	double currentTPS = 0;
	double averageTPS = 0;
	boolean debug = true;
	boolean TPSRestrict = true;
	// List of all Rendered Objects
	List<GameObject> RendObjList = new LinkedList<GameObject>();

	public static void main(String[] args) {
		// Variables
		TetrisClone tc = new TetrisClone();
		// Start Program
		if (args.length > 0) {
			if (args[0].equalsIgnoreCase("debug")) {
				tc.debug = true;
			}
		}
		tc.Start();
	}

	public void Start() {
		// Start Function
		// Initialize
		openGLInit();
		init();
		// Begin Loop
		tpsTimer = System.currentTimeMillis();
		while (!Display.isCloseRequested()) {
			// TPS Calculations
			TPSCalc();
			// Update Positions
			// Render
			render();
			// Update Screen
			Display.update();
		}
		// Clean up
		// Debug Info
		System.out.println("Average TPS: " + averageTPS);
		this.print("Total TPS Counter: " + totalTPSCounter);
		// Exit
	}

	public void print(String message) {
		if (debug) {
			System.out.println(message);
		}
	}

	public void TPSCalc() {
		tpsTimer2 = 0;
		tickTimer = System.currentTimeMillis();
		// Check TPS
		if (TPSRestrict) {
			while (System.currentTimeMillis() - tickTimer < tickLength) {
				// Pause till tick is completed
			}
		}
		tickTimer = System.currentTimeMillis();
		// Calculate tps
		tpsCounter += 1;
		this.print("TPS Counter: " + tpsCounter);
		tpsTimer2 = System.currentTimeMillis();
		if (tpsTimer2 - tpsTimer > 1000) {
			double difference = (double) (tpsTimer2 - tpsTimer);
			this.print("" + difference);
			currentTPS = (tpsCounter / difference) * 1000;
			this.print("Current TPS: " + currentTPS);
			tpsCounter = 0;
			totalTPSCounter += 1;
			averageTPS = ((averageTPS * (totalTPSCounter - 1)) + currentTPS)
					/ totalTPSCounter;
			tpsTimer = System.currentTimeMillis();
		}
	}

	public void openGLInit() {
		try {
			Display.setDisplayMode(new DisplayMode(720, 720));
			Display.create();
			Keyboard.create();
			Mouse.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 720, 0, 720, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL11.GL_TEXTURE_2D);
	}

	public void render() {
		for (int i = 0; i < RendObjList.size(); i++) {
			if (GameObject.BoundTexture == null || !GameObject.BoundTexture
					.equals(RendObjList.get(i).getTexture())) {
				GameObject.BoundTexture = RendObjList.get(i).getTexture();
			}
			RendObjList.get(i).Draw();
			System.out.println("Debug: Called Draw");
		}
		if (Tiles.RenderTiles) {
			Tiles.DrawAll();
		}
	}

	public void init() {
		GameObject.AbsoluteFilePath = new File("").getAbsolutePath();
		RendObjList.add(new GameField());
	}
}
