package io.github.oliviercailloux.teach_planning.teacher.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Table;
import org.odftoolkit.simple.text.list.List;

import io.github.oliviercailloux.teach_planning.model.Teacher;
import io.github.oliviercailloux.teach_planning.model.Teaching;
import io.github.oliviercailloux.teach_planning.service.PreferenceService;
import io.github.oliviercailloux.teach_planning.service.TeacherService;
import io.github.oliviercailloux.teach_planning.service.TeachingService;

@ManagedBean
@RequestScoped
public class AgregPrefDoc {
	@Inject
	private PreferenceService prefS;
	@Inject
	private TeacherService tS;
	
	public String savePreferenceFile() {

		java.util.List<Teacher> teachers = tS.getAll();
		TextDocument outputOdt;
        try {
        	String home = System.getProperty("user.home");
            outputOdt = TextDocument.newTextDocument();

            Table table = outputOdt.addTable(teachers.size()+1, 2);
            Cell titleTeacher = table.getCellByPosition(0, 0);
            titleTeacher.setStringValue("Enseignant");
            Cell titleChoice = table.getCellByPosition(1, 0);
            titleChoice.setStringValue("Preference");
            int i = 1;
            
            for (Teacher teacher : teachers){
            	 java.util.List<Object[]> prefTeacher1 = prefS.getAllTeachingsOfTeacher(teacher.getId());
            	 java.util.List<String> prefTeacher2 = new ArrayList<>();
                 for(Object[] pref : prefTeacher1){
                	 prefTeacher2.add(pref[0] +" - Choix "+pref[1]);
                 }
                 String[] prefTeacher = new String[prefTeacher2.size()];
                 prefTeacher2.toArray(prefTeacher);
                 
                 Cell cell = table.getCellByPosition(0, i);
                 cell.setStringValue(teacher.getFirstname()+ " "+ teacher.getLastname());

                 Cell cell1 = table.getCellByPosition(1, i);
                 List list = cell1.addList();
                 list.addItems(prefTeacher);
                 i++;
            }
           
            outputOdt.save(home+"/Downloads/AgregPreferences.odt");
        } catch (Exception e) {
    		return "fileDownloadFailure.xhtml?faces-redirect=true";
        }
		return "fileDownloadSuccess.xhtml?faces-redirect=true";
	}
}
