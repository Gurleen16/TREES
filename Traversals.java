import java.util.*;
public class Traversals
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

  public static void inorder(TreeNode root)
  {
    if(root!=null)
    {
      inorder(root.left);
      System.out.print(root.data+" ");
      inorder(root.right);
    }
  }

  public static void searchTree(TreeNode root,int n)
  {
    int c=0;
    if(root!=null)
    {
      TreeNode ptr=root;
      while(ptr!=null)
      {
        //temp=ptr;
        if(ptr.data==n)
        {
          c=1;
          System.out.println("Element Found");
          break;
        }

        if(n>ptr.data)
        ptr=ptr.right;
        else
        ptr=ptr.left;
      }
      if(c==0)
      System.out.println("Element Not Found");

    }
  }
  public static void preorder(TreeNode root)
  {
    if(root!=null)
    {
      System.out.print(root.data+" ");
      preorder(root.left);
      preorder(root.right);
    }
  }
  public static void postorder(TreeNode root)
  {
    if(root!=null)
    {
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.data+" ");
    }
  }

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

  public static void main(String args[])
  {
    int n;
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    for(int i=0;i<n;i++)
    insertInTree(sc.nextInt());

    System.out.println("INORDER");
    inorder(root);
    System.out.println();

    System.out.println("PREORDER");
    preorder(root);
    System.out.println();

    System.out.println("POSTORDER");
    postorder(root);
    System.out.println();

    System.out.println("Enter element to be searched");
    searchTree(root,sc.nextInt());

  }

}
