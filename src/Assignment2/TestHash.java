package Assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Graphic representation of my Hash Table with interactions.
 * Read the instruction manual to guide you through this (very) simple application
 * @author danielhertzman-ericson
 *
 */
public class TestHash extends JPanel {
	
	private HashTable ht = new HashTable(15);
	private JPanel northPnl = new JPanel();
	private JTextField keyTxt = new JTextField();
	private JTextArea resultTxt = new JTextArea();
	private JButton findBtn = new JButton("Find");
	private JButton remove = new JButton("Remove");
	private JButton showAll = new JButton("Show table");
	
	public TestHash() {
		putInHash();
		
		setPreferredSize(new Dimension(400,400));
		setLayout(new BorderLayout());
		
		findBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == findBtn) {
					String str = (String) ht.get(keyTxt.getText());
					resultTxt.setText(" Result:\n " + str);
				}
				
			}
		});
		
		remove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == remove) {
					String str = keyTxt.getText();
					ht.remove(str);
					resultTxt.setText("'"+str+"'" + " has been removed");
					keyTxt.setText("");
				}
				
			}
		});
		
		showAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == showAll) {
					resultTxt.setText(" Full table: \n " + ht.getInsertionOrder().toString());					
				}
			}
		});
		
		northPnl.setLayout(new GridLayout(1, 2));
		northPnl.add(keyTxt);
		northPnl.add(findBtn);
		northPnl.add(remove);
		
		add(northPnl, BorderLayout.NORTH);
		add(resultTxt, BorderLayout.CENTER);
		add(showAll, BorderLayout.SOUTH);
	}
	
	/*
	 * Used to push in keys and values.
	 * I'm just using the example from the pdf.
	 */
	private void putInHash() {
		ht.put("hej", "hello");
		ht.put("nej", "no");
		ht.put("senare", "later");
		ht.put("idag", "today");
		ht.put("igår", "yesterday");
	}
	
	public static void main(String[] args) {	
		JFrame frame = new JFrame("TestHash");
		frame.add(new TestHash());
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
