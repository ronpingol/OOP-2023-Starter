package ie.tudublin;

public class Follow {

    private String word;
    private int addUp;

    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public int getAddUp() {
        return addUp;
    }
    public void setAddUp(int add) {
        this.addUp = add;
    }
    public Follow(String word,int add)
    {
        this.word = word;
        this.addUp = add;
    }
    public String toString()
    {
        return word + "(" + addUp + ")";
    }
  

}