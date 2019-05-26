import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;

public class Player {

	private int x;
	private int y;
	private BufferedImage imageCurrent;
	private BufferedImage imageRunning;
	private BufferedImage imageOver;
	private int stepSizex;
	private int stepSizey;

	public Player(int x, int y) {
		try {
			this.imageRunning = ImageIO.read(new File("player-alive.png"));
			this.imageOver = ImageIO.read(new File("player-dead.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
		this.stepSizex = 0;
		this.stepSizey = 0;

		this.imageCurrent = this.imageRunning;
		return;
	}

	public void performAction() {
		//moves the player accordingly to stepsize variables
		this.x += this.stepSizex;
		this.y += this.stepSizey;
		return;

	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public BufferedImage getCurrentImage() {
		return this.imageCurrent;
	}

	public void die() {
		this.imageCurrent = this.imageOver;
		return;
	}

	public void setKey(char c, boolean b) {
		// checks to see if a key is being pressed or not, if a key is being pressed
		// sets the stepSize variables to appropriate ints, if a key is not pressed
		// (or released again) the stepSize variables are set back to 0
		if (b == true) {
			if (c == 'R') {
				this.stepSizex = 15;
			}
			if (c == 'L') {
				this.stepSizex = -15;
			}
			if (c == 'U') {
				this.stepSizey = -15;
			}
			if (c == 'D') {
				this.stepSizey = 15;
			}
		} else if (b == false) {
			if (c == 'R') {
				this.stepSizex = 0;
			}
			if (c == 'L') {
				this.stepSizex = 0;
			}
			if (c == 'U') {
				this.stepSizey = 0;
			}
			if (c == 'D') {
				this.stepSizey = 0;
			}
		}
		return;

	}

}
