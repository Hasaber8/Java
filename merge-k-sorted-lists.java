class Solution {
public ListNode mergeKLists(ListNode[] lists) {
    ArrayList<Integer> list = new ArrayList<>();
    for(ListNode ln : lists){
        while(ln!=null){
            list.add(ln.val);
            ln=ln.next;
        }
    }
    Collections.sort(list);
    ListNode dummy = new ListNode();
    ListNode node = dummy;
    for(int i=0;i<list.size();i++){
        ListNode h = new ListNode(list.get(i));
        node.next=h;
        node=node.next;
   }
    
    
    return dummy.next;
}
}

**SOLUTION USING MERGE SORT**

class Solution {
public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummy = new ListNode(0);
    ListNode node = dummy;
    for(ListNode link : lists){
        while(link!=null){
            node.next=link;
            node=node.next;
            link=link.next;
        }
    }
    
   return MergeSort(dummy.next);
}


public ListNode MergeSort(ListNode head){
     if(head==null || head.next==null)return head;
    ListNode mid = getMid(head);
    
    ListNode left = MergeSort(head);
    ListNode right = MergeSort(mid);
    return Merge(left,right);
}

public ListNode Merge(ListNode left, ListNode right){
    ListNode dummy = new ListNode(0);
    ListNode temp = dummy;
    while(left!=null && right!=null){
        if(left.val<right.val){
            temp.next=left;
            temp=temp.next;
            left=left.next;
        }
        else{
            temp.next=right;
            temp=temp.next;
            right=right.next;
        }
    }
     temp.next=(left!=null)?left:right;
    
    return dummy.next;
}

public ListNode getMid(ListNode head){
    ListNode s =head;
    ListNode f= head;
   ListNode prev=null;
while (f!=null && f.next!=null){
    prev=s;
    s=s.next;
    f=f.next.next;
}
   prev.next=null;
return s;
  
}
}
