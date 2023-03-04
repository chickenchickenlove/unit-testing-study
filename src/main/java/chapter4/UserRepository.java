package chapter4;

public class UserRepository {

    private String lastExecutedSqlStmt;


    public UserEntity getById(int id) {
        /*

         */
        return null;
    }

    public String getLastExecutedSqlStmt() {
        return lastExecutedSqlStmt;
    }

    public void setLastExecutedSqlStmt(String lastExecutedSqlStmt) {
        this.lastExecutedSqlStmt = lastExecutedSqlStmt;
    }
}
