class Solution {
    public static int ans [];
    public int[] recoverArray(int n, int[] sums) {
        ans = new int[n];
        Arrays.sort(sums);
        ArrayList<Integer> al = new ArrayList<>();
        for(int num : sums)al.add(num);
        solve(al,0);
        return ans;
    }
    public static boolean solve(ArrayList<Integer> arr, int idx){
        Collections.sort(arr);
        int n = arr.size();
        if(n == 2){
            if(arr.get(0) == 0)ans[idx] = arr.get(1);
            else if(arr.get(1) == 0)ans[idx] = arr.get(0);
            return true;
        }
        if(arr.get(n-1) > 0 && arr.get(n-2) > 0){
            int num = arr.get(n-1)-arr.get(n-2);
            num *= -1;
            boolean valid = false;
            for(int nn : arr){
                if(nn == num){
                    valid = true;
                    break;
                }
            }
            if(valid){
                ArrayList<Integer> al = new ArrayList<>();
                boolean visited [] = new boolean[n];
                for(int i = 0 ; i < n ; i++){
                    if(visited[i])continue;
                    int find = arr.get(i) - num;
                    int found = -1;
                    for(int j = i+1 ; j < n ; j++){
                        if(visited[j])continue;
                        if(arr.get(j) == find && !visited[j]){
                            found = j;
                            break;
                        }
                        if(arr.get(j) > find)break;
                    }
                    if(found != -1){
                        visited[found] = true;
                        al.add(arr.get(found));
                    }else break;
                }
                if(al.size() != n/2)return false;
                boolean temp = solve(al,idx+1);
                if(temp){
                    ans[idx] = num;
                    return true;
                }
            }
            num *= -1;
            valid = false;
            for(int nn : arr){
                if(nn == num){
                    valid = true;
                    break;
                }
            }
            if(valid){
                ArrayList<Integer> al = new ArrayList<>();
                boolean visited [] = new boolean[n];
                for(int i = n-1 ; i >= 0 ; i--){
                    if(visited[i])continue;
                    int find = arr.get(i) - num;
                    int found = -1;
                    for(int j = i-1 ; j >= 0 ; j--){
                        if(visited[j])continue;
                        if(arr.get(j) == find && !visited[j]){
                            found = j;
                            break;
                        }
                        if(arr.get(j) < find)break;
                    }
                    if(found != -1){
                        visited[found] = true;
                        al.add(arr.get(found));
                    }else break;
                }
                if(al.size() != n/2)return false;
                boolean temp = solve(al,idx+1);
                if(temp){
                    ans[idx] = num;
                    return true;
                }else return false;
            }
        }else{
            int num = arr.get(0)-arr.get(1);
            boolean valid = false;
            for(int nn : arr){
                if(nn == num){
                    valid = true;
                    break;
                }
            }
            if(valid){
                ArrayList<Integer> al = new ArrayList<>();
                boolean visited [] = new boolean[n];
                for(int i = 0 ; i < n ; i++){
                    if(visited[i])continue;
                    int find = arr.get(i) - num;
                    int found = -1;
                    for(int j = i+1 ; j < n ; j++){
                        if(visited[j])continue;
                        if(arr.get(j) == find && !visited[j]){
                            found = j;
                            break;
                        }
                    }
                    if(found != -1){
                        visited[found] = true;
                        al.add(arr.get(found));
                    }else break;
                }
                if(al.size() != n/2)return false;
                boolean temp = solve(al,idx+1);
                if(temp){
                    ans[idx] = num;
                    return true;
                }
            }
            num *= -1;
            valid = false;
            for(int nn : arr){
                if(nn == num){
                    valid = true;
                    break;
                }
            }
            if(valid){
                ArrayList<Integer> al = new ArrayList<>();
                boolean visited [] = new boolean[n];
                for(int i = n-1 ; i >= 0 ; i--){
                    if(visited[i])continue;
                    int find = arr.get(i) - num;
                    int found = -1;
                    for(int j = i-1 ; j >= 0 ; j--){
                        if(visited[j])continue;
                        if(arr.get(j) == find && !visited[j]){
                            found = j;
                            break;
                        }
                        if(arr.get(j) < find)break;
                    }
                    if(found != -1){
                        visited[found] = true;
                        al.add(arr.get(found));
                    }else break;
                }
                if(al.size() != n/2)return false;
                boolean temp = solve(al,idx+1);
                if(temp){
                    ans[idx] = num;
                    return true;
                }else return false;
            }
        }
        return false;
    }
}
