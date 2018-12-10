package win.pub.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import win.pub.srv.WinRefServer;

import java.util.Map;

/**
 * Created by aWin on 2018-12-10.
 *
 * @Description:
 */
@Controller
@RequestMapping("pub")
public class WinRefController {

    @ResponseBody
    @RequestMapping(value = "val",method = RequestMethod.POST)
    public String getValue(@RequestBody Map<String,String> map)
    {
        String val=getServer().getValue(map.get("table") ,map.get("column") ,map.get("pkfield") ,map.get("pkval") );
        return val;
    }

    private WinRefServer server;
    private WinRefServer getServer()
    {
        if(server==null)
            server=new WinRefServer();
        return server;
    }
}
