import java.io.Serializable;
import java.util.ArrayList;

public class FlashCardsSet implements Serializable{
    private String name;
    private String description;
    private int count;
    private ArrayList<FlashCard> flashCards;

    public FlashCardsSet(String name, String description){
        this.name = name;
        this.description = description;
        this.count = 0;
        this.flashCards = new ArrayList<FlashCard>();
        init();
    }

    public FlashCardsSet(String name){
        this(name, null);
    }

    private void init(){
        for(int i=0; i<15; i++){
            this.flashCards.add(new FlashCard(String.valueOf(i), String.valueOf(i)));
        }
        this.count = this.flashCards.size();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getCount(){
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }

    public ArrayList<FlashCard> getFlashCards(){
        return flashCards;
    }

    @Override
    public String toString(){
        return "Name:" + name + "\nDescription: " + description + "\nCount: " + count + "\nFlashCards: " + flashCards;
    }
}
