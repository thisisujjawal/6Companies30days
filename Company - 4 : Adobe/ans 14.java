class Solution
{
	static int[] findSmallestRange(int[][] KSortedArray,int n,int k)
	{
	    int range = Integer.MAX_VALUE;
	    int ans [] = new int[2];
	    PriorityQueue<Tuple> min = new PriorityQueue<>((a,b)->{
	        return a.val - b.val;
	    });
	    PriorityQueue<Tuple> max = new PriorityQueue<>((a,b)->{
	        return b.val - a.val;
	    });
	    for(int i = 0 ; i < k ; i++){
	        Tuple tuple = new Tuple(KSortedArray[i][0], i, 0);
	        min.add(tuple);
	        max.add(tuple);
	    }
	    while(true){
	        Tuple smallest = min.remove();
	        Tuple biggest = max.element();
	        if(smallest == biggest)max.remove();
	        int ran = (biggest.val - smallest.val) + 1;
	        if(ran < range){
	            range = ran;
	            ans[0] = smallest.val;
	            ans[1] = biggest.val;
	        }
	        if(smallest.col + 1 >= n)break;
	        Tuple tuple = new Tuple(KSortedArray[smallest.row][smallest.col + 1],smallest.row, smallest.col + 1);
	        min.add(tuple);
	        max.add(tuple);
	    }
	    return ans;
	    
	}
	public static class Tuple{
	    int val, row, col;
	    Tuple(int val, int row, int col){
	        this.val = val;
	        this.row = row;
	        this.col = col;
	    }
	}
}
