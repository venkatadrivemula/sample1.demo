package CLASESS;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class DScan extends JFrame
implements ActionListener
{

 	Container contentPane;
 	DefaultMutableTreeNode library;
 	JTree tree;
    //String title;
 	public DScan(String s)
	 {
		  super(s);
          setup();
          File tm = new File(s);

	 			if(tm.isDirectory())
	 			{
	 				setEnabled(false);
	 				scanEntireDirectory(library,tm);
	 				setEnabled(true);
	 			}
	 			else
	 				JOptionPane.showMessageDialog(this,"Not a valid Directory","Dir Scan",JOptionPane.ERROR_MESSAGE);

  		  show();
	 }

	public boolean scanEntireDirectory(DefaultMutableTreeNode t,File dir)
	{
		DefaultMutableTreeNode n;
	  	File [] fileArray = dir.listFiles();
		try
		{
			if( fileArray != null )
			{

				n = new DefaultMutableTreeNode(dir.getName());
				for ( int i=0; i < fileArray.length; i++ )
				{
					if (fileArray[i].isFile())
					{
	                	n.add(new DefaultMutableTreeNode(fileArray[i].getName()));
	   				}
	   				else
	   				{
	   					//n.add(new DefaultMutableTreeNode(fileArray[i].getName()));
	   					scanEntireDirectory(n,fileArray[i]);
	   				}
	   			}
	   			t.add(n);
	   		}
	        return true;
	     }
	     catch(Exception se)
	     {
	     	System.out.println(se.getMessage());
	     	return false;
	     }
	}
	 //Setup Method is responsible for Creating Panel, Defining Size, adding Componets to the Panel
	 public void setup()
	 {
		  contentPane = getContentPane();
		  contentPane.setLayout(new BorderLayout());
		  library = new DefaultMutableTreeNode("Library");
		  tree = new JTree(library);
		  int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		  int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		  JScrollPane jsp = new JScrollPane(tree,v,h);
		  contentPane.add(jsp,BorderLayout.CENTER);
		  setSize(700,500);
          //addWindowListener(new WindowEventHandler());


	}


    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
	
}
