package org.codehustler.dao;
 
import org.apache.commons.codec.digest.DigestUtils;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

 
@Document(collection = "user")
public class UserModel
{
    @Id
    private String id;
    @Indexed(unique=true)
    private String username;
    private String password;
    private String role;
 
    public UserModel() {}
 
    
    
    public UserModel(String id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}



	public UserModel( String username, String password, String role )
    {
        this.username = username;
        this.password = DigestUtils.sha1Hex( password );
        this.role = role;
    }
 
    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getSHA1Password() { return password; }
    public String getRole() { return role; }
    public String getPassword() { return password; }
}