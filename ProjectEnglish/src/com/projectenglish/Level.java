package com.projectenglish;

public class Level {
	
	private int level;
	private int minVal;
	private int maxVal;
	
	
	public Level(int level, int minVal, int maxVal) {
		super();
		this.level = level;
		this.minVal = minVal;
		this.maxVal = maxVal;
	}
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @return the minVal
	 */
	public int getMinVal() {
		return minVal;
	}
	/**
	 * @param minVal the minVal to set
	 */
	public void setMinVal(int minVal) {
		this.minVal = minVal;
	}
	/**
	 * @return the maxVal
	 */
	public int getMaxVal() {
		return maxVal;
	}
	/**
	 * @param maxVal the maxVal to set
	 */
	public void setMaxVal(int maxVal) {
		this.maxVal = maxVal;
	}
	
	

}
