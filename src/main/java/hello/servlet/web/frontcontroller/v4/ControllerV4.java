package hello.servlet.web.frontcontroller.v4;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.Map;

public interface ControllerV4 {
    /**
     *
     * @param paramMap
     * @param model
     * @return viewname
     */
    String process(Map<String, String> paramMap, Map<String,Object> model);
}
