import java.util.*;
public class MirorTree
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

  public static void mirror(TreeNode root)
  {
    if(root==null)
    return;
    else
    {
      TreeNode temp;
      mirror(root.left);
      mirror(root.right);

      temp=root.left;
      root.left=root.right;
      root.right=temp;
    }
  }
  public static void main(String args[])
  {
    int n;
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    for(int i=0;i<n;i++)
    insertInTree(sc.nextInt());

    System.out.println("MIRROR OF A TREE");
    mirror(root);
    inorder(root);
    System.out.println();
  }

}
