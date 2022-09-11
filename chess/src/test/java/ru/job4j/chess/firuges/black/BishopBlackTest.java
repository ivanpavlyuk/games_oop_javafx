package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    public void whenPositionCalledThenSamePosition() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertThat(bishop.position()).isEqualTo(Cell.C1);
    }

    @Test
    public void whenCopyCalledWithD2ThenPositionIsD2() {
        Figure bishop = new BishopBlack(Cell.C1).copy(Cell.D2);
        assertThat(bishop.position()).isEqualTo(Cell.D2);
    }

    @Test
    public void whenWayCalledWithG5ThenReturnD2E3F4G5() {
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] rsl = new BishopBlack(Cell.C1).way(Cell.G5);
        assertArrayEquals(expected, rsl);
    }

    @Test
    public void whenTryC1C3ThenException() {
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    new BishopBlack(Cell.C1).way(Cell.C3);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to C3");
    }

}