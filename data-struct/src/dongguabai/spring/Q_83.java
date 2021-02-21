package dongguabai.spring;

import dongguabai.spring.node.ListNode;

/**
 * @author Dongguabai
 * @description
 * @date 2021-02-09 11:32
 */
public class Q_83 {


    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(1,new ListNode(1)));
        System.out.println(head);
        System.out.println(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current!=null && current.next!=null){
            if (current.val == current.next.val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }

}



