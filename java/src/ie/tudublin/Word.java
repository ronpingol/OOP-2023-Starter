package ie.tudublin;

import java.util.ArrayList;

public class Word {

    private String word;
    private ArrayList<Follow> follows;

    
    public Word(String word, ArrayList<Follow> follows) {
        this.word = word;
        this.follows = follows;
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public ArrayList<Follow> getFollows() {
        return follows;
    }
    public void setFollows(ArrayList<Follow> follows) {
        this.follows = follows;
    }

    public String toString() {
        String result = word + ": ";
        for (Follow follow : follows) {
            result += follow.toString() + " ";
        }
        return result.trim();
    }




}