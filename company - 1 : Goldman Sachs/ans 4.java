class GfG
 {
	String encode(String str)
	{
	    char ch [] = str.toCharArray();
	    int n = ch.length;
	    StringBuilder ans = new StringBuilder();
	    for(int i = 0 ; i < n ; i++){
	        int count = 1;
	        int j = i+1;
	        while(j < n){
	            if(ch[i] == ch[j])count++;
	            else break;
	            j++;
	        }
	        ans.append(ch[i]);
	        ans.append(count);
	        i = j-1;
	    }
	    return ans.toString();
	}
	
 }
