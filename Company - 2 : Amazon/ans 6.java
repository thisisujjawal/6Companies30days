class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            while(!dq.isEmpty() && arr[i] > arr[dq.peekLast()])dq.pollLast();
            dq.offerLast(i);
            if(i >= k-1){
                ans.add(arr[dq.peekFirst()]);
                while(!dq.isEmpty() && dq.peekFirst() <= (i-k)+1)dq.pollFirst();
            }
        }
        return ans;
    }
}
