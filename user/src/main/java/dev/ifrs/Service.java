package dev.ifrs;


import java.util.Arrays;
import java.util.HashSet;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;

@Path("/jwt/{user}/{password}")
public class Service {

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @PermitAll
    public String generate(@PathParam("user") String user, @PathParam("password") String password) {
        
        System.out.println(user);
        System.out.println(password);
        
        return Jwt.issuer("http://localhost:8080")
                .upn("rodrig.oliveira1998@outlook.com.br")
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .claim(Claims.full_name, "Rodrigo Leite de Oliveira")
                .sign();
    }
    
}
