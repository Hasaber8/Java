import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * Write a description of class BST here.
 *
 * @author (Oarabile Mwiya)
 * @version (Final version)
 *  @Date (17/10/2019)
 */
class BinarySearchTree {  
    static String villageName;
    static BinarySearchTree bst = new BinarySearchTree();
    public static void main(String [] args)throws Exception{

        Random randoms = new Random();
        FileReader file = new FileReader("botswanatownsAndVillages.txt");
        Scanner scan =new Scanner(file);
        String towns ="botswanatownsAndVillages.txt";
        int size = bst.read(towns);
        String [] villages = new String[size];
        ArrayList<String> villageArray=new ArrayList<>();

        int i =0;

        //Traverse the file line by line
        while (scan.hasNextLine()) {
            String line = scan.nextLine(); 
            villageArray.add(line);
            bst.insert(line);
        }
       
       root = null;
        //Method to Randomise the villages and towns
        while(villageArray.size()>0){
            int x = randoms.nextInt(villageArray.size());
            bst.insert(villageArray.get(x)) ;
            villageArray.remove(x);
            
        }
        System.out.println("Inorder traversal");
        bst.inorder();
        System.out.println("\npreOrder traversal");
        bst.preorder();
        System.out.println("\npostOrder traversal");
        bst.postorder();

        scan.close();
       
    }
    // Method to shuffle an arraylist 
    public static void shuffle( ArrayList<String> list){

        Collections.shuffle(list);
        System.out.println("Inorder traversal");
        bst.inorder();
        System.out.println("\npreOrder traversal");
        bst.preorder();
        System.out.println("\npostOrder traversal");
        bst.postorder();
    }

    /* Class containing left and right child of current node and villageName value*/     
    class Node {  

        String villageName;  
        Node left, right;       
        public Node(String item) {     
            villageName = item;          
            left = right = null;         
        }     
    }            static Node root; // Root of BST  

    // Constructor    
    BinarySearchTree() {      
        root = null;      
    }

    // This method mainly calls insertVillage()    
    void insert(String villageName) {   
        root = insertVillageName(root, villageName);  
    }

    /* A recursive function to insert a new village in BST */  
    Node insertVillageName(Node root, String villageName) {        
        /* If the tree is empty, return a new node */        
        if (root == null) {         
            root = new Node(villageName);  
            return root;         
        } 

        /* Otherwise, recur down the tree */     
        if ( villageName.compareTo(root.villageName)  < 0   ){
            root.left = insertVillageName(root.left, villageName);
        }
        else if (villageName.compareTo( root.villageName) > 0 ){   
            root.right = insertVillageName(root.right, villageName);
        }

        /* return the (unchanged) node pointer */      
        return root;    
    }   

    // This method mainly calls InorderRec()    
    void inorder()  {    
        inorderVillages(root);    
    } 

    // This method mainly calls preorderRec()    
    void preorder()  {    
        preOrderVillages(root);    
    } 

    // This method mainly calls postorderRec()    
    void postorder()  {    
        postOrderVillages(root);    
    } 
    // A utility function to do inorder traversal of BST 
    void inorderVillages(Node root) {      
        if (root != null) {       
            inorderVillages(root.left);    
            System.out.println(root.villageName);  
            inorderVillages(root.right);       
        }
    }

    public Node search(Node root, String villageName)  {   
        // Base Cases: root is null or villageName is present at root 
        if (root==null || villageName.equals(root.villageName))   
            return root;       
        // val is greater than root's villageName
        if (villageName.compareTo(root.villageName)  > 0)    
            return search(root.left, villageName);     
        // val is less than root's village    
        return search(root.right, villageName);  
    }

    // A utility function to do PostOrder traversal of BST
    public  void postOrderVillages(Node root){
        if(root != null){
            postOrderVillages(root.left);
            postOrderVillages(root.right);
            System.out.println(root.villageName);
        }

    }  

    // A utility function to do PreOrder traversal of BST
    public void preOrderVillages(Node root){
        if(root != null){
            System.out.println(root.villageName);
            preOrderVillages(root.left);
            preOrderVillages(root.right);
        }
    } 

    //method to count number of villages in the file
    public  int read(String path)throws Exception
    {
        FileReader file = new FileReader(path);
        BufferedReader buff = new BufferedReader(file);
        String line = null;
        int count = 0;
        while((line = buff.readLine())!=null)
        {
            count++;
        }
        return count;
    }
}

