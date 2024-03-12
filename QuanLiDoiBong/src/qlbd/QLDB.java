package qlbd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import qlbd.QLDB;

public class QLDB  extends JFrame implements ActionListener,MouseListener{
	
	    // CHÀO MỪNG BẠN ĐẾN VỚI GIAO DIỆN QUẢN LÍ CLB BÓNG ĐÁ
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection cn;
	ArrayList<cauthu> listcauthu=new ArrayList<>();
	int index=0;
	private JFrame frame;
	private JTextField tftct;
	private JTextField tfns;
	private JTextField tfqt;
	private JTextField tfvt;
	private JTextField tfngn;
	private JTextField tftl;
	private JTextField tfthlv;
	private JTextField tfnshlv;
	private JTextField tfngnhlv;
	private JTextField tftlhlv;
	private JButton bttthem  ;
	private JButton bttxoa;
	private JButton bttsua;
	private JButton bttluu;
	private JButton btttimkiem;
	

	private JButton bttthemhlv;
	private JButton bttxoahlv;
	private JButton bttsuahlv;
	private JButton bttnewhlv;
	private  DefaultTableModel Model;
	private DefaultTableModel Model1 ;
	private JTable table;
    public QLDB(){
    		   try {
    			   Class.forName("com.mysql.cj.jdbc.Driver");
    	   		cn=DriverManager.getConnection("jdbc"+":mysql://localhost:3307/qlbd","root","root");
    		   }catch(Exception e) {
    			   System.out.println(e);
    		   }
    ngan();
    listcauthu=ketnoi.findAllcauthu();
    bang();
    }


	private void bang() {
	    listcauthu=ketnoi.findAllcauthu();
	    Model.setRowCount(0);
	    listcauthu.forEach((cauthu)-> {
	    	 Model.addRow(new Object[] {cauthu.getten(),cauthu.getngaysinh(),cauthu.getvitri(),cauthu.getquoctich(),cauthu.getngaygianhap(),cauthu.gettienluong()});
	    });
    }


	private void ngan() {
		frame=new JFrame();
		frame.setBounds(100,0,1000,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("CHƯƠNG TRÌNH QUẢN LÝ ĐỘI BÓNG ");
		
		JMenuBar menubar=new JMenuBar();
		 setJMenuBar(menubar);
		JMenu mnuFile=new JMenu("File");
		mnuFile.setMnemonic('F'); 
		JMenu mnuEdit=new JMenu("Edit"); 
		mnuEdit.setMnemonic('E'); 
		JMenu mnuView=new JMenu("View");
		mnuView.setMnemonic('V'); 
        JMenu mnuHelp=new JMenu("Help");
		mnuHelp.setMnemonic('H'); 
		JMenu mnuSearch=new JMenu("Search");
		mnuSearch.setMnemonic('S'); 
        menubar.add(mnuFile); 
		menubar.add(mnuEdit);
		menubar.add(mnuView);
		menubar.add(mnuHelp);
		menubar.add(mnuSearch);
		JMenuItem mnuFileNew=new JMenuItem("New"); 
		JMenuItem mnuFileOpen=new JMenuItem("Open");
		JMenuItem mnuFileSave=new JMenuItem("Save");
		JMenuItem mnuFileSaveAs=new JMenuItem("Save as");
		JMenuItem mnuFileExit=new JMenuItem("Exit"); 
		JMenuItem mnuEditUndo=new JMenuItem("Undo"); 
		JMenuItem mnuEditRedo=new JMenuItem("Redo"); 
		JMenuItem mnuEditCut=new JMenuItem("Cut"); 
		JMenuItem mnuEditCopy=new JMenuItem("Copy"); 
		JMenuItem mnuEditPaste=new JMenuItem("Paste"); 
		JMenuItem mnuEditFind=new JMenuItem("Find"); 
		JMenuItem mnuEditReplace=new JMenuItem("Replace"); 
        mnuFile.add(mnuFileNew);
	    mnuFile.add(mnuFileOpen);
		mnuFile.addSeparator(); 
		mnuFile.add(mnuFileSave);
		mnuFile.add(mnuFileSaveAs);
        mnuFile.addSeparator(); 
		mnuFile.add(mnuFileExit);
		mnuEdit.add(mnuEditUndo);
		mnuEdit.add(mnuEditRedo);
		mnuEdit.addSeparator();
		mnuEdit.add(mnuEditCut);
		mnuEdit.add(mnuEditCopy);
		mnuEdit.add(mnuEditPaste);
		mnuEdit.addSeparator();
		mnuEdit.add(mnuEditFind);
		mnuEdit.add(mnuEditReplace);
        frame.add(menubar,BorderLayout.NORTH);
        
        JTabbedPane tabbedPane=new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel bd =new JPanel();
        tabbedPane.addTab("QUẢN LÝ ĐỘI BÓNG ĐÁ ", null,bd ,null);
		tabbedPane.setForegroundAt(0,Color.BLACK);
		tabbedPane.setMnemonicAt(0, 100);
		tabbedPane.setBackgroundAt(0, SystemColor.menu);;
		bd.setLayout(null);
        JDesktopPane desktopPane1=new JDesktopPane();
		desktopPane1.setDragMode(10);
		desktopPane1.setBackground(Color.LIGHT_GRAY);
		desktopPane1.setBounds(0,0,1350,650);
		desktopPane1.setToolTipText((""));
		desktopPane1.setForeground(Color.GREEN);
	    bd.add(desktopPane1);
        JInternalFrame internalFrame=new JInternalFrame("CẦU THỦ");
		internalFrame.setClosable(true);
		internalFrame.setIconifiable(true);
		internalFrame.setMaximizable(true);
		internalFrame.setEnabled(false);
		internalFrame.setBounds(0,0,1000,600);
		internalFrame.setVisible(true);

		JPanel pnBorder=new JPanel();
		pnBorder.setLayout(new BorderLayout());
        JPanel pnlLeft=new JPanel(new GridLayout(0,1));
		pnlLeft.add(new JLabel("THÔNG TIN CẦU THỦ ",JLabel.CENTER));
		pnlLeft.add(new JLabel("Tên cầu thủ:"));
		pnlLeft.add(tftct=new JTextField(20));
		pnlLeft.add(new JLabel("Ngày sinh:"));
		pnlLeft.add(tfns=new JTextField(20));
		pnlLeft.add(new JLabel("Quốc tịch:"));
		pnlLeft.add(tfqt=new JTextField(20));
		pnlLeft.add(new JLabel("Vị trí:"));
		pnlLeft.add(tfvt=new JTextField(20));
		pnlLeft.add(new JLabel("Ngày gia nhập:"));
		pnlLeft.add(tfngn=new JTextField(20));
		pnlLeft.add(new JLabel("Tiền lương:"));
		pnlLeft.add(tftl=new JTextField(20));	
	    JPanel bt1;
		pnlLeft.add(bt1=new JPanel());
		bt1.add(bttthem  =new JButton("Thêm  "));
		bttthem  .setMnemonic('T');
		bt1.add(bttxoa=new JButton("Xoá"));
		bttxoa.setMnemonic('X');
		bt1.add(bttsua =new JButton("Sửa "));
		bttsua.setMnemonic('S');
		bt1.add(bttluu =new JButton("Lưu"));
		bttluu.setMnemonic('L');
		bt1.add(btttimkiem =new JButton("Tìm kiếm"));
		btttimkiem.setMnemonic('T');
	
		desktopPane1.add(internalFrame);
		pnBorder.add(pnlLeft,BorderLayout.WEST);
        JPanel pnlRight=new JPanel(new GridLayout(0,1));
		  String[] hearders={"Tên cầu thủ ","Ngày sinh ","Quốc tịch","Vị trí","Ngày gia nhập","Tiền Lương"};
		pnlRight.add(new JScrollPane(table=new JTable(Model=new DefaultTableModel(hearders,0))));
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnlLeft, pnlRight    );
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);	
		pnBorder.add(splitPane ,BorderLayout.CENTER);
		internalFrame.add(pnBorder);
		bttxoa.addActionListener(this);
		bttsua.addActionListener(this);
		bttthem.addActionListener(this);
		bttluu.addActionListener(this);
		btttimkiem.addActionListener(this);
		//bttexit.addActionListener(this);
        table.addMouseListener(this);

		
		JPanel hlv =new JPanel();
		tabbedPane.addTab("QUẢN LÝ HUẤN LUYỆN VIÊN ",null,hlv,null);
		tabbedPane.setMnemonicAt(0, 1000);
		tabbedPane.setBackgroundAt(0, SystemColor.menu);;
		hlv.setLayout(null);
		JDesktopPane desktopPane2=new JDesktopPane();
		desktopPane2.setDragMode(10);
		desktopPane2.setBackground(Color.LIGHT_GRAY);
		desktopPane2.setBounds(0,0,1350,650);
		desktopPane2.setToolTipText((""));
		desktopPane2.setForeground(Color.GREEN);
		hlv.add(desktopPane2);
		JInternalFrame internalFrame2=new JInternalFrame("Huấn luyện viên ");
		internalFrame2.setClosable(true);
		internalFrame2.setMaximizable(true);
		internalFrame2.setIconifiable(true);
		internalFrame2.setEnabled(false);
		internalFrame2.setBounds(0,0,1000,600);
		internalFrame2.setVisible(true);
        JPanel pnBorder1=new JPanel();
		pnBorder1.setLayout(new BorderLayout());
		JPanel pnlLeft1=new JPanel(new GridLayout(0,1));
		pnlLeft1.add(new JLabel("THÔNG TIN HUẤN LUYỆN VIÊN",JLabel.CENTER));
		pnlLeft1.add(new JLabel("Tên huấn luyện viên:"));
		pnlLeft1.add(tfthlv=new JTextField(20));
		pnlLeft1.add(new JLabel("Ngày sinh:"));
		pnlLeft1.add(tfnshlv=new JTextField(20));
		pnlLeft1.add(new JLabel("Ngày gia nhập:"));
		pnlLeft1.add(tfngnhlv=new JTextField(20));
		pnlLeft1.add(new JLabel("Tiền lương:"));
		pnlLeft1.add(tftlhlv=new JTextField(20));
        JPanel bt3;
		pnlLeft1.add(bt3=new JPanel());
		bt3.add(bttthemhlv =new JButton("Thêm "));
		bttthemhlv.setMnemonic('T');
		bt3.add(bttxoahlv=new JButton("Xoá"));
		bttxoahlv.setMnemonic('X');
		bt3.add(bttsuahlv=new JButton("Sửa"));
		bttsuahlv.setMnemonic('S');
		bt3.add(bttnewhlv=new JButton("New"));
		bttnewhlv.setMnemonic('N');
		desktopPane2.add(internalFrame2);

		pnBorder1.add(pnlLeft1,BorderLayout.WEST);
		JPanel pnlRight1=new JPanel(new GridLayout(1,1));
		String[] hearders1={"Tên huấn luyện viên","Ngày sinh","Ngày gia nhập","Tiền lương"};
	    JTable table1=new JTable();
        pnlRight1.add(new JScrollPane(table1=new JTable(Model1=new DefaultTableModel(hearders1,0))));
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnlLeft1, pnlRight1   );
      	splitPane1.setOneTouchExpandable(true);
      	splitPane1.setDividerLocation(150);
     	pnBorder1.add(splitPane1 ,BorderLayout.CENTER);
        internalFrame2.add(pnBorder1);
		bttxoahlv.addActionListener(this);
		bttsuahlv.addActionListener(this);
		bttthemhlv.addActionListener(this);
		bttnewhlv.addActionListener(this);
		table1.addMouseListener(this);
		
		
	}
	public static void main(String[]args) {
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
	try{
		QLDB window=new QLDB();
		window.frame.setVisible(true);
	}catch(Exception e){
		e.printStackTrace();
	}
   }
 });
}    
	public boolean check() {
    	if(tftct.getText().equals("")||tfns.getText().equals("")||tfqt.getText().equals("")||tfvt.getText().equals("")||tfngn.getText().equals("")||tftl.getText().equals("")) {
    		 JOptionPane.showMessageDialog(rootPane, "Hãy nhập đủ dữ liệu sau đó ấn lưu ");
             return false;	
    	}
		return true;
    }
public void NapVaoONhapLieu(int index) {
	tftct.setText(listcauthu.get(index).getten());
	tfns.setText(listcauthu.get(index).getngaysinh());
	tfqt.setText(listcauthu.get(index).getquoctich());
	tfvt.setText(listcauthu.get(index).getvitri());
	tftl.setText(String.valueOf(listcauthu.get(index).gettienluong()));
	tfngn.setText(listcauthu.get(index).getngaygianhap());
	AbstractButton tfclb = null;
	
}
@Override
public void mouseClicked(MouseEvent e) {
	clicked();
}
private void clicked() {
	try {
		index=table.getSelectedRow();
		NapVaoONhapLieu(index);
	}catch(Exception e) {
		System.out.println(e);
	}
}
@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}


@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource().equals(bttluu)) luuAc();
	else if(e.getSource().equals(bttxoa)) xoaAc();
	else if(e.getSource().equals(bttsua)) suaAc();
	else if(e.getSource().equals(btttimkiem)) timkiemAc();
	else if(e.getSource().equals(bttthem)) themAc();
	



	
}   
private void clbAc() {
    
       }


private void themAc() {
	tftct.setText("");
	tfns.setText("");
	tfvt.setText("");
	tfqt.setText("");
	tfngn.setText("");
	tftl.setText("");		
}
private void timkiemAc() {
	String input =JOptionPane.showInputDialog(rootPane,"Chọn tên cầu thủ để tìm kiếm");
	if(input!=null&&input.length()>0) {
		listcauthu=ketnoi.timkiemcauthu(input);
		Model.setRowCount(0);
		listcauthu.forEach((cauthu)->
		{Model.addRow(new Object[] {
			cauthu.getten(),cauthu.getngaysinh(),cauthu.getvitri(),cauthu.getquoctich(),cauthu.getngaygianhap(),cauthu.gettienluong()});
		});
	}	else {
		bang();
	}
}

private void xoaAc() {
	int index=table.getSelectedRow();
	if(index>=0) {
		cauthu cauthu=listcauthu.get(index);
		int option=JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa không?");
		System.out.println("option:"+option);
	if(option==0) {
		ketnoi.xoacauthu(cauthu.getten());
		bang();
	}
	}
}
public boolean addcauthu(cauthu cauthu) {
	   String sql="insert into cauthu (tencauthu, ngaysinh, vitri, quoctich, ngaygianhap, tienluong)"+"values(?,?,?,?,?,?)";
	   try {
		   PreparedStatement ps =cn.prepareStatement(sql);
		   ps.setString(1, cauthu.getten());
           ps.setString(2, cauthu.getngaysinh());
           ps.setString(3, cauthu.getvitri());
           ps.setString(4, cauthu.getquoctich());
           ps.setString(5, cauthu.getngaygianhap());
           ps.setDouble(6, cauthu.gettienluong());
           
		   return ps.executeUpdate()>0;
		   
	   }catch(Exception e) {
		   System.out.println(e);
	   }
return false;
}
private void luuAc() {
	if(check()) { 
	cauthu cauthu=new cauthu();
    cauthu.setten(tftct.getText());
    cauthu.setngaysinh(tfns.getText());
    cauthu.setvitri(tfvt.getText());
    cauthu.setquoctich(tfqt.getText());
    cauthu.setngaygianhap(tfngn.getText());
    cauthu.settienluong(Double.parseDouble(tftl.getText()));
	listcauthu.add( cauthu);
	if(addcauthu( cauthu)) {
		JOptionPane.showConfirmDialog(rootPane, "Lưu thành công");
	}else {
		JOptionPane.showConfirmDialog(rootPane, "Lưu không thành công");

	}
	bang();
	} 
}
private void suaAc() {
	try {
		String sql="update cauthu set ngaysinh=?,vitri=?,quoctich=?,ngaygianhap=?,tienluong=? where cauthu.tencauthu=?";
		PreparedStatement ps= cn.prepareStatement(sql) ;
        index =table.getSelectedRow();
        if(listcauthu.size()==0) {
			JOptionPane.showConfirmDialog(rootPane, "Hãy nhập thêm cầu thủ rồi sửa");
        }	else if (index==-1){
			JOptionPane.showConfirmDialog(rootPane, "Chọn dòng cần sửa");
  
        }else {
        	 ps.setString(1, tfns.getText());
     		   ps.setString(3,tfqt.getText());
     		   ps.setString(2, tfvt.getText());
     		   ps.setString(4, tfngn.getText());
     		   ps.setDouble(5, Double.parseDouble(tftl.getText()));
     		   ps.setString(6, tftct.getText());
     		   ps.execute();
     		   bang();
   			JOptionPane.showConfirmDialog(rootPane, "Sửa thành công");

        }
	}catch(Exception e) {
		System.out.println(e);
		
	}
	
}
	

}