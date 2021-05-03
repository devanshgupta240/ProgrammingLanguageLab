package matchsockets;

class Matcher {
    private ManageShelf manageShelf;
    private Boolean whiteSock;
    private Boolean blackSock;
    private Boolean blueSock;
    private Boolean greySock;

    Matcher(ManageShelf manageShelf) {
        whiteSock = false;
        blackSock = false;
        blueSock = false;
        greySock = false;
        this.manageShelf = manageShelf;
    }


    void MatchSock(String sock) {
        if (sock.equals(InputData.WHITE_SOCK)) 
	{ 
            synchronized (whiteSock) {
                if (whiteSock) //one socket
		{  
                    manageShelf.ManageSockPair(InputData.WHITE_SOCK);
                    whiteSock = false;
                } 
		else 
		{ 
                    whiteSock = true;
                }
            }
        } 
	else if (sock.equals(InputData.BLACK_SOCK)) 
	{
            synchronized (blackSock) {
                if (blackSock) 
		{
                    manageShelf.ManageSockPair(InputData.BLACK_SOCK);
                    blackSock = false;
                } 
		else 
		{ 
                    blackSock = true;
                }
            }
        } 
	else if (sock.equals(InputData.BLUE_SOCK)) 
	{ 
            synchronized (blueSock) {
                if (blueSock) 
		{
                    manageShelf.ManageSockPair(InputData.BLUE_SOCK);
                    blueSock = false;
                } 
		else 
		{
                    blueSock = true;
                }
            }
        } 
	else if (sock.equals(InputData.GREY_SOCK)) {
            synchronized (greySock) {
                if (greySock) 
		{
                    manageShelf.ManageSockPair(InputData.GREY_SOCK);
                    greySock = false;
                } 
		else 
		{
                    greySock = true;
                }
            }
        }
    }
}
