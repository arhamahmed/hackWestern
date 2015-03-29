import java.io.IOException;
import java.util.Scanner;

import com.leapmotion.leap.*;

public class main {
	
	//static Controller controller = new Controller();
    //static LeapEventListener listener = new LeapEventListener();
	public static void main(String[] args) {
        
		LeapEventListener listener = new LeapEventListener();
        Controller controller = new Controller();

        // Have the sample listener receive events from the controller
        controller.addListener(listener);

        // Keep this process running until Enter is pressed
        System.out.println("Press Enter to quit...");
        int loop = 1;
        float[] s1 = {-8,4,(float) -1003.3,100,(float) -1007.5,100,100,(float) -1007.5,100,100,(float) -1007.5,100,100,(float) -1007.5,100};
        float[] s2 = {-4, (float) 8.5, 100,3, (float) 8.5, 100, 3,-9, 100,3,-9,100,0,(float) -9.5,100};
        float[] s3 = {5, 8, -5, 100,(float) 1008.5,100,100,(float) 1008.5,100,100,2007,100,100,2007,100};
        float[] s4 = {-2002,-5,100,-2004,-5,100,-2004,-5,100,100,100,100,100,-5,100};
        float[] s5 = {-8, 100, 100, (float) -8.8, 100, 100, (float) -7.5, 100, 100, -9, 100, 100, (float) -9.5, 100, 100};
        float[] s6 = {(float) -2.3, 9, 100, 0, 9, 100, 100, 6, 100, 100, -9, 100, 100, -9, 100};
        float[] s7 = {-5, 6, 100, 100, 6, 100, 0, (float) 5.5, 100, 0, -6, (float)-7.5, 0, -6, (float) -7.5};
        float[] s8 = {(float) 1007.5, 100, 100, (float) 1007.5, 100, 100, (float) 1007.5, 100, 100, (float) 1007.5, 100, 100, (float) 1007.5, 100, 100,};
        float[] s9 = {100, 100, 100, 100, (float) 2006.5, 100, 100, (float) 2006.5, 100, 100, (float) 2006.5, 100, 100, (float) 2006.5, 100};
        float[] s10 = {100, (float) 2008.5, 100, (float) 2006.5, 100, 100, (float) 2006.5, 100, 100, (float) 2006.5, 100, 100, (float) 2006.5, 100, 100};
        float[] s12 = {4, 8, 100, 6, 4, 100, 6, 0, -7, (float) -9.5, 100, 100, (float) -8.5, 100, 100};
        float[] s15 = {(float) 8.5, 100, 100, 7, 100, -5, (float) -9.5, 100, 2, (float) -9.5, 100, 2, (float) -9.5, 100, 2};
        float[] s16 = {0, (float) 9.9, 0, 100, -5, 7, 100, -5, 7, 100, -3, (float) 6.5, 100, -2, (float) 6.5};
        float[] s17 = {(float) -7.8, 5, 100, -2, (float) 9.6, 100, 0, (float) 9.8, 100, 2, (float) 9.3, 100, (float) 7.8, (float) 4.8, 100};
        float[] s18 = {8, 100, -3, 8, 2, (float) -4.5, 6, 0, 100, (float) -9.5, 0, 0, -9, 100, 0};
        float[] s19 = {(float) -3.6, (float) -4.2, (float) -8.3, -2, (float) -5.6, -8, -1, -5, -8, 0, -5, -8, 6, -4, -7};
        int count = 0;
        boolean again = true;
        while(again){
        while (loop == 1)
        {
            Frame frame = controller.frame();
            HandList hands = frame.hands();
            PointableList pointables = frame.pointables();
            FingerList fingers = frame.fingers();
            ToolList tools = frame.tools();
            delay();
            /*
              System.out.println(pointables.get(0).direction().toString() + " - "
            			     + pointables.get(1).direction().toString() + " - " +
            			       pointables.get(2).direction().toString() + " - " +
            			       pointables.get(3).direction().toString() + " - " +
            			       pointables.get(4).direction().toString());
            */
            
            //> 2000 then LT
            //b/w 1000^2000 then GT
            //b/w -1000^-2000 then LT
            //LT -20000 then GT
            
            int j = 0;
            float[] userHandDirections = new float[15];
            for (int i = 0; i < 5; i++)
            {
        		userHandDirections[j] = pointables.get(i).direction().getX();
        		userHandDirections[j+1] = pointables.get(i).direction().getY();
        		userHandDirections[j+2] = pointables.get(i).direction().getZ();
        		j += 3;
            }
            
            float[] sums = new float[16];
            
            sums[0] = help(userHandDirections, s1);
            sums[1] = help(userHandDirections, s2);
            sums[2] = help(userHandDirections, s3);
            sums[3] = help(userHandDirections, s4);
            sums[4] = help(userHandDirections, s5);
            sums[5] = help(userHandDirections, s6);
            sums[6] = help(userHandDirections, s7);
            sums[7] = help(userHandDirections, s8);
            sums[8] = help(userHandDirections, s9);
            sums[9] = help(userHandDirections, s10);
            sums[10] = help(userHandDirections, s12);
            sums[11] = help(userHandDirections, s15);
            sums[12] = help(userHandDirections, s16);
            sums[13] = help(userHandDirections, s17);
            sums[14] = help(userHandDirections, s18);
            sums[15] = help(userHandDirections, s19);
            
            int min = getMinArray(sums);
            ///*
            System.out.println("start: " + sums[0]);
            System.out.println(sums[1]);
            System.out.println(sums[2]);
            System.out.println(sums[3]);
            System.out.println(sums[4]);
            System.out.println(sums[5]);
            System.out.println(sums[6]);
            System.out.println(sums[7]);
            System.out.println(sums[8]);
            System.out.println(sums[9]);
            System.out.println(sums[10]);
            System.out.println(sums[11]);
            System.out.println(sums[12]);
            System.out.println(sums[13]);
            System.out.println(sums[14]);
            System.out.println(sums[15]);
            System.out.println("THE HAND SIGN MATCHES PATTERN " + min);
            count++;
            if(count==5){
            	count=0;
            	loop=0;
            	controller.removeListener(listener);
            }
            
            //*/
        }
        char cont = 'x';
        while (cont != 'y' && cont != 'n')
        {
        	Scanner sc = new Scanner(System.in);
        	System.out.println("continue?");
        	cont = sc.next().charAt(0);
        }
        if (cont == 'y')
        {
        	controller.addListener(listener);
        	loop = 1;
        }
        		
        }
        // Remove the sample listener when done
        controller.removeListener(listener);
	}
	
	private static void delay()
	{
		 long start = System.currentTimeMillis();
	     try {
	         Thread.sleep(1000);
	     } catch (InterruptedException e) {
	         System.out.println(""+e);
	     }
	     while(System.currentTimeMillis() - start < 1000L){}
	     System.out.println("hi");
	     
	}
	
	public static double min(int x, double y){
		if(x<y)
			return y;
		else
			return (double)x;
	}
	
	//returns min index
	public static int getMinArray(float[] x)
	{
		float min = 100000000;
		int index = 0;
		if (x != null)
			min = 100000000;
		for (int i = 0; i < x.length; i++)
		{
			if (x[i] < min)
			{
				min = x[i];
				index = i;
			}
		}
		return index+1;
	}
	
	public static float help(float[] sign,float[] arr){
		double sum = 0;
		int l;
		for(int i=0;i<15;i++){
			if(arr[i]==100)
				l =0;
			else if(arr[i]<1000&&arr[i]>-1000){
				sum+= Math.pow((sign[i]*10-arr[i]),2);
			}
			else if(arr[i]>2000){
				arr[i]-=2000;
				if((sign[i]*10)<=arr[i])
					sum+=min(4,Math.pow((sign[i]*10-arr[i]),2));
				else
					sum+= Math.pow((sign[i]*10-arr[i]),2);
			}
			else if(arr[i]>1000){
				arr[i]-=1000;
				if((sign[i]*10)>=arr[i])
					sum+=min(4,Math.pow((sign[i]*10-arr[i]),2));
				else
					sum+= Math.pow((sign[i]*10-arr[i]),2);
			}
			else if(arr[i]<-2000){
				arr[i]+=2000;
				if((sign[i]*10)>=arr[i])
					sum+=min(4,Math.pow((sign[i]*10-arr[i]),2));
				else
					sum+= Math.pow((sign[i]*10-arr[i]),2);
			}
			else{
				arr[i]+=1000;
				if((sign[i]*10)<=arr[i])
					sum+=min(4,Math.pow((sign[i]*10-arr[i]),2));
				else
					sum+= Math.pow((sign[i]*10-arr[i]),2);
			}
		}
		return (float) sum;
	}
}


