/*
  federico Rubino
  frubino
  Assignment #7
  Binary Search Tree
  main
  working/ tested
*/


import java.util.Scanner;

//main does the I/O
//using BinarySearchTree class
public class p7{
    
    public static void main(String args[]){
	Scanner input = new Scanner(System.in);
	BinarySearchTree bst = new BinarySearchTree();
	String[] line;
	while(input.hasNextLine()){
	    try{
		line = input.nextLine().split(" ");
		switch(line[0]){
		case "insert":
		    int insrt = Integer.parseInt(line[1]);
		    bst.insert(insrt);
		    break;
		case "delete":
		    int del = Integer.parseInt(line[1]);
		    bst.delete(del);
		    break;
		case "search":
		    int serc = Integer.parseInt(line[1]);
		    bst.search(serc);
		    break;
		case "min":
		    bst.min();
		    break;
		case "max":
		    bst.max();
		    break;
		case "successor":
		    int succ = Integer.parseInt(line[1]);
		    bst.successor(succ);
		    break;
		case "predecessor":
		    int pred = Integer.parseInt(line[1]);
		    bst.predecessor(pred);
		    break;
		case "inorder":
		    bst.inorder();
		    break;
		case "postorder":
		    bst.postorder();
		    break;
		case "preorder":
		    bst.preorder();
		    break;
		default:
		//dont do anything
		    break;
		}//switch
	    }catch (NumberFormatException e) {
		System.err.printf("that was not a valid input%n");
	    }
	}//while
    } //main
}//class
