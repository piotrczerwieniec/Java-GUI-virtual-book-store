import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VirtualGui implements ActionListener {

    JButton button = new JButton("next");
	JButton Button4 = new JButton("done");
	JButton Button5 = new JButton("done");
	JLabel Label1;
	JLabel Label2;
	JLabel Label3;
	JLabel label4;
	JLabel Label5;
	JLabel label6;
	JFrame f;
	JFrame f2;
	JFrame f3;
	JFrame f4;
	JFrame f5;
	JTextField text1;
	JList list;
	JPanel panel = new JPanel(null);
	String Genre;
	String price;
	JComboBox c2;
public VirtualGui() {
    f = new JFrame("Greeting");
    f.setLayout (new BorderLayout(3,3));
    f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    Label1 = new JLabel ("Welcome to the virtual book store");
    Label2 = new JLabel ("Please hit the next button");
    button = new JButton ("done");
    f.add(Label1,BorderLayout.NORTH);
    f.add(Label2,BorderLayout.CENTER);
    f.add(button,BorderLayout.PAGE_END);
    f.setSize(480,200);
    f.setVisible(true);
    button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            
            f.dispose();
            GenreFrame(); //this method when called the second frame appear
        }
        });






}
 
void GenreFrame() {
			       f2 = new JFrame("Genre");
		           f2.setDefaultCloseOperation(f2.EXIT_ON_CLOSE);
		           f2.add(panel);
		           f2.setSize(480,200);
				   //f2.setPreferredSize(new Dimension(480,200));
		           f2.setVisible(true);
		           Label3 = new JLabel("Please select your prefferred genre and press done");
		           Label3.setBounds(0, 0, 480, 20);
		           panel.add(Label3);
		           DefaultListModel<String> i1 = new DefaultListModel<>(); 
		           JList<String> list = new JList<>(i1); 
		           i1.addElement("Drama");
				   i1.addElement("Crime");  
		           i1.addElement("Kids");
		           list.setBounds(0, 25, 50, 70);
		           panel.add(list);
		           panel.add(Button4); 
		           Button4.setBounds(50, 25, 70, 70);
		           Button4.addActionListener( new ActionListener()
				    {
				        @Override
				        public void actionPerformed(ActionEvent arg0)
				        {
				        	f2.dispose();
                            Genre = (String)list.getSelectedValue();
				        	PriceFrame(Genre);
				        	
				        }
				    });
		         
	    	   
	       }
   void PriceFrame (String Genre) {
		f3 = new JFrame("price");
		f3.setDefaultCloseOperation(f3.EXIT_ON_CLOSE);
		f3.setLayout(new FlowLayout());
		label4 = new JLabel("Please select your suitable price range");
		String price [] = { "High", "Low" };
		JComboBox cl = new JComboBox<>(price);
		Button5 = new JButton ("done");
		f3.add(label4);
		f3.add(cl);
		f3.add(Button5);
		f3.setSize(480, 200);
		f3.setVisible(true);
		Button5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String price = (String)cl.getSelectedItem() ;
				f3.dispose();
				ChooseBook(price, Genre);



			}


		});





   }
   
   void ChooseBook(String price, String Genre) {

		f4 = new JFrame("choice");
		f4.setDefaultCloseOperation(f4.EXIT_ON_CLOSE);
		f4.setLayout(new FlowLayout());
		f4.setVisible(true);
		f4.setSize(480,200);
		Label5 = new JLabel("Please select your book");
		if(Genre.equals("Crime") && price.equals("High") ) {
			String s1[] = { "Crime1_High", "Crime2_High", "Crime3_High"};
			 c2 = new JComboBox(s1);
		}else if(Genre.equals("Crime") && price.equals("low") ) {
			String s1[] = { "Crime1_Low", "Crime2_Low", "Crime3_Low"};
			c2 = new JComboBox(s1);
	   }
		else if(Genre.equals("Drama")&& price.equals("High")) {
			String s1[] = { "Drama1_High", "Drama2_High", "Drama3_High"};
			 c2 = new JComboBox(s1);
		}else if(Genre.equals("Drama")&& price.equals("low")) {
			String s1[] = { "Drama1_Low", "Drama2_Low", "Drama3_Low"};
			c2 = new JComboBox(s1);
	   }
	else if(Genre.equals("Kids")&& price.equals("High")) {
		String s1[] = { "Kids1_High", "Kids2_High", "Kids3_High"};
		 c2 = new JComboBox(s1);
	}else if(Genre.equals("Kids")&& price.equals("low")) {
		String s1[] = { "Kids1_Low", "Kids2_Low", "Kids3_Low"};
		 c2 = new JComboBox(s1);
	}
	
		JButton Button6 = new JButton("done");
		f4.add(Label5);
		f4.add(c2);
		f4.add(Button6);
		Button6.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String choice = (String)c2.getSelectedItem();
				f4.dispose();
				Choosen(choice);


			}
		});
	
	}

	void Choosen(String choice){
		f5 = new JFrame("Bill");
		f5.setDefaultCloseOperation(f5.EXIT_ON_CLOSE);
		f5.setLayout(new FlowLayout());
		label6 = new JLabel();
		if(choice.equals("Crime1_high")) {
			label6 = new JLabel("Your bill is 7 dollars");
		}else if(choice.equals("Crime2_High")) {
			label6 = new JLabel("Your bill is 7.5 dollars");

		}else if(choice.equals("Crime3_High")) {
			label6.setText("Your bill is 7 dollars ");
		}else if(choice.equals("Crime1_Low")) {
			label6.setText("Your bill is 3 dollars ");
		}else if(choice.equals("Crime2_Low")) {
			label6.setText("Your bill is 3 dollars ");
		}else if(choice.equals("Crime3_Low")) {
			label6.setText("Your bill is 3 dollars ");
		}else if(choice.equals("Drama1_High")) {
			 label6 = new JLabel("Your bill is 9 dollars ");
		}
		else if(choice.equals("Drama2_High")) {
			label6.setText("Your bill is 9 dollars ");
		}else if(choice.equals("Drama3_High")) {
			label6.setText("Your bill is 9 dollars ");
		}else if(choice.equals("Drama1_Low")) {
			label6.setText("Your bill is 5 dollars ");
		}else if(choice.equals("Drama2_Low")) {
			label6.setText("Your bill is 5 dollars ");
		}else if(choice.equals("Drama3_Low")) {
			label6.setText("Your bill is 5 dollars ");
		}else if(choice.equals("Kids1_High")) {
			 label6 = new JLabel("Your bill is 11 dollars ");
		}
		else if(choice.equals("Kids2_High")) {
			label6.setText("Your bill is 11 dollars ");
		}else if(choice.equals("Kids3_High")) {
			label6.setText("Your bill is 11 dollars ");
		}else if(choice.equals("Kids1_Low")) {
			label6.setText("Your bill is 8 dollars ");
		}else if(choice.equals("Kids2_Low")) {
			label6.setText("Your bill is 8 dollars ");
		}else if(choice.equals("Kids3_Low")) {
			label6.setText("Your bill is 8 dollars ");
		}
		f5.add(label6);
		f5.setVisible(true);
		f5.setSize(480,200);


	}
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        VirtualGui b = new VirtualGui ();
    }

    

    @Override
    public void actionPerformed (ActionEvent arg0) {
        // TODO Auto-generated method stub


}
}

