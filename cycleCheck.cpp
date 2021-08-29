#include<bits/stdc++.h>
using namespace std;


class LinkedListNode{
    public:
    int data;
    LinkedListNode* next;
};

LinkedListNode* CreateNode(int Data) {

    LinkedListNode* node = new LinkedListNode;
    node-> data = Data;
    node -> next = nullptr;
    return node;
}

void Insert(LinkedListNode* head, int data) {

    LinkedListNode* temp = head;
    while(temp->next != nullptr) temp=temp->next;
    temp->next = CreateNode(data);

}

//Method 1



