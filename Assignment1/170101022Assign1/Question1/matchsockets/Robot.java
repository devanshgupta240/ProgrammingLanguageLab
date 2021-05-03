package matchsockets;

//Robot is used to pick up a sock from the buffer and pass it to the matching machine.
 
class Robot extends Thread {
    private Matcher matcher; 
    private MatchSockets matchSockets; 


    Robot(MatchSockets matchSockets, Matcher matcher, int name) {
        super();
        setName(String.valueOf(name));
        this.matchSockets = matchSockets;
        this.matcher = matcher;
    }

    @Override
    public void run() {
        while (true) {
 
            String pickedSocket = matchSockets.PickSock();	           // Pick socket
            if (pickedSocket.equals(InputData.NULL_SOCK)) {   		// Socket List empty
                // Stopping thread
                System.out.println("Thread" + getName() + " Stopped!");
                stop();
            }
            System.out.println(String.format("Socket Color %s recieved by Thread%s",pickedSocket, getName()));
            matcher.MatchSock(pickedSocket);
        }
    }
}
