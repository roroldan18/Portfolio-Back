
package com.rrportafolio.portafolio.security.jwt;

//Clase que genera el token y valida el mismo.

import com.rrportafolio.portafolio.model.PrincipalUser;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;
    
    
    public String generateToken(Authentication authentication){
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        
        //retorno el token con este metodo gigante
        return Jwts.builder().setSubject(principalUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expiration*1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    
    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
                .getBody().getSubject();
    }
    
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } 
        catch (MalformedJwtException e){
            logger.error("JWT Inválido");
        }
        catch (UnsupportedJwtException e){
            logger.error("JWT no soportado");
        }
        catch (ExpiredJwtException e){
            logger.error("Token expirado");
        }
        catch (IllegalArgumentException e){
            logger.error("Token vacío");
        }
        catch (SignatureException e){
            logger.error("Firma de token no válida");
        }
        return false;
    }

}
