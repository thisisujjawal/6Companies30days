class Solution{
    public String amendSentence(String s){
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        if(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z')sb.append((char)(s.charAt(0)+32));
        else sb.append(s.charAt(0));
        for(int i = 1 ; i < n ; i++){
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                sb.append(" ");
                c += 32;
                sb.append(c);
            }else sb.append(c);
        }
        return sb.toString();
    }
}
