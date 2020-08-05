package 链表;


/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 *
 */
public class _剑指_Offer_52_两个链表的第一个公共节点 {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
		ListNode node1 = headA, node2 = headB;
		
		while (node1 != node2) {
			node1 = node1.next == null ? headB : node1.next;
			node2 = node2.next == null ? headA : node2.next;
		}
		return node1;
    }
}
