package com.projectenglish;

public interface IUserDAO {
	User getUser();
	int getLevel();
	void setPoint(int point);
	Stat getStat();
	void setStat(int nbquestion);
	void addQuestionAnwer(Question question);
	void reinitializeQuestionAnswer();
	int getNumberOfPointGain();
}
