package com.projectenglish;

import java.io.Serializable;

public class Question implements Serializable,Comparable<Question>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String question;
	private String reponse1;
	private String reponse2;
	private String reponse3;
	private String reponse4;
	private String reponseJuste;
	private String theme;
	
	private int points;
	private int niveau;
	private boolean withImage;
	
	@Override
	public int compareTo(Question another) {
		return this.question.compareTo(another.question);
	}
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Question)) {
	        return false;
	    }
		Question that = (Question) other;
	    return this.question==that.question;
	}

	public Question(int id, String question, String reponse1, String reponse2, String reponse3, String reponse4,
			String reponseJuste, String theme, int points, int niveau, int image) {
		super();
		this.question = question;
		this.reponse1 = reponse1;
		this.reponse2 = reponse2;
		this.reponse3 = reponse3;
		this.reponse4 = reponse4;
		this.reponseJuste = reponseJuste;
		this.theme = theme;
		this.points = points;
		this.niveau = niveau;
		if(image == 1){
			this.withImage = true;
		}
		else{
			this.withImage = false;
		}
		
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the reponse1
	 */
	public String getReponse1() {
		return reponse1;
	}

	/**
	 * @param reponse1 the reponse1 to set
	 */
	public void setReponse1(String reponse1) {
		this.reponse1 = reponse1;
	}

	/**
	 * @return the reponse2
	 */
	public String getReponse2() {
		return reponse2;
	}

	/**
	 * @param reponse2 the reponse2 to set
	 */
	public void setReponse2(String reponse2) {
		this.reponse2 = reponse2;
	}

	/**
	 * @return the reponse3
	 */
	public String getReponse3() {
		return reponse3;
	}

	/**
	 * @param reponse3 the reponse3 to set
	 */
	public void setReponse3(String reponse3) {
		this.reponse3 = reponse3;
	}

	/**
	 * @return the reponse4
	 */
	public String getReponse4() {
		return reponse4;
	}

	/**
	 * @param reponse4 the reponse4 to set
	 */
	public void setReponse4(String reponse4) {
		this.reponse4 = reponse4;
	}

	/**
	 * @return the reponseJuste
	 */
	public String getReponseJuste() {
		return reponseJuste;
	}

	/**
	 * @param reponseJuste the reponseJuste to set
	 */
	public void setReponseJuste(String reponseJuste) {
		this.reponseJuste = reponseJuste;
	}

	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the niveau
	 */
	public int getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau the niveau to set
	 */
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public boolean isWithImage() {
		return withImage;
	}
	public void setWithImage(boolean withImage) {
		this.withImage = withImage;
	}

	
	
	
	
}
