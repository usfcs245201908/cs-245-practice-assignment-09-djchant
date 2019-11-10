public class BinaryHeap {
	int[] a;
	int size;

	public static void main(String[] args ) {
		BinaryHeap heap = new BinaryHeap();
		heap.add(1);
		heap.remove();
	}

	public BinaryHeap() {
		a = new int[10];
		size = 0;
	} 

	public void add(int item) {
		if(size == a.length) {
			int[] new_array = new int[a.length * 2];
			for(int i = 0; i < a.length; i++) {
				new_array[i] = a[i];
			}

			a = new_array;
		}

		a[++size] = item;

		int i = size;
		while(a[i] > a[(i - 1) / 2]) {
			swap(a, i, (i - 1) / 2);
			i = (i - 1) / 2;
		}
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public int remove() throws Exception {
		if(size <= 0) {
			throw new Exception("Array is empty");
		}

		swap(a, size, 1);
		siftdown(1);
		size--;

		return a[size + 1];
	}

	private void siftdown(int pos) {
		int largestChild = 1;

		while( !((pos > size/2) && (pos <= size)) ) {
			if(a[pos * 2] > a[(pos * 2) + 1]) {
				largestChild = pos * 2;
			} 
			if(a[pos] >= a[largestChild]) {
				return;
			}

			swap(a, pos, largestChild);
			pos = largestChild;
		}
		
	}
}





