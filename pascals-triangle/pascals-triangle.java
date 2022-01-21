class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if(numRows == 0) return ret;
        
        ret.add(new ArrayList<>());
        ret.get(0).add(1);
        for(int i = 1; i < numRows; ++i) {
            List<Integer> prv = ret.get(i - 1);
            List<Integer> row = new ArrayList<>();
            
            for(int j = 0; j < prv.size() + 1; ++j) {
                row.add(get(prv, j - 1) + get(prv, j));
            }
            ret.add(row);
        }
        
        return ret;
    }
    
    private int get(List<Integer> list, int index) {
        return 0 <= index && index < list.size() ? list.get(index) : 0;
    }
}