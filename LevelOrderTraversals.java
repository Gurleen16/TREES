import java.util.*;
public class LevelOrderTraversals
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
  public static void levelorder(TreeNode root)
  {
    int h=height_tree(root);
    for(int i=1;i<=h;i++)
    printGivenLevel(root,i);
  }

  public static void reverselevelorder(TreeNode root)
  {
    int h=height_tree(root);
    for(int i=h;i>=0;i--)
    printGivenLevel(root,i);
  }

  public static void levelorderspiral(TreeNode root)
  {
    int h=height_tree(root);
    boolean ltr=false;
    for(int i=1;i<=h;i++)
    {
      printGivenLevel(root,i,ltr);
      ltr=!ltr;
    }
  }

  public static void printGivenLevel(TreeNode root,int level)
  {
    if(root==null)
    return;
    if(level==1)
    System.out.print(root.data+" ");
    else
    {
      printGivenLevel(root.left,level-1);
      printGivenLevel(root.right,level-1);
    }
  }

  public static void printGivenLevel(TreeNode root,int level,boolean ltr)
  {
    if(root==null)
    return;
    if(level==1)
    System.out.print(root.data+" ");
    else
    {
      if(ltr!=false)
      {
        printGivenLevel(root.left,level-1,ltr);
        printGivenLevel(root.right,level-1,ltr);
      }
      else
      {
        printGivenLevel(root.right,level-1,ltr);
        printGivenLevel(root.left,level-1,ltr);
      }
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

    System.out.println("LEVELORDER");
    levelorder(root);
    System.out.println();

    System.out.println("REVERSE LEVELORDER");
    reverselevelorder(root);
    System.out.println();

    System.out.println("LEVELORDER SPIRAL");
    levelorderspiral(root);
    System.out.println();
  }

}
