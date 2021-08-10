import java.lang.*;
import java.util.Scanner;

/*

This code has the solution for the following Questions:
    1. Finding a Loop in a Linked List
    2. Finding the Start node of the Loop in a Linked List. (head.LoopStartFind())
    3. Finding the Length of the Loop in a Linked List. (head.FindLengthOfLoop())
    
    ~~~~~~~~~~~ <3 ~~~~~~~~~~~

*/

class LinkedListNode {
    int data;
    LinkedListNode next;

    LinkedListNode(int data){

        this.data = data;
        this.next = null;

    }

    void InsertNode(int data){

        LinkedListNode Node = new LinkedListNode(data);
        LinkedListNode temp = this;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = Node;
    }

    void ViewList(){
        LinkedListNode temp = this;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    LinkedListNode LoopStartFind(){

        LinkedListNode SlowPtr = this , FastPtr  = this;
        boolean LoopExists = false;

        while(FastPtr != null){

            SlowPtr = SlowPtr.next;
            FastPtr = FastPtr.next; 
            if(FastPtr != null) FastPtr = FastPtr.next;

            if(FastPtr == SlowPtr){
                LoopExists = true;
                break;
            }

        }

        SlowPtr = this;

        if(LoopExists){
            while(SlowPtr != FastPtr){
                SlowPtr = SlowPtr.next;
                FastPtr = FastPtr.next;
            }
            return SlowPtr;
        }
        else System.out.println("There is no loop in the Linked List");
        return null;

    }

    int FindLengthOfLoop(){
        LinkedListNode Start = this.LoopStartFind();
        LinkedListNode Runner = Start.next;
        int Len = 1;

        while(Runner != Start){
            Runner = Runner.next;
            Len++;
        }
        return Len;
    }
    
    void MakeLoopAt(int pos){
        LinkedListNode temp = this, ref = this;

        while(pos-- != 0){
            temp = temp.next;
            ref = ref.next;
        }

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = ref;

    }

}

class LoopStartFinder{

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
            head.InsertNode(x);
        }

        head.MakeLoopAt(3);

        LinkedListNode loop = head.LoopStartFind();
        
        if(loop != null){
            int len = head.FindLengthOfLoop();
            System.out.println("The Length of the loop is " + len);
        }

        sc.close();
    }

}

