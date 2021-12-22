package ti.umy.DirhamKeRinggit;

import java.text.DecimalFormat;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CurrentController {
    @RequestMapping("/CurrentConverter")
    public String getDataSampling(Model model, HttpServletRequest param){
        //ini harga mata uang 1 dirham = 1.13 Ringgit
        double aedtorm = 1.13; 
        
        //terima input dari index dan di konversi
        //konversi kedalam bentuk double dan dikalikan dengan harga aedtorm
        String input = param.getParameter("sendData"); 
        double konv = Double.parseDouble(input)*aedtorm;
        
        //membaca 2 angka belakang koma
        DecimalFormat df = new DecimalFormat("#.##");
        //menampilkan hasil convert di index dengan function data history dan data1
        model.addAttribute("data1",df.format(konv));
        model.addAttribute("dataHistory", input);
        return "Index";
    }
}
