package PR.example.PPRRproject.Controller;

import PR.example.PPRRproject.Model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;

@Controller
public class webController {
    @Autowired
    private RecipeRepsitory infoRepository;

    @Autowired
    private ClientRepository infoCRepo;

    int check = 0;
    String Arg1;
    String Arg2;
    String Arg3;

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

    @GetMapping("service")
    public String Get_main() {
        return "service";
    }

    @PostMapping("serviceAction")
    public String Post_main(MultipartHttpServletRequest files) throws Exception {
        String uploadFolder = "C:\\test\\upload";
        List<MultipartFile> list = files.getFiles("files");
        if (list.size() < 1) {
            return "service";
        } else{
            try {
                URL url = new URL("http:9900//17.135.65.255/api");
                ObjectMapper mapper = new ObjectMapper();
                StringBuilder sb = new StringBuilder();

                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                //Request Header 정의
                con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
                BufferedReader br;
                List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
                //전송방식
                con.setRequestMethod("POST");
                //서버에 연결되는 Timeout 시간 설정
                con.setConnectTimeout(5000);
                //InputStream 읽어 오는 Timeout 시간 설정
                con.setReadTimeout(5000);
                con.setDoOutput(false);
                if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    br.close();

                    mapper.readValue(sb.toString(), new TypeReference<List<Map<String, Object>>>(){});
                    //model.addAttribute("listMap", listMap);
                    if (list.size() > 2) {

                    } else if (list.size() > 1) {

                    } else {

                    }
                }
                else {
                    System.out.println("error: 서버와 통신 실패");
                    return "service";
                }
            }catch (Exception e){
                System.err.println(e.toString());
                return "service";
            }
        }
        return "redirect:/show";
    }

    @GetMapping("show")
    public String Get_show(Model model) {
        List<recipe> buf;
        if(check < 1) {
            buf = new List<recipe>() {
                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean contains(Object o) {
                    return false;
                }

                @Override
                public Iterator<recipe> iterator() {
                    return null;
                }

                @Override
                public Object[] toArray() {
                    return new Object[0];
                }

                @Override
                public <T> T[] toArray(T[] a) {
                    return null;
                }

                @Override
                public boolean add(recipe recipe) {
                    return false;
                }

                @Override
                public boolean remove(Object o) {
                    return false;
                }

                @Override
                public boolean containsAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean addAll(Collection<? extends recipe> c) {
                    return false;
                }

                @Override
                public boolean addAll(int index, Collection<? extends recipe> c) {
                    return false;
                }

                @Override
                public boolean removeAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean retainAll(Collection<?> c) {
                    return false;
                }

                @Override
                public void clear() {

                }

                @Override
                public recipe get(int index) {
                    return null;
                }

                @Override
                public recipe set(int index, recipe element) {
                    return null;
                }

                @Override
                public void add(int index, recipe element) {

                }

                @Override
                public recipe remove(int index) {
                    return null;
                }

                @Override
                public int indexOf(Object o) {
                    return 0;
                }

                @Override
                public int lastIndexOf(Object o) {
                    return 0;
                }

                @Override
                public ListIterator<recipe> listIterator() {
                    return null;
                }

                @Override
                public ListIterator<recipe> listIterator(int index) {
                    return null;
                }

                @Override
                public List<recipe> subList(int fromIndex, int toIndex) {
                    return null;
                }
            };
        }
        else if(check < 2){
            buf = infoRepository.findByRCPPARTSDTLSContaining("황태");
        }
        else if(check < 3){
            buf = infoRepository.findUserByApAndBpNamedParams("황태", "무");
        }
        else{
            buf = infoRepository.findUserByApAndBpAndCpNamedParams("황태", "무", "두부");
        }
        if(buf.size() < 1){

        }
        else {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            int index = (int)random.nextInt(buf.size());
            if(index == buf.size()){
                index --;
            }
            model.addAttribute("data", buf.get(index).getRCPNM());
            model.addAttribute("data0", buf.get(index).getRCPPARTSDTLS());
            model.addAttribute("data1", buf.get(index).getMANUAL01());
            model.addAttribute("data2", buf.get(index).getMANUAL02());
            model.addAttribute("data3", buf.get(index).getMANUAL03());
            model.addAttribute("data4", buf.get(index).getMANUAL04());
            model.addAttribute("data5", buf.get(index).getMANUAL05());
            model.addAttribute("data6", buf.get(index).getMANUAL06());
            model.addAttribute("source", buf.get(index).getATTFILE_NO_MAIN());
            model.addAttribute("source1", buf.get(index).getMANUALIMG01());
            model.addAttribute("source2", buf.get(index).getMANUALIMG02());
            model.addAttribute("source3", buf.get(index).getMANUALIMG03());
            model.addAttribute("source4", buf.get(index).getMANUALIMG04());
            model.addAttribute("source5", buf.get(index).getMANUALIMG05());
            model.addAttribute("source6", buf.get(index).getMANUALIMG06());
        }
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
