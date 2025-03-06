public class IDedLinkedList<AnyType extends IDedObject> {
    // Node class for the linked list
    private static class Node<AnyType> {
        AnyType data;     // Element stored in this node
        Node<AnyType> next; // Reference to next node
        
        Node(AnyType data, Node<AnyType> next) {
            this.data = data;
            this.next = next;
        }
    }
    
    private Node<AnyType> head; // First node in the list
    private int size;           // Number of elements in the list

    // Initialize empty list
    public IDedLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    // Clear all elements from the list
    public void makeEmpty() {
        head = null;
        size = 0;
    }
    
    // Find element with given ID
    public AnyType findID(int ID) {
        if (head == null) {
            return null;
        }
        
        Node<AnyType> current = head;
        while (current != null) {
            if (current.data.getID() == ID) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }
    
    // Add element at front if ID doesn't exist yet
    public boolean insertAtFront(AnyType x) {
        int targetID = x.getID();
        if (findID(targetID) != null) {
            return false; // ID already exists
        }

        head = new Node<>(x, head);
        size++;
        return true;
    }

    // Remove and return the first element
    public AnyType deleteFromFront() {
        if (head == null) {
            return null;
        }

        AnyType elementToReturn = head.data;
        head = head.next;
        size--;
        return elementToReturn;
    }

    // Remove element with specified ID
    public AnyType delete(int ID) {
        if (head == null) {
            return null;  
        }
        
        // Special case: deleting head node
        if (head.data.getID() == ID) {
            AnyType elementToReturn = head.data;
            head = head.next;
            size--;
            return elementToReturn;
        }
        
        // Search for node with matching ID
        Node<AnyType> current = head.next;  
        Node<AnyType> previous = head; 

        while (current != null) {
            if (current.data.getID() == ID) {
                AnyType elementToReturn = current.data;
                previous.next = current.next; // Bypass the node
                size--;
                return elementToReturn;
            }
            
            previous = current;
            current = current.next;
        }

        return null; // ID not found
    }

    // Calculate sum of all IDs in the list
    public int printTotal() {
        if (head == null) {
            return -1; // Empty list case  
        }
        
        int sum = 0;
        Node<AnyType> current = head;
        
        while (current != null) {
            sum += current.data.getID();
            current = current.next;
        }
        
        return sum;
    }
}