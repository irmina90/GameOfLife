package Game.GameOfLife;

import java.util.List;

public interface GameOfLife {

	/**
	 * Register the data
	 * 
	 * @param noOfIterations
	 *            number of plays
	 * @param cells
	 *            two dimensional Cell list
	 */
	public void setData(int noOfIterations, List<List<Cell>> cells);

	/**
	 * @return two dimensional Cell list after all iterations
	 */
	public List<List<Cell>> playTheGame();

}
