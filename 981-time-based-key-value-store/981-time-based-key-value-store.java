class TimeMap {
    Map<String, TreeMap<Integer, String>> temp;

    public TimeMap() {
        temp = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        temp.putIfAbsent(key, new TreeMap());
        temp.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        return java.util.Optional.ofNullable(temp.get(key))
            .map(tp -> tp.floorEntry(timestamp))
            .map(entry->entry.getValue())
            .orElse("");
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */