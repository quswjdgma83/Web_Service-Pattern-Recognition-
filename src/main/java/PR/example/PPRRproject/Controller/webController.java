package PR.example.PPRRproject.Controller;

import PR.example.PPRRproject.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class webController {
    @Autowired
    private RecipeRepsitory infoRepository;

    @Autowired
    private ClientRepository infoCRepo;

    @GetMapping("home")
    public String Get_home() {
        return "home";
    }

    @GetMapping("login")
    public String Get_login(Model model) {
        model.addAttribute("message",0);
        return "login";
    }

    @PostMapping("loginAction")
    public String Post_login(HttpServletRequest request, Model model){
        String id=request.getParameter("userID");
        String password=request.getParameter("userPassword");
        List<client> tmp = infoCRepo.findByCIdAndCPasswd(id, password);
        if(tmp.size() < 1){
            model.addAttribute("message",1);
            return "login";
        }
        else{
            model.addAttribute("message",0);
            return "redirect:/home";
        }
    }

    @GetMapping("main")
    public String Get_main() {
        return "main";
    }

    @PostMapping("mainAction")
    public String Post_main(MultipartHttpServletRequest files){
        String uploadFolder = "C:\\test\\upload";
        List<MultipartFile> list = files.getFiles("files");
        if(list.size() < 1){
            return "home";
        } else if (list.size() < 2) {
            return "login";
        }else if (list.size() < 3){
            return "join";
        }
        else{
            return "redirect:/show";
        }
    }

    @GetMapping("show")
    public String Get_show(Model model) {
        List<recipe> buf = infoRepository.findUserByApAndBpAndCpNamedParams("황태", "무", "두부");
        model.addAttribute("data", buf.get(0).getRCPNM());
        model.addAttribute("data0", buf.get(0).getRCPPARTSDTLS());
        model.addAttribute("data1", buf.get(0).getMANUAL01());
        model.addAttribute("data2", buf.get(0).getMANUAL02());
        model.addAttribute("data3", buf.get(0).getMANUAL03());
        model.addAttribute("data4", buf.get(0).getMANUAL04());
        model.addAttribute("data5", buf.get(0).getMANUAL05());
        model.addAttribute("data6", buf.get(0).getMANUAL06());
        model.addAttribute("source", buf.get(0).getATTFILE_NO_MAIN());
        model.addAttribute("source1", buf.get(0).getMANUALIMG01());
        model.addAttribute("source2", buf.get(0).getMANUALIMG02());
        model.addAttribute("source3", buf.get(0).getMANUALIMG03());
        model.addAttribute("source4", buf.get(0).getMANUALIMG04());
        model.addAttribute("source5", buf.get(0).getMANUALIMG05());
        model.addAttribute("source6", buf.get(0).getMANUALIMG06());
        return "show";
    }

    @GetMapping("join")
    public String Get_join(Model model) {
        model.addAttribute("err",0);
        return "join";
    }

    @PostMapping("joinAction")
    public String Post_join(HttpServletRequest request, Model model){
        String id=request.getParameter("userID");
        String password=request.getParameter("userPassword");
        List<client> tmp = infoCRepo.findByCIdAndCPasswd(id, password);
        if(tmp.size() < 1){
            client buffer = new client(id, password);
            infoCRepo.save(buffer);
            model.addAttribute("message",2);
            return "redirect:/login";
        }
        else{
            model.addAttribute("err",1);
            return "join";
        }
    }

    @GetMapping("ctb")
    public String Get_ctb() {
        return "contributor";
    }

}
