
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * Author Philip
 */
public class BSTCount {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter a value for n: ");
            int n = scan.nextInt();
            if (n<0)
                break;
            System.out.println("There are " + bstCount(n) + " structurally unique binary search trees that can be made with the integers 1-" + n);
        }
        System.out.println("Goodbye!");
    }
    
    public static HashMap<Integer, BigInteger> memo = new HashMap<Integer, BigInteger>();
    //Returns a BigInteger representing the number of unique binary search trees that can be made with the integers 1-n
    public static BigInteger bstCount(int n)
    {
        if (n <= 1)
            return new BigInteger("1");
        BigInteger memoAns = memo.get(n);
        if (memoAns != null)
            return memoAns;
        BigInteger total = new BigInteger("0");
        //For each possible root 1-n
        for(int r = 1; r <= n; r++)
        {
            //How many structurally unique BSTs in my left subtree?
            BigInteger left = bstCount(r-1);
            //How many structurally unique BSTs in my right subtree?
            BigInteger right = bstCount(n-r);
            //Use the rule of product to determine the number of BSTs with r as the root, and add it to total via rule of sum.
            total = total.add(left.multiply(right));
        }
        memo.put(n, total);
        return total;
    }
}
