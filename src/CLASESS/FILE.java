/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CLASESS;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author MOHAMMAD
 */
public class FILE extends MAIN_PAGE implements ActionListener{
    //private JFrame showFile=new JFrame();
    private String subFolderName;
    private String directoryName;
    private String FolderName;//file that subFolderName is subfolder for it.
    public boolean b=false;
    File directory = null;
    File Folder=null;
    String s;
    DefaultMutableTreeNode TN;
 	JTree tr;
    int sw=1;
    private JFileChooser fc=new JFileChooser();
    BufferedReader inputStream;
    ////////////////////////////////////////////////
    public FILE(String sfn,String fn,String s ) throws IOException
    {
       
 		///////////////////////////////////////////////////////
         ////////////////////////////////////////////////////////
        subFolderName=sfn;
        FolderName=fn;
        
        ////////////////////////////////////////////////////////////
        if(s.equals("search"))
        {
           String h=JOptionPane.showInputDialog(null,"Please insert Name Of File Or Directory \n To Search: ");
           if(tree.search(h))
           {
               JOptionPane.showMessageDialog(null,"File Is Found" );
           }
           else
               JOptionPane.showMessageDialog(null,"File Is Not Found" );
        }
        if(s.equals("Directory"))
        {
             {
                FolderName=JOptionPane.showInputDialog(null,"Input Directory Name");
                fc.setDialogTitle("select directory");
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = fc.showOpenDialog(this);
                try{
                        directory =new File(fc.getSelectedFile(),FolderName);
                        directory.mkdir();
                        subFolderName=fc.getSelectedFile().getParent().toString();
                        
                    }
                catch(NullPointerException ioe) {
                    JOptionPane.showMessageDialog(null, "Sorry,File Not Found", "", JOptionPane.WARNING_MESSAGE );
               }
            
        }
      }
///////////////////////////////////////////////////////////////////////////////////////////
        if(s.equals("Folder"))
        {
                fc.setDialogTitle("select file");
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int returnVal = fc.showOpenDialog(this);
                if (returnVal == JFileChooser.FILES_ONLY) {
                try{
                        directory=fc.getSelectedFile();
                        
                    }
                catch(NullPointerException ioe) {
                    JOptionPane.showMessageDialog(null, "Sorry,File Not Found", "", JOptionPane.WARNING_MESSAGE );
               }
                }
                fc.setDialogTitle("select directory");
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                returnVal = fc.showOpenDialog(this);
                try{
                        Folder=fc.getSelectedFile();
                        BufferedReader inputStream = new BufferedReader(new FileReader(directory.getPath()));
                        FileWriter outputStream=new FileWriter(Folder.getPath()+"/"+directory.getName());
                        String input=inputStream.readLine();
                        while(input != null)
                        {
                            outputStream.write(input+"\n");
                            input=inputStream.readLine();
                        }
                        outputStream.close();
                        
                   }
                catch(NullPointerException ioe) {
                    JOptionPane.showMessageDialog(null, "Sorry,File Not Found", "", JOptionPane.WARNING_MESSAGE );
               }
            
        }
     }
    ////////////////////////////////////////////////
    public void setSubFolderName(String s)
    {
        subFolderName=s;
    }
    public String getSubFolderName()
    {
        return subFolderName;
    }
    public void setFolderName(String s)
    {
        FolderName=s;
    }
    public String getFolderName()
    {
        return FolderName;
    }
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
     
}
