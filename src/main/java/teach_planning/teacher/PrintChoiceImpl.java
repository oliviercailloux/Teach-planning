package teach_planning.teacher;

import java.io.PrintWriter;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PrintChoiceImpl implements PrintChoiceInterface
	{

	public void printPreferences(PrintWriter pw, Teacher teacher/*, Teaching teaching*/) {
		teacher.printPreferences(pw);
		
	}

}
