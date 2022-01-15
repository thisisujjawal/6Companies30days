class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        int i = 0 , j = 0;
        int sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(j < n){
            sum += arr[j];
            while(sum > s){
                sum -= arr[i];
                i++;
            }
            if(sum == s){
                ans.add(i+1);
                ans.add(j+1);
                break;
            }
            j++;
        }
        if(ans.isEmpty())ans.add(-1);
        return ans;
    }
}
