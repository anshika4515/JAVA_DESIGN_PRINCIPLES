class Sql{
    public void SavaToDb(String data){
        System.out.println("Saving data to SQL database: " + data);
    }
}

class NoSql{
    public void SaveToDb(String data){
        System.out.println("Saving data to NoSQL database: " + data);
    }
}

class UserService{   //(High Level Model Tghtly coupled with Low Level Model)
    Sql sql = new Sql();
    NoSql mongo = new NoSql();

    void saveToSql(String data){
        sql.SavaToDb(data);
    }

    void saveToNoSql(String data){
        mongo.SaveToDb(data);
    }
}
class Main{
    public static void main(String[] args) {
        UserService user = new UserService();
        user.saveToSql("Kartik");
        user.saveToNoSql("Anshika");
    }
}

//This will voilate Ope closed principle as well as dependency inversion principle
// because if we want to add a new database, we have to modify the UserService class