package com.projectenglish;

public class Stat {
	private int nbQuestion;
	private int nbQuestionAverage;
	private int nbQuestionWrong;
	private int nbPart;
	
	public Stat(int nbQuestion, int nbQuestionAverage, int nbQuestionWrong, int nbPart) {
		super();
		this.nbQuestion = nbQuestion;
		this.nbQuestionAverage = nbQuestionAverage;
		this.nbQuestionWrong = nbQuestionWrong;
		this.setNbPart(nbPart);
	}


	/**
	 * @return the nbQuestion
	 */
	public int getNbQuestion() {
		return nbQuestion;
	}


	/**
	 * @param nbQuestion the nbQuestion to set
	 */
	public void setNbQuestion(int nbQuestion) {
		this.nbQuestion = nbQuestion;
	}


	/**
	 * @return the nbQuestionAverage
	 */
	public int getNbQuestionAverage() {
		return nbQuestionAverage;
	}


	/**
	 * @param nbQuestionAverage the nbQuestionAverage to set
	 */
	public void setNbQuestionAverage(int nbQuestionAverage) {
		this.nbQuestionAverage = nbQuestionAverage;
	}


	/**
	 * @return the nbQuestionWrong
	 */
	public int getNbQuestionWrong() {
		return nbQuestionWrong;
	}


	/**
	 * @param nbQuestionWrong the nbQuestionWrong to set
	 */
	public void setNbQuestionWrong(int nbQuestionWrong) {
		this.nbQuestionWrong = nbQuestionWrong;
	}


	public int getNbPart() {
		return nbPart;
	}


	public void setNbPart(int nbPart) {
		this.nbPart = nbPart;
	}
	
	
	
	
}
