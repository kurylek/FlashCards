public class FlashCard{
    private String word;
    private String translation;
    private String description;

    public FlashCard(String word, String translation, String description){
        this.word = word;
        this.translation = translation;
        this.description = description;
    }

    public String getWord(){
        return word;
    }

    public String getTranslation(){
        return translation;
    }

    public String getDescription(){
        return description;
    }
}
