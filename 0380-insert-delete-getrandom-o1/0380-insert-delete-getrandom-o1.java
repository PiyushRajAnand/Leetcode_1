class RandomizedSet {
    java.util.Random rand=new java.util.Random();
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    public RandomizedSet() {
        this.map=new HashMap<>();
        this.list=new ArrayList<>();
    }
    public boolean search(int val){
        return map.containsKey(val);
    }
    public boolean insert(int val) {
        if(search(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!search(val)){
            return false;
        }
        int loc=map.get(val);
        if(loc<list.size()-1){
            int v=list.get(list.size()-1);
            list.set(loc,v);
            map.put(v,loc);
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */