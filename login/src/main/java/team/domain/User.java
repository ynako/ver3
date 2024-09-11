package team.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import team.LoginApplication;
import team.domain.AdminLogin;
import team.domain.AdminRegistered;

@Entity
@Table(name = "User_table")
@Data
//<<< DDD / Aggregate Root
public class User {

    @Id
    private String userId;

    private String type;

    private String userName;

    private String password;

    private Integer tableCnt;

    @PostPersist
    public void onPostPersist() {
        AdminLogin adminLogin = new AdminLogin(this);
        adminLogin.publishAfterCommit();

        AdminRegistered adminRegistered = new AdminRegistered(this);
        adminRegistered.publishAfterCommit();
    }

    public static UserRepository repository() {
        UserRepository userRepository = LoginApplication.applicationContext.getBean(
            UserRepository.class
        );
        return userRepository;
    }
}
//>>> DDD / Aggregate Root
