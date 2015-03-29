import com.leapmotion.leap.*;


public class LeapEventListener extends Listener{

	public void onFrame (Controller controller){
        System.out.println("New Frame");
    }

    public void onInit (Controller controller){
        System.out.println("Initialized");
    }

    public void onConnect (Controller controller){
        System.out.println("Connected");
    }

    public void onDisconnect (Controller controller){
        System.out.println("Disconnected");
    }

    public void onFocusGained (Controller controller){
        System.out.println("Focus gained");
    }

    public void  onFocusLost (Controller controller){
        System.out.println("Focus lost");        
    }
	
}