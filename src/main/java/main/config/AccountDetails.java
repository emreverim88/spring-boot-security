package main.config;

import main.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class AccountDetails implements UserDetails {

    private Account account;

    public AccountDetails(Account account) {
        this.account = account;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<SimpleGrantedAuthority> authorities = new HashSet<>();

        authorities.add(new SimpleGrantedAuthority("USER"));

        return authorities;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
