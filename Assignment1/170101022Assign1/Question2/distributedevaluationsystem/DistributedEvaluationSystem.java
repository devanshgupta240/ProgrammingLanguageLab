package distributedevaluationsystem;

import java.io.*;
import java.util.*;

public class DistributedEvaluationSystem {
    private Map<String, ArrayList<String>> StudMap; //Roll no. -> [name, email, marks, last_updated_by]
    private ArrayList<ArrayList<String>> InputBuffer; // Teachers name, roll num, update marks by    
    private final static Scanner scanner = new Scanner(System.in);  // For reading input

    private DistributedEvaluationSystem() {
        StudMap = new HashMap<>();
        InputBuffer = new ArrayList<>();
    }

    private void AddingToInputBuffer() {
        String teacherThread = GetTeacherName();	//changed by
        String roll_Number = GetRollNumber();		//roll number
        String marks_Update = MarksToBeUpdated();		//marks changed
        ArrayList<String> new_Record = new ArrayList<>();        // Adding to InputBuffer
        new_Record.add(teacherThread);
        new_Record.add(roll_Number);
        new_Record.add(marks_Update);
        InputBuffer.add(new_Record);
    }

    private String MarksToBeUpdated() {
        System.out.println("Choose:" + "   '0' for Decreasing marks    OR" + "   '1' for Increasing marks");

        int choice = scanner.nextInt();

	if (choice == 0) 
	{   
            System.out.println("Enter Marks to be Decreased:");
            int marks = scanner.nextInt();
            return String.valueOf(-marks);
        }
        else if (choice == 1) 
	{
            System.out.println("Enter Marks to be Increased:");
            int marks = scanner.nextInt();
            return String.valueOf(marks);
        } 
	else 
	{
            System.out.println("Choose from '1' or '0' only.");
            return MarksToBeUpdated();
        }
    }

    private String GetRollNumber() {
        System.out.println("Enter Roll Number of the Student:");
        return scanner.next();
    }

    private String GetTeacherName() {
        System.out.println("Enter teacher's name:- ");
        String teacherThread = scanner.next();
        if (teacherThread.equals("CC") || teacherThread.equals("TA1") || teacherThread.equals("TA2")) 
	{
            return teacherThread;
        } 
	else 
	{
            System.out.println("Teacher can be 'CC' or 'TA1' or 'TA2'.");
            return GetTeacherName();
        }
    }

   
    private void UpdateMarks() {
        // ask if updating the files synchronously or asynchronously for hte previous inputs.
        System.out.println("Choose:" + "   '0' for Without Synchronization  OR" + "   '1' for Synchronization\n");
        int option = scanner.nextInt();

        // Create the threads for updating the marks of the students
        TeacherThread courseCoordinator = new TeacherThread(this, InputData.CC, Thread.MAX_PRIORITY);
        TeacherThread teachingAssistant1 = new TeacherThread(this, InputData.TA1, Thread.NORM_PRIORITY);
        TeacherThread teachingAssistant2 = new TeacherThread(this, InputData.TA2, Thread.NORM_PRIORITY);

	//synchronizedExec
	if (option == 1) 
	{  
	    courseCoordinator.setSynchronize(true);
            teachingAssistant1.setSynchronize(true);
            teachingAssistant2.setSynchronize(true);   
        } 
	//WithoutSynchronizedExec
        else if (option == 0) 
	{
            teachingAssistant1.setSynchronize(false);
            teachingAssistant2.setSynchronize(false);
            courseCoordinator.setSynchronize(false);
        }
	else 
	{
            System.out.println("Choose from '1' or '0' only.");
            return;
        }

        for (ArrayList<String> entry : InputBuffer) 
	{
            String teacherThread = entry.get(0);
            String roll_Number = entry.get(1);
            String update_Marks = entry.get(2);
	    if(InputData.CC.equals(teacherThread)) 
	    {
                courseCoordinator.extractInput(update_Marks,roll_Number);
            }
            else if(InputData.TA1.equals(teacherThread))
	    {
                teachingAssistant1.extractInput(update_Marks,roll_Number);
            } 
	    else if(InputData.TA2.equals(teacherThread)) 
	    {
                teachingAssistant2.extractInput(update_Marks,roll_Number);
            } 
	    
        }

        InputBuffer.clear();

        courseCoordinator.start();
        teachingAssistant1.start();
        teachingAssistant2.start();

        try {
            courseCoordinator.join();
            teachingAssistant1.join();
            teachingAssistant2.join();
        } 
	catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateFinal();
    }


    void ExecuteWithSynchronisation(String roll_Number, int newMarksUpdate, String editor) {
        if (StudMap.get(roll_Number) != null) 
	{
            synchronized (StudMap.get(roll_Number)) {
                updateData(StudMap.get(roll_Number), newMarksUpdate, editor);
            }
        }
    }

    void ExecuteWithoutSynchronisation(String roll_Number, int newMarksUpdate, String editor) {
        if (StudMap.get(roll_Number) != null) 
	{
            updateData(StudMap.get(roll_Number), newMarksUpdate, editor);
        }
    }

    private void updateData(ArrayList<String> data, int newMarksUpdate, String editor) {
        if (data.get(3).equals(InputData.CC) && !editor.equals(InputData.CC)) 
	{
            return;
        }
        int prevMarks = Integer.parseInt(data.get(2).trim());
        prevMarks = prevMarks + newMarksUpdate;
        data.set(2, String.valueOf(prevMarks));
        data.set(3, editor);
    }

    //Read the initial data of the files and store in the memory
    private void inputDataRead() throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(InputData.STUD_INFO));
        String line;
        while ((line = buffRead.readLine()) != null) 
	{
            String[] segmenteData = line.split(",");
            ArrayList<String> new_Record = new ArrayList<>();
            new_Record.add(segmenteData[1]);
            new_Record.add(segmenteData[2]);
            new_Record.add(segmenteData[3]);
            new_Record.add(segmenteData[4]);
            StudMap.put(segmenteData[0], new_Record);
        }
    }

    private void updateFinal() {
        BufferedWriter writer = null, writer1 = null;
        try 
	{
            writer = new BufferedWriter(new FileWriter(InputData.STUD_INFO));
        } 
	catch (IOException e) 
	{
            e.printStackTrace();
        }
        assert writer != null;
        for (Map.Entry<String, ArrayList<String>> entry : StudMap.entrySet()) 
	{
            try {
                writer.append(entry.getKey());
                for (String value : entry.getValue()) 
		{
                    writer.append(',');
                    writer.append(value);
                }
                writer.append('\n');
            } 
	    catch (IOException e) {
                e.printStackTrace();
            }
        }
        try 
	{
            writer.flush();
            writer.close();
        } 
	catch (IOException e) 
	{
            e.printStackTrace();
        }
        try 
	{
            writer = new BufferedWriter(new FileWriter(InputData.SORTED_ROLL));
            writer1 = new BufferedWriter(new FileWriter(InputData.SORTED_NAME));
        } 
	catch (IOException e) 
	{
            e.printStackTrace();
        }
        ArrayList<String> sortedKeys = new ArrayList<>(StudMap.keySet());
        Collections.sort(sortedKeys);
        for (String key : sortedKeys) 
	{
            try {
                writer.append(key);
                writer1.append(key);
                for (String value : StudMap.get(key)) 
		{
                    writer.append(',');
                    writer1.append(',');
                    writer.append(value);
                    writer1.append(value);
                }
                writer.append('\n');
                writer1.append('\n');
            } 
	    catch (IOException e) {
                e.printStackTrace();
            }
        }
        try 
	{
            writer.flush();
            writer1.flush();
            writer.close();
            writer1.close();
        } 
	catch (IOException e) 
	{
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        DistributedEvaluationSystem distributedEvaluationSystem = new DistributedEvaluationSystem();

        distributedEvaluationSystem.inputDataRead();

        while (true) {
            int choice;
            System.out.println("Choose:\n" + "  '0' for updating student marks\n" + "  '1' for Choosing ExecuteType\n" + "  '2' for Quiting System.");
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    distributedEvaluationSystem.AddingToInputBuffer();
                    break;
                case 1:
                    distributedEvaluationSystem.UpdateMarks();
                    break;
		case 2:
                    return;
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        }
    }
}

