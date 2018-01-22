package DataStructure;

class Stack {
	private int maxTop;
	private int top;
	double[] values;
	public Stack(int size){
		values = new double[size];
		top = -1;
		maxTop = size - 1;
	}
	
	public void push(double x){
		if(isFull())
			System.out.println("Error: the stack is full");
		else
			values[++top] = x;
	}
	
	public double pop(){
		if(isEmpty()){
			System.out.println("Error : the stack is empty.");
			return -1;
		}else {
			return values[top--];
		} 
	}

	private boolean isEmpty() {
		// TODO Auto-generated method stub
		if(top == -1){
			return true;
		}else{
			return false;
		}
	}

	private boolean isFull() {
		// TODO Auto-generated method stub
		if(top == maxTop){
			return true;
		}else{
			return false;
		}
	}

}
