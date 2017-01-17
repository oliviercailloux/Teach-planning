package teacherPackage;

import java.io.PrintWriter;
import java.util.HashMap;

import teachingPackage.Teaching;

public interface TeacherInterface {
	
	public void addMatiere(Teaching m);
	public void printPreferences (PrintWriter pw);
	public HashMap<String, Teaching> getPreferences();
	public void addPreference(String choix, Teaching preference);
}