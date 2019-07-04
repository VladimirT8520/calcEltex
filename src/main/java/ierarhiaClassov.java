public class ierarhiaClassov {
    public abstract class User{
        private String fio;
        private Integer phone;
        private Integer id;
        private String email;

            /*public User(String fio, Integer phone,Integer id, String email){
                this.fio=fio;
                this.email=email;
                this.phone=phone;
                this.id=id;
            }*/
    }
    public class Sales{
        String title;
        Integer prices;
    }
    public class Developer extends User {

    }
    class Manager extends User{

    }
}
