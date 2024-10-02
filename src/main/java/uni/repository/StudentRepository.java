package uni.repository;

import uni.db.DBOperator;
import uni.entity.Define;
import uni.entity.Student;
import uni.utility.RestResult;
import uni.utility.StaticConstants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private DBOperator dbOperator = null;
    private Student student;
    private ArrayList<Student> studentList;

    public ArrayList<Student> selectStudent(Student student,DBOperator dbOperator) {
        if(student!=null) {
            this.student=student;
            if(dbOperator!=null)
                this.dbOperator=dbOperator;
            return selectStudentList();
        }
        else return null;

    }

    public ArrayList<Student> selectStudentList(){
       ArrayList<Student> studentList = new ArrayList<Student>();
       List<Object> parmsList = new ArrayList<Object>();
       ResultSet rs = null;
       Student studentClass ;
       DBOperator dbOperator=null;


        if(this.dbOperator==null)
            dbOperator= new DBOperator();
        else {
            dbOperator=this.dbOperator;
        }

        String sqlString="SELECT ID,Name,Surname,Mail,Address,PhoneNumber,Faculty,Department,Situation FROM student T "
                + " WHERE 1=1 " +
                ""+((student.getId()<=0 )? "" : " AND T.ID = ? " )+""+
                ""+((student.getName()==null || student.getName()=="" )? "" : " AND T.Name = ? " )+""+
                ""+((student.getSurname()==null || student.getSurname()=="" )? "" : " AND T.Surname = ? " )+""+
                ""+((student.getMail()==null || student.getMail()=="" )? "" : " AND T.Mail = ? " )+""+
                ""+((student.getAddress()==null || student.getAddress()=="" )? "" : " AND T.Address = ? " )+""+
                ""+((student.getPhoneNumber()==null )? "" : " AND T.PhoneNumber = ? " )+""+
                ""+((student.getFaculty()==null ||student.getFaculty().getId()<=0 )? "" : " AND T.Faculty = ? " )+""+
                ""+((student.getDepartment()==null ||student.getDepartment().getId()<=0 )? "" : " AND T.Department = ? " )+""+
                ""+((student.getSituation()<=-1 )? "" : " AND T.Situation = ? " )+"";



        if(student.getId()>0)
            parmsList.add(student.getId());
        if(student.getName()!= null && student.getName()!="")
            parmsList.add(student.getName());
        if(student.getSurname()!= null && student.getSurname()!="")
            parmsList.add(student.getSurname());
        if(student.getMail()!= null && student.getMail()!="")
            parmsList.add(student.getMail());
        if(student.getPhoneNumber()!= null && student.getPhoneNumber()!="")
            parmsList.add(student.getPhoneNumber());
        if(student.getFaculty()!= null &&student.getFaculty().getId()>0)
            parmsList.add(student.getFaculty().getId());
        if(student.getDepartment()!= null &&student.getDepartment().getId()>0)
            parmsList.add(student.getDepartment().getId());
        if(student.getSituation()!=-1)
            parmsList.add(student.getSituation());

        rs=dbOperator.selectStatement(sqlString, parmsList);

        try {
            while(rs.next()) {
                Define faculty = new Define();
                Define department = new Define();
                DefineRepository defineRepository = new DefineRepository();
                studentClass = new Student();
                studentClass.setId(rs.getInt("ID"));
                studentClass.setName(rs.getString("Name"));
                studentClass.setSurname(rs.getString("Surname"));
                studentClass.setMail(rs.getString("Mail"));
                studentClass.setAddress(rs.getString("Address"));
                studentClass.setPhoneNumber(rs.getString("PhoneNumber"));
                studentClass.setSituation(rs.getInt("Situation"));
                faculty.setId(rs.getInt("Faculty"));
                faculty = defineRepository.selectDefine(faculty, dbOperator).get(0);
                studentClass.setFaculty(faculty);

                department.setId(rs.getInt("Department"));
                department = defineRepository.selectDefine(department, dbOperator).get(0);
                studentClass.setDepartment(department);

                studentList.add(studentClass);
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
        return studentList;
    }


    public RestResult insertStudent(Student student, DBOperator dbOperatorIn) {
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

        sqlString="INSERT INTO STUDENT  (Name,Surname,Mail,Address,PhoneNumber,Faculty,Department,Situation)" +
                " VALUES(?,?,?,?,?,?,?,?)";

        parmsList.add(student.getName());
        parmsList.add(student.getSurname());
        parmsList.add(student.getMail());
        parmsList.add(student.getAddress());
        parmsList.add(student.getPhoneNumber());
        parmsList.add(student.getFaculty().getId());
        parmsList.add(student.getDepartment().getId());
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

    public RestResult deleteStudent(Student student,DBOperator dbOperatorIn) {
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

        sqlString="UPDATE STUDENT SET Situation=? where ID=?";

        parmsList.add(StaticConstants.STATUS_PASSİVE);
        parmsList.add(student.getId());

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


    public RestResult updateStudent(Student student,DBOperator dbOperatorIn) {
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

        sqlString="UPDATE STUDENT SET Name=? , Surname=? , Mail=?,"
                + " Address=?, PhoneNumber=?, Faculty=?, Department=?"
                + " where ID=?";

        parmsList.add(student.getName());
        parmsList.add(student.getSurname());
        parmsList.add(student.getMail());
        parmsList.add(student.getAddress());
        parmsList.add(student.getPhoneNumber());
        parmsList.add(student.getFaculty().getId());
        parmsList.add(student.getDepartment().getId());
        parmsList.add(student.getId());

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

