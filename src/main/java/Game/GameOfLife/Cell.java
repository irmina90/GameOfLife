package Game.GameOfLife;

import java.util.List;

public class Cell {
	private final int twoNeighbours = 2;
	private final int threeNeighbours = 3;
	private int neighbours;
	private boolean alive;

	Cell(boolean alive) {
		this.alive = alive;
	}

	private void incrementNeighbours() {
		this.neighbours += 1;
	}

	private boolean isAliveInNextGen() {
		return this.neighbours == threeNeighbours || (isAlive() && this.neighbours == twoNeighbours);
	}

	public boolean isAlive() {
		return this.alive;
	}

	public void countAliveNeighbours(List<Cell> neighbours) {
		for (Cell c : neighbours) {
			if (c.isAlive())
				incrementNeighbours();
		}
	}

	public void updateLife() {
		this.alive = isAliveInNextGen();
	}

}
