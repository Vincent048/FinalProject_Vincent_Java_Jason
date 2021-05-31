import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.*;

import dao.BobaCool;

public class DeleteData extends JFrame implements ActionListener, MouseListener {

	JMenuItem back, exitMenu;
	JTable table1, table2;
	JLabel txtNama, txtHarga, txtStok;
	JButton delete;
	String kode = "";
	
	public DeleteData() {
		initMenuBar();
		initFrame();
		addDeleteButton();
	}
	
	public void initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Actions");

		back = new JMenuItem("Back to main menu");
		exitMenu = new JMenuItem("Exit");
		
		back.addActionListener(this);
		exitMenu.addActionListener(this);

		menu1.add(back);
		menu1.add(exitMenu);
		
		menuBar.add(menu1);
		
		setJMenuBar(menuBar);
	}
	
	public void initFrame() {
		setTitle("Delete Data");
		setSize(500, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(400, 200);
		setLayout(new GridLayout(3,1));
		setResizable(false);
		setVisible(true);
		
		initTable();
		initComponent();
	}
	
	public void initTable() {
		Vector<String> column = new Vector<>();
		column.add("Kode Menu");
		column.add("Nama Menu");
		column.add("Harga Menu");
		column.add("Stok Menu");
		BobaCool bobacooldao = new BobaCool();
		
		table1 = new JTable(bobacooldao.getData1(), column) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		
//		table2 = new JTable(bobacooldao.getData2(), column) {
//			public boolean isCellEditable(int row, int column) {
//				return false;
//			};
//		};
		
		table1.addMouseListener(this);
		JScrollPane scroll1 = new JScrollPane(table1);
		scroll1.setBounds(0, 0, 500, 500);
		
//		table2.addMouseListener(this);
//		JScrollPane scroll2 = new JScrollPane(table2);
//		scroll2.setBounds(0, 0, 500, 500);
		
		add(scroll1);
//		add(scroll2);
	}
	
	public void initComponent() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		JLabel nama = new JLabel("Name Menu: ");
		txtNama = new JLabel();
		panel.add(nama);
		panel.add(txtNama);
		
		JLabel harga = new JLabel("Harga Menu: ");
		txtHarga = new JLabel();
		panel.add(harga);
		panel.add(txtHarga);
		
		JLabel stok = new JLabel("Stok Menu: ");
		txtStok = new JLabel();
		panel.add(stok);
		panel.add(txtStok);
		
		add(panel);
	}
	
	public void addDeleteButton() {
		delete = new JButton("Delete Data");
		delete.addActionListener(this);
		add(delete);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int selectRowIndex = table1.getSelectedRow();
		kode = table1.getValueAt(selectRowIndex, 0).toString();
		String nama = table1.getValueAt(selectRowIndex, 1).toString();
		Integer harga = Integer.parseInt(table1.getValueAt(selectRowIndex, 2).toString());
		Integer stok = Integer.parseInt(table1.getValueAt(selectRowIndex, 3).toString());
		
		txtNama.setText(nama);
		txtHarga.setText(String.valueOf(harga));
		txtStok.setText(String.valueOf(stok));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(back)){
			new menu();
			setVisible(false);
		}else if(e.getSource().equals(exitMenu)) {
			System.exit(0);
		}else if(e.getSource().equals(delete)) {
			if(kode.equals("")) {
				JOptionPane.showMessageDialog(null, "You have to choose data first!");
			}else {
				BobaCool bobacooldao = new BobaCool();
				bobacooldao.deleteData(kode);
				JOptionPane.showMessageDialog(null, "Success Delete!");
				new DeleteData();
				setVisible(false);
			}
		}
	}

}