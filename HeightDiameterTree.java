import java.util.*;
public class HeightDiameterTree
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

  public static int height_tree(TreeNode root)
  {
    if(root==null)
    {
      return 0;
    }
    else
    {
      int maxl=height_tree(root.left);
      int maxr=height_tree(root.right);
      if(maxl>maxr)
      return maxl+1;
      else
      return maxr+1;
    }
  }
  public static int diameter_tree(TreeNode root)
  {
    if(root==null)
      return 0;

    int lheight=height_tree(root.left);
    int rheight=height_tree(root.right);

    int ldiameter=diameter_tree(root.left);
    int rdiameter=diameter_tree(root.right);

    return Math.max(lheight+rheight+1,Math.max(ldiameter,rdiameter));
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

    int height=height_tree(root);
    System.out.println("Height of the tree: "+height);

    int diameter=diameter_tree(root);
    System.out.println("Diameter of the tree: "+diameter);
  }
}
