/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CLASESS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
/**
 *
 * @author MOHAMMAD
 */
public class MAIN_PAGE extends JFrame {
     JFrame main_page=new JFrame("DATA STRUCTUR PROJECT");
     FILE f;
     String s1;
     String s2;
     public searchTree tree=new searchTree();
     private JFileChooser fc = new JFileChooser();
     private JTextArea dat;
     searchTree main=new searchTree();
     BufferedReader inputStream;
     public MAIN_PAGE()
     {
        main_page.getContentPane().setBackground(Color.YELLOW);
        
        JMenu fileMenu = new JMenu("File");
        final JMenuItem ImportF = new JMenuItem("Import File");
        fileMenu.add(ImportF);
        final JMenuItem ImportD = new JMenuItem("Import Directory");
        fileMenu.add(ImportD);
        JMenuBar Bar = new JMenuBar();
        Bar.add(fileMenu);
        final JMenu EditMenu = new JMenu("Edit");
        Bar.add(EditMenu);
        JMenuItem EditF = new JMenuItem("Edit File");
        EditMenu.add(EditF);
        final JMenu viewMenu = new JMenu("View");
        final JMenuItem viewTree = new JMenuItem("View Tree");
        viewMenu.add(viewTree);
        final JMenuItem viewSubTree = new JMenuItem("View Sub Tree");
        viewMenu.add(viewSubTree);
        Bar.add(viewMenu);
        final JMenu searchMenu = new JMenu("Search");
        final JMenuItem search_all = new JMenuItem("Search File");
        searchMenu.add(search_all);
        final JMenuItem search_word = new JMenuItem("Search Word Into File");
        searchMenu.add(search_word);
        Bar.add(searchMenu);
        final JMenu list = new JMenu("List");
        final JMenuItem  list_file= new JMenuItem("Get List Of Files");
        list.add(list_file);
        final JMenuItem  list_directory= new JMenuItem("Get List Of Directorys");
        list.add(list_directory);
        Bar.add(list);
        Bar.add(new JSeparator());

        JToolBar TBar=new JToolBar();
        JButton  makeDirectory=new JButton("New");
        //makeDirectory.setBackground(Color.YELLOW);
        makeDirectory.setToolTipText("Make New Directory");
        makeDirectory.setIcon(new ImageIcon(getClass().getResource("pic\\m.jpg")));
        TBar.add(makeDirectory);

        JButton search=new JButton("Search");
        //search.setBackground(Color.YELLOW);
        search.setToolTipText("Search Word");
        search.setIcon(new ImageIcon(getClass().getResource("pic\\n.jpg")));
        TBar.add(search);
        
        JButton getList=new JButton("Get List");
        //getList.setBackground(Color.YELLOW);
        getList.setToolTipText("get List");
        getList.setIcon(new ImageIcon(getClass().getResource("pic\\o.jpg")));
        TBar.add(getList);

        JButton viewT=new JButton("View Tree");
        //viewT.setBackground(Color.YELLOW);
        viewT.setToolTipText("view Tree");
        viewT.setIcon(new ImageIcon(getClass().getResource("pic\\p.jpg")));
        TBar.add(viewT);
        
        TBar.add(new JSeparator());
        
        final JFileChooser file = new JFileChooser();
        JLabel pic=new JLabel();
        //pic.setIcon(new ImageIcon(getClass().getResource(
          //  "pic\\1.jpg")));

        //////////////////////////////////////////////////////////////////////
        makeDirectory.addActionListener(
                   new ActionListener() {
               public void actionPerformed(ActionEvent event) {
                String FolderName=JOptionPane.showInputDialog(null,"Input Directory Name");
                fc.setDialogTitle("select directory");
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fc.showOpenDialog(null);
                try{
                        File directory =new File(fc.getSelectedFile(),FolderName);
                        directory.mkdir();

                    }
                catch(NullPointerException ioe) {
                    JOptionPane.showMessageDialog(null, "Sorry,File Not Found", "", JOptionPane.WARNING_MESSAGE );
               }
               }
        }
        );

        search.addActionListener(
                   new ActionListener() {
               public void actionPerformed(ActionEvent event) {

                   String h=JOptionPane.showInputDialog(null,"Please insert the name To Search \n In Library: ");
                    file.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    int result = file.showOpenDialog(null);
                    File f=file.getSelectedFile();
                    BufferedReader inputStream = null;
                    try {
                        inputStream = new BufferedReader(new FileReader(f.getPath()));
                        } catch (FileNotFoundException ex) {
                        Logger.getLogger(MAIN_PAGE.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     try{
                        String inputLine=inputStream.readLine();
                        while(inputLine!=null){
                        StringTokenizer st=new StringTokenizer(inputLine," ");
                        while(st.hasMoreTokens())
                        {
                            String token= st.nextToken();
                            main.insert(token);
                         }
                        inputLine=inputStream.readLine();
                     }
                     main.display();
                  }
               catch(FileNotFoundException ef){

                }
               catch(IOException ef){
                }
                 if(main.search(h))
                     JOptionPane.showMessageDialog(null,"Word  Exist");
                 else
                     JOptionPane.showMessageDialog(null,"Word DOES Not Exist");
              }
           }
         );

           getList.addActionListener(
                   new ActionListener() {
                   public void actionPerformed(ActionEvent event) {
                   JFrame r=new JFrame("List All Of Files ");
                   JTextArea jt=new JTextArea(8,8);
                   JPanel spane = new JPanel(new GridLayout(0, 1));
                   spane.add(jt);
                   JScrollPane sp = new JScrollPane(spane);
                   JPanel mpane = new JPanel(new GridLayout(0, 1));
                   r.getContentPane().add(sp);
                   r.getContentPane().add(spane);
                   File file=new File("C:\\proje");
                   File[] file_list=file.listFiles();
                   jt.append("|   FILE         NAM                         |             PATH\n");
                   jt.append("****************************************************" +
                           "*****************************************************" +
                           "*****************\n");
                   jt.append("****************************************************" +
                           "*****************************************************" +
                           "*****************\n");
                   for(File f : file_list)
                   {
                    if(f.isFile())
                    {
                     jt.append(f.getName()+"                                       ");
                     jt.append(f.getPath().toString()+"\n");
                     jt.append("------------------------------------------------" +
                             "---------------------------------------------------" +
                             "-----------------------\n");
                    }
                    if(f.isDirectory())
                    {
                        jt.append(Scan(f,f.listFiles()));
                    }
                   }
                   jt.setEditable(false);
                   r.setLocation(100,100);
                   r.setSize(500,500);
                   r.setVisible(true);
               }
               public String Scan(File w,File[] file_list)
                {
                   for(File f: file_list)
                    {
                        if(f.isFile())
                            return f.getName()+"                                       "+f.getPath().toString()+"\n"
                                    +"------------------------------------------" +
                                    "-------------------------------------------" +
                                    "-------------------------------------\n";
                        if(f.isDirectory())
                           return Scan(f,f.listFiles());
                    }
                    return "";
                }
           }
           );

           viewT.addActionListener(
                   new ActionListener() {

               public void actionPerformed(ActionEvent event) {
                DScan scan=new DScan("C:\\proje");
               }
           }
           );

///////////////////////////////////////////////////////////////////////////////
        ImportF.addActionListener(
                   new ActionListener() {
               public void actionPerformed(ActionEvent event) {
                   main_page.hide();
                try {
                    FILE f = new FILE("","","Folder");
                } catch (IOException ex) {
                    Logger.getLogger(MAIN_PAGE.class.getName()).log(Level.SEVERE, null, ex);
                }
              
              }
           }
           );

          ImportD.addActionListener(
                   new ActionListener() {
               public void actionPerformed(ActionEvent event) {
                   main_page.hide();
                try {
                    FILE f = new FILE("", "", "Directory");
                } catch (IOException ex) {
                    Logger.getLogger(MAIN_PAGE.class.getName()).log(Level.SEVERE, null, ex);
                }
                                      
               }
           }

           );

           search_word.addActionListener(
                   new ActionListener() {
               public void actionPerformed(ActionEvent event) {
                    String h=JOptionPane.showInputDialog(null,"Please insert the name To Search \n In Library: ");
                    file.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    int result = file.showOpenDialog(null);
                    File f=file.getSelectedFile();
                    BufferedReader inputStream = null;
                    try {
                        inputStream = new BufferedReader(new FileReader(f.getPath()));
                        } catch (FileNotFoundException ex) {
                        Logger.getLogger(MAIN_PAGE.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     try{
                        String inputLine=inputStream.readLine();
                        while(inputLine!=null){
                        StringTokenizer st=new StringTokenizer(inputLine," ");
                        while(st.hasMoreTokens())
                        {
                            String token= st.nextToken();
                            main.insert(token);
                         }
                        inputLine=inputStream.readLine();
                     }
                     main.display();
                  }
               catch(FileNotFoundException ef){

                }
               catch(IOException ef){
                }
                 if(main.search(h))
                     JOptionPane.showMessageDialog(null,"Word  Exist");
                 else
                     JOptionPane.showMessageDialog(null,"Word DOES Not Exist");
              }
           }
           );

           search_all.addActionListener(
                   new ActionListener() {

               public void actionPerformed(ActionEvent event) {
                    main_page.hide();
                    String h=JOptionPane.showInputDialog(null,"Please insert the name of your book \n To Search: ");
                    h=h+".txt";
                    File file=new File("C:\\proje");
                    File[] file_list=file.listFiles();
                    JFrame r=new JFrame("List Of Files Are Found ");
                    JTextArea jt=new JTextArea(8,8);
                    JPanel spane = new JPanel(new GridLayout(0, 1));
                    spane.add(jt);
                    JScrollPane sp = new JScrollPane(spane);
                    JPanel mpane = new JPanel(new GridLayout(0, 1));
                    r.getContentPane().add(sp);
                    r.getContentPane().add(spane);
                    jt.append("|   FILE         NAM              |             PATH\n");
                    jt.append("----------------------------------------------------\n");
                    for(File f: file_list)
                    {
                        if(f.isFile())
                        {
                            if(f.getName().equals(h))
                            {
                                jt.append(f.getName()+"                                  ");
                                jt.append(f.getPath().toString()+"\n");
                            }
                        }
                        if(f.isDirectory())
                        {
                            jt.append(Scan(f,f.listFiles(),h));
                        }
                    }
               jt.setEditable(false);
               r.setLocation(100,100);
               r.setSize(500,500);
               r.setVisible(true);
               }
               public String Scan(File w,File[] file_list,String s)
                {
                   for(File f: file_list)
                    {
                        if(f.isFile())
                            if(f.getName().equals(s))
                            {
                              return f.getName()+"                                   "+f.getPath().toString()+"\n";
                            }
                        if(f.isDirectory())
                           return Scan(f,f.listFiles(),s);
                    }
                    return "";
                }
               
           }
           );

           list_directory.addActionListener(
                   new ActionListener() {
               public void actionPerformed(ActionEvent event) {
                   JFrame r=new JFrame("List All Of Files ");
                   JTextArea jt=new JTextArea(8,8);
                   JPanel spane = new JPanel(new GridLayout(0, 1));
                   spane.add(jt);
                   JScrollPane sp = new JScrollPane(spane);
                   JPanel mpane = new JPanel(new GridLayout(0, 1));
                   r.getContentPane().add(sp);
                   r.getContentPane().add(spane);

                   fc.setDialogTitle("select Directory");
                   fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                   fc.showOpenDialog(null);
                   File file=new File(fc.getSelectedFile().getPath());
                   File[] file_list=file.listFiles();
                   
                   jt.append("|   FILE         NAM              |             PATH\n");
                   jt.append("-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                   for(File f : file_list)
                   {
                    if(f.isFile())
                    {
                     jt.append(f.getName()+"                                     ");
                     jt.append(f.getPath().toString()+"\n");
                    }
                    if(f.isDirectory())
                    {
                        jt.append(Scan(f,f.listFiles()));
                    }
                   }
                   r.setLocation(100,100);
                   r.setSize(500,500);
                   r.setVisible(true);
                   
               }
                public String Scan(File w,File[] file_list)
                {
                   for(File f: file_list)
                    {
                        if(f.isFile())
                            return f.getName()+"                                       "+f.getPath().toString()+"\n";
                        if(f.isDirectory())
                           return Scan(f,f.listFiles());
                    }
                    return "";
                }
           }
           );

           list_file.addActionListener(
                   new ActionListener() {
                   public void actionPerformed(ActionEvent event) {
                   JFrame r=new JFrame("List All Of Files ");
                   JTextArea jt=new JTextArea(8,8);
                   JPanel spane = new JPanel(new GridLayout(0, 1));
                   spane.add(jt);
                   JScrollPane sp = new JScrollPane(spane);
                   JPanel mpane = new JPanel(new GridLayout(0, 1));
                   r.getContentPane().add(sp);
                   r.getContentPane().add(spane);
                   File file=new File("C:\\proje");
                   File[] file_list=file.listFiles();
                   jt.append("|   FILE         NAM              |             PATH\n");
                   for(File f : file_list)
                   {
                    if(f.isFile())
                    {
                     jt.append(f.getName()+"                                     ");
                     jt.append(f.getPath().toString()+"                                    "+"\n");
                    }
                    if(f.isDirectory())
                    {
                        jt.append(Scan(f,f.listFiles()));
                    }
                   }
                   r.setLocation(100,100);
                   r.setSize(500,500);
                   r.setVisible(true);
               }
               public String Scan(File w,File[] file_list)
                {
                   for(File f: file_list)
                    {
                        if(f.isFile())
                            return f.getName()+"                                       "+f.getPath().toString()+"\n";
                        if(f.isDirectory())
                           return Scan(f,f.listFiles());
                    }
                    return "";
                }
           }
           );

           viewTree.addActionListener(
                   new ActionListener() {

               public void actionPerformed(ActionEvent event) {
                DScan scan=new DScan("C:\\proje");
               }
           }
           );

           viewSubTree.addActionListener(
                   new ActionListener() {
               public void actionPerformed(ActionEvent event) {
                fc.setDialogTitle("select Directory");
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = fc.showOpenDialog(null);
                File file = fc.getSelectedFile();
                String path=file.getPath();
                DScan ds=new DScan(path);
              }
           }
           );


          EditF.addActionListener(
                   new ActionListener() {

               public void actionPerformed(ActionEvent event) {
                final JFrame q=new JFrame();
                dat = new JTextArea(8, 8);
                JPanel spane = new JPanel(new GridLayout(0, 1));
                spane.add(dat);
                JScrollPane sp = new JScrollPane(spane);
                JPanel mpane = new JPanel(new GridLayout(0, 1));
                q.getContentPane().add(sp);
                q.getContentPane().add(spane);

                final JMenu FMenu = new JMenu("File");
                JMenuBar FBar = new JMenuBar();
                final JMenuItem save = new JMenuItem("Save");
                FMenu.add(save);
                final JMenuItem saveAs = new JMenuItem("Save As...");
                FMenu.add(saveAs);
                final JMenuItem exit = new JMenuItem("Exit");
                FMenu.add(exit);
                FBar.add(FMenu);
                FBar.add(new JSeparator());

                JToolBar T=new JToolBar();
                JButton  Save=new JButton();
                Save.setBackground(Color.YELLOW);
                Save.setToolTipText("Save");
                Save.setIcon(new ImageIcon(getClass().getResource("pic\\y.jpg")));
                T.add(Save);

                JButton SaveAs=new JButton();
                SaveAs.setBackground(Color.YELLOW);
                SaveAs.setToolTipText("Save As");
                SaveAs.setIcon(new ImageIcon(getClass().getResource("pic\\x.jpg")));
                T.add(SaveAs);

                T.add(new JSeparator());

               fc.setDialogTitle("select file");
               fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
               int returnVal = fc.showOpenDialog(null);
               File file = fc.getSelectedFile();
               try {
                   BufferedReader inputStream = new BufferedReader(new FileReader(file.getPath()));
                   String inputLine;
                   dat.setText("");
                   while((inputLine = inputStream.readLine()) != null) {
                         dat.append(inputLine+"\n");
                   }
               }
               catch(FileNotFoundException ioe) {
                    JOptionPane.showMessageDialog(null, "Sorry,File Not Found", "", JOptionPane.WARNING_MESSAGE );
               }
               catch(IOException ioe) {
                    System.out.println(file.getAbsoluteFile());
               }
               ///////////////////////FOR TOOLBAR////////////////////////////
               Save.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent event) {

                                try {
                                File file = fc.getSelectedFile();
                                FileWriter outputStream=new FileWriter(file.getPath());
                                outputStream.write(dat.getText());
                                outputStream.close();
                                setTitle(file.getName());

                                }
                                catch(IOException ioe) {
                            	System.out.println("IOException");
                             }
                       }
                     }
                     );
                     SaveAs.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent event) {

                                fc.showSaveDialog(null);
                                try {
                                 File file = fc.getSelectedFile();
                                 FileWriter outputStream=new FileWriter(file.getPath()+".txt");
                                 outputStream.write(dat.getText());
                                     outputStream.close();
                                 }
                              catch(IOException ioe) {
                               System.out.println("IOException");
                        }
                            }
                     }
                     );
               ///////////////////////////////////////////////////////////////
            
                     save.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent event) {

                                try {
                                File file = fc.getSelectedFile();
                                FileWriter outputStream=new FileWriter(file.getPath());
                                outputStream.write(dat.getText());
                                outputStream.close();
                                setTitle(file.getName());
                                
                                }
                                catch(IOException ioe) {
                            	System.out.println("IOException");
                             }
                       }
                     }
                     );
                     saveAs.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                
                                fc.showSaveDialog(null);
                                try {
                                 File file = fc.getSelectedFile();
                                 FileWriter outputStream=new FileWriter(file.getPath()+".txt");        				
                                 outputStream.write(dat.getText());
                                     outputStream.close();
                                 }
                              catch(IOException ioe) {
                               System.out.println("IOException");
                        }
                            }
                     }
                     );
                     exit.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent event) {

                                q.hide();
                          }
                     }
                     );
                     q.add(T,BorderLayout.NORTH);
                     q.setJMenuBar(FBar);
                     q.setSize(500,500);
                     q.setLocation(100,100);
                     q.setVisible(true);
               }
           }
           );
        main_page.add(TBar,BorderLayout.NORTH);
        main_page.add(pic,BorderLayout.SOUTH);
        main_page.setJMenuBar(Bar);
        main_page.setSize(500, 700);
        main_page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_page.setLocation(50, 50);
        main_page.setVisible(true);

    }


}
