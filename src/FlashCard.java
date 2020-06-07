public class FlashCard{
    private String word;
    private String translation;
    private String description;

    public FlashCard(String word, String translation, String description){
        this.word = word;
        this.translation = translation;
        this.description = description;
    }

    public FlashCard(String word, String translation){
        this(word, translation, null);
    }

    public String getWord(){
        return word;
    }

    public void setWord(String word){
        this.word = word;
    }

    public String getTranslation(){
        return translation;
    }

    public void setTranslation(String translation){
        this.translation = translation;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
