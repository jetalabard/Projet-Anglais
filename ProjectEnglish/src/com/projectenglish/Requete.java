package com.projectenglish;

import java.util.List;


public interface Requete {

	List<Question> loadQuestion();
	User loadUser();
	Maj loadMaj();
	List<Level> loadLevel();
	void changeUserPoint(int point, int userId);
	Stat loadStat();
	void changeStat(int NBQUESTION, int NBAVERAGEQUESTIONBYPART, int NBQUESTIONWRONG, int NBPART, int statId);
	
}
