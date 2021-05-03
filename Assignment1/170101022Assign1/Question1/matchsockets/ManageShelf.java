package matchsockets;

//recieves a sock pair and puts it in the right shelf
class ManageShelf {

    private Integer countGreySocks;
    private Integer countWhiteSocks;
    private Integer countBlueSocks;
    private Integer countBlackSocks;

    ManageShelf(){
        countGreySocks = 0;
        countWhiteSocks = 0;
        countBlueSocks = 0;
        countBlackSocks = 0;
    }

    void ManageSockPair(String socket) {
	if (socket.equals(InputData.GREY_SOCK)) 
	{
            synchronized (countGreySocks) {
                countGreySocks += 2;  
            }
        }
        else if (socket.equals(InputData.WHITE_SOCK))
	{
            synchronized (countWhiteSocks) {
                countWhiteSocks += 2;    
            }
        }
	else if (socket.equals(InputData.BLUE_SOCK)) 
	{
            synchronized (countBlueSocks) {
                countBlueSocks += 2;    
            }
        } 
	else if (socket.equals(InputData.BLACK_SOCK)) 
	{
            synchronized (countBlackSocks) {
                countBlackSocks += 2;    
            }
        } 
    }

    void ShowShelf() {
	System.out.println("Final Shelf Status: -");
        System.out.println(String.format("No. of White: %d\tNo. of black: %d\tNo. of blue: %d\tNo. of grey: %d", countWhiteSocks, countBlackSocks, countBlueSocks, countGreySocks));
    }
}
