package com.example.awesomefat.bst_csc300_spring2016;

import java.util.Stack;

/**
 * Created by awesomefat on 3/3/16.
 */
public class BST
{
    private BinaryTree root;

    public BST()
    {
        this.root = null;
    }

    public void add(char payload)
    {
        if(this.root == null)
        {
            this.root = new BinaryTree(payload);
        }
        else
        {
            //we need to add to the tree
            this.root.add(payload);
        }
    }

    public void visitLevelOrder()
    {
        Stack<BinaryTree> answerStack = new Stack<BinaryTree>();
        Stack<BinaryTree> contentStack = new Stack<BinaryTree>();
        Stack<BinaryTree> childStack = new Stack<BinaryTree>();
        Stack<BinaryTree> tempStack = new Stack<BinaryTree>();

        if(this.root == null)
        {
            System.out.println("Empty Tree");
        }
        else
        {
            childStack.push(this.root);
            while(!childStack.isEmpty() || !tempStack.isEmpty())
            { //System.out.println("A");
                //clear child stack by adding its children to tempStack and then popping
                if (childStack.peek().getLeftTree() != null)
                    tempStack.push(childStack.peek().getLeftTree());
                if (childStack.peek().getRightTree() != null)
                    tempStack.push(childStack.peek().getRightTree());
                childStack.pop();
                while(!childStack.isEmpty())
                { //System.out.println("B");
                    //push the left and right children of peek childStack onto tempStack
                    //pop from childStack and push onto contentStack
                    if (childStack.peek().getLeftTree() != null)
                        tempStack.push(childStack.peek().getLeftTree());
                    if (childStack.peek().getRightTree() != null)
                        tempStack.push(childStack.peek().getRightTree());
                    contentStack.push(childStack.pop());
                }

                //move contents of tempStack onto childStack in REVERSE
                while(!tempStack.isEmpty())
                { //System.out.println("C");
                    //pop -> push onto childStack
                    childStack.push(tempStack.pop());
                }
            }

            //we now know that child and temp stacks are empty and all of our
            //nodes are in contentStack in REVERSE order, so we need to reverse them again
            while(!contentStack.isEmpty())
            { //System.out.println("D");
                //pop -> push onto answerStack
                answerStack.push(contentStack.pop());
            }

            //our final answer is answerStack, we can visit the nodes in pop order
            System.out.println("**** Level Order Display ****");
            while(!answerStack.isEmpty())
            {
                //pop and display value
                System.out.println(answerStack.pop().getPayload());
            }
            System.out.println("**** Level Order Display End ****");
        }
    }

    public void visitPreOrder()
    {
        if(this.root == null)
        {
            System.out.println("Empty Tree");
        }
        else
        {
            System.out.println("Pre-Order: " + this.root.displayPreOrder());
        }
    }

    public void visitPostOrder()
    {
        if(this.root == null)
        {
            System.out.println("Empty Tree");
        }
        else
        {
            System.out.println("Post-Order: " + this.root.displayPostOrder());
        }
    }
    public void visitInOrder()
    {
        if(this.root == null)
        {
            System.out.println("Empty Tree");
        }
        else
        {
            System.out.println("In-Order: " + this.root.displayInOrder());
        }
    }
}