package com.feas.domain.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jwt_token_store", schema = "epp")
public class JwtTokenStore {

    private String jwtToken;

    public JwtTokenStore(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public JwtTokenStore() {
    }

    @Id
    @Column(name = "JWT_TOKEN", nullable = false, length = 1500)
    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JwtTokenStore that = (JwtTokenStore) o;
        return Objects.equals(jwtToken, that.jwtToken) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jwtToken);
    }
}
