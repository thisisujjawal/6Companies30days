class Solution
{
    static void linkdelete(Node head, int M, int N)
    {
        if(M == 0 && N != 0){
            head = null;
            return;
        }else if(N == 0)return;
        Node node = head;
        while(node != null){
            for(int i = 1 ; i < M ; i++){
                if(node.next != null)node = node.next;
                else return;
            }
            Node temp = node;
            for(int i = 0 ; i < N ; i++){
                if(temp.next != null)temp = temp.next;
                else{
                    node.next = null;
                    return;
                }
            }
            node.next = temp.next;
            node = node.next;
        }
    }
}
