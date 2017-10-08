package lt.karauz.controllers;

import lt.karauz.utilities.StringUtilities;
import lt.karauz.data_objects.StringResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LineSplitterController {

    @RequestMapping("/split")
    public StringResponse LineSplit(
            @RequestParam(value="text") String text,
            @RequestParam(value="lettersPerLine") int lettersPerLine) {
        StringResponse formattedString;

        try {
            formattedString = new StringResponse(StringUtilities.splitIntoLines(text, lettersPerLine));
        }catch (Exception e){
            formattedString = new StringResponse(e.getMessage());
        }

        return formattedString;
    }
}
