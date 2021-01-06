package dongguabai.algorithm;

/**
 * @author Dongguabai
 * @Description
 *
 *
 * // 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * //输出：7 -> 0 -> 8
 * //原因：342 + 465 = 807
 * @Date 创建于 2020-12-21 14:51
 */
public class Main {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1 = l1.next;

       /* l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers2(l1, l2);*/
        System.out.println(l1);

    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // 小技巧
        ListNode p = l1, q = l2, curr = dummyHead;// 指向节点
        int carry = 0;// 进位
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            ListNode a = new ListNode(sum % 10);
            curr.next = a; //
            curr = curr.next;//
            if (p != null) p = p.next; // 进入下一个循环
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry); // 赋值给下一个
        }
        return dummyHead.next;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(-1),c = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        int j = 0;
        while (p1 != null || p2 != null) {
            int n1 = p1 == null ? 0 : p1.val;
            int n2 = p2 == null ? 0 : p2.val;
            int sum = n1 + n2 + j;
            j = sum / 10;
            resultNode.next = new ListNode(sum % 10);
            resultNode = resultNode.next;

        }
        return resultNode.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
