package Guifunctionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import Entity.Sales;
import Entity.UserEntity;
import Entity.VehicleEntity;
import Entity.WishlistEntity;

public class UViewVehicleProfile {
	Configuration con = new Configuration().configure().addAnnotatedClass(UserEntity.class).addAnnotatedClass(VehicleEntity.class).addAnnotatedClass(WishlistEntity.class).addAnnotatedClass(Sales.class);
    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); 
    SessionFactory sf = con.buildSessionFactory(reg);
	
    Frame frame;
    public void Framex(VehicleEntity ve, UserEntity U) {
		frame = new Frame();
		
		viewvehicleinfo(frame, ve, U);
			
//			frame.setLayout(null);
//			frame.setVisible(true);

			
			frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					frame.dispose();
				}
			});
	}
    public void viewvehicleinfo(final Frame frame, VehicleEntity ve, final UserEntity U1) {

        Image image = null;
        try {
            File sourceimage = new File(ve.getImageUrl());
            image = ImageIO.read(sourceimage).getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        } catch (Exception e) {
            System.out.println("Error on loading image");
            try {
                image = ImageIO.read(new File("C://Users//jigny//OneDrive//Desktop//imgp2.png/")).getScaledInstance(500, 400, Image.SCALE_DEFAULT);
            }
            catch(Exception e1) {
            	System.out.println(e1);
            }
        }

        final JFrame f = new JFrame("Vehicle Image");
        f.setLayout(new BorderLayout());

        JLabel label = new JLabel(new ImageIcon(image));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        label.setBorder(border);
        label.setHorizontalAlignment(JLabel.CENTER);
        f.add(label, BorderLayout.CENTER);

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel()); // add a dummy label to take up space
        f.add(topPanel, BorderLayout.NORTH);

//        JLabel descheading = new JLabel("description");
//        descheading.setFont(new Font("Myriad Pro",Font.PLAIN,15));

        JLabel tlabel = new JLabel("description_cont");
        tlabel.setFont(new Font("Myriad Pro",Font.PLAIN,15));
        tlabel.setText("<html>"+ve.dispString().replace("\n", "<br>")+"</html>");

        JPanel descPanel = new JPanel(new BorderLayout());
//        descPanel.add(descheading, BorderLayout.NORTH);
        descPanel.add(tlabel, BorderLayout.CENTER);
        f.add(descPanel, BorderLayout.SOUTH);

        JButton jb = new JButton("back");
        f.add(jb, BorderLayout.EAST);

        f.pack();
        
        jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				f.dispose();
				Uvehicleview av = new Uvehicleview();
				av.Frame3(U1);
				
			}
		});
        
        f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        f.setLocationRelativeTo(null); // center the frame on the screen
        f.setVisible(true);

    }

    
    public void disp(VehicleEntity ve) {
    	Framex(ve, new UserEntity());
    }
    
    public static void main(String[] args) {
		VehicleEntity ve = new VehicleEntity();
		ve.setBrand("Mahindra");
		ve.setDescription("THIS IS A DESCRIPTION\nTHIS IS A DESCRIPTION\nTHIS IS A DESCRIPTION\n");
		ve.setImageUrl("C://Users//jigny//OneDrive//Desktop//car1.jpeg//");
		ve.setModel("Scorpio");
		ve.setVehiclePrice(19191919);
		ve.setVehicleStock(23);
		System.out.println(ve.dispString());
		AViewVehicleProfile vp = new AViewVehicleProfile();
		vp.disp(ve);
//		new disp(ve);
	}
}
