package chapter5;

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

    public void renameUser(Long userId, String newName) {

        UserEntity userFromDB = getUserFromDB(userId);

        String normalizedName = userFromDB.normalizedName(newName);
        userFromDB.setName(normalizedName);

        saveUserToDB(userFromDB);
    }

    public void setLastExecutedSqlStmt(String lastExecutedSqlStmt) {
        this.lastExecutedSqlStmt = lastExecutedSqlStmt;
    }

    public UserEntity getUserFromDB(Long userId) {
        return null;
    }

    public void saveUserToDB(UserEntity user) {

    }

}
