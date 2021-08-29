import java.util.*;

// This program checks if an expression is balanced or not


class Stack{

    char stk[];
    int end = -1;
    int size;
    Stack(int size){
        this.size = size;
        this.stk = new char[size];
    }

    boolean IsEmpty(){ return this.end  == -1 ?  true : false;}

    boolean IsFull(){ return this.end == this.size ? true : false ;}

    char Peek(){
        if(this.IsEmpty() != true) return stk[end];
        else throw new EmptyStackException();
    }

    char pop(){
        if(this.IsEmpty() != true){
            char x = stk[end];
            end -= 1;
            return x;
        }
        else throw new EmptyStackException();
    }

    void push(char data){
        if(IsFull() != true){
            end += 1;
            stk[end] = data;
        }
    }

}


class Expression{

    String expression;

    Expression(String expression){
        this.expression = expression;
    }

    Boolean IsBalanced(){
        Stack stk = new Stack(expression.length());

        for(int i = 0 ; i < expression.length() ; i++) {

            if(expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '['){
                stk.push(expression.charAt(i));
            }

            if(expression.charAt(i) == ')'){
                if(stk.Peek() == '(') stk.pop();
                else break;
            }

            if(expression.charAt(i) == '}'){
                if(stk.Peek() == '{') stk.pop();
                else break;
            }

            if(expression.charAt(i) == ']'){
                if(stk.Peek() == '[') stk.pop();
                else break;
            }

        }

        return stk.IsEmpty();

    }
}

public class BalancedExpression{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        Expression expression = new Expression(expr);
        System.out.println(expression.IsBalanced() ? "The Expression is balanced" : "The Expression is not balanced");
        sc.close();
    }

}