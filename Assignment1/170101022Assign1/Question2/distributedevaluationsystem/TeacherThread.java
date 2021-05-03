package distributedevaluationsystem;

import java.util.ArrayList;

// Teacher(Threads)
public class TeacherThread extends Thread {
    private DistributedEvaluationSystem distributedEvaluationSystem;  // The main parent running class
    private ArrayList<ArrayList<String>> InputBuffer;
    private boolean IsSynchronizeExec;    			//isSynchronize 

    TeacherThread(DistributedEvaluationSystem distributedEvaluationSystem, String Name, int priority) {
        this.distributedEvaluationSystem = distributedEvaluationSystem;
        setName(Name);
        setPriority(priority);
        InputBuffer = new ArrayList<>();
        IsSynchronizeExec = false;
    }

    @Override
    public void run() {
        while (InputBuffer.size() > 0) 
	{
            if (IsSynchronizeExec) {
                distributedEvaluationSystem.ExecuteWithSynchronisation(InputBuffer.get(0).get(0), Integer.parseInt(InputBuffer.get(0).get(1)), getName());
            } 
	    else {
                distributedEvaluationSystem.ExecuteWithoutSynchronisation(InputBuffer.get(0).get(0), Integer.parseInt(InputBuffer.get(0).get(1)), getName());
            }
            InputBuffer.remove(0);
        }
    }

    void extractInput( String update_Marks, String roll_Number) {
        ArrayList<String> new_Record = new ArrayList<>();
        new_Record.add(roll_Number);
        new_Record.add(update_Marks);
        InputBuffer.add(new_Record);
    }

    void setSynchronize(boolean isSynchronizeExec) {
        IsSynchronizeExec = isSynchronizeExec;
    }
}
