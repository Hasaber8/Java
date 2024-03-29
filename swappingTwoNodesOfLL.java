public static ListNode swapNodes_tp(ListNode head, int k) {
    ListNode left = head;
    ListNode right = head;
    int cnt = 0;
    // find the k-th node
    while (left != null) {
        cnt++;
        if (cnt == k) {
            break;
        }
        left = left.next;
    }

    // find the k-th last element
    ListNode pNode = left;
    while (pNode.next != null) {
        pNode = pNode.next;
        right = right.next;
    }

    // swap their values.
    int temp = left.val;
    left.val = right.val;
    right.val = temp;

    return head;
}