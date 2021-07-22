#include<bits/stdc++.h>
using namespace std;

class LinkedListNode {
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

void InsertNode(LinkedListNode* head, int data){

    LinkedListNode* temp = head;
    while(temp->next != nullptr) temp = temp->next;
    temp->next = CreateNode(data);
}

//Method 1: Adding the addressess into a vector

bool FindCycle(LinkedListNode* head) {

    vector<LinkedListNode*> addr;
    LinkedListNode* temp = head;
    while(temp != nullptr){
        
        for(int i = 0 ; i < addr.size() ;i++) 
            if(addr[i] == temp) return true;
        
        addr.push_back(temp);
        temp = temp->next;
    }

    return false;

}

//Method 2: use a hash map for fast access .... i didn't want to code it so...

// Method 3: Time to do some racing :))
bool FindCycle_3(LinkedListNode* head) {

    LinkedListNode* FastBoi = head;
    LinkedListNode* SlowBoi = head;

    while(FastBoi != nullptr){

        SlowBoi = SlowBoi->next;
        FastBoi = FastBoi->next;
        if(FastBoi != nullptr){
            FastBoi = FastBoi->next;
        }

        if(FastBoi == SlowBoi){
            return true;
        }

    }

    return false;

}



void LoopPos(LinkedListNode* head, int pos){

    LinkedListNode* temp = head;
    LinkedListNode* looped;
    while(pos--) {
        temp = temp->next;
    }
    looped = temp;

    while(temp->next != nullptr){
        temp = temp->next;
    }
    temp->next = looped;
}


int main(void) {

    int len, x;
    cin >> len;
    cin >> x ;

    LinkedListNode* head = CreateNode(x);

    for(int i = 0 ; i < len -1 ; i++){
        cin >> x;
        InsertNode(head, x);
    }

    // LoopPos(head, 4);

    bool cycle = FindCycle_3(head);

    if(cycle) cout << "The linked list has a loop";
    else cout << "The LL does not have a loop";

}