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
	private int followX;
	private int followY;
	private GameManager gameManager;

	public Enemy(GameManager gameManager, int x, int y) {
		try {
			this.imageRunning = ImageIO.read(new File("enemy-alive.png"));
			this.imageOver = ImageIO.read(new File("enemy-dead.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
		this.followX = 0;
		this.followY = 0;
		this.gameManager = gameManager;

		this.imageCurrent = this.imageRunning;
		return;
	}

	public void performAction() {
		// gets the players x and y coords from the gamemanager class then compares it
		// with enemy x and y coords
		// and moves the enemy accordingly
		if (this.gameManager.getPlayer().getX() > this.x) {
			this.followX = 5;
			this.x = this.x + this.followX;
		} else if (this.gameManager.getPlayer().getX() < this.x) {
			this.followX = -5;
			this.x = this.x + this.followX;
		}
		if (this.gameManager.getPlayer().getY() > this.y) {
			this.followY = 5;
			this.y = this.y + this.followY;
		} else if (this.gameManager.getPlayer().getY() < this.y) {
			this.followY = -5;
			this.y = this.y + this.followY;
		}

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
