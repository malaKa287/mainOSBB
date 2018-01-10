package ua.somedomen.osbb.entity.securityEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.somedomen.osbb.entity.Voting;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = "votings")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String passwordConfirm;

    @Email(message = "Введіть email коректно")
    private String email;


    @ManyToMany( cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            }, fetch = FetchType.EAGER /* targetEntity = User.class */)
//    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.REFRESH})
    @JoinTable(name = "USERS_VOTINGS_TRUE",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "votings_id"))
    private Collection<Voting> votings = new LinkedHashSet<>();

    @Enumerated(EnumType.STRING)
    private Authority authority = Authority.ROLE_USER;

    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;

    private String name;
    private String prename;
    private String phoneNumber;
    private String someInfo;


    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String passwordConfirm, String email, List<Voting> votings, Authority authority, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled, String name, String prename, String phoneNumber, String someInfo) {
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.email = email;
        this.votings = votings;
        this.authority = authority;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.name = name;
        this.prename = prename;
        this.phoneNumber = phoneNumber;
        this.someInfo = someInfo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(authority.name()));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


//    @Override
//    public boolean equals(Object o) {   // походу я шось не так переоприділив, бо по ідеї мало б працювати
//
//        if (o == this) return true;
//        if (!(o instanceof User)) {
//            return false;
//        }
//
//        User user = (User) o;
//
//        return user.name.equals(name) &&
//                user.id == id &&
//                user.email.equals(email) &&
//                user.password.equals(password) &&
//                user.passwordConfirm.equals(password) &&
//                user.phoneNumber.equals(phoneNumber) &&
//                user.prename.equals(prename) &&
//                user.someInfo.equals(someInfo) &&
//                user.username.equals(username) &&
//                user.authority.equals(authority) &&
//                user.votings.equals(votings);
//    }
//
//    //Idea from effective Java : Item 9
//    @Override
//    public int hashCode() {
//        int result = 17;
//        result = 31 * result + name.hashCode();
//        result = 31 * result + id;
//        result = 31 * result + password.hashCode();
//        result = 31 * result + email.hashCode();
//        result = 31 * result + passwordConfirm.hashCode();
//        result = 31 * result + phoneNumber.hashCode();
//        result = 31 * result + prename.hashCode();
//        result = 31 * result + someInfo.hashCode();
//        result = 31 * result + username.hashCode();
//        result = 31 * result + votings.hashCode();
//        return result;
//    }

}
