package collectons.map.cache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * TODO
 * 
 * @author ivo.rusev
 *
 * @param <Key>
 * @param <Value>
 */
public class LRUCache<Key, Value> implements Map<Key, Value> {

	private Map<Key, Value> cache;
	private Queue<Key> hits;
	private int size;

	public LRUCache(int size) {
		cache = new HashMap<>(size);
		hits = new LinkedBlockingQueue(size);
		this.size = size;
	}

	@Override
	public Value put(Key key, Value value) {
		if (size <= cache.size()) {
			Key keyToRemove = hits.poll();
			cache.remove(keyToRemove);
		}
		hits.add(key);
		return cache.put(key, value);
	}

	@Override
	public Value get(Object key) {
		if (hits.remove(key) == false) {
			System.out.println("Element ccould not be found");
			return null;
		}
		Key keyToAdd = (Key) key;
		hits.add(keyToAdd);
		return cache.get(key);
	}

	@Override
	public int size() {
		return cache.size();
	}

	@Override
	public boolean isEmpty() {
		return cache.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public boolean containsValue(Object value) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Value remove(Object key) {
		hits.remove(key);
		return cache.remove(key);
	}

	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) {
		throw new UnsupportedOperationException("Not implemented");

	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("Not implemented");

	}

	@Override
	public Set<Key> keySet() {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Collection<Value> values() {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Set<Entry<Key, Value>> entrySet() {
		throw new UnsupportedOperationException("Not implemented");
	}

}
