package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {

	

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

    String[] small;

    public String[] writeSonnet()
    {
        return null;
    }

	public void setup() {
		colorMode(HSB);
		loadFile("small.txt");
       
	}

	public void keyPressed() {

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

	private ArrayList<Word> model;

    public DANI() {
        model = new ArrayList<>();
    }

	

	

	private Word getWord(String word) {
        for (Word w : model) {
            if (w.getWord().equals(word)) {
                return w;
            }
        }
        return null;
    }

    private Follow getFollow(Word word, String followingWord) {
        for (Follow follow : word.getFollows()) {
            if (follow.getWord().equals(followingWord)) {
                return follow;
            }
        }
        return null;
    }

	private int count;

	public void incrementCount() {
        count++;
    }



	public void loadFile(String filename) {
        String[] lines = loadStrings(filename);

        for (String line : lines) {
            // Clean the text by removing punctuation and converting to lower case
            String[] words = split(line.replaceAll("[^\\w\\s]","").toLowerCase(), ' ');

            // Generate the word frequency and following word lists for the model
            for (int i = 0; i < words.length; i++) {
                String currentWord = words[i];
                String nextWord = i < words.length - 1 ? words[i+1] : null;
                Word word = getWord(currentWord);

                if (word == null) {
                    // Create a new Word object and add it to the model
                    word = new Word(currentWord, new ArrayList<Follow>());
                    model.add(word);
                }

                // Update the following word list for the current Word object
                if (nextWord != null) {
                    Follow follow = getFollow(word, nextWord);

                    if (follow == null) {
                        // Create a new Follow object and add it to the follows list
                        follow = new Follow(nextWord, 1);
                        word.getFollows().add(follow);
                    } else {
                        // Increment the count for the existing Follow object
                        follow.incrementCount();
                    }
                }
            }
        }
    }

	public void printModel() {
		for (Word word : model) {
			System.out.println(word.toString());
		}
	}


}
