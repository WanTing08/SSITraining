package hw2.topic_ExecutorService;

/*
    Define a inner class A has method “getMethod()” which return string “A.getMethod” and another inner class B has
    method “getMethod()” which return string “B.getMethod”.

    write another method “runSameTime()” which should let A and B getMethod to run at the same time, but the
    “runSameTime()” method should return a string “B.getMethod A.getMethod”
 */
public class OuterClass {
    public class A{
        public String getMthod(){
            return "A.getMethod()";
        }
    }

    public class B{
        public String getMethod(){
            return "B.getmethod()";
        }
    }

    public String runSameTime() throws InterruptedException{
        final StringBuilder sb = new StringBuilder();

        Thread threadA = new Thread(() -> {
            A a = new A();
            sb.append(a.getMthod());
        });

        Thread threadB = new Thread(() -> {
            B b = new B();
            sb.append(b.getMethod());
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        return sb.toString();
    }

    public static void main(String[] args) throws InterruptedException{
        OuterClass outer = new OuterClass();
        String result = outer.runSameTime();
        System.out.println(result);
    }
}
