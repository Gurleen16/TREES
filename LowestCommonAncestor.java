import java.util.*;
public class LowestCommonAncestor
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

  public static int lowestCommonAncestor(TreeNode root,int n1,int n2)
  {
    if(root==null)
    return 0;

    while(root!=null)
    {
      if(root.getdata()>n1 && root.getdata()>n2)
      root=root.left;
      else if(root.getdata()<n1 && root.getdata()<n2)
      root=root.right;
      else
      break;
    }
    return root.getdata();
  }

  public static void main(String args[])
  {
    int n;
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    for(int i=0;i<n;i++)
    insertInTree(sc.nextInt());

    System.out.println("Enter Numbers to find LCA:");
    int n1=sc.nextInt();
    int n2=sc.nextInt();
    int res=lowestCommonAncestor(root,n1,n2);
    System.out.println("LCA: "+res);
  }

}
