package PR.example.PPRRproject.Model;


import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "client")
@Data
public class client {
    @Id
    @Column(name = "ClientId", length = 20)
    private String CId;

    @Column(name = "ClientPasswd", length = 20)
    private String CPasswd;

    public client(String cid, String cpasswd) {
        this.CId = cid;
        this.CPasswd = cpasswd;
    }

    public client(){

    }
}
