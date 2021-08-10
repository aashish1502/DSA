class LinkedListNode:
    
    def __init__(self, data):
        self.data = data
        self.next = None

    def Insert(self, data):
        node = LinkedListNode(data)
        temp = self
        while(temp.next != None):
            temp = temp.next
        temp.next = node

    def FindMiddle(self):
        Slow, Fast = self, self
        while(Fast != None):
            Fast = Fast.next
            if(Fast != None):
                Fast = Fast.next
                Slow = Slow.next
        return Slow.data

if __name__ == "__main__":
    n = int(input())
    n-=1
    x = int(input()) 
    head = LinkedListNode(x)

    for i in range(n):
        x = int(input())
        head.Insert(x)

    print(head.FindMiddle())        
