package me.ThePsyDragon.TetrisClone;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.util.*;

import me.ThePsyDragon.Board.Background;
import me.ThePsyDragon.Board.GameField;
import me.ThePsyDragon.Board.Tiles;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.*;
import org.newdawn.slick.opengl.Texture;

/*Description:
 *    Main Class: Starting point for program.
 *      Houses main loop
 */

public class TetrisClone {
	// Global Variables
	// Debug
	int tickLength = 45;
	int tpsCounter = 0;
	int fps = 60;
	public static int WHeight;
	public static int WWidth;
	long totalTPSCounter = 0;
	long tpsTimer = 0;
	long tpsTimer2 = 0;
	long tickTimer = 0;
	int currentTPS = 0;
	int averageTPS = 0;
	boolean debug = true;
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
			AdjustWindow();
			Display.sync(fps);
		}
		// Clean up
		// Exit
		Close();
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
		tickTimer = System.currentTimeMillis();
		// Calculate tps
		tpsCounter += 1;
		tpsTimer2 = System.currentTimeMillis();
		if (tpsTimer2 - tpsTimer > 1000) {
			double difference = (double) (tpsTimer2 - tpsTimer);
			currentTPS = (int) ((tpsCounter / difference) * 1000);
			this.print("Current FPS: " + currentTPS);
			tpsCounter = 0;
			totalTPSCounter += 1;
			averageTPS = (int) (((averageTPS * (totalTPSCounter - 1)) + currentTPS)
					/ totalTPSCounter);
			tpsTimer = System.currentTimeMillis();
		}
	}

	public void openGLInit() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 640));
			Display.setTitle("Tetris");
			Display.setResizable(true);
			Display.create();
			Keyboard.create();
			Mouse.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		WWidth = Display.getWidth();
		WHeight = Display.getHeight();
		Display.setLocation(-1, -1);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 0, 640, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
	}

	public void render() {
		glClear(GL_COLOR_BUFFER_BIT);
		int x = 0;
		Texture CurrentTexture = null;
		List<GameObject> TempList = new LinkedList<GameObject>();
		List<Texture> UsedTextures = new LinkedList<Texture>();
		while(RendObjList.size() > x){
			for(int i = 0; i<=50;i++){
				TempList = new LinkedList<GameObject>();
				for(int k = 0; k<RendObjList.size();k++){
					if(RendObjList.get(k).getPriority() == i){
						TempList.add(RendObjList.get(k));
					}
				}
				int y = 0;
				while(TempList.size() > y){
					for(int l = 0;;l++){
						if(CurrentTexture == null || !UsedTextures.contains(CurrentTexture)){
							CurrentTexture = TempList.get(l).getTexture();
							break;
						}
					}
					for(int z = 0;z<TempList.size();z++){
						if(TempList.get(z).getTexture().equals(CurrentTexture)){
							TempList.get(z).Draw();
							y++;
							x++;
						}
					}
				}
			}
		}
		if (Tiles.RenderTiles) {
			Tiles.DrawAll();
		}
	}

	public void init() {
		GameObject.AbsoluteFilePath = new File("").getAbsolutePath();
		RendObjList.add(new Background());
		RendObjList.add(new GameField());
	}
	
	public void Close(){
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
		System.out.println("Average FPS: " + averageTPS);
	}
	
	public void AdjustWindow(){
		if(WWidth != Display.getWidth() || WHeight != Display.getHeight()){
			for(int i = 0; i<RendObjList.size();i++){
				RendObjList.get(i).AdjustToWindow();
			}
		}
	}
}
