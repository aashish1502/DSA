#include<bits/stdc++.h>
using namespace std;

class LinkedListNode{ 

public:
    int data;
    LinkedListNode* next;
};

LinkedListNode* CreateNode(int Data){
        LinkedListNode* node = new LinkedListNode;
        node->data = Data;
        node->next = nullptr;
        return node;
}

void PrintList(LinkedListNode* head){
    LinkedListNode* temp = head;
    while (temp != nullptr)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl ;
    
}

void Insert(LinkedListNode* head, int data){

    LinkedListNode* temp = head;
    while (temp->next != nullptr)
    {
        temp = temp->next;
    }
    temp->next = CreateNode(data);
    
}

void FindNthNode(LinkedListNode* head, int place){


    LinkedListNode* temp = head;
    LinkedListNode* Buffer = head;
    int counter = place;

    while(counter--)    Buffer = Buffer->next;

    while(Buffer->next != nullptr){
        Buffer = Buffer->next;
        temp = temp->next;
    }

    cout << "The Nth element from the last is: " << temp->data << endl;

}


int main(void){

    int size; 
    cout << "Enter the size of the list: ";
    cin >> size;

    int n;
    cout<<"Enter the first element: " ;
    cin >> n;

    LinkedListNode* head = CreateNode(n);
    for(int i = 1 ; i < size ; i++) {
        int data;
        cout<<"Enter the " << i+1 << " element:";
        cin >> data;
        Insert(head, data);
    }

    PrintList(head);

    FindNthNode(head, 1);

}