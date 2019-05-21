import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Enemy {

	private int x;
	private int y;
	private BufferedImage imageCurrent;
	private BufferedImage imageRunning;
	private BufferedImage imageOver;
	private int stepSize;

	public Enemy(GameManager gameManager, int x, int y) {
		try {
			this.imageRunning = ImageIO.read(new File("enemy-alive.png"));
			this.imageOver = ImageIO.read(new File("enemy-dead.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
		this.stepSize = 5;

		this.imageCurrent = this.imageRunning;
		return;
	}

	public void performAction() {
		
	}

	public void die() {
		this.imageCurrent = this.imageOver;
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

}
