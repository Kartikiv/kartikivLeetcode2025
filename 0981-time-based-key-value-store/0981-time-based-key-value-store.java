import java.util.*;

class TimeMap {
    HashMap<String, TreeMap<Integer, String> > map; 
    public TimeMap() {
       this.map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer,String> list =  map.getOrDefault(key, new TreeMap<>());
        list.put(timestamp, value);
        map.put(key,list);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> list = map.get(key);
        if(list == null) return "";
        Map.Entry<Integer, String> e = list.floorEntry(timestamp);
    return e == null ? "" :e.getValue() ;}

  
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */