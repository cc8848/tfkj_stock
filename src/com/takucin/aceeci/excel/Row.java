package com.takucin.aceeci.excel;

import java.util.ArrayList;
import java.util.List;

public class Row {
	
	private List<Cell> cells;

	public Row(){
		cells = new ArrayList<Cell>();
	}
	
	public Row(List<Cell> cells){
		this.cells = cells;
	}
	
	public List<Cell> getCells() {
		return cells;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}
	
	public void addCell(Cell cell){
		this.cells.add(cell);
	}
	public void addCell(String cell){
		this.cells.add(new Cell(cell));
	}
	public int size(){
		return this.cells.size();
	}
	
	public Cell get(int index){
		return this.cells.get(index);
	}
}
