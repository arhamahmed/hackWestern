import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

import com.leapmotion.leap.*;

public class Main {
	static Controller controller = new Controller();
    static LeapEventListener listener = new LeapEventListener();
	public static void main(String[] args) {

        controller.addListener(listener);

        int loop = 1;
        //Calibrate signs
        File file = new File("machineLearning.txt");
        float[] s1 = {-8,4,(float) 3.3,100,(float) 7.5,100,100,(float) 7.5,100,100,(float) 7.5,100,100,(float) 7.5,100};
        float[] s2 = {-4, (float) 8.5, 100,3, (float) 8.5, 100, 3,-9, 100,3,-9,100,0,(float) -9.5,100};
        float[] s3 = {5, 8, -5, 100,(float) 8.5,100,100,(float) 8.5,100,100,7,100,100,7,100};
        float[] s4 = {-2,-5,100,-4,-5,100,-4,-5,100,100,100,100,100,-5,100};
        float[] s5 = {-8, 100, 100, (float) -8.8, 100, 100, (float) -7.5, 100, 100, -9, 100, 100, (float) -9.5, 100, 100};
        float[] s6 = {(float) -2.3, 9, 100, 0, 9, 100, 100, 6, 100, 100, -9, 100, 100, -9, 100};
        float[] s7 = {-5, 6, 100, 100, 6, 100, 0, (float) 5.5, 100, 0, -6, (float)-7.5, 0, -6, (float) -7.5};
        float[] s8 = {(float) 7.5, 100, 100, (float) 7.5, 100, 100, (float) 7.5, 100, 100, (float) 7.5, 100, 100, (float) 7.5, 100, 100,};
        float[] s9 = {100, 100, 100, 100, (float) 6.5, 100, 100, (float) 6.5, 100, 100, (float) 6.5, 100, 100, (float) 6.5, 100};
        float[] s10 = {100, (float) 8.5, 100, (float) 6.5, 100, 100, (float) 6.5, 100, 100, (float) 6.5, 100, 100, (float) 6.5, 100, 100};
        float[] s12 = {4, 8, 100, 6, 4, 100, 6, 0, -7, (float) -9.5, 100, 100, (float) -8.5, 100, 100};
        float[] s15 = {(float) 8.5, 100, 100, 7, 100, -5, (float) -9.5, 100, 2, (float) -9.5, 100, 2, (float) -9.5, 100, 2};
        float[] s16 = {0, (float) 9.9, 0, 100, -5, 7, 100, -5, 7, 100, -3, (float) 6.5, 100, -2, (float) 6.5};
        float[] s17 = {(float) -7.8, 5, 100, -2, (float) 9.6, 100, 0, (float) 9.8, 100, 2, (float) 9.3, 100, (float) 7.8, (float) 4.8, 100};
        float[] s18 = {8, 100, -3, 8, 2, (float) -4.5, 6, 0, 100, (float) -9.5, 0, 0, -9, 100, 0};
        float[] s19 = {(float) -3.6, (float) -4.2, (float) -8.3, -2, (float) -5.6, -8, -1, -5, -8, 0, -5, -8, 6, -4, -7};
        
        //Open machineLearned data
        String strPls= "";
            try {
            	BufferedReader br = new BufferedReader(new FileReader("machinelearning.txt"));
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append("\n");
                    line = br.readLine();
                }
                br.close();
                strPls= sb.toString();
            String[] elems = strPls.split(" ");
            s1 = new float[15];
            for(int i=0;i<15;i++)
            	s1[i]=Float.parseFloat(elems[i]);
            s2 = new float[15];
            for(int i=15;i<30;i++)
            	s2[i-15]=Float.parseFloat(elems[i]);
            s3 = new float[15];
            for(int i=30;i<45;i++)
            	s3[i-30]=Float.parseFloat(elems[i]);
            s4 = new float[15];
            for(int i=45;i<60;i++)
            	s4[i-45]=Float.parseFloat(elems[i]);
            s5 = new float[15];
            for(int i=60;i<75;i++)
            	s5[i-60]=Float.parseFloat(elems[i]);
            s6 = new float[15];
            for(int i=75;i<90;i++)
            	s6[i-75]=Float.parseFloat(elems[i]);
            s7 = new float[15];
            for(int i=90;i<105;i++)
            	s7[i-90]=Float.parseFloat(elems[i]);
            s8 = new float[15];
            for(int i=105;i<120;i++)
            	s8[i-105]=Float.parseFloat(elems[i]);
            s9 = new float[15];
            for(int i=120;i<135;i++)
            	s9[i-120]=Float.parseFloat(elems[i]);
            s10 = new float[15];
            for(int i=135;i<150;i++)
            	s10[i-135]=Float.parseFloat(elems[i]);
            s12 = new float[15];
            for(int i=150;i<165;i++)
            	s12[i-150]=Float.parseFloat(elems[i]);
            s15 = new float[15];
            for(int i=165;i<180;i++)
            	s15[i-165]=Float.parseFloat(elems[i]);
            s16 = new float[15];
            for(int i=180;i<195;i++)
            	s16[i-180]=Float.parseFloat(elems[i]);
            s17 = new float[15];
            for(int i=195;i<210;i++)
            	s17[i-195]=Float.parseFloat(elems[i]);
            s18 = new float[15];
            for(int i=210;i<225;i++)
            	s18[i-210]=Float.parseFloat(elems[i]);
            s19 = new float[15];
            for(int i=225;i<240;i++)
            	s19[i-225]=Float.parseFloat(elems[i]);
        }
        catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
        int count = 0;
        boolean again = true;
        
        
        //Get input from LeapMotion
        while(again){
        	while (loop == 1){
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
	            
	            int j = 0;
	            
	            //Assign vectors into matrix
	            float[] userHandDirections = new float[15];
	            for (int i = 0; i < 5; i++)
	            {
	        		userHandDirections[j] = pointables.get(i).direction().getX();
	        		userHandDirections[j+1] = pointables.get(i).direction().getY();
	        		userHandDirections[j+2] = pointables.get(i).direction().getZ();
	        		j += 3;
	            }
	            
	            //Match signs
	            float[] sums = new float[16];
	            
	            sums[0] = leastSquares(userHandDirections, s1);
	            sums[1] = leastSquares(userHandDirections, s2);
	            sums[2] = leastSquares(userHandDirections, s3);
	            sums[3] = leastSquares(userHandDirections, s4);
	            sums[4] = leastSquares(userHandDirections, s5);
	            sums[5] = leastSquares(userHandDirections, s6);
	            sums[6] = leastSquares(userHandDirections, s7);
	            sums[7] = leastSquares(userHandDirections, s8);
	            sums[8] = leastSquares(userHandDirections, s9);
	            sums[9] = leastSquares(userHandDirections, s10);
	            sums[10] = leastSquares(userHandDirections, s12);
	            sums[11] = leastSquares(userHandDirections, s15);
	            sums[12] = leastSquares(userHandDirections, s16);
	            sums[13] = leastSquares(userHandDirections, s17);
	            sums[14] = leastSquares(userHandDirections, s18);
	            sums[15] = leastSquares(userHandDirections, s19);
	            
	            int min = getMinArray(sums);
	            
	            //Adjust the calibration to matched sign in machine learning
	            if(min==0)
	            	adjust(userHandDirections, s1);
	            else if(min==1)
	            	adjust(userHandDirections, s2);
	            else if(min==2)
	            	adjust(userHandDirections, s3);
	            else if(min==3)
	            	adjust(userHandDirections, s4);
	            else if(min==4)
	            	adjust(userHandDirections, s5);
	            else if(min==5)
	            	adjust(userHandDirections, s6);
	            else if(min==6)
	            	adjust(userHandDirections, s7);
	            else if(min==7)
	            	adjust(userHandDirections, s8);
	            else if(min==8)
	            	adjust(userHandDirections, s9);
	            else if(min==9)
	            	adjust(userHandDirections, s10);
	            else if(min==11)
	            	adjust(userHandDirections, s12);
	            else if(min==12)
	            	adjust(userHandDirections, s15);
	            else if(min==13)
	            	adjust(userHandDirections, s16);
	            else if(min==14)
	            	adjust(userHandDirections, s17);
	            else if(min==15)
	            	adjust(userHandDirections, s18);
	            else
	            	adjust(userHandDirections, s19);
	            
	            Writer writer = null;
	            try {
	                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("machineLearning.txt"), "utf-8"));
	                String str ="";
	                for(int i=0;i<15;i++)
	                	str+= s1[i] + " ";
	                for(int i=0;i<15;i++)
	                	str+= s2[i] + " ";
	                for(int i=0;i<15;i++)
	                	str+= s3[i] + " ";
	                for(int i=0;i<15;i++)
	                	str+= s4[i] + " ";
	                for(int i=0;i<15;i++)
	                	str+= s5[i] + " ";
	                for(int i=0;i<15;i++)
	                	str+= s6[i] + " ";
	                for(int i=0;i<15;i++)
	                	str+= s7[i] + " ";
	                for(int i=0;i<15;i++)
	                	str+= s8[i] + " ";
	                for(int i=0;i<15;i++)
	                	str+= s9[i] + " ";
	                for(int i=0;i<15;i++)
	                	str+= s10[i] + " ";
	                for(int i=0;i<15;i++)
	                	str+= s12[i] + " ";
	                for(int i=0;i<15;i++)
	                	str+= s15[i] + " ";
	                for(int i=0;i<15;i++)
	                	str+= s16[i] + " ";
	                for(int i=0;i<15;i++)
	                	str+= s17[i] + " ";
	                for(int i=0;i<15;i++)
	                	str+= s18[i] + " ";
	                for(int i=0;i<15;i++)
	                	str+= s19[i] + " ";
	                writer.write(str);
	            } catch (IOException ex) {
	              // report
	            } finally {
	               try {writer.close();} catch (Exception ex) {}
	            }
	            
	            count++;
	            if(count==5){
	            	count=0;
	            	loop=0;
	            	controller.removeListener(listener);
	            }
        	}
        char cont = 'x';
        while (cont != 'y' && cont != 'n') {
        	Scanner sc = new Scanner(System.in);
        	System.out.println("continue?");
        	cont = sc.next().charAt(0);
        }
        if (cont == 'y'){
        	controller.addListener(listener);
        	loop = 1;
        }
        else{
        	loop =0;
        	again=false;
            controller.removeListener(listener);
        }
	}
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
	}
	
	public static double min(int x, double y){
		if(x<y)
			return y;
		else
			return (double)x;
	}
	
	//returns index of the min
	public static int getMinArray(float[] x)
	{
		float min = 200;
		int index = 0;
		if (x != null)
			min = 200;
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
	
	public static float leastSquares(float[] sign,float[] arr){
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
	
	//adjustment factor for custom calibration
	public static void adjust(float[] user, float[] baseVector){
		for(int i=0;i<15;i++){
			if(baseVector[i]!=100)
				baseVector[i]=(baseVector[i]*100+user[i]*2)/102;
		}
	}
}