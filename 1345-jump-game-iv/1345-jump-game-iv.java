class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> pos = new HashMap<>();
        boolean[] visited = new boolean[arr.length];
        
        for(int i = 0; i < arr.length; ++i) {
            visited[i] = false;
            if(pos.containsKey(arr[i])) pos.get(arr[i]).add(i);
            else pos.put(arr[i], new ArrayList<>(Arrays.asList(i)));
        }
        
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] { arr.length - 1, 0 });    
        while(q.size() > 0) {
            int[] curr = q.removeFirst();
            int idx = curr[0];
            int cst = curr[1];
            
            if(idx == 0) return cst;
            if(visited[idx]) continue;            
            visited[idx] = true;
            
            if(idx < arr.length - 1 && !visited[idx + 1]) {
                q.add(new int[] { idx + 1, cst + 1 });
            }
            
            if(idx > 0 && !visited[idx - 1]) {
                q.add(new int[] { idx - 1, cst + 1 });
            }
            
            List<Integer> sameValues = pos.get(arr[idx]);
            for(int i = 0; i < sameValues.size(); ++i) {
                if(!visited[sameValues.get(i)]) 
                    q.add(new int[] { sameValues.get(i), cst + 1 });
            }
            pos.put(arr[idx], new ArrayList<>());
        }
        
        return -1;
    }
}