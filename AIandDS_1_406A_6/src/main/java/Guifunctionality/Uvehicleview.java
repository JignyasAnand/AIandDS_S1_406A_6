package Guifunctionality;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Entity.Sales;
import Entity.UserEntity;
import Entity.VehicleEntity;
import Entity.WishlistEntity;

public class Uvehicleview {

	Configuration con = new Configuration().configure().addAnnotatedClass(UserEntity.class).addAnnotatedClass(VehicleEntity.class).addAnnotatedClass(WishlistEntity.class).addAnnotatedClass(Sales.class);
    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); 
    SessionFactory sf = con.buildSessionFactory(reg);
    
    Frame frame;
    public void Frame3(UserEntity U) {
		frame = new Frame();
		
		vehicleview(U,frame);
			
			frame.setLayout(null);
			frame.setVisible(true);

			
			frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					frame.dispose();
				}
			});
	}
    
    
 
  		public void vehicleview(final UserEntity U, final Frame frame) {
  			Session session = sf.openSession();
  		    Transaction transaction = session.beginTransaction();
  			
  			
  	        
  			Query q = session.createQuery("from VehicleEntity");
  			List<VehicleEntity> V=q.list();
  			Label display=new Label("List of Vehicles: ");
  			display.setBounds(100, 40, 200, 30);
  			int x=120;
  			Label id=new Label("V Id");
  			Label brand=new Label("Brand");
  			Label model=new Label("Model ");
  			Label price=new Label("Price");
  			Label wishlist=new Label("Enter VId to add vehicle to Wishlist");
  			final TextField t=new TextField();
  			id.setBounds(20,80,100,30);
  			brand.setBounds(130,80,100,30);
  			model.setBounds(240,80,100,30);
  			price.setBounds(350,80,100,30);
  			
  			
  			
  			
  			for(final VehicleEntity ve:V) {
  				if(ve.getVehicleStock()>0) {
  				Label vid=new Label(""+ve.getVehicleId());
  				Label vbrand=new Label(ve.getBrand());
  				Label vmodel=new Label(ve.getModel());
  				Label vprice=new Label(""+ve.getVehiclePrice());
				Button bt = new Button("View");
  				vid.setBounds(20,x,100,30);
  				vbrand.setBounds(130,x,100,30);
  				vmodel.setBounds(240,x,100,30);
  				vprice.setBounds(350,x,100,30);	
				bt.setBounds(460, x, 100, 30);
  			x+=60;
  			frame.add(vid);
  			frame.add(vbrand);
  			frame.add(vmodel);
  			frame.add(vprice);
  			frame.add(bt);
  			
			bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					UViewVehicleProfile vhp = new UViewVehicleProfile();
					vhp.Framex(ve, U);
				}
			});
  				}
  				
  			}
  			wishlist.setBounds(30,x+80,250,30);
  			t.setBounds(300,x+80,50,30);
  			Button submit=new Button("Submit");
  			submit.setBounds(360,x+80,100,30);
  			final Button back = new Button("Back");
  			back.setBounds(360, x+140, 100, 30);
  			
  			
  			frame.add(display);
  			frame.add(id);
  			frame.add(brand);
  			frame.add(model);
  			frame.add(price);
  			frame.add(wishlist);
  			frame.add(t);
  			frame.add(submit);
  			frame.add(back);
  			frame.setSize(800,x+400);
  			
  			
  			//Button function
  			submit.addActionListener(new ActionListener() {
  				public void actionPerformed(ActionEvent e) {
  					int vd=Integer.parseInt(t.getText());
  					Wishlistf wl=new Wishlistf();
  					wl.wishlist(U, vd);
  					new dialog("Added Successfully");
  				}
  			});
  			back.addActionListener(new ActionListener() {

  				public void actionPerformed(ActionEvent e) {
  					UserProfile up=new UserProfile();
					frame.dispose();
					up.Frame2(U);
  				}
  			});
  		}
}
