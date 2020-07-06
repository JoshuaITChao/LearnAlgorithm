package com.joshua;

import com.joshua.printer.BinaryTrees;
import com.joshua.tree.BST;
import com.joshua.tree.BinaryTree.Visitor;
import com.joshua.tree.BinaryTree;

public class Main {

	public static void main(String[] args) {
		test1();
	}
	
	
	static void test1() {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5, 8, 11, 3, 12, 1
		};
		
		BST<Integer> bst = new BST<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
		BinaryTrees.println(bst);
		
		// 先序遍历
		System.out.println("\n");
		System.out.println("------------先序遍历------------");
		bst.preorder(new Visitor<Integer>() {
			public void visit(Integer element) {
				System.out.print("_" + element + "_");
			}
		});
		
		// 中序遍历
		System.out.println("\n");
		System.out.println("------------中序遍历------------");
		bst.inorder(new Visitor<Integer>() {
			public void visit(Integer element) {
				System.out.print("_" + element + "_");
			}
		});
		// 后序遍历
		System.out.println("\n");
		System.out.println("------------后序遍历------------");
		bst.postorder(new Visitor<Integer>() {
			public void visit(Integer element) {
				System.out.print("_" + element + "_");
			}
		});	
		
		// 层序遍历
		System.out.println("\n");
		System.out.println("------------层序遍历------------");
		bst.levelorder(new Visitor<Integer>() {
			public void visit(Integer element) {
				System.out.print("_" + element + "_");
			}
		});	
		
		// 获取树的深度
		System.out.println("\n");
		System.out.println("树的深度------"+bst.depath());
		
		
		// 获取某个节点的前驱节点
		System.out.println("\n");
		
		
		// 删除二叉树的某个节点
		bst.remove(9);
		System.out.println("\n");
		System.out.println("------------删除某个节点------------");
		BinaryTrees.println(bst);
	}

}
