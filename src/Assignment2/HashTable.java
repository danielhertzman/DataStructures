package Assignment2;
import java.util.*;


/**
 * Represent a hash table
 * @author danielhertzman-ericson
 *
 */
public class HashTable {
	
	private LinkedList<Object> insertionOrder = new LinkedList<Object>();
	public LinkedList<Entry>[] table;
	
	public HashTable(int size) {
		
		table = (LinkedList<Entry>[]) new LinkedList<?>[size];
		
		for (int i = 0; i < size; i++) {
			table[i] = new LinkedList<Entry>();
		}		
	}
	
	/**
	 * Generates and returns an index value
	 * @param key
	 * @return index value
	 */
	private int hashIndex(Object key) {
		int hashCode = key.hashCode();
		hashCode = hashCode % table.length;
		return (hashCode < 0) ? -hashCode : hashCode;
	}
	
	/**
	 * Get a value from a specified key
	 * @param key
	 * @return the value from the key (not the key itself)
	 */
	public Object get(Object key) {
		
		int hashIndex = hashIndex(key);
		
		LinkedList<Entry> entries = table[hashIndex];
		Iterator<Entry> it = entries.listIterator();
		
		while(it.hasNext()) {
			Entry entry = it.next();
			
			if (entry.equals(key)) {
				return entry.getValue();
			}
		}
		
		return null;
	}
	
	/**
	 * Returns the number of elements in the insertion order
	 * @return the number of elements
	 */
	public int count() {
		return insertionOrder.size();
	}
	
	/**
	 * Create a new entry with a key and a value. 
	 * We then place the value last in insertion order.
	 * @param key, the key
	 * @param value, the value
	 */
	public void put(Object key, Object value) {
		
		if (get(key) == null) {
			
			Entry newEntry = new Entry(key, value);
			table[hashIndex(key)].add(newEntry);
			insertionOrder.addLast(value);
			
		}
		
	}
	
	/**
	 * Returns the whole insertion order (all of the values)
	 * @return The list of values
	 */
	public LinkedList<Object> getInsertionOrder() {
		
		return insertionOrder;
		
	}
	
	/**
	 * Allows you to remove a key and its value
	 * @param key to be removed along with its value
	 */
	public void remove(Object key) {
		
		// simply removes a value from a specified key
		insertionOrder.remove(get(key));
		
		for (int i = 0; i < table[hashIndex(key)].size(); i++) {
	
			table[hashIndex(key)].remove(i);

		}
	}
}	
