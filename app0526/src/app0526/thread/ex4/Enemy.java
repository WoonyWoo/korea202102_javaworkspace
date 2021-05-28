package app0526.thread.ex4;

import java.awt.Graphics;

public class Enemy extends GameObject{

	public Enemy(GamePanel gamePanel, String path, int x, int y, int width, int height, int velX, int velY) {
		super(gamePanel, path, x, y, width, height, velX, velY);
	}

	public void tick() {
		this.x += velX;
		this.y += velY;
	}

	public void render(Graphics g) {
		g.drawImage(img, x, y, width, height, this.gamePanel);
	}
}
