package pekan4_2511531005;

public class QueueArrayDriver_2511531005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueueArray_2511531005 queue = new QueueArray_2511531005(1000);
		queue.enqueue_1005(10);
		queue.enqueue_1005(20);
		queue.enqueue_1005(30);
		queue.enqueue_1005(40);
		System.out.println("item di depan " + queue.front_1005());
		System.out.println("item paling belakang " + queue.rear_1005());
		System.out.println("tampilan queue");
		queue.display_1005();
		System.out.println();
		System.out.println(queue.dequeue_1005() + " dihapus dari queue");
		System.out.println("item di depan : " + queue.front_1005());
		System.out.println("item di belakang : " + queue.rear_1005());
		System.out.println("tampilan queue setalah satu data dihapus");
		queue.display_1005();
		
	}

}
