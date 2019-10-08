import java.util.*;
public class VerticalOrderTraversals
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
  private static class MinMax
  {
    int min;
    int max;
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
  public static void findMinMax(TreeNode root,MinMax mn,MinMax mx,int hd)
  {
    if(root==null)
    return;
    if(hd<mn.min)
    mn.min=hd;
    else
    mx.max=hd;

    findMinMax(root.left,mn,mx,hd-1);
    findMinMax(root.right,mn,mx,hd+1);
  }

  public static void printVerticalLevel(TreeNode root,int line,int hd)
  {
    if(root==null)
    return;
    if(hd==line)
    System.out.print(root.data+" ");

    printVerticalLevel(root.left,line,hd-1);
    printVerticalLevel(root.right,line,hd+1);
  }

  public static void verticalorder(TreeNode root,MinMax mnx)
  {
    int min=0,max=0;
    findMinMax(root,mnx,mnx,0);

    for(int i=mnx.min;i<=mnx.max;i++)
    {
      printVerticalLevel(root,i,0);
      System.out.println();
    }
  }
  public static void main(String args[])
  {
    int n;
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    for(int i=0;i<n;i++)
    insertInTree(sc.nextInt());

    System.out.println("VERTICALORDER");
    MinMax mnx=new MinMax();
    verticalorder(root,mnx);
  }

}
