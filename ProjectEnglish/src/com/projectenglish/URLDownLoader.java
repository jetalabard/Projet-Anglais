package com.projectenglish;

import java.util.ArrayList;
import java.util.List;

public class URLDownLoader {
	private static String[] urls={"https://www.dropbox.com/s/30rmtpekpgk685f/createEnglishProject.txt?dl=1",
    		"https://www.dropbox.com/s/3zhu9fjgar05fig/insertEnglishProject.txt?dl=1"};
	
	public static String[] getUrls()
	{
		return urls;
	}
	
	public static List<String> getNameFileOfUrl()
	{
		List<String> ret = new ArrayList<String>();
		for(String url :urls)
		{
			String[] split = url.split("/");
			String name = split[split.length-1];
			ret.add(name.substring(0, 24));
		}
		return ret;
	}
	
}
