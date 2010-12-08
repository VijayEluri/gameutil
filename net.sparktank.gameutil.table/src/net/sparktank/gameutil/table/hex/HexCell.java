/*
 * Copyright 2010 Fae Hutter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package net.sparktank.gameutil.table.hex;

import java.util.Collection;

import net.sparktank.gameutil.table.Cell;

public interface HexCell extends Cell {
	
	public HexCoordinates getHexCoordinates ();
	
	/**
	 * Get all the cells surrounding this cell.
	 * A range of 1 will fetch all cells adjacent to this one.
	 * @param range
	 * @return
	 */
	public Collection<? extends HexCell> getAdjacentHexCells (int range);
	
	/**
	 * Calculate the number of moves needed to travel from this cell to another cell.
	 * @param otherCell
	 * @return
	 */
	public int measureHexDistanceTo (HexCell otherCell);
	
	public Collection<? extends HexPiece> getHexPieces ();
	
}
