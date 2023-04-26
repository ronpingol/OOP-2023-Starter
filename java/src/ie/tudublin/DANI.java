package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;

public class DANI extends PApplet {

	ArrayList<Word> model;
	ArrayList<String> sonnets;
	StringBuilder building;

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}


	public void setup() {
		colorMode(RGB);
		model = new ArrayList<Word>();
		loadFile();

       
	}

	public void keyPressed() {

	}

	String[] sonet;

	public void loadFile()
	{
		String[] lines = loadStrings("shakespere.txt");
		
		for(int i = 0; i < lines.length; i ++)
		{
			String[] wrd = split(lines[i], " ");
			for(int j = 0; j < wrd.length; j ++)
			{
				
				wrd[j] = wrd[j].replaceAll("[^a-zA-Z ]", "");
				wrd[j] = wrd[j].toLowerCase();

				boolean lastWord;
				if(j+1 == wrd.length)
				{
					lastWord = true;
				}
				else
				{
					lastWord = false;
				}
				
				if(!lastWord)
				{
					wrd[j+1] = wrd[j+1].replaceAll("[^a-zA-Z ]", "");
					wrd[j+1] = wrd[j+1].toLowerCase();
				}

				int result = findWord(wrd[j]);
				Word word;
				
				if(result == -1)
				{
					word = new Word(wrd[j]);
					model.add(word);
				}
				else
				{
					word = model.get(result);
				}

				
				if(!lastWord)
				{
					if(word.findFollow(wrd[j+1]) == -1)
					{
						word.addFollow(new Follow(wrd[j+1], 1));
					}
					else
					{
						word.addFollowCount(word.getFollows().get(word.findFollow(wrd[j+1])));
					}
				}
			}
		}
	}
	public int findWord(String word)
	{
		for(int i = 0; i < model.size(); i ++)
		{
			if(model.get(i).getWord().equals(word))
			{
				return i;
			}
		}
		return -1;
	}
	




	float off = 0;

	public void draw() 
    {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
        textAlign(CENTER, CENTER);

        
	}
}