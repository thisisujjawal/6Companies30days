class Solution{
    static String decodedString(String s){
        char ch [] = s.toCharArray();
        int n = ch.length;
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            if(ch[i] == ']'){
                StringBuilder sb = new StringBuilder();
                while(true){
                    char c = stack.pop();
                    if(c == '[')break;
                    sb.append(c);
                }
                String str = sb.reverse().toString();
                char temp [] = str.toCharArray();
                int num = 0, helper = 1;
                while(!stack.empty() && stack.peek() >= '0' && stack.peek() <= '9'){
                    num += (Integer.valueOf(stack.pop()-'0')*helper);
                    helper *= 10;
                }
                while(num > 0){
                    for(char c : temp)stack.push(c);
                    num--;
                }
            }else{
                stack.push(ch[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
