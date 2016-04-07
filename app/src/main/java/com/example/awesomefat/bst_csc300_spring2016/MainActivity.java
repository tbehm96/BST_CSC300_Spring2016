import java.util.Random;

public class Driver
{
    public static void main(String[] args)
    {
        BST tree = new BST();
        String vals = "gnz";
        for(int i = 0; i < vals.length(); i++)
        {
            tree.add(vals.charAt(i));
        }

        if(tree.isOutOfBalance())
        {
            System.out.println("Out of balance: " + tree.isOutOfBalance());
            System.out.println(tree.howAreWeOutOfBalance('z'));
        }
        tree.rebalance();
        System.out.println("Out of balance: " + tree.isOutOfBalance());
        //tree.visitPreOrder();
        //tree.visitPostOrder();
        //tree.visitInOrder();
        //tree.visitLevelOrder();
    }
}