import java.util.ArrayList;
public class Min_heap{
	
	static ArrayList<Integer> data = new ArrayList<>();

	public void add(int item){

		data.add(item);
		upheapify(data.size()-1);

	}

	private void upheapify(int childIdx){

		int parentIdx = (childIdx-1)/2;

		// here greater sign is deciding factor min heap;
		// for max heap we have to set in opposite way -> upheapify and downheapify method

		if(data.get(childIdx) < data.get(parentIdx)){
			swap(parentIdx,childIdx);
			upheapify(parentIdx);
		}

	}

	private int delete(){

		swap(0,this.data.size()-1);
		int removeValue = this.data.remove(this.data.size()-1);

		downHeapify(0);

		return removeValue;
	}

	private void downHeapify(int parentIdx){

		int leftChildIdx = 2*parentIdx+1;
		int rightChildIdx = 2*parentIdx+2;

		int mini = parentIdx;

		if(leftChildIdx < this.data.size() && data.get(leftChildIdx)<data.get(mini)){
			mini = leftChildIdx;
		}

		if(rightChildIdx < this.data.size() &&  data.get(rightChildIdx)<data.get(mini)){
			mini = rightChildIdx;
		}

		if(mini != parentIdx){
			swap(mini,parentIdx);
			downHeapify(mini);
		}

	}	

	private void swap(int i,int j){

		int ith = data.get(i);
		int jth  = data.get(j);

		data.set(i,jth);
		data.set(j,ith);

	}

	public static void main(String[] args) {
		
		Min_heap mh = new Min_heap();
		mh.add(10);
		mh.add(20);
		mh.add(40);
		mh.add(30);
		mh.add(5);

		
		System.out.println(mh.delete());
		System.out.println(mh.delete());
		System.out.println(mh.delete());
		System.out.println(mh.delete());
		System.out.println(mh.delete());
		
	}
}