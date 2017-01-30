package teach_planning.teacher;

import java.io.PrintWriter;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PrintChoiceImpl implements PrintChoiceInterface {

	@Override
	public void printPreferences(PrintWriter pw, Teacher teacher) {
		teacher.printPreferences(pw);
	}
	
}
