import java.util.ArrayList;

public class FlashCardsSet{
    private String name;
    private String description;
    private int count;
    private ArrayList<FlashCard> flashCards;

    public FlashCardsSet(String name, String description){
        this.name = name;
        this.description = description;
        this.count = 0;
        this.flashCards = new ArrayList<FlashCard   >();
    }

    public FlashCardsSet(String name){
        this(name, null);
    }


    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getCount(){
        return count;
    }
}
