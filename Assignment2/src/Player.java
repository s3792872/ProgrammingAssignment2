import java.awt.Dimension;
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
	private int stepSize;

	public Player(int x, int y) {
		try {
			this.imageRunning = ImageIO.read(new File("player-alive.png"));
			this.imageOver = ImageIO.read(new File("player-dead.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
		this.stepSize = 10;

		this.imageCurrent = this.imageRunning;
		return;
	}

	public void performAction() {
		

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
		

	}

}
