package matchsockets;

import java.util.concurrent.Semaphore;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MatchSockets {
    private ManageShelf manageShelf;  		// Manages Shelf
    private List<Semaphore> SemLocks;   	// Semaphore locks for the sockets
    private Random rand = new Random(); 	// random generator
    private int CountArms; 			// robot arms
    private final List<String> Sockets;  	// Sockets
    private Matcher matcher;    		// Socket matcher
    private List<Robot> Robots; 		// Threads
    
    private void startMachine() throws InterruptedException {
        for (Robot robot : Robots) 
	{
            robot.start();
        }

        for (Robot robot : Robots) 
	{
            robot.join();
        }

        manageShelf.ShowShelf();
    }

    private void createSockLocks() {
        SemLocks = new ArrayList<>();
        for (int i = 0; i < Sockets.size(); i++) 
	{
            Semaphore SemLock = new Semaphore(1);
            SemLocks.add(SemLock);
        }
    }

    private void createRobotArms() {
        Robots = new ArrayList<>();
        for (int i = 0; i < CountArms; i++) 
	{
            Robot robot = new Robot(this, this.matcher, i);
            Robots.add(robot);
        }
    }

    private MatchSockets(int countArms, List<String> sockets) {
        CountArms = countArms;
        Sockets = sockets;
	
        manageShelf = new ManageShelf();
	matcher = new Matcher(manageShelf);
        createRobotArms();
        createSockLocks();
    }

    String PickSock() {
        String sock;
        int n = -1;
        boolean flag = false;
        synchronized (Sockets) 
	{
            if (Sockets.size() > 0) {
                n = rand.nextInt(Sockets.size());
            } 
	    else {
                flag = true;
            }
        }
        if (flag) 
	{
            return InputData.NULL_SOCK;
        }
        boolean success = SemLocks.get(n).tryAcquire();
        if (success && n < Sockets.size()) 
	{
            synchronized (Sockets) {
                sock = Sockets.get(n);
                Sockets.remove(n);
            }
            SemLocks.get(n).release();
            return sock;
        } 
	else 
	{
            return PickSock();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // File input
        File file = new File(InputData.INPUT_FILE);
        Scanner scanner = new Scanner(file);
        int number_of_robots = scanner.nextInt();
        List<String> sockets = new ArrayList<>();
        while (scanner.hasNextLine()) 
	{
            sockets.add(scanner.nextLine());
        }
        MatchSockets matchSockets = new MatchSockets(number_of_robots, sockets);
        matchSockets.startMachine();
    }


}
