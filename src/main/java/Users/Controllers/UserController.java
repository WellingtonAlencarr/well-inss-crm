package Users.Controllers;

import Users.Models.UserModel;
import Users.Repositories.UserRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserRepository userRepository;

    @GET
    public List<UserModel> getAllUsers(){
        return userRepository.listAll();
    }

    @POST
    public Response createUser(UserModel userModel){
        userRepository.persist(userModel);
        return Response.status(Response.Status.CREATED).entity(userModel).build();
    }

    @GET
    @Path("/{id}")
    public UserModel getUser(@PathParam("id") Long id){
        return userRepository.findById(id);
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Long id, UserModel user){
        UserModel existingUser = userRepository.findById(id);
        if(existingUser == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        existingUser.setUserName(UserModel.getUsername);
        existingUser.setPassword(UserModel.getPassword());
        existingUser.setPassword(UserModel.getUserTypeEnum());
        userRepository.persist(existingUser);
        return Response.ok(existingUser).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id){
        UserModel userModel = userRepository.findById(id);
        if(userModel == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        userRepository.delete(userModel);
        return Response.noContent().build();
    }



}
