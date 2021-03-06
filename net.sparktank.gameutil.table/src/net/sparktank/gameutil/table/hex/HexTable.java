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
import java.util.List;
import java.util.Random;

import net.sparktank.gameutil.table.Table;

public interface HexTable extends Table {
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	/**
	 * Return an object representing these coordinates.
	 * Returns null if the coordinates are out of range.
	 */
	public HexCoordinates getHexCoordinates (int x, int y);
	
	public HexCoordinates getRandomHexCoordinates (Random random);
	
	/**
	 * Returns all the HexPiece instances on the table.
	 */
	public Collection<? extends HexPiece> getHexPieces ();
	
	public Collection<? extends HexPiece> getHexPieces (HexCoordinates coordinates);
	
	/**
	 * Returns all the HexPiece instances on the table that are referenced by the coordinates parameter.
	 * Any illegal entries (coordinates for which no cell exists) are ignored.
	 * The HexPiece instances will be returned in the same order as the HexCoordinates were passed in.
	 */
	public Collection<? extends HexPiece> getHexPieces (List<? extends HexCoordinates> coordinates);
	
	public void addHexPiece (HexPiece piece);
	
	/**
	 * Call this if a piece is moved.
	 */
	public void updateHexPiece (HexPiece piece, HexCoordinates oldCoordinates);
	
	public void moveHexPiece (HexPiece piece, HexCoordinates newCoordinates);
	
	public boolean removeHexPiece (HexPiece piece);
	
	
	public void addHexCellAnnotation (HexCellAnnotation annotation);
	
	public void removeHexCellAnnotation (HexCellAnnotation annotation);
	
	public Collection<? extends HexCellAnnotation> getHexCellAnnotations ();
	
	public Collection<? extends HexCellAnnotation> getHexCellAnnotations (HexCoordinates coordinates);
	
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
}
