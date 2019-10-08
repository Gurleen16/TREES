import java.util.*;
public class ValidBST
{
  private static class TreeNode
  {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int i)
    {
      data=i;
      left=null;
      right=null;
    }
    int getdata()
    {
      return data;
    }
    TreeNode getleft()
    {
      return left;
    }
    TreeNode getright()
    {
      return right;
    }
    void setleft(TreeNode l)
    {
      left=l;
    }
    void setright(TreeNode r)
    {
      right=r;
    }
  }

  public static TreeNode root;

  public static void insertInTree(int n)
  {
    TreeNode new1=new TreeNode(n);
    if(root==null)
    {
      root=new1;
      root.left=null;
      root.right=null;
    }
    else
    {
      TreeNode temp=new TreeNode(0);
      TreeNode ptr=root;
      while(ptr!=null)
      {
        temp=ptr;
        if(n>ptr.data)
        ptr=ptr.right;
        else
        ptr=ptr.left;
      }
      if(n>temp.data)
      temp.right=new1;
      else
      temp.left=new1;

    }
  }

  public static boolean isBST(TreeNode root)
  {
    int min=-1;
    int max=9999;
    return BST(root,min,max);
  }

  public static boolean BST(TreeNode root,int min,int max)
  {
    if(root==null)
    return true;
    if(root.getdata()<min || root.getdata()>max)
    return false;

    return (BST(root.left,min,root.getdata()) && BST(root.right,root.getdata(),max));
  }

  public static void main(String args[])
  {
    int n;
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    for(int i=0;i<n;i++)
    insertInTree(sc.nextInt());

    System.out.println("Check if tree is BST or not");
    if(isBST(root))
    System.out.println("Yes");
    else
    System.out.println("No");

  }

}
