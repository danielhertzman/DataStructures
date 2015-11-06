package assignment1;

public class TestStack {
	private static boolean NDEBUG = true;
	
	public static void main(String[] args) {		
		int myObject1 = 1;
		String myObject2 = "myObject2";
		String myObject3 = "myObject3";
		
		Stack myStack = new Stack();
		assertTest(myStack.size() == 0, "Not correct number of Nodes");
		assertTest(myStack.peek() == null, "Peek is not correct");
		myStack.push(myObject1);
		myStack.push(myObject2);
		assertTest(myStack.size() == 2, "Not correct number of Nodes");
		myStack.push(myObject3);
		assertTest(myStack.peek() == myObject3, "Peek is not correct");
		assertTest(myStack.size() == 3, "Not correct number of Nodes");
				
		assertTest(myStack.pop() == myObject3, "Pop is not correct");
		assertTest(myStack.peek() == myObject2, "Stack is not correct");
		
		myStack.pop();	
		String myObject4 = "myObject4";
		myStack.push(myObject4);
		assertTest(myStack.peek() == myObject4, "Peek is not correct");

		myStack.pop();
		assertTest((int)myStack.pop() == 1, "Pop is not correct");
		myStack.pop();
		myStack.pop();
		assertTest(myStack.pop() == null, "Pop is not correct");
		
		System.out.println("All code is working");
	}

   private static void printStack(String why) {
	   Throwable t = new Throwable(why);
	   t.printStackTrace();
	   System.exit(1);
   }

   public static void assertTest(boolean expression, String why) {
	   if (NDEBUG && !expression) {
		   printStack(why);
	   }
   }
}
