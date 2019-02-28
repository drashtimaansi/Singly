package doubly;

public class DoublyLinkedList {
    private static class Node {
        private int data;
        private Node prev = null, next = null;

        public Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }
    }

    private int size = 0;
    private Node head = null;
    private Node tail = null;

    @Override
    public String toString() {
        StringBuilder response = new StringBuilder();

        if (size == 0) {
            response.append("[]");
        } else {
            response.append("[");
            Node temp = this.head;
            while (temp != null) {
                response.append(temp.data);

                if (temp.next != null) {
                    response.append(" ==> ");
                }
                temp = temp.next;
            }

            response.append("]");
            }
        return response.toString();

    }

    public void insertHead(int data){
//        Node newNode = new Node(data,null,this.head);
//        this.head=newNode; OR
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev =newNode;
            head = newNode;
        }
      size++;
//
    }

    public void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            insertHead(data);
        }else{
            Node temp = head;
            while(temp.next!=null){
                temp=temp.next;
            }
            newNode.next=temp.next;
            newNode.prev=temp;
            temp.next = newNode;
            tail = newNode;
            size++;
        }
    }

//deletes only last element
    public int delete(){
        int response =-1;
        if(head != null){
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            response = temp.data;
            temp = temp.prev;
            temp.next = null;
            size--;
        }
        return response;
    }

    public int removeHead(){
        int response =-1;

        if(head != null){
            Node temp = head.next;
            response=temp.data;
            temp.prev =null;
            head = temp;

        }

        return response;
    }

    public int removeAfter(Node node){
        int response = -1;

        if(node.next != null){
            Node temp = node.next;
            response = temp.data;

            node.next = temp.next;
            temp.next.prev = temp.prev;

            size--;
        }

    return response;
    }

    public int remove(int data){
        int response = -1;

        if(head.data == data){
            removeHead();
        }else{
            Node temp = head;
            while (temp.next != null){
                if(temp.next.data == data){
                    removeAfter(temp);
                    break;
                }
                temp = temp.next;
            }
        }
        return response;
    }

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        System.out.println(linkedList);
        for (int i=0;i<5;i++){
            linkedList.insert(i+1);
        }
        linkedList.removeHead();
       int delete = linkedList.delete();
        System.out.println(delete);
        System.out.println(linkedList);

    }
}