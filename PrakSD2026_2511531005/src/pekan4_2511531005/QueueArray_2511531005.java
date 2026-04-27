package pekan4_2511531005;

public class QueueArray_2511531005 {
	
	int front, rear, size;
	int capacity;
	int array[];
	
	public QueueArray_2511531005(int capacity) {
		this.capacity=capacity;
		front = this.size = 0;
		rear = capacity - 1 ;
		array = new int[this.capacity];
	}
	
	boolean isFull_1005(QueueArray_2511531005 queue) {
		return (queue.size == queue.capacity);
	}
	
	boolean isEmpty_1005(QueueArray_2511531005 queue) {
		return (queue.size==0);
	}
	
	void enqueue_1005(int item) {
		if (isFull_1005 (this))
			return;
		this.rear = (this.rear +1) % this.capacity;
		this.array[this.rear] = item;
		this.size = this.size + 1;
		System.out.println(item + " endqueue to queue");
	}
	
	int dequeue_1005() {
		if(isEmpty_1005(this))
			return Integer.MIN_VALUE;
		int item = this.array[this.front];
		this.front = (this.front + 1 ) % this.capacity;
		this.size = this.size -1;
		return item;
	}
	
	int front_1005() {
		if(isEmpty_1005(this))
			return Integer.MIN_VALUE;
		return this.array[this.front];
	}
	
	int rear_1005() {
		if (isEmpty_1005(this))
			return Integer.MIN_VALUE;
		return this.array[this.rear];
	}
	
	void display_1005() {
		int i;
		if(front == rear) {
			System.out.printf("\nAntrian kosong\n");
			return;
		}
		
		for (i = front; i < rear ; i++) {
			System.out.printf(" %d <== ", array[i]);
		}
		return;
	}

}
