package me.ThePsyDragon.TetrisClone;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

/*Description:
 *    Main Class: Starting point for program.
 *      Houses 
 */

public class TetrisClone {
	// Global Variables
	int tickLength = 50;
	int tpsCounter = 0;
	long totalTPSCounter = 0;
	double currentTPS = 0;
	double averageTPS = 0;
	boolean debug = true;
	boolean TPSRestrict = true;

	public static void main(String[] args) {
		// Variables
		// Start Program
		TetrisClone tc = new TetrisClone();
		tc.Start();
	}
	
	public void Start() {
		// Start Function
		// Initialize
		try {
			Display.setDisplayMode(new DisplayMode(720, 720));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		// Begin Loop
		long tpsTimer2 = 0;
		long tpsTimer = System.currentTimeMillis();
		long tickTimer = System.currentTimeMillis();
		while (!Display.isCloseRequested()) {
			//Check TPS
			if (TPSRestrict) {
				while (System.currentTimeMillis() - tickTimer < tickLength) {
					// Pause till tick is completed
				}
			}
			tickTimer = System.currentTimeMillis();
			// Calculate tps
			tpsTimer2 = System.currentTimeMillis();
			tpsCounter += 1;
			this.print("TPS Counter: " + tpsCounter);
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
			// Update Positions
			// Render
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
}
