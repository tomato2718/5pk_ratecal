import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int deck[] = new int[5];
		
		@SuppressWarnings("unchecked")
		DefaultComboBoxModel<String> cards[]=new DefaultComboBoxModel[5];
		for(int i=0;i<5;i++) {
			cards[i]=new DefaultComboBoxModel<>(new String[] {"\u9ED1\u6843A", "\u9ED1\u68432", "\u9ED1\u68433", "\u9ED1\u68434", "\u9ED1\u68435", "\u9ED1\u68436", "\u9ED1\u68437", "\u9ED1\u68438", "\u9ED1\u68439", "\u9ED1\u684310", "\u9ED1\u6843J", "\u9ED1\u6843Q", "\u9ED1\u6843K", "\u7D05\u5FC3A", "\u7D05\u5FC32", "\u7D05\u5FC33", "\u7D05\u5FC34", "\u7D05\u5FC35", "\u7D05\u5FC36", "\u7D05\u5FC37", "\u7D05\u5FC38", "\u7D05\u5FC39", "\u7D05\u5FC310", "\u7D05\u5FC3J", "\u7D05\u5FC3Q", "\u7D05\u5FC3K", "\u65B9\u584AA", "\u65B9\u584A2", "\u65B9\u584A3", "\u65B9\u584A4", "\u65B9\u584A5", "\u65B9\u584A6", "\u65B9\u584A7", "\u65B9\u584A8", "\u65B9\u584A9", "\u65B9\u584A10", "\u65B9\u584AJ", "\u65B9\u584AQ", "\u65B9\u584AK", "\u6885\u82B1A", "\u6885\u82B12", "\u6885\u82B13", "\u6885\u82B14", "\u6885\u82B15", "\u6885\u82B16", "\u6885\u82B17", "\u6885\u82B18", "\u6885\u82B19", "\u6885\u82B110", "\u6885\u82B1J", "\u6885\u82B1Q", "\u6885\u82B1K", "\u9B3C\u724CA", "\u9B3C\u724C2"});
		}
		
		
		frame = new JFrame("5PK牌型計算機");
		frame.setResizable(false);
		frame.setMaximumSize(new Dimension(450, 200));
		frame.setMinimumSize(new Dimension(450, 200));
		frame.setSize(450, 250);
		frame.setBounds(100, 100, 450, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(20, 0, 0, 0));
		panel.setPreferredSize(new Dimension(10, 110));
		panel.setMinimumSize(new Dimension(0, 60));
		panel.setMaximumSize(new Dimension(0, 60));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 20, 0, 0));
		panel_3.setPreferredSize(new Dimension(10, 30));
		panel_3.setMaximumSize(new Dimension(0, 20));
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		JComboBox<String> card1 = new JComboBox<String>();
		card1.setModel(cards[0]);
		card1.setSelectedIndex(0);
		card1.setToolTipText("");
		card1.setPreferredSize(new Dimension(75, 23));
		card1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		panel_3.add(card1);

		JComboBox<String> card2 = new JComboBox<String>();
		card2.setModel(cards[1]);
		card2.setSelectedIndex(1);
		card2.setToolTipText("");
		card2.setPreferredSize(new Dimension(75, 23));
		card2.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		panel_3.add(card2);

		JComboBox<String> card3 = new JComboBox<String>();
		card3.setModel(cards[2]);
		card3.setSelectedIndex(2);
		card3.setToolTipText("");
		card3.setPreferredSize(new Dimension(75, 23));
		card3.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		panel_3.add(card3);

		JComboBox<String> card4 = new JComboBox<String>();
		card4.setModel(cards[3]);
		card4.setSelectedIndex(3);
		card4.setToolTipText("");
		card4.setPreferredSize(new Dimension(75, 23));
		card4.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		panel_3.add(card4);

		JComboBox<String> card5 = new JComboBox<String>();
		card5.setModel(cards[4]);
		card5.setSelectedIndex(4);
		card5.setToolTipText("");
		card5.setPreferredSize(new Dimension(75, 23));
		card5.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		panel_3.add(card5);

		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(10, 30));
		panel.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new BorderLayout(0, 0));

		JLabel text1 = new JLabel("\u60A8\u6301\u6709\u7684\u724C\u70BA:");
		text1.setBorder(new EmptyBorder(0, 25, 0, 0));
		text1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		panel_5.add(text1, BorderLayout.WEST);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 0, 0, 14));
		panel_1.setPreferredSize(new Dimension(10, 30));
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		JButton cal_btn = new JButton("\u8A08\u7B97");

		
		
		cal_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		cal_btn.setPreferredSize(new Dimension(75, 23));
		panel_1.add(cal_btn, BorderLayout.EAST);

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 80));
		panel_2.setMaximumSize(new Dimension(32767, 150));
		panel_2.setMinimumSize(new Dimension(10, 150));
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(0, 20, 0, 0));
		panel_2.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel expresult_text = new JLabel("\u671F\u671B\u500D\u7387\u70BA:");
		expresult_text.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		panel_4.add(expresult_text);

		JLabel exp = new JLabel("\u986F\u793A\u7D50\u679C");
		exp.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		panel_4.add(exp);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(0, 20, 0, 0));
		panel_2.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel cresult_text = new JLabel("\u6700\u4F73\u7D50\u679C\u70BA:");
		cresult_text.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		panel_6.add(cresult_text);

		JLabel c = new JLabel("\u986F\u793A\u7D50\u679C");
		c.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		panel_6.add(c);
		
		cal_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deck[0]=card1.getSelectedIndex()+1;
				deck[1]=card2.getSelectedIndex()+1;
				deck[2]=card3.getSelectedIndex()+1;
				deck[3]=card4.getSelectedIndex()+1;
				deck[4]=card5.getSelectedIndex()+1;
				Cal cal = new Cal();
				cal.main(deck);
				exp.setText(String.format("%.4f",Cal.maxEx));
				c.setText(Cal.showResult);
			}
		});
		

	}
}
