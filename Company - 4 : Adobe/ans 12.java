class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        int max = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = n-1 ; i >= 0 ; i--){
            max = Math.max(max, arr[i]);
            if(arr[i] >= max)ans.add(arr[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
}
