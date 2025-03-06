import java.util.ArrayList;
import java.util.List;

// Implements IDedObject for use with IDedLinkedList
public class MyItem implements IDedObject {
    private final int itemID;                  // Unique identifier
    private final int itemPrice;               // Item price
    private final List<Integer> itemDescription; // Description as integer list
 
    // Constructor with defensive copy of description list
    public MyItem(int itemID, int itemPrice, List<Integer> itemDescription) {
        this.itemID = itemID;
        this.itemPrice = itemPrice;
        this.itemDescription = new ArrayList<>(itemDescription);
    }

    // Returns the item's ID
    @Override
    public int getID() {
        return itemID;
    }
     
    // Returns string format: "itemID itemPrice item1 item2 ..."
    @Override
    public String printID() {
        StringBuilder sb = new StringBuilder();
        sb.append(itemID).append(" ").append(itemPrice);
        
        for (Integer item : itemDescription) {
            sb.append(" ").append(item);
        }
        return sb.toString();
    }
}
