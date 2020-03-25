import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTree;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;

public class MainWindow {

	boolean filterByType=false;
	boolean filterByFlavor=false; 
	String flavor ="?"; 
	String type="?"; 
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 380, 230);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Get stats");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
		        HistogramPanel panel = new HistogramPanel();
		        SalesGraph stats;
		        
		        if(filterByType)
		        {
		        	stats = new SalesGraphFilterType(type);
		        }
		        else if(filterByFlavor)
		        {
		        	stats = new SalesGraphFilterFlavor(flavor);	
		        }
		        else
		        {
		        	stats = new SalesGraphRegular();    
		        }
		     
		        SqlCon connect = new SqlCon(); 
		        connect.myCon(stats); 
		        stats.filter();
		        
		        
		        SnackItem item;
		        Integer sale;
		        while(stats.itemsAmount()>0)
		        {
		        	item=stats.items.pop();
		        	sale =stats.sales.pop();
		        	panel.addHistogramColumn(item.name +"\n sales",sale,Color.BLUE);
		        }
		      
		        panel.layoutHistogram();

		        JFrame frame = new JFrame("Histogram Panel");
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        frame.getContentPane().add( panel );
		        frame.setLocationByPlatform( true );
		        frame.pack();
		        frame.setVisible( true );
			}
		});
		btnNewButton.setBounds(125, 122, 97, 25);
		frame.getContentPane().add(btnNewButton);
		ButtonGroup bgHow = new ButtonGroup();
		
		
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Type");
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filterByType=true;
					filterByFlavor=false; 
				}
			});
			rdbtnNewRadioButton.setBounds(70, 2, 57, 25);
			frame.getContentPane().add(rdbtnNewRadioButton);
		
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Flavor");
			rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					filterByType=false;
					filterByFlavor=true; 
				}
			});
			rdbtnNewRadioButton_1.setBounds(125, 2, 63, 25);
			frame.getContentPane().add(rdbtnNewRadioButton_1);
		
			JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("None");
			rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filterByType=false;
					filterByFlavor=false; 
				}
			});
			rdbtnNewRadioButton_2.setSelected(true);
			rdbtnNewRadioButton_2.setBounds(185, 2, 127, 25);
			frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		bgHow.add(rdbtnNewRadioButton);
		bgHow.add(rdbtnNewRadioButton_1);
		bgHow.add(rdbtnNewRadioButton_2);
			
			JLabel lblNewLabel = new JLabel("Filter by:");
			lblNewLabel.setBounds(8, 0, 108, 29);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Which type: ");
			lblNewLabel_1.setBounds(8, 36, 86, 16);
			frame.getContentPane().add(lblNewLabel_1);
			
			JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Drink");
			rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					type ="Drink"; 
				}
			});
			rdbtnNewRadioButton_3.setBounds(80, 32, 57, 25);
			frame.getContentPane().add(rdbtnNewRadioButton_3);
			
			JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Food");
			rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					type ="Food"; 
				}
			});
			rdbtnNewRadioButton_4.setBounds(135, 32, 127, 25);
			frame.getContentPane().add(rdbtnNewRadioButton_4);
			
			ButtonGroup bgType = new ButtonGroup();
			
		bgType.add(rdbtnNewRadioButton_3);
		bgType.add(rdbtnNewRadioButton_4);
			
			JLabel lblNewLabel_2 = new JLabel("Which flavor:");
			lblNewLabel_2.setBounds(8, 65, 76, 16);
			frame.getContentPane().add(lblNewLabel_2);
			
			JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Sweet");
			rdbtnNewRadioButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					flavor ="Sweet"; 
				}
			});
			rdbtnNewRadioButton_5.setBounds(90, 61, 65, 25);
			frame.getContentPane().add(rdbtnNewRadioButton_5);
			
			JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Salty");
			rdbtnNewRadioButton_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					flavor ="Salty"; 
				}
			});
			rdbtnNewRadioButton_6.setBounds(155, 62, 57, 25);
			frame.getContentPane().add(rdbtnNewRadioButton_6);
			
			JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("Spicy");
			rdbtnNewRadioButton_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					flavor ="Spicy"; 
				}
			});
			rdbtnNewRadioButton_7.setBounds(210, 61, 63, 25);
			frame.getContentPane().add(rdbtnNewRadioButton_7);
			
			JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("Sour");
			rdbtnNewRadioButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					flavor="Sour"; 
				}
			});
			rdbtnNewRadioButton_8.setBounds(275, 61, 127, 25);
			frame.getContentPane().add(rdbtnNewRadioButton_8);
		
		ButtonGroup bgFlavor = new ButtonGroup();
		bgFlavor.add(rdbtnNewRadioButton_5);
		bgFlavor.add(rdbtnNewRadioButton_6);
		bgFlavor.add(rdbtnNewRadioButton_7);
		bgFlavor.add(rdbtnNewRadioButton_8);
		
	}
}
