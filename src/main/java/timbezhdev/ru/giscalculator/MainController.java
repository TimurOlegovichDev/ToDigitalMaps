package timbezhdev.ru.giscalculator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {


    private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private static Graph graph = context.getBean(Graph.class);

    @GetMapping("/graph")
    public String graphPage(Model model){
        graph.add(1,2);
        graph.add(3,3);
        model.addAttribute("graphName", graph.getName());
        String[] data = graph.toJson();
        for(String str : data){
            System.out.println(str);
        }
        model.addAttribute("graphColor", graph.getColor());
        model.addAttribute("heights", data[0]);
        model.addAttribute("positions", data[1]);
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