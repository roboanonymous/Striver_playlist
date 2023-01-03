package Graph;
import java.util.ArrayList;
import java.util.HashMap;



public class HeapGeneric<T extends Comparable<T>> {

	private ArrayList<T> data = new ArrayList<>();
	private HashMap<T, Integer> indexes = new HashMap<>();

	public int size() {
		return data.size();
	}

	public void display() {
		System.out.println(this.data);
	}

	public void insert(T item) {

		data.add(item);
		upheapify(this.size() - 1);
		indexes.put(item, data.size() - 1);
	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (isLarger(data.get(ci), data.get(pi)) > 0) {
			swap(ci, pi);
			upheapify(pi);
		}
	}

	private void swap(int i, int j) {

		T ith = data.get(i);
		T jth = data.get(j);

		data.set(i, jth);
		data.set(j, ith);

		indexes.put(ith, j);
		indexes.put(jth, i);
	}

	public T remove() {

		swap(0, data.size() - 1);
		T rv = data.remove(data.size() - 1);
		indexes.remove(rv);
		downheapify(0);
		return rv;

	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;

		if (lci < this.data.size() && isLarger(data.get(lci), data.get(mini)) > 0) {
			mini = lci;
		}
		if (rci < this.data.size() && isLarger(data.get(rci), data.get(mini)) > 0) {
			mini = rci;
		}

		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}

	}

	public T get() {
		return data.get(0);
	}

	public int isLarger(T t, T o) {
		return t.compareTo(o);
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void updatePriority(T pair) {

		// int idx = -1;
		//
		// for (int i = 0; i < this.data.size(); i++) {
		// if (data.get(i) == pair) {
		// idx = i;
		// }
		// }

		int idx = indexes.get(pair);

		upheapify(idx);
	}

}
