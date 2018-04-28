package com.projectenglish;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class UserDAO implements IUserDAO{

	private Activity act;

	private static UserDAO instance =null;

	private User user = null;
	
	private List<Question> questionAnwer = null;
	private Stat stat = null;

	private UserDAO(Activity context) {
		this.act = context;
		this.questionAnwer = new ArrayList<Question>();
		user = null;
		stat = null;
	}

	public static UserDAO getInstance(Activity context)
	{
		if(instance == null)
			instance = new UserDAO(context);
		return instance;
	}

	@Override
	public User getUser() {
		if(this.user == null){
			this.user =  AccessData.getInstance(this.act).loadUser();
		}
		return this.user;
	}
	
	@Override
	public void addQuestionAnwer(Question question) {
		this.questionAnwer.add(question);
	}
	
	@Override
	public void reinitializeQuestionAnswer() {
		this.questionAnwer =new ArrayList<Question>();
	}


	@Override
	public Stat getStat() {
		if(this.stat == null){
			this.stat =  AccessData.getInstance(this.act).loadStat();
		}
		return this.stat;
	}

	@Override
	public void setStat(int nbquestion) {
		this.stat = getStat();
		nbquestion = stat.getNbQuestion() + nbquestion;
		int nbaverage= 0;
		int nbwrong = stat.getNbQuestionWrong() +1;
		int nbPart = stat.getNbPart() +1;
		if(nbPart <=1){
			nbaverage = (stat.getNbQuestionAverage() + nbquestion);
		}else{
			nbaverage = (stat.getNbQuestionAverage() + nbquestion)/2;
		}
		
		stat.setNbQuestion(nbquestion);
		stat.setNbQuestionAverage(nbaverage);
		stat.setNbQuestionWrong(nbwrong);
		stat.setNbPart(nbPart);
		AccessData.getInstance(this.act).changeStat(nbquestion, nbaverage, nbwrong,nbPart, 0);
	}

	@Override
	public void setPoint(int point){
		int newPoint = user.getPoint() + point;
		user.setPoint(newPoint);
		AccessData.getInstance(this.act).changeUserPoint(newPoint,0);
	}
	@Override
	public int getLevel() {
		User user = getUser();
		List<Level> levels = AccessData.getInstance(this.act).loadLevel();
		for(Level l : levels){
			if(user.getPoint()< l.getMaxVal() && user.getPoint()>= l.getMinVal()){
				return l.getLevel();
			}
		}
		return 0;
	}
	
	@Override
	public int getNumberOfPointGain()
	{
		int point = 0;
		for(Question q:this.questionAnwer ){
			point+=q.getPoints();
		}
		return point;
	}

	public static void setInstance(Object object) {
		instance = null;
	}
	


}
