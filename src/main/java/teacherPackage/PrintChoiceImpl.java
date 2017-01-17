package teacherPackage;

import java.io.PrintWriter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;

import teachingPackage.Teaching;

@ApplicationScoped
public class PrintChoiceImpl implements PrintChoiceInterface
	{

	public void printPreferences(PrintWriter pw, Teacher teacher/*, Teaching teaching*/) {
		teacher.printPreferences(pw);
		
	}

}
