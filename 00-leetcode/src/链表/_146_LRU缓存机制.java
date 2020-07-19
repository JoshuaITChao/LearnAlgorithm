package 链表;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * Hash + 双向链表
 * @author dingxiaomin
 *
 */
public class _146_LRU缓存机制 {
	
	class DLinkedNode {
		int key;
		int value;
		DLinkedNode prev;
		DLinkedNode next;
		public DLinkedNode() {}
		public DLinkedNode(int key, int value) {
			this.key = key;
			this.value = value;
		}	
	}
	
	private Map<Integer, DLinkedNode> cache = new HashMap<>();
	private int size;
	private int capacity;
	private DLinkedNode head, trail;
	
	public _146_LRU缓存机制(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		// 使用头部伪节点和尾部伪节点
		this.head = new DLinkedNode();
		this.trail = new DLinkedNode();
		head.next = trail;
		trail.prev = head;
    }
    
    public int get(int key) {
    	DLinkedNode node = cache.get(key);
    	if(node == null) {
    		return -1;
    	}
    	// 如果key存在，先通过哈希表定位，再移动到头部
    	moveToHead(node);
    	return node.value;
    	
    }
    
    public void put(int key, int value) {
    	DLinkedNode node = cache.get(key);
    	if(node == null) {
    		// 如果 key 不存在，就创建一个新的节点
    		DLinkedNode newNode = new DLinkedNode(key, value);
    		// 添加进哈希表
    		cache.put(key, newNode);
    		// 添加至双向链表的头部
    		addToHead(newNode);
    		++size;
    		if(size > capacity) {
    			// 超出容量，删除双向链表的尾部节点
    			DLinkedNode trail = removeTrail();
    			// 删除哈希表中的对应项
    			cache.remove(trail.key);
    			--size;
    		}
    	}else {
			// 如果 key 已经存在，先通过哈希表定位元素，再修改 value 并移动到头部
    		node.value = value;
    		moveToHead(node);
		}
    }
    
    /**
     * 添加节点到头部
     * @param node
     */
    private void addToHead(DLinkedNode node) {
		node.prev = head;
		node.next = head.next;
		node.next.prev = node;
		head.next = node;
	}
    
    /**
     * 删除节点
     * @param node
     */
    private void removeNode(DLinkedNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
    /**
     * 移动到头部节点
     * @param node
     */
    private void moveToHead(DLinkedNode node) {
    	// 先删除头部节点
		removeNode(node);
		// 再添加头部节点
		addToHead(node);
		
	}
    /**
     * 删除尾部节点
     * @return
     */
    private DLinkedNode removeTrail() {
		DLinkedNode tailNode = trail.prev;
		removeNode(tailNode);
		return tailNode;
	}

}
