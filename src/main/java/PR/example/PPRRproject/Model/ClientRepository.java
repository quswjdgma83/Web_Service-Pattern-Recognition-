package PR.example.PPRRproject.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<client,Long> {

    List<client> findByCIdAndCPasswd(String ID, String PASSWD);

}
