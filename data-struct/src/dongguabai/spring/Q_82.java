package dongguabai.spring;

import dongguabai.spring.node.ListNode;

/**
 * @author Dongguabai
 * @description
 * @date 2021-02-09 14:57
 */
public class Q_82 {

    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates(ListNode node) {
        ListNode dummyHead = new ListNode(-1,node);
        ListNode head = dummyHead.next;
        while (head!=null && head.next!=null){
            if (head.val == head.next.val){
                //两个都要删除
                dummyHead.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return dummyHead.next;
    }
}
