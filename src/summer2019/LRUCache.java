package summer2019;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
    int size = 0;
    public LRUCache(int capacity){
        this.size = capacity;
    }

    public int get(int key) {
        if(map.keySet().contains(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.keySet().contains(key)){
            map.remove(key);
            map.put(key,value);
        }
        else{
            size++;
            if(size == map.size()){
                Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
                Map.Entry<Integer,Integer> m = iterator.next();
                map.remove(m.getKey());
            }
            map.put(key,value);
        }

    }
}
