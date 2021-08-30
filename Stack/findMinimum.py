
class MinStack:

    def __init__(self, size):
        self.size = size
        self.stk = []
        self.minStk = []
        self.brim = -1
    
    def isEmpty(self): return (self.brim == -1)
    def isFull(self): return (self.brim == self.size)


    '''
        This code is not optimized for space therefore i will make one that is

        def push(self, data):
            if(self.isFull()):
                raise Exception("Stack is full!")
            else:
                if(self.isEmpty()):
                    self.minStk.append(data)
                else:
                    if(self.minStk[-1] <= data):
                        self.minStk.append(self.minStk[-1])
                    else:
                        self.minStk.append(data)
                self.stk.append(data)
                self.brim+=1
    '''

    #This code is optimized for space

    def push(self, data):
        if(self.isFull()):
            raise Exception("Stack is full!")
        else:
            if(self.isEmpty()):
                self.minStk.append(data)
            else:
                if(self.minStk[-1] >= data):
                    self.minStk.append(self.minStk[-1])
            self.stk.append(data)
            self.brim+=1

    def top(self): return self.stk[-1]
    '''
    def pop(self):
        if(self.isEmpty()):
            raise Exception("Cannot pop")
        else:
            self.minStk.pop(-1)
            self.brim-=1
            return self.stk.pop(-1)
    '''

    def pop(self):
        if(self.isEmpty()):
            raise Exception("Cannot pop empty stack")
        else:
            if(self.stk[-1] == self.minStk[-1]):
                self.minStk.pop(-1)
            self.brim-=1
            return self.stk.pop(-1)

    def FindMin(self):
        return self.minStk[-1]

if __name__ == '__main__':
    n = int(input())
    stk = MinStack(n)

    stk.push(-1)
    stk.pop()
    for _ in range(n):
        x = int(input())
        stk.push(x)
    
    stk.pop()

    print(f"The minimum value in stack is {stk.FindMin()}")