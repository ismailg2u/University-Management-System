package uni.repository;

import uni.db.DBOperator;
import uni.entity.DefineType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefineTypeRepository {

    private DBOperator dbOperator = null;
    private DefineType defineType;
    private ArrayList<DefineType> defineTypeList;


    public ArrayList<DefineType> selectDefineType(DefineType defineType, DBOperator dbOperator) {

        if(defineType!=null)
          this.defineType = defineType;
          if (dbOperator!=null)
              this.dbOperator = dbOperator;
          return selectDefineTypeList();

    }





    public ArrayList<DefineType> selectDefineTypeList() {
        ArrayList<DefineType> defineTypeList = new ArrayList<DefineType>();
        List<Object> parmsList= new ArrayList<Object>();
        ResultSet rs = null;
        DefineType defineTypeClas ;
        DBOperator dbOperator=null;

        if(this.dbOperator==null)
            dbOperator= new DBOperator();
        else {
            dbOperator=this.dbOperator;
        }


        String sqlString="SELECT ID,Name,Situation FROM definetype T WHERE 1=1 " +
                ""+((defineType.getId()<=0 )? "" : " AND T.ID = ? " )+""+
                ""+((defineType.getName()==null || defineType.getName()=="" )? "" : " AND T.Name = ? " )+""+
                ""+((defineType.getSituation()==-1 )? "" : " AND T.Situation = ? " )+"";


        if(defineType.getId()>0)
            parmsList.add(defineType.getId());
        if(defineType.getName()!= null && defineType.getName()!="")
            parmsList.add(defineType.getName());
        if(defineType.getSituation()>-1)
            parmsList.add(defineType.getSituation());

        rs=dbOperator.selectStatement(sqlString, parmsList);

        try {
            while(rs.next()) {
                defineTypeClas = new DefineType();
                defineTypeClas.setId(rs.getInt("ID"));
                defineTypeClas.setName(rs.getString("Name"));
                defineTypeClas.setSituation(rs.getInt("Situation"));
                defineTypeList.add(defineTypeClas);
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
        return defineTypeList;
    }
    public DBOperator getDbOperator() {
        return dbOperator;
    }

    public void setDbOperator(DBOperator dbOperator) {
        this.dbOperator = dbOperator;
    }

    public DefineType getDefineType() {
        return defineType;
    }

    public void setDefineType(DefineType defineType) {
        this.defineType = defineType;
    }

    public ArrayList<DefineType> getDefineTypeList() {
        return defineTypeList;
    }

    public void setDefineTypeList(ArrayList<DefineType> defineTypeList) {
        this.defineTypeList = defineTypeList;
    }

}
