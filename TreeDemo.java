// Ian Nelson
// 4/12/2023
// CS 380
// Lab 2

/**
* This is a class that creates a node object.
*@Author Prof. Dovhalets
*/

class Node{
	/**
	 * An integer field holding the nodes value
	 */
   int value;
   /**
    * two node fields for the left and right linked node.
    */
   Node left, right;
   
   /**
   * Node constructor
   * @param value | value of node
   */
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

/**
* This is a class that creates a tree object.
*@Author Prof. Dovhalets
*/
class BinarySearchTree{
	/**
	 * A node object to serve as the root of the tree
	 */
   Node root;
   
   /**
   * Inserts a node into the tree
   * @param root | current root node
   * @param value | int value of node
   * @return root | root node
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }

   
   
   
   /**
   * Prints values of nodes in pre order
   * @param root | current root node
   */
   public void preOrderTraversal(Node root){
      //implement me
      if (root != null) {
         // some sort of visitation
         System.out.println("Value is " + root.value);
         
         // movement
         preOrderTraversal(root.left);
         preOrderTraversal(root.right);
      }
   }

   
   
   /**
   * Prints values of nodes in  order
   * @param root | current root node
   */
   public void inOrderTraversal(Node root){
      //implement me
      if (root != null) {
         
         // movement
         inOrderTraversal(root.left);
         
         // some sort of visitation
         System.out.println("Value is " + root.value);
         
         // movement
         inOrderTraversal(root.right);
      }
   }
   
   
   
   /**
   * Prints values of nodes in post order
   * @param root | current root node
   */
   public void postOrderTraversal(Node root){
      //implement me
      if (root != null) {
                   
         // movement
         postOrderTraversal(root.left);
         postOrderTraversal(root.right);
         
         // some sort of visitation
         System.out.println("Value is " + root.value);
      }
   }
   
   
   
   /**
   * finds a key value from nodes in the tree
   * @param root | current root node
   * @param key | value being searched for
   * @return boolean | true or false depending on if the key is found
   */
   public boolean find(Node root, int key){
     //implement me
      boolean returnBool = true;
     
     // base case for no key
      if (root == null){
         return false;
      }
     
     // if found
      if (root.value == key){
         return true;  
      }
      // recursive statement
      else if (root.value > key){
         returnBool = find(root.left, key);
      }
      //recursive statement
      else if (root.value < key){
         returnBool = find(root.right, key);
      }
   
      return returnBool;
   }
   
   
   
   /**
   * Prints values of smallest valued node
   * @param root | current root node
   * @return int | value of the min node
   */
   public int getMin(Node root){
     //implement me
      if (root.left != null){
         return getMin(root.left); // recursive statement
      } 
      // base case
      return root.value;
   }
  
  
  
   /**
   * Prints values of largest valued node
   * @param root | current root node
   * @return int | value of the max node
   */
   public int getMax(Node root){
     //implement me
      if (root.right != null){
         return getMax(root.right); // recursive statement
      } 
      // base case
      return root.value;
   }
   
   
   
   /**
   * deletes a key value from nodes in the tree
   * @param root | current root node
   * @param key | value being searched for
   * @return Node | delete node
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}


/**
* This is a class that contains the main method
*@Author Prof. Dovhalets
*/
public class TreeDemo{
	   /**
	   * main method
	   * @param args | string array of arguments
	   */
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.root = new Node(24);
      t1.insert(t1.root, 80);
      t1.insert(t1.root, 18);
      t1.insert(t1.root, 9);
      t1.insert(t1.root, 90);
      t1.insert(t1.root, 22);
            
      System.out.print("[pre-order :   ");
      t1.preOrderTraversal(t1.root);
      System.out.println();
      
      System.out.print("[in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
      
      System.out.print("[post-order :   ");
      t1.postOrderTraversal(t1.root);
      System.out.println();
       
      int myKey = 22;
      System.out.println("[Find " + myKey + ":   " + t1.find(t1.root, myKey));          
      
      myKey = 17;
      System.out.println("[Find " + myKey + ":   " + t1.find(t1.root, myKey));          
   
      System.out.println("[getMin :   " + t1.getMin(t1.root));          
      System.out.println("[getMax :   " + t1.getMax(t1.root));          
   
    
   }  
}

// small change to test github