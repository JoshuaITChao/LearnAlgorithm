package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author Joshua
 *
 */
public class _206_反转链表 {
	// 递归实现反转链表
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
    }
	
	// 非递归实现反转链表
	public ListNode reverseList2(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode newHead = null;
		while (head.next != null) {
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		return newHead;
    }
}
