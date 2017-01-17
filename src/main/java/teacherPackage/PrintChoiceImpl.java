package teacherPackage;

import java.io.PrintWriter;

import javax.enterprise.context.RequestScoped;

import teachingPackage.Teaching;

@RequestScoped
public class PrintChoiceImpl implements PrintChoiceInterface
	{

	public void printPreferences(PrintWriter pw, Teacher teacher/*, Teaching teaching*/) {
		teacher.printPreferences(pw);
		
	}

}
