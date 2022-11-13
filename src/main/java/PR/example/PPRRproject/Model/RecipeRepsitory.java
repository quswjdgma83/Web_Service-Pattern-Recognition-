package PR.example.PPRRproject.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepsitory extends JpaRepository<recipe,Long> {

    List<recipe> findByRCPPARTSDTLSContaining(String RCPPARTSDTLS);

    @Query("SELECT a FROM recipe a WHERE a.RCPPARTSDTLS like %:aParma% and a.RCPPARTSDTLS like %:bParma%")
    List<recipe> findUserByApAndBpNamedParams(
            @Param("aParma") String ap,
            @Param("bParma") String bp);

    @Query("SELECT a FROM recipe a WHERE a.RCPPARTSDTLS like %:aParma% and a.RCPPARTSDTLS like %:bParma% and a.RCPPARTSDTLS like %:cParma%")
    List<recipe> findUserByApAndBpAndCpNamedParams(
            @Param("aParma") String ap,
            @Param("bParma") String bp,
            @Param("cParma") String cp);
}
