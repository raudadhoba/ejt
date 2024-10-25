package myPackage;

import jakarta.ejb.Local;

@Local
public interface RoomBeanLocal {
    public int checkin(int no); 
    public int checkout(int no);
}
