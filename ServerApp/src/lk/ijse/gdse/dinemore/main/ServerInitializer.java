package lk.ijse.gdse.dinemore.main;

import lk.ijse.gdse.dinemore.service.custom.impl.AdminServiceImpl;
import lk.ijse.gdse.dinemore.service.custom.impl.ChefServiceImpl;
import lk.ijse.gdse.dinemore.service.custom.impl.DeliverBoyServiceImpl;
import lk.ijse.gdse.dinemore.service.custom.impl.ReceptionServiceImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerInitializer {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(5050);
            registry.bind("reception",new ReceptionServiceImpl());
            registry.bind("admin",new AdminServiceImpl());
            registry.bind("chef",new ChefServiceImpl());
            registry.bind("deliverBoy",new DeliverBoyServiceImpl());
            System.out.println("rmi registry ok");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
