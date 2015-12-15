package Game.GameOfLife;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class GameOfLifeTest  {
	
	private GameOfLife game;
	private List<List<Cell>> cells;

	@Before
	public void setUp() {
		this.game = new GameOfLifeImpl();
		this.cells = new ArrayList<List<Cell>>();
	}
	
	@Test
	public void shouldReturnAliveFalseWhenCellHasLessThanTwoNeighbours() {
		// given
		cells.add(Arrays.asList(new Cell(false),new Cell(false),new Cell(false)));
		cells.add(Arrays.asList(new Cell(false),new Cell(true),new Cell(true)));
		cells.add(Arrays.asList(new Cell(false),new Cell(false),new Cell(false)));
		// when
		game.setData(1, cells);
		List<List<Cell>> cellsNextGeneration = game.playTheGame();
		// then
		assertThat(cellsNextGeneration.get(1).get(1).isAlive()).isEqualTo(false);
	}
	
	@Test
	public void shouldReturnAliveTrueWhenCellHasTwoOrThreeNeighbours() {
		// given
		cells.add(Arrays.asList(new Cell(false),new Cell(false),new Cell(true)));
		cells.add(Arrays.asList(new Cell(false),new Cell(true),new Cell(true)));
		cells.add(Arrays.asList(new Cell(false),new Cell(false),new Cell(true)));
		// when
		game.setData(1, cells);
		List<List<Cell>> cellsNextGeneration = game.playTheGame();
		// then
		assertThat(cellsNextGeneration.get(1).get(1).isAlive()).isEqualTo(true);
	}
	
	@Test
	public void shouldReturnAliveFalseWhenCellHasMoreThanThreeNeighbours() {
		// given
		cells.add(Arrays.asList(new Cell(true),new Cell(true),new Cell(true)));
		cells.add(Arrays.asList(new Cell(true),new Cell(true),new Cell(true)));
		cells.add(Arrays.asList(new Cell(true),new Cell(true),new Cell(true)));
		// when
		game.setData(1, cells);
		List<List<Cell>> cellsNextGeneration = game.playTheGame();
		// then
		assertThat(cellsNextGeneration.get(1).get(1).isAlive()).isEqualTo(false);
	}
	
	@Test
	public void shouldReturnAliveTrueWhenDeadCellHasThreeNeighbours() {
		// given
		cells.add(Arrays.asList(new Cell(false),new Cell(false),new Cell(true)));
		cells.add(Arrays.asList(new Cell(false),new Cell(false),new Cell(true)));
		cells.add(Arrays.asList(new Cell(false),new Cell(false),new Cell(true)));
		// when
		game.setData(1, cells);
		List<List<Cell>> cellsNextGeneration = game.playTheGame();
		// then
		assertThat(cellsNextGeneration.get(1).get(1).isAlive()).isEqualTo(true);
	}

}
