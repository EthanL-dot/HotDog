public class Itinerary {

    private static class Node
    {
        private Destination element;
        private Node next;
        public Node(Destination d, Node n)
        {
            element = d;
            next = n;
        }

        public Destination getElement() {
            return element;
        }

        public void setElement(Destination d)
        {
            element = d;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    //Do NOT manipulate the Node class. The only code I should see with your code is in the methods vacation length,
    // the two add methods, and the remove method below. We are using a SINGLY LINKED LIST for this exercise.
    private Node head, tail;
    private int size;

    public Itinerary()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public Node getFirst()
    {
        if(size == 0)
            return null;
        return head;
    }

    public Node getLast()
    {
        if(size == 0)
            return null;
        return tail;
    }

    public String vacationLength()
    {
        //returns the length of your journey with this format: #“ months, ”#“ days.” For simplicity, assume each month is 30 days long.

        /*before starting we need to think about how to approach this. If I had a book and each page had a city and the number of days im staying there,
        I would mentally start with 0, and as I flip through each page I add the number that I see on each page to this mental sum.
        When I'm done with the book, ill know how long, in days, my vacation is by adding the number on each page
        */
        int len = 0;
        /*To conduct the traversal, I don't want to manipulate the existing pointers, such as head or tail, or else I risk
        damaging the linked list properties. So I create a new Node variable that I can change without changing the list properties.
         */
        Node n = head;
        while(n != null);
        {
            //each Node has a Destination object embedded in it. To access this object, you'll need to do n.getElement().
            //len+= some property of destination
            //n.getNext(); you need this line, which does the actual travelling from left to right


            len += n.getElement().getDuration();
            n = n.getNext();
        }

        //once you have the length of your journey in days, the last part shouldn't be challenging

        int m = len /30;
        int days =  len % 30 ;
        return m + days +"";
    }

    public void addDestinationToFront(Destination d)
    {
        //adds a new destination object to the front of your itinerary. Write ALL code BEFORE the if statement

        /*Remember our steps
        1 Allocate new node
        2 Insert new element
        3 Have new node point to old head
        4 Have head point to new node

        Steps 1-3 means creating a Node whose element is made of a destination object. It won't be fully inserted once we create it but we must
        CREATE the node before we can try slipping it into the list.*/
        /*
        So now our new node (#1) has destination d (#2), and its next node is assigned as the current HEAD of the list (#3).
        Obviously, the HEAD is the FIRST node in the list, so you'll need to reassign the head instance variable. I'll leave #4 to you.
         */
        Node newest = new Node(d, head);
        Node getNext = head;
        head = newest;
        size += 1;


        if(size == 1)
        {
            tail = head;
        }

    }

    public void addDestinationtoBack(Destination d) {
        //adds a new destination object to the back of your itinerary.Write ALL code BEFORE the if statement
        /*1 Allocate new node
        2 Insert new element
        3 Have new node point to null
        4 Have old last node point to new node (with setNext)
        5 Reassign tail to new node

        Like last time, generate the new node first!
         */
         /* So we have an uninserted new Node (#1) with element that's destination object d (#2), and points to null (#3), which makes
        sense since we are putting this at the END of the singly linked list.
        To complete #4, remember that the "old last node" referred to is the tail.
        To compplete #5, reassign the tail instance variable.
         */

        Node newest = new Node(d, null);
        newest = null;
        tail.setNext(newest);
        tail = newest;
        size +=1;



        if(size == 1)
        {
            head = tail;
        }
    }


    public void removeDestination()
    {
        //removes the head destination object in the itinerary.Write ALL code BEFORE the if statement
        //reassign the head instance variable to next node in the list. You shoudl have more than one line of code though,
        // check the instance variables provided to see why.
        Node n = head;
        //Void remove(head);
        n.getNext();

        if(size == 1)
        {
            head = tail;
            tail = head;
        }
    }


    public static void main (String[] args) {
        Itinerary i = new Itinerary();
        i.addDestinationToFront(new Destination("Rio", 14));
        i.addDestinationToFront(new Destination("New York", 14));
        i.addDestinationToFront(new Destination("Vancouver", 21));
        i.addDestinationtoBack(new Destination("London", 30));//error here
        i.addDestinationtoBack(new Destination("Paris", 21));
        i.addDestinationtoBack(new Destination("Geneva", 14));
        i.addDestinationtoBack(new Destination("Milan", 21));
        i.addDestinationtoBack(new Destination("Johannesburg", 14));
        i.addDestinationtoBack(new Destination("Shanghai", 30));
        i.addDestinationtoBack(new Destination("Seoul", 28));
        i.addDestinationtoBack(new Destination("Tokyo", 28));
        System.out.print(i.toString());
        System.out.println(i.vacationLength());
        i.removeDestination();
        i.removeDestination();
        i.removeDestination();
        System.out.print(i.toString());
        System.out.println(i.vacationLength());

    }


}