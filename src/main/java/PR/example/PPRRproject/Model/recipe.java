package PR.example.PPRRproject.Model;

import lombok.*;

import javax.persistence.*;
@Getter
@Entity
@Table(name = "recipe")
@Data
public class recipe{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RCPSEQ;
    @Column(name = "RCPNM")
    private String RCPNM;
    @Column(name = "RCPWAY2")
    private String RCPWAY2;
    @Column(name = "NOMAIN")
    private String ATTFILE_NO_MAIN;
    @Column(name="NOMK")
    private String ATTFILENOMK;
    @Column(name="RCPDTLS")
    private String RCPPARTSDTLS;
    @Column(name="MAN01")
    private String MANUAL01;
    @Column(name="MANIMG01")
    private String MANUALIMG01;
    @Column(name="MAN02")
    private String MANUAL02;
    @Column(name="MANIMG02")
    private String MANUALIMG02;
    @Column(name="MAN03")
    private String MANUAL03;
    @Column(name="MANIMG03")
    private String MANUALIMG03;
    @Column(name="MAN04")
    private String MANUAL04;
    @Column(name="MANIMG04")
    private String MANUALIMG04;
    @Column(name="MAN05")
    private String MANUAL05;
    @Column(name="MANIMG05")
    private String MANUALIMG05;
    @Column(name="MAN06")
    private String MANUAL06;
    @Column(name="MANIMG06")
    private String MANUALIMG06;


    public recipe(Long RCPSEQ, String RCPNM, String RCPWAY2,
                  String ATTFILENOMAIN, String ATTFILENOMK,
                  String RCPPARTSDTLS, String MANUAL01, String MANUALIMG01, String MANUAL02,
                  String MANUALIMG02, String MANUAL03, String MANUALIMG03, String MANUAL04,
                  String MANUALIMG04, String MANUAL05, String MANUALIMG05, String MANUAL06,
                  String MANUALIMG06) {
        this.RCPSEQ = RCPSEQ;
        this.RCPNM = RCPNM;
        this.RCPWAY2 = RCPWAY2;
        this.ATTFILE_NO_MAIN = ATTFILENOMAIN;
        this.ATTFILENOMK = ATTFILENOMK;
        this.RCPPARTSDTLS = RCPPARTSDTLS;
        this.MANUAL01 = MANUAL01;
        this.MANUALIMG01 = MANUALIMG01;
        this.MANUAL02 = MANUAL02;
        this.MANUALIMG02 = MANUALIMG02;
        this.MANUAL03 = MANUAL03;
        this.MANUALIMG03 = MANUALIMG03;
        this.MANUAL04 = MANUAL04;
        this.MANUALIMG04 = MANUALIMG04;
        this.MANUAL05 = MANUAL05;
        this.MANUALIMG05 = MANUALIMG05;
        this.MANUAL06 = MANUAL06;
        this.MANUALIMG06 = MANUALIMG06;


    }

    public recipe() {

    }
}
