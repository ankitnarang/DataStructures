package binarytree;

import java.util.ArrayList;

public class IsBTSubtreeofAnotherBT {
	
	public static void main(String[] args) {
		IsBTSubtreeofAnotherBT tree = new IsBTSubtreeofAnotherBT();
		/*
		LocalTreeNode T = new LocalTreeNode('a'); 
        T.left = new LocalTreeNode('b'); 
        T.right = new LocalTreeNode('d'); 
        T.left.left = new LocalTreeNode('c'); 
        T.right.right = new LocalTreeNode('e'); 
  
        LocalTreeNode S = new LocalTreeNode('a'); 
        S.left = new LocalTreeNode('b'); 
        S.right = new LocalTreeNode('d'); 
        S.left.left = new LocalTreeNode('c'); 
        */
		/*
		LocalTreeNode T = new LocalTreeNode('z');
		T.left = new LocalTreeNode('x');
		T.right = new LocalTreeNode('e');
		T.left.left = new LocalTreeNode('a');
		T.left.right = new LocalTreeNode('b');
		T.left.left.right = new LocalTreeNode('c');
		T.right.right = new LocalTreeNode('k');
        
        LocalTreeNode S = new LocalTreeNode('x'); 
        S.left = new LocalTreeNode('a'); 
        S.right = new LocalTreeNode('b'); 
        S.left.right = new LocalTreeNode('c'); 
  		*/
		LocalTreeNode T = new LocalTreeNode('x');
		T.left = new LocalTreeNode('a');
		T.right = new LocalTreeNode('b');
		T.left.left = new LocalTreeNode('c');
        
        LocalTreeNode S = new LocalTreeNode('x'); 
        S.left = new LocalTreeNode('a'); 
        S.right = new LocalTreeNode('b'); 
        S.left.left = new LocalTreeNode('c'); 
        S.right.right = new LocalTreeNode('d'); 
		
		
        // To check if S is subtree of T
        if(tree.isSubTree(T,S))
        	System.out.println("Yes, S is subtree of T");
        else
        	System.out.println("No, S is not a subtree of T");
	}

	private boolean isSubTree(LocalTreeNode T, LocalTreeNode S) {
		if(S == null)
			return true;
		if(T == null)
			return false;
		ArrayList<Character> inorderT = new ArrayList<Character>();
		ArrayList<Character> inorderS = new ArrayList<Character>();
		
		LocalTreeNode tempT = T;
		LocalTreeNode tempS = S;
		
		storeInOrder(T,inorderT);
		storeInOrder(S,inorderS);
		
		String str1 = getString(inorderT);
		String str2 = getString(inorderS);
		//System.out.println("Inorder of T " + str1.replace('$', ' ') + "\nInorder of S " + str2.replace('$', ' '));
		
		if(!str1.contains(str2))
			return false;
		
		T = tempT;
		S = tempS;
		
		ArrayList<Character> preorderT = new ArrayList<Character>();
		ArrayList<Character> preorderS = new ArrayList<Character>();
		
		storePreOrder(T,preorderT);
		storePreOrder(S,preorderS);
		
		str1 = getString(preorderT);
		str2 = getString(preorderS);
		//System.out.println("Preorder of T " + str1.replace('$', ' ') + "\nPreorder of S " + str2.replace('$', ' '));
		
		if(!str1.contains(str2))
			return false;
		
		return true;
	}

	private String getString(ArrayList<Character> list) {
		StringBuilder sb = new StringBuilder();
		for(Character ch : list) {
			sb.append(ch);
		}
		return sb.toString();
	}

	private void storeInOrder(LocalTreeNode T, ArrayList<Character> inorderT) {
		if(T == null) {
			inorderT.add('$');
			return;
		} else {
			storeInOrder(T.left, inorderT);
			inorderT.add(T.data);
			storeInOrder(T.right, inorderT);
		}
	}
	
	private void storePreOrder(LocalTreeNode T, ArrayList<Character> preorderT) {
		if(T == null) {
			preorderT.add('$');
			return;
		} else {
			preorderT.add(T.data);
			storePreOrder(T.left, preorderT);
			storePreOrder(T.right, preorderT);
		}
	}

}
class LocalTreeNode { 
	  
    char data; 
    LocalTreeNode left, right; 
  
    LocalTreeNode(char item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 
