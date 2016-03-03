package com.example.awesomefat.bst_csc300_spring2016;

/**
 * Created by awesomefat on 3/3/16.
 */
public class BST
{
    private Node root;

    public BST()
    {
        this.root = null;
    }

    public void add(int payload)
    {
        Node n = new Node(payload);
        if(this.root == null)
        {
            this.root = n;
        }
        else
        {
            //we need to add to the tree
            this.root.add(n);
        }
    }
    
    public void display()
    {
        if(this.root == null)
        {
            System.out.println("Empty Tree");
        }
        else
        {
            //Display the tree
            System.out.println(this.root.display());

        }
    }
}
