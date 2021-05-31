import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import dao.BobaCool;

public class GetTable extends JFrame implements ActionListener{

	JMenuItem back = new JMenuItem("Back to main menu");
	JMenuItem exitMenu = new JMenuItem("Exit");
	
	public GetTable() {
		// TODO Auto-generated constructor stub
		initMenuBar();
		initFrame();
	}
	
	public void initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Actions");

		back.addActionListener(this);
		exitMenu.addActionListener(this);

		menu1.add(back);
		menu1.add(exitMenu);
		
		menuBar.add(menu1);
		
		setJMenuBar(menuBar);
	}
	
	public void initFrame() {
		setTitle("Get Data");
		setSize(500, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(400, 200);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		
		initTable();
	}
	
	public void initTable() {

		Vector<String> column = new Vector<>();
		column.add("Kode Menu");
		column.add("Nama Menu");
		column.add("Harga Menu");
		column.add("Stock Menu");
		BobaCool bobacooldao = new BobaCool();
		
		JTable table1 = new JTable(bobacooldao.getData1(), column) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		
		JScrollPane scroll1 = new JScrollPane(table1);
		scroll1.setBounds(0, 0, 500, 500);
		
		
		add(scroll1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(back)){
			new menu();
			setVisible(false);
		}else if(e.getSource().equals(exitMenu)) {
			System.exit(0);
		}
	}

}
