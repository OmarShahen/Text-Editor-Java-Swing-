/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytexteditor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
public class MainFrame extends JFrame implements ActionListener{
    
    JMenu file,edit,font,fontType,color,undo_redo;
    JMenuItem newF,openF,saveF,Exit;//file variables
    JMenuItem cut,copy,paste;//edit variables
    JMenuItem bold,plain,italic;//font variables
    JMenu sizeSubMenu;
    JMenuItem size10,size12,size14,size16,size18,size20,size22,size24,size26,size28;//font sub menu type variables
    JMenuItem timesRoman,ebrima,courier,arial,arial_black,century;//font type variables
    JMenu backGround,foreGround;//color variables
    JMenuItem black,white;//Background colors
    JMenuItem fblack,fblue,fgreen,faqua,fred,fpink,fyellow,fwhite;//Foreground colors
    JTextArea textArea;
    JMenuBar menuBar;
    String backgroundColor,foregroundColor;
    String fontFamily = "Sans Serif";
    int fontStyle = Font.PLAIN;
    int fontSize = 30;
    
    JMenuItem iundo,iredo;//undo redo variables
    UndoManager um = new UndoManager();
    
    
    
    public MainFrame()
    {
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
         menuBar = new JMenuBar();
        
        
        file = new JMenu("File");
        newF = new JMenuItem("New");
        openF = new JMenuItem("Open");
        saveF = new JMenuItem("Save");
        Exit = new JMenuItem("Exit");
        file.add(newF);
        file.add(openF);
        file.add(saveF);
        file.add(Exit);
        
        
        edit = new JMenu("Edit");        
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        
        font = new JMenu("Font");
        bold = new JMenuItem("Bold");
        plain = new JMenuItem("Plain");
        italic = new JMenuItem("Italic");
        font.add(bold);
        font.add(plain);
        font.add(italic);
        
        bold.addActionListener(this);
        italic.addActionListener(this);
        plain.addActionListener(this);
        
        sizeSubMenu = new JMenu("Size");
        size10 = new JMenuItem("10");
        size12 = new JMenuItem("12");
        size14 = new JMenuItem("14");
        size16 = new JMenuItem("16");
        size18 = new JMenuItem("18");
        size20 = new JMenuItem("20");
        size22 = new JMenuItem("22");
        size24 = new JMenuItem("24");
        size26 = new JMenuItem("26");
        size28 = new JMenuItem("28");
        
        size10.addActionListener(this);
        size12.addActionListener(this);
        size14.addActionListener(this);
        size16.addActionListener(this);
        size18.addActionListener(this);
        size20.addActionListener(this);
        size22.addActionListener(this);
        size24.addActionListener(this);
        size26.addActionListener(this);
        size28.addActionListener(this);
        
        sizeSubMenu.add(size10);
        sizeSubMenu.add(size12);
        sizeSubMenu.add(size14);
        sizeSubMenu.add(size16);
        sizeSubMenu.add(size18);
        sizeSubMenu.add(size20);
        sizeSubMenu.add(size22);
        sizeSubMenu.add(size24);
        sizeSubMenu.add(size26);
        sizeSubMenu.add(size28);
        
        font.addActionListener(this);
        
       
        fontType = new JMenu("Font Type");
        timesRoman = new JMenuItem("Times Roman");
        ebrima = new JMenuItem("Helvetica");
        courier = new JMenuItem("Courier");
        arial = new JMenuItem("Arial");
        arial_black = new JMenuItem("Arial Black");
        century = new JMenuItem("Century");
        fontType.add(timesRoman);
        fontType.add(ebrima);
        fontType.add(courier);
        fontType.add(arial);
        fontType.add(arial_black);
        fontType.add(century);
        
        timesRoman.addActionListener(this);
        ebrima.addActionListener(this);
        courier.addActionListener(this);
        arial.addActionListener(this);
        arial_black.addActionListener(this);
        century.addActionListener(this);
        
        color = new JMenu("Color");
        backGround = new JMenu("Background");
        foreGround = new JMenu("Foreground");
        color.add(backGround);
        color.add(foreGround);
        black = new JMenuItem("Black");
        white = new JMenuItem("White");
        backGround.add(black);
        backGround.add(white);
        black.addActionListener(this);
        white.addActionListener(this);
        
        fblack = new JMenuItem("Black");
        fblue = new JMenuItem("Blue");
        fgreen = new JMenuItem("Green");
        faqua = new JMenuItem("Aqua");
        fred = new JMenuItem("Red");
        fpink = new JMenuItem("Purple");
        fyellow = new JMenuItem("Yellow");
        fwhite = new JMenuItem("White");
        
        
        foreGround.add(fblack);
        foreGround.add(fblue);
        foreGround.add(fgreen);
        foreGround.add(faqua);
        foreGround.add(fred);
        foreGround.add(fpink);
        foreGround.add(fyellow);
        foreGround.add(fwhite);
       
        fblack.addActionListener(this);
        fblue.addActionListener(this);
        fgreen.addActionListener(this);
        faqua.addActionListener(this);
        fred.addActionListener(this);
        fpink.addActionListener(this);
        fyellow.addActionListener(this);
        fwhite.addActionListener(this);
        
        
        
        
        
                
        undo_redo = new JMenu("Undo&Redo");
        iundo = new JMenuItem("Undo");
        iredo = new JMenuItem("Redo");
        iundo.addActionListener(this);
        iredo.addActionListener(this);
        undo_redo.add(iundo);
        undo_redo.add(iredo);
        menuBar.add(file);
        menuBar.add(edit);
        font.add(sizeSubMenu);
        menuBar.add(font);
        menuBar.add(fontType);
        menuBar.add(color);
        menuBar.add(undo_redo);
        
        
        setJMenuBar(menuBar);
        textArea = new JTextArea(400,400);
        
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener(){public void undoableEditHappened(UndoableEditEvent e){um.addEdit(e.getEdit());}});
     
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize));
        add(textArea);
        JScrollPane scrollPane = new JScrollPane(textArea);                                                                                                                                                                                                                                                                                                                                         
        add(scrollPane);
                

        
    }
public void actionPerformed(ActionEvent e)
{ 
    if(e.getSource() == bold)
    {
            fontStyle = Font.BOLD;
            textArea.setFont(new Font(fontFamily,fontStyle,fontSize));
    }
    else if(e.getSource() == italic)
    {
        fontStyle = Font.ITALIC;
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize));      
    }
    else if(e.getSource() == plain)
    {
        fontStyle = Font.PLAIN;
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize));
    }
    if(e.getSource() == size10)
    {
        fontSize = 10;
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize)); 
    }
    else if(e.getSource() == size12)
    {
        fontSize = 12;
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize)); 
    }
     else if(e.getSource() == size14)
    {
        fontSize = 14;
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize)); 
    }
     else if(e.getSource() == size16)
    {
        fontSize = 16;
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize)); 
    }
     else if(e.getSource() == size18)
    {
        fontSize = 18;
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize)); 
    }
     else if(e.getSource() == size20)
    {
        fontSize = 20;
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize)); 
    }
     else if(e.getSource() == size22)
    {
        fontSize = 22;
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize)); 
    }
     else if(e.getSource() == size24)
    {
        fontSize = 24;
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize)); 
    }
     else if(e.getSource() == size26)
    {
        fontSize = 26;
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize)); 
    }
     else if(e.getSource() == size28)
    {
        fontSize = 28;
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize)); 
    }
    if(e.getSource() == timesRoman)
    {
        fontFamily = "Times New Roman";
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize));                
    }
    else if(e.getSource() == ebrima)
    {
        fontFamily = "Ebrima";
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize));                
    }
     else if(e.getSource() == courier)
    {
        fontFamily = "Courier New";
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize));                
    }
    else if(e.getSource() == arial)
    {
        fontFamily = "Arial";
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize));                
    }
    else if(e.getSource() == arial_black)
    {
        fontFamily = "Arial Black";
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize));                
    }
    else if(e.getSource() == century)
    {
        fontFamily = "Century";
        textArea.setFont(new Font(fontFamily,fontStyle,fontSize));                
    }
    if(e.getSource() == black)
    {
        textArea.setBackground(Color.BLACK);
    }
    else if(e.getSource() == white)
    {
        textArea.setBackground(Color.WHITE);
    }
    if(e.getSource() == fblack)
    {
        textArea.setForeground(Color.BLACK);
    }
    else if(e.getSource() == fblue)
    {
        textArea.setForeground(Color.BLUE);
    }
    else if(e.getSource() == fgreen)
    {
        textArea.setForeground(Color.GREEN);
    }
    else if(e.getSource() == fred)
    {
        textArea.setForeground(Color.RED);
    }
    else if(e.getSource() == fpink)
    {
        textArea.setForeground(Color.PINK);
    }
    else if(e.getSource() == fyellow)
    {
        textArea.setForeground(Color.YELLOW);
    }
    else if(e.getSource() == fwhite)
    {
        textArea.setForeground(Color.WHITE);
    }
    if(e.getSource() == iundo)
    {
        um.undo();
    }
    else if(e.getSource() == iredo)
    {
        um.redo();
    }
        
}
   
}
    



