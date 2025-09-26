
package p3;

public class StackApp {

    public static void main(String[] args) {
        Stack theStack = new Stack(10);
        System.out.println(">> push someitems");
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);
        System.out.println("\n>> pop itemsin the stack");
        while (!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.print(value + " ");
            System.out.print("");
        }
        System.out.println();
    }
}
