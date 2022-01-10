class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        int ans [] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while(!stack.empty() && price[stack.peek()] <= price[i])stack.pop();
            if(stack.empty())ans[i] = i+1;
            else ans[i] = i - stack.peek();
            stack.push(i);
        }
        return ans;
    }
    
}
