import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import dao.BobaCool;

public class CreateForm extends JFrame implements ActionListener {

	JButton save = new JButton("Save");
	JButton cancel = new JButton("Cancel");
	
	JTextField txtNama = new JTextField();
	JTextField txtHarga = new JTextField();
	JTextField txtStok = new JTextField();
	
	JMenuItem exit = new JMenuItem("Exit");
	
	public CreateForm() {
		// TODO Auto-generated constructor stub
		initMenuBar();
		initFrame();
	}
	
	public void initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Actions");
		
		exit.addActionListener(this);
		menu1.add(exit);
		
		menuBar.add(menu1);
		
		setJMenuBar(menuBar);
	}
	
	public void initFrame() {
		setTitle("Create Form");
		setSize(400, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(400, 200);
		setLayout(new GridLayout(0,2));
		setResizable(false);
		setVisible(true);
		
		initComponent();
	}
	
	public void initComponent() {
		
		JLabel nama = new JLabel("Nama :");
		add(nama);
		add(txtNama);
		
		JLabel harga = new JLabel("Harga :");
		add(harga);
		add(txtHarga);
		
		JLabel stok = new JLabel("Stok :");
		add(stok);
		add(txtStok);
		
		save.addActionListener(this);
		cancel.addActionListener(this);
		add(save);
		add(cancel);
	}

	public boolean validateData() {
		if(
			txtNama.getText().isEmpty()
			||txtHarga.getText().isEmpty()
			||txtStok.getText().isEmpty()){
			return false;
		}else {
			return true;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(save)) {
			if(validateData() == false) {
				JOptionPane.showMessageDialog(null, "Please fill all input");
			}else {
				BobaCool bobacooldao = new BobaCool();
				bobacooldao.insertData(txtNama.getText(), txtHarga.getText(), txtStok.getText());
				JOptionPane.showMessageDialog(null, "Success Add Data");
			}
		}else if(e.getSource().equals(cancel)){
			new menu();
			setVisible(false);
		}else if(e.getSource().equals(exit)) {
			System.exit(0);
		}
	}
	
}