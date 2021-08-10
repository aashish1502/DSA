
'''
    To find the intersection of two merging Lists
    Techniques used:
        1. Using a List.
        2. Using 2 Stacks.
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
    

def FindMerge_0(head1, head2):
    temp1, temp2 = head1, head2
    Addr = set()

    while(temp1 != None):
        Addr.add(temp1)
        temp1 = temp1.next
    
    while(temp2 != None):
        if(temp2 not in Addr): Addr.add(temp2)
        else: return temp2.data
        temp2 = temp2.next

def FindMerge_1(head1, head2):

    temp1, temp2 = head1, head2

    stack1 = []
    stack2 = []

    while(temp1 != None):
        stack1.append(temp1)
        temp1 = temp1.next

    while(temp2 != None):
        stack2.append(temp2)
        temp2 = temp2.next
    
    while(len(stack1) != 0 and len(stack2) != 0):
        if(stack1[-1] == stack1[-1]):
            ref = stack1[-1]
            stack1.pop(-1)
            stack2.pop(-1)
        else:
            return ref.data

    


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
