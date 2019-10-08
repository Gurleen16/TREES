import java.util.*;
public class TopBottomView
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

  public static void left_top_view(TreeNode root)
  {
      if(root != null)
      {
          left_top_view(root.left);
          System.out.print(root.getdata()+" ");
      }
  }

  public static void right_top_view(TreeNode root)
  {
      if(root != null)
      {
          System.out.print(root.getdata()+" ");
          right_top_view(root.right);
      }
  }

  public static void top_view(TreeNode root)
  {
      if(root != null)
      {
          left_top_view(root);
          right_top_view(root.right);
      }
  }

  public static void left_bottom_view(TreeNode root)
  {
      if(root != null)
      {
          left_bottom_view(root.left);
          System.out.print(root.getdata()+" ");
      }
  }

  public static void right_bottom_view(TreeNode root)
  {
      if(root != null)
      {
        System.out.print(root.getdata()+" ");
        right_bottom_view(root.right);
      }
  }

  public static void bottom_view(TreeNode root)
  {
      if(root != null)
      {
        left_bottom_view(root.left);
        right_bottom_view(root.right);
      }
  }
  public static void main(String args[])
  {
    int n;
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    for(int i=0;i<n;i++)
    insertInTree(sc.nextInt());

    System.out.println("TOP VIEW OF A TREE");
    top_view(root);

    System.out.println("BOTTOM VIEW OF A TREE");
    bottom_view(root);



  }

}
