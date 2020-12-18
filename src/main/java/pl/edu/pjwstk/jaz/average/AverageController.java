package pl.edu.pjwstk.jaz.average;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.IntStream;

@RestController
public class AverageController {

    @GetMapping("average")
    public String getAverage(@RequestParam("numbers") String numbers){
        //Policzyć średnią.
        if(numbers.isEmpty()){
            return "Please put parameters.";
        }

        String[] numb = numbers.split(",");

        int[] results = new int [numb.length];
        for(int i = 0; i < numb.length; i++){
            results[i] = Integer.parseInt(numb[i]);
        }
        int sum = IntStream.of(results).sum();
        float avg = (float) sum / results.length;
        BigDecimal bd = new BigDecimal(avg);
        bd = bd.setScale(2, RoundingMode.HALF_UP).stripTrailingZeros();
        return "Average equals: " + String.valueOf(bd);
    }
}
