/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CLASESS;

/**
 *
 * @author MOHAMMAD
 */
public class TreeNode
{
      TreeNode left; 
      Object info;
      TreeNode right;

      public TreeNode(Object ob)
      {
         info=ob;
         left = right = null;
      }
      public boolean insertNode(Object item)
      {
         if (item.toString().compareTo(info.toString())== 0 )
            return false;
         else if (item.toString().compareTo(info.toString()) < 0 )
            if(left==null)
            {
                left=new TreeNode(item);
                return true;
            }
            else
            {
                return left.insertNode(item);
            }
         else if(right==null)
         {
             right=new TreeNode(item);
             return true;
         }
         else
             return right.insertNode(item);
      }
}