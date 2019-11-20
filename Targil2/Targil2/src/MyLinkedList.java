import java.util.*;
public class MyLinkedList {
	int node_Count = 0;
	Node head = null;
	static class Node{
		int value;
		Node next_Node = null;
		Node(int value){
			this.value = value;
		}			
		}
	
	//addNode(Node n) - adds a node to the end of the list
	public void addNode(Node n) {
		if(node_Count == 0) { 
			head = n;
			node_Count++;
		}
		else {
			Node index = head;
			while(index.next_Node != null) {
				index = index.next_Node;
			}
			index.next_Node = n;
			node_Count++;
		}
	}
	
	//AddNode(Node n, int index)- adds a node to a specific place in the list
	public void AddNode(Node n, int index) {
		if((index > node_Count+1)||(index <= 0)) 
			System.out.println("Invalid Index Value");
		else {
			Node temp = head;
			for(int i = 1; i < index-1; i++) {
				temp = temp.next_Node;
			}
			if(temp.next_Node != null) {
				n.next_Node = temp.next_Node;
				temp.next_Node = n;
			}
			else
				temp.next_Node = n;
			node_Count++;
		}
		
	}
	
	//RemoveNode() - removes the last node of the list
	public void RemoveNode() {
		if(node_Count == 0) {
			System.out.println("There list is empty");
			return;
		}
		Node temp = head;
		for(int i = 1 ; i < node_Count-1;i++)
			temp = temp.next_Node;
		temp.next_Node = null;
		node_Count--;
	}
	public void RemoveNode(int index) {
		if(node_Count == 0) {
			System.out.println("The list is empty");
			return;
		}
		if( (index > node_Count) || (index <= 0)) {
			System.out.println("Invalid Index Value");
			return;
		}
		Node tail = head;
		Node temp = head.next_Node;
		for(int i = 0 ;i < index-1; i++) {
			tail = temp;
			temp = temp.next_Node;
		}
		
		
	}
	
	
	public static void main(String[]args) {
		MyLinkedList l = new MyLinkedList();
		Node n = new Node(6);
		Node n2 = new Node(7);
		Node n3 = new Node(8);
		l.addNode(n);
		l.addNode(n2);
		l.AddNode(n3,2);
		l.RemoveNode();
		l.RemoveNode(1);
		System.out.println(l.head.next_Node);
	}
}
