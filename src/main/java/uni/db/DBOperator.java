package uni.db;

import java.sql.*;
import java.util.Iterator;
import java.util.List;

public class DBOperator {
    private Connection conn = null;
    private Statement stmnt = null;
    private PreparedStatement ps = null;

    public DBOperator() {
        conn = ConnectionToDb.getDBConnection();
    }

    public DBOperator(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStmnt() {
        return stmnt;
    }

    public void setStmnt(Statement stmnt) {
        this.stmnt = stmnt;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public void commit() {
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void rollback() {
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeStatement() {
        try {
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closePreparedStatement() {
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * Firstly we create a rs variable. This variable will be the return value.
     * Then we create an index value.This will be the
     */
    public ResultSet selectStatement(String sql, List<Object> values) {

        ResultSet rs = null;
        int index = 0;
        try {
            ps = conn.prepareStatement(sql);
            Iterator<Object> iter = values.iterator();
            while (iter.hasNext()) {
                Object eleman = iter.next();
                if (eleman instanceof String) {
                    ps.setString(++index, (String) eleman);
                } else if (eleman instanceof Integer) {
                    ps.setInt(++index, (int) eleman);
                } else if (eleman instanceof Short)
                    ps.setShort(++index, (short) eleman);
                else if (eleman instanceof Long)
                    ps.setLong(++index, (long) eleman);
                else if (eleman instanceof Date)
                    ps.setDate(++index, (Date) eleman);
                else {
                    SQLException e = new SQLException("Boyle bir parametre tipi bulunamadı.");
                }
            }
            rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


    /**
     *
     */
    public int executeAndUpdate(String sql, List<Object> values) {

        int result = 0;
        int index = 0;
        try {
            ps = conn.prepareStatement(sql);
            Iterator<Object> iter = values.iterator();
            while (iter.hasNext()) {
                Object eleman = iter.next();
                if (eleman instanceof String) {
                    ps.setString(++index, (String) eleman);
                } else if (eleman instanceof Integer) {
                    ps.setInt(++index, (int) eleman);
                } else if (eleman instanceof Short)
                    ps.setShort(++index, (short) eleman);
                else if (eleman instanceof Long)
                    ps.setLong(++index, (long) eleman);
                else if (eleman instanceof Date)
                    ps.setDate(++index, (Date) eleman);
                else {
                    SQLException e = new SQLException("Boyle bir parametre tipi bulunamadı.");
                }
            }
            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     */

    public int executeAndUpdateReturnValue(String sql, List<Object> values, String returnColumn) {

        int result = 0;
        int index = 0;
        try {
            PreparedStatement pst = conn.prepareStatement(sql, new String[] { returnColumn });

            Iterator<Object> iter = values.iterator();
            while (iter.hasNext()) {
                Object eleman = iter.next();
                if (eleman instanceof String) {
                    ps.setString(++index, (String) eleman);
                } else if (eleman instanceof Integer) {
                    ps.setInt(++index, (int) eleman);
                } else if (eleman instanceof Short)
                    ps.setShort(++index, (short) eleman);
                else if (eleman instanceof Long)
                    ps.setLong(++index, (long) eleman);
                else if (eleman instanceof Date)
                    ps.setDate(++index, (Date) eleman);
                else {
                    SQLException e = new SQLException("Boyle bir parametre tipi bulunamadı.");
                }
            }
            result = pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if (rs != null && rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     */

    public ResultSet selectStatement(String sql) {
        ResultSet rs = null;
        try {
            Statement stmnt = conn.createStatement();
            rs = stmnt.executeQuery(sql);
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    /**
     * Girilen sql querysini yerine getirerek(insert,update delete) işlemin başarılımı başarısızmı olduğunu 0
     *  ve 1 lerle return eder
     * @param sql
     * @return int
     * Önce int tipinde "result" değişkeni oluşturulur bu işlemin başarılı olup olmadığını anlamak için,
     *  sonrasında yeni bir Statement değişkeni oluşturulur
     * daha sonra oluşturulan "stmnt" değişkenindeki .executeUpdate() metodu kullanılarak gelen @param sql
     * qurydini yerinee getirir , statement kapatılır ve result değeri reutrn edilir
     *
     */
    public int executeUpdate(String sql) {
        int result = 0;
        try {
            Statement stmnt = conn.createStatement();
            result = stmnt.executeUpdate(sql);
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * Girilen sql querysini yerine getirerek eklenen yeni datanın "id"sini return eder
     * @param sql
     * @return int
     * Önce int tipinde "result" değişkeni oluşturulur bunun sebebi eklenen yeni datadaki oluşturulan keyleri
     *  çekmek için (Bu örnekte ID columunda oluşturulan keyleri çekmek için )
     *  sonrasında yeni bir Statement değişkeni oluşturulur
     * daha sonra oluşturulan "stmnt" değişkenindeki .executeUpdate() metodu kullanılarak gelen @param sql
     * sorgusunu yerinee getirir ve Tablein içindeki "ID" columunda oluşturulan keyleri .getInt() metodu
     * aracılığıyla çeker ve "result" değişkenine eşleriz en sonda da "result" değişkeni return edilir
     *
     */


    public int executeUpdateReturnValue(String sql) {
        int result = 0;
        try {
            Statement stmnt = conn.createStatement();
            stmnt.executeUpdate(sql, new String[] {"ID"});
            ResultSet rSet=stmnt.getGeneratedKeys();
            if(rSet!=null &&rSet.next())
                result=rSet.getInt(1);
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
