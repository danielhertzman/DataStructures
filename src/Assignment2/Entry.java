package Assignment2;

/**
 * Represents an entry in the hash table.
 * An entry contains of a key and a value.
 * @author danielhertzman-ericson
 *
 */
public class Entry {
	
	private Object key;
	private Object value;
	
	public Entry(Object key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Compares two keys with each other. 
	 * @param obj The key that is to be compared
	 * @return True if keys match
	 */
	public boolean equals(Object obj) {
		Entry keyToCompare = new Entry(obj, null);
		return key.equals(keyToCompare.key);
	}
	
	/**
	 * Returns the value of the Entry
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

}
