package 链表;

/**
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * @author dingxiaomin
 *
 */
public class _剑指_Offer_25_合并两个排序的链表 {

	/**
	 * 非递归法，创建虚拟头节点
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode vHead = new ListNode(-1);
		ListNode cur = vHead;
		
		while (l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			}else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		cur.next = l1 != null ? l1 : l2;
		return vHead.next;
	}
	
	/**
	 * 递归版本
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoList2(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val <= l2.val) {
			l1.next = mergeTwoList2(l1.next, l2);
			return l1;
		}else {
			l2.next = mergeTwoList2(l1, l2.next);
			return l2;
		}
	}
	
	
}
