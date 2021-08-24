#include<bits/stdc++.h>
using namespace std;

class LinkedListNode{
    public:
        int data;
        LinkedListNode* next;
};

LinkedListNode* CreatNode(int data){
    LinkedListNode* node = new LinkedListNode;
    node->data = data;
    node->next = nullptr;

    return node;
}

void Insert(LinkedListNode* head, int data){
    
    LinkedListNode* node = CreatNode(data);
    if(head == nullptr){
        cout << "made a new node"<<endl;
        head = node;
    }
    LinkedListNode* temp = head;

    while(temp->next != nullptr) temp = temp->next;
    temp->next = node;

}

LinkedListNode* MergeAndSort(LinkedListNode* head1, LinkedListNode* head2){

    LinkedListNode* head = nullptr;
    if(head1 == nullptr) return head2;
    if(head2 == nullptr) return head1;

    if(head1->data >= head2->data){
        head = head1;
        head->next = MergeAndSort(head1->next, head2);
    }
    else{
        head = head2;
        head->next = MergeAndSort(head1, head2->next);
    }

    return head;

}

void PrintLL(LinkedListNode* head){

    LinkedListNode* temp = head;

    while(!head){
        cout << temp->data << " ";
        temp = temp->next;
    }

}


int main(void){

    int n, x;
    cin >> n;
    LinkedListNode* head1 = CreatNode(2);

    while(n--){
        cin >> x;
        Insert(head1, x);
    }

    cout << "Printing the LL"<<endl;
    PrintLL(head1);

    cin >> n;
    LinkedListNode* head2 = CreatNode(5);

    while(n--){
        cin >> x;
        Insert(head2, x);
    }

    LinkedListNode* head =  MergeAndSort(head1, head2);

    PrintLL(head);

}