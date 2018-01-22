package DataStructure;

class Queue {

	private int front;
	private int rear;
	private int counter;
	private int maxSize;
	private double[] values;
	public Queue(int size) {
		// TODO Auto-generated constructor stub
		values = new double[size];
		maxSize = size;
		front = 0;
		rear = -1;
		counter = 0;
	}
	
	public boolean Enqueue(double x){
		if(isFull()){
			System.out.println("Error : the queue is full");
			return false;
		}else {
			//calculate the new rear position(circular)
			rear = (rear + 1) % maxSize;
			//insert new item
			values[rear] = x;
			counter++;
			return true;
		}
	}
	
	public double Dequeue(){
		if(isEmpty()){
			System.out.println("Error : the queue is empty");
			return -1;
		}else{
			double x = values[front];
			front = (front + 1) % maxSize;
			counter--;
			return x;
		}
	}
	public boolean isEmpty(){
		if(counter <= 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isFull(){
		if(counter < maxSize){
			return false;
		}else{
			return true;
		}
	}
	public void extendCapacity(int capacity){
		if(capacity <= maxSize){
			return;
		}
		double[] old = values;
		values = new double[capacity];
		int j = 0;
		//复制元素
	     for (int i = front; i != rear ; i = (i+1) % old.length) {
	         values[j++] = old[i];
	     }
	     //恢复front,rear指向
	     this.front=0;
	     this.rear=j;
	}
}
