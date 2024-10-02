package uni.repository;

import uni.db.DBOperator;
import uni.entity.Course;
import uni.entity.Define;
import uni.entity.Teacher;
import uni.utility.RestResult;
import uni.utility.StaticConstants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    DBOperator dbOperator=null;
    Course course;
    ArrayList<Course> courseList;

    public ArrayList<Course> selectCourse(Course course, DBOperator dbOperator) {
        if (course != null){
            this.course = course;
            if (dbOperator != null)
               this.dbOperator = dbOperator;
            return selectCourseList();
        }
        else return null;
    }



    public ArrayList<Course> selectCourseList() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        List<Object> parmsList= new ArrayList<Object>();
        ResultSet rs = null;
        Course courseClass;
        DBOperator dbOperator=null;

        if(this.dbOperator==null)
            dbOperator= new DBOperator();
        else {
            dbOperator=this.dbOperator;
        }


        String sqlString="SELECT ID,Name,Description,Quota,Teacher,Department,"
                + "Faculty,Term,Credit,Coursestatus,Situation"
                + " FROM course T"
                + " WHERE 1=1 " +
                ""+((course.getId()<=0 )? "" : " AND T.ID = ? " )+""+
                ""+((course.getName()==null || course.getName()=="" )? "" : " AND T.Name = ? " )+""+
                ""+((course.getDescription()==null || course.getDescription()=="" )? "" : " AND T.Description = ? " )+""+
                ""+((course.getQuota()==null|| course.getQuota()=="")? "" : " AND T.Quota = ? " )+""+
                ""+((course.getTerm()==null||course.getTerm().getId()<=0 )? "" : " AND T.Term = ? " )+""+
                ""+((course.getCredit()==null||course.getCredit().getId()<=0 )? "" : " AND T.Credit = ? " )+""+
                ""+((course.getTeacher()==null||course.getTeacher().getId()<=0 )? "" : " AND T.Teacher = ? " )+""+
                ""+((course.getCourseStatus()==null||course.getCourseStatus().getId()<=0 )? "" : " AND T.Coursestatus = ? " )+""+
                ""+((course.getFaculty()==null||course.getFaculty().getId()<=0 )? "" : " AND T.Faculty = ? " )+"" +
                ""+((course.getDepartment()==null||course.getDepartment().getId()<=0 )? "" : " AND T.Department = ? " )+"" +
                ""+((course.getSituation()<=-1 )? "" : " AND T.Situation = ? " )+"";




        if(course.getId()>0)
            parmsList.add(course.getId());
        if(course.getName()!= null && course.getName()!="")
            parmsList.add(course.getName());
        if(course.getDescription()!= null && course.getDescription()!="")
            parmsList.add(course.getDescription());
        if(course.getQuota()!=null&&course.getQuota()!="")
            parmsList.add(course.getQuota());
        if(course.getTerm()!= null &&course.getTerm().getId()>0)
            parmsList.add(course.getTerm());
        if(course.getCredit()!= null &&course.getCredit().getId()>0)
            parmsList.add(course.getCredit().getId());
        if(course.getCourseStatus()!= null &&course.getCourseStatus().getId()>0)
            parmsList.add(course.getCourseStatus().getId());
        if(course.getFaculty()!= null &&course.getFaculty().getId()>0)
            parmsList.add(course.getFaculty().getId());
        if(course.getDepartment()!= null &&course.getDepartment().getId()>0)
            parmsList.add(course.getDepartment().getId());
        if(course.getSituation()!=-1)
            parmsList.add(course.getSituation());

        rs=dbOperator.selectStatement(sqlString, parmsList);

        try {
            while(rs.next()) {
                DefineRepository defineRepository = new DefineRepository();
                TeacherRepository teacherRepository = new TeacherRepository();
                Define defines = new Define();
                Teacher teacher = new Teacher();

                courseClass = new Course();
                courseClass.setId(rs.getInt("ID"));
                courseClass.setName(rs.getString("Name"));
                courseClass.setDescription(rs.getString("Description"));
                courseClass.setQuota(rs.getString("Quota"));
                courseClass.setSituation(rs.getInt("Situation"));

                defines.setId(rs.getInt("Term"));
                defines = defineRepository.selectDefine(defines, dbOperator).get(0);
                courseClass.setTerm(defines);

                defines= new Define();
                defines.setId(rs.getInt("Credit"));
                defines = defineRepository.selectDefine(defines, dbOperator).get(0);
                courseClass.setCredit(defines);

                teacher.setId(rs.getInt("Teacher"));
                teacher = teacherRepository.selectTeacher(teacher, dbOperator).get(0);
                courseClass.setTeacher(teacher);

                defines=new Define();
                defines.setId(rs.getInt("Faculty"));
                defines = defineRepository.selectDefine(defines, dbOperator).get(0);
                courseClass.setFaculty(defines);

                defines=new Define();
                defines.setId(rs.getInt("Department"));
                defines = defineRepository.selectDefine(defines, dbOperator).get(0);
                courseClass.setDepartment(defines);

                defines=new Define();
                defines.setId(rs.getInt("Coursestatus"));
                defines = defineRepository.selectDefine(defines, dbOperator).get(0);
                courseClass.setCourseStatus(defines);

                courseList.add(courseClass);
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
        return courseList;
    }

    public RestResult insertCourse(Course course, DBOperator dbOperatorIn) {
        RestResult restResult= new RestResult();
        int result=0;
        DBOperator dbOperator=null;
        String sqlString="";
        List<Object> parmsList = new ArrayList<Object>();
        if(dbOperatorIn==null)
            dbOperator=new DBOperator();
        else {
            dbOperator=dbOperatorIn;
        }

        sqlString="INSERT INTO course  (Name,Description,Quota,Teacher,Department,Faculty,Term,Credit,Coursestatus,Situation)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?)";

        parmsList.add(course.getName());
        parmsList.add(course.getDescription());
        parmsList.add(course.getQuota());
        parmsList.add(course.getTeacher().getId());
        parmsList.add(course.getDepartment().getId());
        parmsList.add(course.getFaculty().getId());
        parmsList.add(course.getTerm().getId());
        parmsList.add(course.getCredit().getId());
        parmsList.add(course.getCourseStatus().getId());
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

    public RestResult deleteCourse(Course course,DBOperator dbOperatorIn) {
        RestResult restResult=new RestResult();
        boolean bool=false;
        int result=0;
        DBOperator dbOperator=null;
        String sqlString="";
        List<Object> parmsList = new ArrayList<Object>();
        if(dbOperatorIn==null)
            dbOperator=new DBOperator();
        else {
            dbOperator=dbOperatorIn;
        }

        sqlString="UPDATE course SET Situation=? where ID=?";

        parmsList.add(StaticConstants.STATUS_PASSİVE);
        parmsList.add(course.getId());

        result=dbOperator.executeAndUpdate(sqlString, parmsList);

        if(result==0) {
            dbOperator.rollback();
            restResult.setMessage(StaticConstants.PROCESS_ERROR_MESSAGE);
            restResult.setCode(StaticConstants.PROCESS_ERROR);
        }
        else {
            bool=true;
            dbOperator.commit();
            restResult.setMessage(StaticConstants.PROCESS_OKAY_MESSAGE);
            restResult.setCode(StaticConstants.PROCESS_OKAY);
        }
        dbOperator.closePreparedStatement();
        dbOperator.closeConnection();
        return restResult;


    }


    public RestResult updateCourse(Course course,DBOperator dbOperatorIn) {
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

        sqlString="UPDATE course SET Name=? ,  Description=? , Quota=?,"
                + " Teacher=?, Department=?, Faculty=?, Term=?,"
                + " Credit=?, Coursestatus=? "
                + "where ID=?";



        parmsList.add(course.getName());
        parmsList.add(course.getDescription());
        parmsList.add(course.getQuota());
        parmsList.add(course.getTeacher().getId());
        parmsList.add(course.getDepartment().getId());
        parmsList.add(course.getFaculty().getId());
        parmsList.add(course.getTerm().getId());
        parmsList.add(course.getCredit().getId());
        parmsList.add(course.getCourseStatus().getId());
        parmsList.add(course.getId());

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
