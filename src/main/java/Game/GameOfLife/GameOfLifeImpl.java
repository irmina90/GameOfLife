package Game.GameOfLife;

import java.util.ArrayList;
import java.util.List;

public class GameOfLifeImpl implements GameOfLife {
	List<List<Cell>> cells = new ArrayList<List<Cell>>();
	private int noOfInterations;

	private int getTheLastCell() {
		return cells.size() - 1;
	}

	private int checkTheRange(int noOfCell) {
		if (noOfCell < 0)
			return 0;
		if (noOfCell > getTheLastCell())
			return getTheLastCell();
		return noOfCell;
	}

	private void updateCells() {
		for (int row = 0; row <= getTheLastCell(); row++) {
			for (int col = 0; col <= getTheLastCell(); col++) {
				cells.get(row).get(col).updateLife();
			}
		}
	}

	private List<Cell> getListOfNeighbours(int row, int col) {
		List<Cell> neighbours = new ArrayList<Cell>();

		for (int x = checkTheRange(row - 1); x <= checkTheRange(row + 1); x++) {
			for (int y = checkTheRange(col - 1); y <= checkTheRange(col + 1); y++) {
				if (x == row && y == row)
					continue;
				neighbours.add(cells.get(x).get(y));
			}
		}
		return neighbours;
	}

	public void setData(int noOfIterations, List<List<Cell>> cells) {
		this.noOfInterations = noOfIterations;
		this.cells = cells;
	}

	public List<List<Cell>> playTheGame() {
		while (noOfInterations > 0) {
			for (int row = 0; row <= getTheLastCell(); row++) {
				for (int col = 0; col <= getTheLastCell(); col++) {
					cells.get(row).get(col).countAliveNeighbours(getListOfNeighbours(row, col));
				}
			}
			updateCells();
			noOfInterations--;
		}
		return cells;
	}

}
