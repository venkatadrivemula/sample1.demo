/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CLASESS;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author MOHAMMAD
 */
  public class searchTree extends JFrame
   {
      int count=0;
      JTextArea jt;
      ///////////////////////////////////////////////////////
      private TreeNode root;
      public boolean insert(Object item)
      {
          if(isEmpty())
          {
              root=new TreeNode(item);
              return true;
          }
          else
          {
              return root.insertNode(item);
          }

      }
      /////////////////////////////
      public boolean isEmpty()
      {
          return (root==null);
      }
      ////////////////////////////////
      public boolean search(Object target)
      {
          return search(root,target);
      }
      ///////////////////////////////////
      private boolean search(TreeNode root,Object target)
      {
          if(isEmpty())
          {
              return false;
          }
          if(target.toString().compareTo(root.info.toString())==0)
          {
              return true;
          }
          else if(target.toString().compareTo(root.info.toString()) < 0)
              if(root.left==null)
              {
                  return false;
              }
              else
              {
                  return search(root.left,target);
              }
          else if(root.right==null)
          {
              return false;
          }
          else
              return search(root.right,target);

      }
      ////////////////////////////////////////////////
      public void display()
      {
            JFrame r=new JFrame("Binary Search Tree");
            jt=new JTextArea(8,8);
            JPanel spane = new JPanel(new GridLayout(0, 1));
            spane.add(jt);
            JScrollPane sp = new JScrollPane(spane);
            JPanel mpane = new JPanel(new GridLayout(0, 1));
            r.getContentPane().add(sp);
            r.getContentPane().add(spane);
            display(root);
            r.setLocation(100,100);
            r.setSize(500,500);
            r.setVisible(true);
      }

      private void display(TreeNode root)
      {
          
          if(!isEmpty())
          {
              if(root.left != null)
                  display(root.left);
              count++;
              String f=Integer.toString(count);
              jt.append("[ "+f+" ]    "+root.info.toString()+"\n");
              if(root.right != null)
                  display(root.right);
          }
          
      }








   }