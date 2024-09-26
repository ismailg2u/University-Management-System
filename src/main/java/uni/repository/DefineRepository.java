package uni.repository;

import uni.db.DBOperator;
import uni.entity.Define;
import uni.entity.DefineType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefineRepository {
    private DBOperator dbOperator = null;
    private Define define;
    private ArrayList<Define> defineList;

    public ArrayList<Define> selectDefine(Define define, DBOperator dbOperator) {
        if(define!=null) {
            this.define=define;
            if(dbOperator!=null)
                this.dbOperator=dbOperator;
            return selectDefineList();
        }
        else return null;

    }






    public ArrayList<Define> selectDefineList(){

     ArrayList<Define> defineList = new ArrayList<Define>();
        List<Object> parmsList= new ArrayList<Object>();
        ResultSet rs = null;
        Define defineClass ;
        DBOperator dbOperator=null;

        if(this.dbOperator==null)
            dbOperator= new DBOperator();
        else {
            dbOperator=this.dbOperator;
        }

        String sqlString="SELECT ID,definetypeID,Name,Situation FROM define T,definetype F"
                + " WHERE 1=1 " +
                ""+((define.getId()<=0 )? "" : " AND T.ID = ? " )+""+
                ""+((define.getDefineType().getId()<=0 )? "" : " AND T.definetypeID = ? " )+""+
                ""+((define.getName()==null || define.getName()=="" )? "" : " AND T.Name = ? " )+""+
                ""+((define.getSituation()==-1 )? "" : " AND T.Situation = ? " )+"";


        if(define.getId()>0)
            parmsList.add(define.getId());
        if(define.getDefineType().getId()>0)
            parmsList.add(define.getDefineType().getId());
        if(define.getName()!= null && define.getName()!="")
            parmsList.add(define.getName());
        if(define.getSituation()>-1)
            parmsList.add(define.getSituation());

        rs=dbOperator.selectStatement(sqlString, parmsList);

        try {
            while(rs.next()) {
                defineClass = new Define();
                DefineTypeRepository defineTypeRepository = new DefineTypeRepository();
                defineClass.setId(rs.getInt("ID"));

                DefineType tanimTip = new DefineType();
                tanimTip.setId(rs.getInt("definetypeID"));
                tanimTip = defineTypeRepository.selectDefineType(tanimTip, dbOperator).get(0);
                defineClass.setDefineType(tanimTip);;
                defineClass.setName(rs.getString("Name"));
                defineClass.setSituation(rs.getInt("Situation"));
                defineList.add(defineClass);
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
        return defineList;
    }
}
