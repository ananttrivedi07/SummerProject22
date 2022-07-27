package resources;

import dao.QueryMan;
import model.Post;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("post")
public class PostResources {

    public static QueryMan queryMan;

    @POST
    @Path("insertPost")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Post insertPost(@QueryParam("postContent") String postContent,
                           @QueryParam("postTitle") String postTitle,
                           @QueryParam("userName") String userName) throws SQLException {

        queryMan = new QueryMan();

        queryMan.executeInsertPost(queryMan.getQueryFactory().insertPost(), );



    }
}
