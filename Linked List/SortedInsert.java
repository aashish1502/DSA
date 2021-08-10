import java.util.Scanner;

class LinkedListNode{

    int data;
    LinkedListNode next;

    LinkedListNode(int data){
        this.data = data;
        this.next = null;
    }

    void ViewList(){
        LinkedListNode temp = this;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    void InsertInASortedOrder(int data){
        LinkedListNode temp1 = this, temp2 = this;

        if(data < temp1.data){
            // System.out.println("Changing the head");
            LinkedListNode node = new LinkedListNode(this.data);
            node.next = temp1.next;
            this.next = node;
            this.data = data;
        }
        else if(temp2.next == null){
            LinkedListNode node = new LinkedListNode(data);
            temp2.next = node;
        }
        else{
            temp2 = temp2.next;

            while(temp2 != null){
                if(temp1.data < data && temp2.data > data){
                    LinkedListNode node = new LinkedListNode(data);
                    node.next = temp1.next;
                    temp1.next = node;   
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        if(temp1.next == null){
            LinkedListNode node = new LinkedListNode(data);
            temp1.next = node;
        }

    }

}



public class SortedInsert {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Linked List: ");
        int n = sc.nextInt();
        n--;
        System.out.println("Enter the numbers");
        int x = sc.nextInt();
        LinkedListNode head = new LinkedListNode(x);
        
        while(n-- != 0){
            x = sc.nextInt();
            head.InsertInASortedOrder(x);
        }

        head.ViewList();

        sc.close();
    }
}
