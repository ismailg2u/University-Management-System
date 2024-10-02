package uni.repository;

import uni.db.DBOperator;
import uni.entity.Course;
import uni.entity.CourseSelection;
import uni.entity.Student;
import uni.utility.RestResult;
import uni.utility.StaticConstants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseSelectionRepository {

    private DBOperator dbOperator = null;
    private CourseSelection courseSelection;
    private ArrayList<CourseSelection> courseSelectionList;

    public ArrayList<CourseSelection> selectCourseSelection(CourseSelection courseSelection,DBOperator dbOperator) {
        if(courseSelection!=null) {
            this.courseSelection=courseSelection;
            if(dbOperator!=null)
                this.dbOperator=dbOperator;
            return selectCourseSelectionList();
        }
        else return null;

    }

    public ArrayList<CourseSelection> selectCourseSelectionList() {
        ArrayList<CourseSelection> courseSelectionList = new ArrayList<CourseSelection>();
        List<Object> parmsList= new ArrayList<Object>();
        ResultSet rs = null;
        CourseSelection courseSelectionClass ;
        DBOperator dbOperator=null;

        if(this.dbOperator==null)
            dbOperator= new DBOperator();
        else {
            dbOperator=this.dbOperator;
        }


        String sqlString="SELECT ID,StudentID,CourseID,Situation"
                + " FROM courseselection T  "
                + " WHERE 1=1 " +
                ""+((courseSelection.getId()<=0 )? "" : " AND T.ID = ? " )+""+
                ""+((courseSelection.getStudentID().getId()<=0 )? "" : " AND T.StudentID = ? " )+""+
                ""+((courseSelection.getCourseID().getId()<=0 )? "" : " AND T.CourseID = ? " )+""+
                ""+((courseSelection.getSituation()<=-1 )? "" : " AND T.Situation = ? " )+"";

        if(courseSelection.getId()>0)
            parmsList.add(courseSelection.getId());
        if(courseSelection.getStudentID().getId()>0)
            parmsList.add(courseSelection.getStudentID().getId());
        if(courseSelection.getCourseID().getId()>0)
            parmsList.add(courseSelection.getCourseID().getId());
        if(courseSelection.getSituation()!=-1) ;
        parmsList.add(courseSelection.getSituation());

        rs=dbOperator.selectStatement(sqlString, parmsList);

        try {
            while(rs.next()) {

                courseSelectionClass = new CourseSelection();
                courseSelectionClass.setId(rs.getInt("ID"));
                courseSelectionClass.setSituation(rs.getInt("Situation"));

                Student student = new Student();
                student.setId(rs.getInt("StudentID"));
                StudentRepository studentRepository= new StudentRepository();
                student=studentRepository.selectStudent(student,dbOperator).get(0);
                courseSelectionClass.setStudentID(student);

                Course course = new Course();
                course.setId(rs.getInt("CourseID"));
                CourseRepository courseRepository= new CourseRepository();
                course=courseRepository.selectCourse(course,dbOperator).get(0);
                courseSelectionClass.setCourseID(course);

                courseSelectionList.add(courseSelectionClass);
            }

            rs.close();
            dbOperator.closePreparedStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(this.dbOperator==null)
                dbOperator.closeConnection();
        }
        return courseSelectionList;
    }


    public RestResult insertCourseSelection(CourseSelection courseSelection, DBOperator dbOperatorIn) {

        RestResult restResult = new RestResult();
        int result=0;
        DBOperator dbOperator=null;
        String sqlString="";
        List<Object> parmsList = new ArrayList<Object>();
        if(dbOperatorIn==null)
            dbOperator=new DBOperator();
        else {
            dbOperator=dbOperatorIn;
        }

        sqlString="INSERT INTO courseselection  (StudentID,CourseID,Situation)"
                + " VALUES(?,?,?)";

        parmsList.add(courseSelection.getStudentID().getId());
        parmsList.add(courseSelection.getCourseID().getId());
        parmsList.add(StaticConstants.STATUS_ACTİVE);




        result=dbOperator.executeAndUpdate(sqlString, parmsList);

        if(result==0) {
            dbOperator.rollback();
            restResult.setMessage(StaticConstants.PROCESS_ERROR_MESSAGE);
            restResult.setCode(StaticConstants.PROCESS_ERROR);
        }
        else {
            dbOperator.commit();
            restResult.setMessage(StaticConstants.PROCESS_OKAY_MESSAGE);
            restResult.setCode(StaticConstants.PROCESS_OKAY);
        }
        dbOperator.closeConnection();
        return restResult;

    }

    public RestResult deleteCourseSelection(CourseSelection courseSelection,DBOperator dbOperatorIn) {

        RestResult restResult = new RestResult();
        int result=0;
        DBOperator dbOperator=null;
        String sqlString="";
        List<Object> parmsList = new ArrayList<Object>();
        if(dbOperatorIn==null)
            dbOperator=new DBOperator();
        else {
            dbOperator=dbOperatorIn;
        }

        sqlString="UPDATE courseselection SET Situation=? where ID=?";

        parmsList.add(StaticConstants.STATUS_PASSİVE);
        parmsList.add(courseSelection.getId());

        result=dbOperator.executeAndUpdate(sqlString, parmsList);

        if(result==0) {
            dbOperator.rollback();
            restResult.setMessage(StaticConstants.PROCESS_ERROR_MESSAGE);
            restResult.setCode(StaticConstants.PROCESS_ERROR);
        }
        else {
            dbOperator.commit();
            restResult.setMessage(StaticConstants.PROCESS_OKAY_MESSAGE);
            restResult.setCode(StaticConstants.PROCESS_OKAY);
        }
        dbOperator.closePreparedStatement();
        dbOperator.closeConnection();
        return restResult;


    }

    public RestResult updateCourseSelection(CourseSelection courseSelection,DBOperator dbOperatorIn) {

        RestResult restResult = new RestResult();
        int result=0;
        DBOperator dbOperator=null;
        String sqlString="";
        List<Object> parmsList = new ArrayList<Object>();
        if(dbOperatorIn==null)
            dbOperator=new DBOperator();
        else {
            dbOperator=dbOperatorIn;
        }

        sqlString="UPDATE courseselection SET StudentID=? ,  CourseID=? "
                + "where ID=?";



        parmsList.add(courseSelection.getStudentID().getId());
        parmsList.add(courseSelection.getCourseID().getId());
        parmsList.add(courseSelection.getId());

        result=dbOperator.executeAndUpdate(sqlString, parmsList);

        if(result==0) {
            dbOperator.rollback();
            restResult.setMessage(StaticConstants.PROCESS_ERROR_MESSAGE);
            restResult.setCode(StaticConstants.PROCESS_ERROR);
        }
        else {
            dbOperator.commit();
            restResult.setMessage(StaticConstants.PROCESS_OKAY_MESSAGE);
            restResult.setCode(StaticConstants.PROCESS_OKAY);
        }
        dbOperator.closePreparedStatement();
        dbOperator.closeConnection();
        return restResult;

    }





}
