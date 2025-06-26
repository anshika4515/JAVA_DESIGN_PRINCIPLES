interface Database{
    public void save(String data);
}

class SqlDatabase implements Database{   
    @Override
    public void save(String data){
        System.out.println("Saving data to SQL database: " + data);
    }
}

class MongoDatabase implements Database{
    @Override
    public void save(String Data){
        System.out.println("Saving data to NoSQL database: " + Data);
    }
}

class UserService{
    private Database db;

    public UserService(Database db){
        this.db=db;
    }

    public void storeData(String data){
        db.save(data);
    }
}

class Main{
    public static void main(String[] args) {
       SqlDatabase sqlDb = new SqlDatabase();
       MongoDatabase mongoDb = new MongoDatabase();

       UserService userService1 = new UserService(sqlDb);
       userService1.storeData("Kartik");

       UserService userService2 = new UserService(mongoDb);
       userService2.storeData("Anshika");
    }
}