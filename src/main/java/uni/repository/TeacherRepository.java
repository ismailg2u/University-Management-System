package uni.repository;

import uni.db.DBOperator;
import uni.entity.Define;
import uni.entity.Teacher;
import uni.utility.RestResult;
import uni.utility.StaticConstants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {
    private DBOperator dbOperator = null;
    private Teacher teacher;
    private ArrayList<Teacher> teacherList;

    public ArrayList<Teacher> selectTeacher(Teacher teacher,DBOperator dbOperator) {
        if(teacher!=null) {
            this.teacher=teacher;
            if(dbOperator!=null)
                this.dbOperator=dbOperator;
            return selectTeacherList();
        }
        else return null;

    }


    public ArrayList<Teacher> selectTeacherList() {
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        List<Object> parmsList= new ArrayList<Object>();
        ResultSet rs = null;
        Teacher teacherClass ;
        DBOperator dbOperator=null;

        if(this.dbOperator==null)
            dbOperator= new DBOperator();
        else {
            dbOperator=this.dbOperator;
        }


        String sqlString="SELECT ID,Name,Surname,Mail,Address,PhoneNumber,"
                + "Faculty,Department,Title,Situation FROM teacher T"
                + " WHERE 1=1 " +
                ""+((teacher.getId()<=0 )? "" : " AND T.ID = ? " )+""+
                ""+((teacher.getName()==null || teacher.getName()=="" )? "" : " AND T.Name = ? " )+""+
                ""+((teacher.getSurname()==null || teacher.getSurname()=="" )? "" : " AND T.Surname = ? " )+""+
                ""+((teacher.getMail()==null || teacher.getMail()=="" )? "" : " AND T.Mail = ? " )+""+
                ""+((teacher.getAddress()==null || teacher.getAddress()=="" )? "" : " AND T.Address = ? " )+""+
                ""+((teacher.getPhoneNumber()==null )? "" : " AND T.PhoneNumber = ? " )+""+
                ""+((teacher.getFaculty()==null||teacher.getFaculty().getId()<=0 )? "" : " AND T.Faculty = ? " )+""+
                ""+((teacher.getDepartment()==null||teacher.getDepartment().getId()<=0 )? "" : " AND T.Department = ? " )+""+
                ""+((teacher.getTitle()==null||teacher.getTitle().getId()<=0 )? "" : " AND T.Title = ? " )+""+
                ""+((teacher.getSituation()<=-1 )? "" : " AND T.Situation = ? " )+"";


        if(teacher.getId()>0)
            parmsList.add(teacher.getId());
        if(teacher.getName()!= null && teacher.getName()!="")
            parmsList.add(teacher.getName());
        if(teacher.getSurname()!= null && teacher.getSurname()!="")
            parmsList.add(teacher.getSurname());
        if(teacher.getMail()!= null && teacher.getMail()!="")
            parmsList.add(teacher.getMail());
        if(teacher.getAddress()!= null && teacher.getAddress()!="")
            parmsList.add(teacher.getAddress());
        if(teacher.getPhoneNumber()!=null)
            parmsList.add(teacher.getPhoneNumber());
        if(teacher.getFaculty()!=null&&teacher.getFaculty().getId()>0)
            parmsList.add(teacher.getFaculty().getId());
        if(teacher.getDepartment()!=null&&teacher.getDepartment().getId()>0)
            parmsList.add(teacher.getDepartment().getId());
        if(teacher.getTitle()!=null&&teacher.getTitle().getId()>0)
            parmsList.add(teacher.getTitle().getId());
        if(teacher.getSituation()!=-1)
            parmsList.add(teacher.getSituation());

        rs=dbOperator.selectStatement(sqlString, parmsList);

        try {
            while(rs.next()) {
                DefineRepository defineRepository = new DefineRepository();
                Define faculty = new Define();
                Define department = new Define();
                Define title = new Define();

                teacherClass = new Teacher();
                teacherClass.setId(rs.getInt("ID"));
                teacherClass.setName(rs.getString("Name"));
                teacherClass.setSurname(rs.getString("Surname"));
                teacherClass.setMail(rs.getString("Mail"));
                teacherClass.setAddress(rs.getString("Address"));
                teacherClass.setPhoneNumber(rs.getString("PhoneNumber"));
                teacherClass.setSituation(rs.getInt("Situation"));

                faculty.setId(rs.getInt("Faculty"));
                faculty=defineRepository.selectDefine(faculty, dbOperator).get(0);
                teacherClass.setFaculty(faculty);

                department.setId(rs.getInt("Department"));
                department=defineRepository.selectDefine(department, dbOperator).get(0);
                teacherClass.setDepartment(department);

                title.setId(rs.getInt("Title"));
                title=defineRepository.selectDefine(title, dbOperator).get(0);
                teacherClass.setTitle(title);

                teacherList.add(teacherClass);
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
        return teacherList;
    }

    public RestResult insertTeacher(Teacher teacher, DBOperator dbOperatorIn) {
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




        sqlString="INSERT INTO teacher  (Name,Surname,Mail,Address,PhoneNumber,Faculty,Department,Title,Situation)"
                + " VALUES(?,?,?,?,?,?,?,?,?)";

        parmsList.add(teacher.getName());
        parmsList.add(teacher.getSurname());
        parmsList.add(teacher.getMail());
        parmsList.add(teacher.getAddress());
        parmsList.add(teacher.getPhoneNumber());

        parmsList.add(teacher.getFaculty().getId());
        parmsList.add(teacher.getDepartment().getId());
        parmsList.add(teacher.getTitle().getId());
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


    public RestResult deleteTeacher(Teacher teacher,DBOperator dbOperatorIn) {
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

        sqlString="UPDATE teacher SET Situation=? where ID=?";

        parmsList.add(StaticConstants.STATUS_PASSİVE);
        parmsList.add(teacher.getId());

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


    public RestResult updateTeacher(Teacher teacher,DBOperator dbOperatorIn) {
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

        sqlString="UPDATE teacher SET Name=? ,  Surname=? , Mail=?,"
                + " Address=?, PhoneNumber=?, Faculty=?, Department=? ,  Title=?"
                + " where ID=?";



        parmsList.add(teacher.getName());
        parmsList.add(teacher.getSurname());
        parmsList.add(teacher.getMail());


        parmsList.add(teacher.getAddress());
        parmsList.add(teacher.getPhoneNumber());
        parmsList.add(teacher.getFaculty().getId());
        parmsList.add(teacher.getDepartment().getId());
        parmsList.add(teacher.getTitle().getId());
        parmsList.add(teacher.getId());

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
