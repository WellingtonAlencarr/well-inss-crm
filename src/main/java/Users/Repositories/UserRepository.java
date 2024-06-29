package Users.Repositories;

import Users.Models.UserModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserModel> {


        public UserModel findByUsername(String username){
            return find("username", username.toLowerCase()).firstResult();
        }

        public UserModel findById(long id){
            return find("Id", id).firstResult();
        }

        public UserModel findAll(){

        }
}
