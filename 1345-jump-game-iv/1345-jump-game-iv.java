class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> indicesOfValues = new HashMap<>();
        boolean[] visited = new boolean[arr.length];
        
        for(int i = 0; i < arr.length; ++i) {
            indicesOfValues.computeIfAbsent(arr[i], k -> new ArrayList<Integer>()).add(i);
        }
        
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] { arr.length - 1, 0 });    
        while(q.size() > 0) {
            int[] curr = q.removeFirst();
            int idx = curr[0];
            int cst = curr[1];
            
            if(idx == 0) return cst;
            visited[idx] = true;
            
            if(idx < arr.length - 1 && !visited[idx + 1]) q.add(new int[] { idx + 1, cst + 1 });
            if(idx > 0 && !visited[idx - 1]) q.add(new int[] { idx - 1, cst + 1 });
            
            List<Integer> sameValues = indicesOfValues.get(arr[idx]);
            for(int i = 0; i < sameValues.size(); ++i) {
                if(!visited[sameValues.get(i)]) 
                    q.add(new int[] { sameValues.get(i), cst + 1 });
            }
            indicesOfValues.put(arr[idx], new ArrayList<>());
        }
        
        return -1;
    }
}