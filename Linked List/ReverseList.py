
'''

This code is for reversing a Linked List by creating a new list from end rather then to go through some bruteforced method.

'''

class LinkedList:
    def __init__(self, data):
        self.data = data
        self.next = None
    
    def Insert(self, data):
        temp = self
        while(temp.next != None):
            temp=temp.next
        node = LinkedList(data)
        temp.next = node
    
    def ViewList(self):
        temp = self
        while(temp != None):
            print(f'{temp.data}',end=" ")
            temp = temp.next
        print()
    
    def ReverseList(self):
        temp = self
        Rev = None
        while(temp != None):
            new = LinkedList(temp.data)
            new.next = Rev
            Rev = new 
            temp = temp.next
        return Rev



if __name__ == "__main__":
    n = int(input()) - 1 
    data = int(input())
    head = LinkedList(data)

    for _ in range(n):
        data = int(input())
        head.Insert(data)
    
    head.ViewList()
    Rev = head.ReverseList()
    Rev.ViewList()
