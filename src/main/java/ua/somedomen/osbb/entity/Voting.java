package ua.somedomen.osbb.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import ua.somedomen.osbb.entity.securityEntity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@Entity
@Setter
@Getter
@ToString(exclude = "users")
public class Voting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String votingName;
    private String votingShort;
    private String votingText;
    private String votingTime;

    private int votingTrue;
    private int votingFalse;


    @ManyToMany( cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            },fetch = FetchType.EAGER  /* targetEntity = User.class */)
//    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.REFRESH})
    @JoinTable(name = "USERS_VOTINGS_TRUE",
            inverseJoinColumns = @JoinColumn(name = "users_id"),
            joinColumns = @JoinColumn(name = "votings_id"))
    private Collection<User> users = new LinkedHashSet<>();

    public Voting(String votingName, String votingShort, String votingText, String votingTime, int votingTrue, int votingFalse) {
        this.votingName = votingName;
        this.votingShort = votingShort;
        this.votingText = votingText;
        this.votingTime = votingTime;
        this.votingTrue = votingTrue;
        this.votingFalse = votingFalse;
    }

    public Voting(String votingName, String votingShort, String votingText, String votingTime, int votingTrue, int votingFalse, List<User> users) {
        this.votingName = votingName;
        this.votingShort = votingShort;
        this.votingText = votingText;
        this.votingTime = votingTime;
        this.votingTrue = votingTrue;
        this.votingFalse = votingFalse;
        this.users = users;
    }

    public Voting() {
    }

//    @Override
//    public boolean equals(Object o) {  // походу я шось не так переоприділив, бо по ідеї мало б працювати
//
//        if (o == this) return true;
//        if (!(o instanceof Voting)) {
//            return false;
//        }
//
//        Voting voting = (Voting) o;
//
//        return voting.id == id &&
//                voting.votingName.equals(votingName) &&
//                voting.votingFalse == votingFalse &&
//                voting.votingShort.equals(votingShort) &&
//                voting.votingText.equals(votingText) &&
//                voting.votingTime.equals(votingTime) &&
//                voting.votingTrue == votingTrue &&
//                voting.users.equals(users);
//    }
//
//    //Idea from effective Java : Item 9
//    @Override
//    public int hashCode() {
//        int result = 17;
//        result = 31 * result + votingName.hashCode();
//        result = 31 * result + id;
//        result = 31 * result + votingTrue;
//        result = 31 * result + votingTime.hashCode();
//        result = 31 * result + votingText.hashCode();
//        result = 31 * result + votingShort.hashCode();
//        result = 31 * result + votingFalse;
//        result = 31 * result + users.hashCode();
//        return result;
//    }
}

