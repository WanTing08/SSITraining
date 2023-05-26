package hw1.topic2_final;

/*
    Define a final class and final method and final variable, modify the value of the variable in final method

    Note: A final variable can only be assigned once, but its value can be modified if it refers to a mutable object.
 */
public final class MyClass {
    private final int val;

    public MyClass(int value){
        val = value;
    }

    public final void printVal(){
        System.out.println(val);
    }

    public static void main(String[] args) {
        MyClass object = new MyClass(1);
        object.printVal();
    }
}
