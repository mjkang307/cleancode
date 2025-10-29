def getFlaggedCells():
    flagged_cells = []
    for cell in game_board:
        if cell.status == FLAGGED:
            flagged_cells.append(cell)
    return flagged_cells
