package net.sparktank.gameutil.table_impl.test;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import junit.framework.Assert;

import net.sparktank.gameutil.table.hex.HexCoordinates;
import net.sparktank.gameutil.table_impl.HexCoordinatesImpl;

import org.junit.Test;

public class TestHexCoordinates {
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	@Test
	public void testGetAdjacentHexCoordinates () {
		HexCoordinates coord = new HexCoordinatesImpl(1, 1);
		
		List<? extends HexCoordinates> adjacentHexCoordinates = coord.getAdjacentHexCoordinates();
		for (HexCoordinates adjCoord : adjacentHexCoordinates) {
			System.out.print(" ");
			System.out.print(adjCoord);
		}
		System.out.println();
	}
	
	@Test
	public void testGetAdjacentHexCoordinatesRange1 () {
		HexCoordinates coord = new HexCoordinatesImpl(1, 1);
		
		Map<Integer, List<? extends HexCoordinates>> adjacentHexCoordinates = coord.getAdjacentHexCoordinates(60);
		for (Entry<Integer, List<? extends HexCoordinates>> adjCoords : adjacentHexCoordinates.entrySet()) {
			System.out.print(adjCoords.getKey());
			System.out.print(" (");
			System.out.print(adjCoords.getValue().size());
			System.out.print(")");
			for (HexCoordinates adjCoord : adjCoords.getValue()) {
				System.out.print(" ");
				System.out.print(adjCoord);
			}
			System.out.println();
		}
	}
	
	@Test
	public void testMeasureHexRange () {
		HexCoordinates startCoord = new HexCoordinatesImpl(3, 2);
		HexCoordinates endCoord = new HexCoordinatesImpl(0, 3);
		
		int dist = startCoord.measureHexDistanceTo(endCoord);
		
		if (dist != 3) throw new RuntimeException(dist + " != 3");
	}
	
	@Test
	public void testGetHexPath () {
		HexCoordinates startCoord = new HexCoordinatesImpl(3, 2);
		HexCoordinates endCoord = new HexCoordinatesImpl(0, 3);
		
		List<HexCoordinates> path = startCoord.getHexPathTo(endCoord);
		
		Assert.assertEquals(path.get(0), new HexCoordinatesImpl(3, 2));
		Assert.assertEquals(path.get(1), new HexCoordinatesImpl(2, 3));
		Assert.assertEquals(path.get(2), new HexCoordinatesImpl(1, 3));
		Assert.assertEquals(path.get(3), new HexCoordinatesImpl(0, 3));
	}
	
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
}
