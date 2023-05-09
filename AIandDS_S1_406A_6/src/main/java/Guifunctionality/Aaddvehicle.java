package Guifunctionality;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

public class Aaddvehicle {

	Configuration con = new Configuration().configure().addAnnotatedClass(UserEntity.class).addAnnotatedClass(VehicleEntity.class).addAnnotatedClass(WishlistEntity.class).addAnnotatedClass(Sales.class);
    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); 
    SessionFactory sf = con.buildSessionFactory(reg);
	
    Frame frame;
    public void Frame10() {
		frame = new Frame();
		
		addvehicle(frame);
			
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
	
	//add vehicle
//		public void addvehicle(final Frame frame) {
//			
//			final Session session = sf.openSession();
//	        final Transaction transaction = session.beginTransaction();
//			VehicleEntity V = new VehicleEntity();
//			
//			Label display=new Label("Add Vehicle Details ");
//			display.setBounds(100, 40, 200, 30);
//			Label vbrand=new Label(" Vehicle Brand :");
//			vbrand.setBounds(20,80,100,30);
//			final TextField brand=new TextField();
//			brand.setBounds(150,80,200,30);
//			Label vmodel=new Label(" Vehicle Model :");
//			vmodel.setBounds(20,120,100,30);
//			final TextField model=new TextField();
//			model.setBounds(150,120,200,30);
//			Label vprice=new Label(" Vehicle Price :");
//			vprice.setBounds(20,160,100,30);
//			final TextField price=new TextField();
//			price.setBounds(150,160,200,30);
//			Label vstock=new Label(" No. of Vehicles :");
//			vstock.setBounds(20,200,100,30);
//			final TextField stock=new TextField();
//			stock.setBounds(150,200,200,30);
//			Button submit=new Button("Submit");
//			submit.setBounds(150,250,100,30);
//			final Button back = new Button("Back");
//			back.setBounds(300, 250, 100, 30);
//			
//			//Button function
//			submit.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					VehicleEntity V=new VehicleEntity();
//					
//					V.setBrand(brand.getText());
//					V.setModel(model.getText());
//					V.setVehiclePrice(Double.parseDouble(price.getText()));
//					V.setVehicleStock(Integer.parseInt(stock.getText()));
//					
//					session.save(V);
//					transaction.commit();
//					//added successfully
//					new dialog("Added Successfully");
//					
//				}
//
//			});	
//			back.addActionListener(new ActionListener() {
//
//				public void actionPerformed(ActionEvent e) {
//					frame.dispose();
//					AdminProfile ap=new AdminProfile();
//					ap.Frame5();
//				}
//			});
//			
//			frame.add(display);
//			frame.add(vbrand);
//			frame.add(brand);
//			frame.add(vmodel);
//			frame.add(model);
//			frame.add(vprice);
//			frame.add(price);
//			frame.add(vstock);
//			frame.add(stock);
//			frame.add(submit);
//			frame.add(back);
//			frame.setSize(800,600);
//			
//		}
    
  //add vehicle
    public void addvehicle(final Frame frame) {

        final Session session = sf.openSession();
        final Transaction transaction = session.beginTransaction();
        final VehicleEntity V = new VehicleEntity();

        Label display = new Label("Add Vehicle Details ");
        display.setBounds(100, 40, 200, 30);
        Label vbrand = new Label(" Vehicle Brand :");
        vbrand.setBounds(20,80,100,30);
        Label vmodel = new Label(" Vehicle Model :");
        vmodel.setBounds(20,120,100,30);
        Label vprice = new Label(" Vehicle Price :");
        vprice.setBounds(20,160,100,30);
        Label vstock = new Label(" No. of Vehicles :");
        vstock.setBounds(20,200,100,30);        
        Label vimage = new Label(" Vehicle Image :");
        vimage.setBounds(20,240,100,30);
        Label desc = new Label(" Description :");
        desc.setBounds(20,280,100,30);
        
        
        
        final TextField brand = new TextField();
        brand.setBounds(150,80,200,30);

        final TextField model = new TextField();
        model.setBounds(150,120,200,30);

        final TextField price = new TextField();
        price.setBounds(150,160,200,30);

        final TextField stock = new TextField();
        stock.setBounds(150,200,200,30);

        final TextField image = new TextField();
        image.setBounds(150,240,200,30);
        
        final Button chooseImage = new Button("Choose Image");
        chooseImage.setBounds(360,240,100,30);
        
        final TextField description = new TextField();
        description.setBounds(150,280,200,30);
        
        
        Button submit = new Button("Submit");
        submit.setBounds(150,330,100,30);
        final Button back = new Button("Back");
        back.setBounds(300, 330, 100, 30);

        //Button function
        chooseImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileDialog fd = new FileDialog(frame, "Choose Image", FileDialog.LOAD);
                fd.setVisible(true);
                if (fd.getFile() != null) {
                    String filename = fd.getDirectory() + fd.getFile();
                    image.setText(filename);
                }
            }
        });

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                V.setBrand(brand.getText());
                V.setModel(model.getText());
                V.setVehiclePrice(Double.parseDouble(price.getText()));
                V.setVehicleStock(Integer.parseInt(stock.getText()));
                System.out.println("------------------------------------- "+image.getText());
                V.setImageUrl(image.getText());
                V.setDescription(description.getText());
                System.out.println("---------------------------------- "+description.getText());
                session.save(V);
                transaction.commit();
                //added successfully
                new dialog("Added Successfully");

            }

        });
        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                AdminProfile ap = new AdminProfile();
                ap.Frame5();
            }
        });

        frame.add(display);
        frame.add(vbrand);
        frame.add(brand);
        frame.add(vmodel);
        frame.add(model);
        frame.add(vprice);
        frame.add(price);
        frame.add(vstock);
        frame.add(stock);
        frame.add(vimage);
        frame.add(image);
        frame.add(chooseImage);
        frame.add(desc);
        frame.add(description);
        frame.add(submit);
        frame.add(back);
        frame.setSize(800,600);

    }
    
    public static void main(String[] args) {
		Aaddvehicle adv = new Aaddvehicle();
		adv.Frame10();
	}
		
}
