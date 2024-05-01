package timbezhdev.ru.giscalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/graph")
    public String graphPage(){
        return "graph";
    }
    @GetMapping("/gis-calculator")
    public String greeting(){
        return "start";
    }
    @GetMapping("/direct")
    public String calculator(){
        return "direct";
    }
    @PostMapping("/direct/result")
    public String outPut(@RequestParam("x") double x,
                         @RequestParam("y") double y,
                         @RequestParam("angle") String angle,
                         @RequestParam("position") double position,
                         Model model){
        double[] at = DirectCalculator.calculate(x,y,angle,position);
        model.addAttribute("xCoordinate", at[0]);
        model.addAttribute("yCoordinate", at[1]);
        return "resultDir";
    }
    @GetMapping("/reverse")
    public String revCalculator(){
        return "revers";
    }
    @PostMapping("/reverse/result")
    public String reversOutPut(@RequestParam("x1") double x1,
                         @RequestParam("y1") double y1,
                         @RequestParam("x2") double x2,
                         @RequestParam("y2") double y2,
                         Model model){
        String[] resultOfReverse = ReversCalculator.calculate(x1,y1,x2,y2);
        model.addAttribute("angle", resultOfReverse[0]);
        model.addAttribute("position", resultOfReverse[1]);
        return "resultRev";
    }
    @GetMapping("/")
    public String mainPage(){
            return "main";
    }
}