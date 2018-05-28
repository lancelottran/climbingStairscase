int[][] climbingStaircase(int n, int k) {
    if(n == 0 && k == 0)
        return new int[1][0];
    
    List<int[]> res = new ArrayList<int[]>();
    res = find_step(n, k, 0, 0, res);
    
    return res.toArray(new int[0][]);
}

int[] path = new int[100];
int idx = 0;

List<int[]> find_step(int n, int k, int sum, int idx, List<int[]> res){
    if(sum == n){
        int[] a = new int[idx];
        for(int i = 0; i < idx; i++)
            a[i] = path[i];
        
        res.add(a);
        return res;
    }
    
    if(sum > n)
        return res;
    
    if(sum < n){
        for(int i = 1; i <= k; i++){
            path[idx] = i;
            find_step(n, k, sum+i, idx+1, res);
        }
    }
    
    return res;
}
