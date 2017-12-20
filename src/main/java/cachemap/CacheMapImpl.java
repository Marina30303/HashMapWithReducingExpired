package cachemap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Марiна on 10.06.2017.
 */
public class CacheMapImpl <K,V> implements CacheMap <K,V> {


    HashMap<K, Entri<V>> map = new HashMap();

    private long timeToLive = 1000;


    static class Entri<V> {

        V value;
        long startTime ;
        public V getValue() {
            return value;
        }

        public long getStartTime() {
            return startTime;
        }

        public Entri(V value){
            this.value = value;
            startTime = System.currentTimeMillis();
        }
    }
    public void clearExpired() {

        Entri<V> e;
              Iterator<Map.Entry<K, Entri<V>>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<K, Entri<V>> entry = entries.next();
            e=entry.getValue();
                      if (System.currentTimeMillis()-e.getStartTime() > getTimeToLive())
                entries.remove();

        }
    }

    public void setTimeToLive(long timeToLive) {

       this.timeToLive=timeToLive;

    }

    public long getTimeToLive() {

        return timeToLive;
    }


    public V put(K key, V value) {


        return (V) map.put((K)key, new Entri<V>(value));

    }
    public void clear() {
        map.clear();

    }

    public boolean containsKey(Object key) {
        clearExpired();
        return map.containsKey((K)key);
    }

    public boolean containsValue(Object value) {
        clearExpired();
        Entri<V> e;
        for (Map.Entry<K, Entri<V>> entry : map.entrySet()) {

                e = entry.getValue();
            if (e.getValue().equals(value))
                return true;
       }

        return false;
    }

    public V get(Object key) {

        clearExpired();
        Entri<V> e;
        for (Map.Entry<K, Entri<V>> entry : map.entrySet()) {

            if (entry.getKey().equals(key)) {
                e = entry.getValue();
                return e.getValue();
            }

        }

        return null;
    }

    public boolean isEmpty() {

       clearExpired();
       return map.isEmpty();
    }

    public Object remove(Object key) {

       // clearExpired();
        Entri<V> e;

        for (Map.Entry<K, Entri<V>> entry : map.entrySet()) {

            if (entry.getKey().equals(key)) {
                map.remove(key);
                e = entry.getValue();
                return e.getValue();
            }

        }
       return null;

    }

    public int size() {
        clearExpired();
        return map.size();
    }


}
