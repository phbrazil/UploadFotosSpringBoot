package com.example.Controller;

import com.example.DAO.AddFotoDAO;
import com.example.DAO.DeleteFotoDAO;
import com.example.DAO.GetFotoDAO;
import com.example.DAO.ListFotosDAO;
import com.example.DAO.UpdateFotoDAO;
import com.example.Model.tbFotos;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FotoController {

    //  @Autowired
//    private usuario dao;
    @GetMapping("/list")
    public String listFotos(Model fotos, Model foto, 
            @ModelAttribute("result") String result,
            @ModelAttribute("user") String user) {
        
        ListFotosDAO list = new ListFotosDAO();

        List<tbFotos> listFotos = list.List();

        fotos.addAttribute("fotos", listFotos);
        foto.addAttribute("foto", new tbFotos());
        return "listaFotos";
    }

    @GetMapping("/")
    public String fotoForm(Model foto) {

        foto.addAttribute("foto", new tbFotos());

        return "index";
    }

    @PostMapping("/AddFoto")
    public String fotoSubmit(@ModelAttribute tbFotos foto, Model fotos,
            RedirectAttributes redirectAttrs) {

        AddFotoDAO add = new AddFotoDAO();

        String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

        foto.setDate(date);
        foto.setPath("em branco");

        int id = add.addFoto(foto);

        if (id > 0) {
            redirectAttrs.addAttribute("result", "fotoAdded");
            redirectAttrs.addAttribute("user", foto.getName());

        } else {
            redirectAttrs.addAttribute("result", "failedAdded");
            redirectAttrs.addAttribute("user", foto.getName());

        }

        //return "listaUsuarios";
        return "redirect:list";
    }

    @PostMapping("/deleteFoto")
    public String deleteFoto(@ModelAttribute tbFotos foto, Model fotos) {

        GetFotoDAO get = new GetFotoDAO();

        foto = get.getUsuario(foto.getId());

        DeleteFotoDAO delete = new DeleteFotoDAO();

        delete.deleteUsuario(foto);

        ListFotosDAO list = new ListFotosDAO();

        List<tbFotos> listFotos = list.List();

        fotos.addAttribute("result", "fotoDeleted");

        fotos.addAttribute("fotos", listFotos);

        return "listaFotos";
    }

    @PostMapping("/editFoto")
    public String editFoto(@ModelAttribute tbFotos foto, Model fotos) {

        UpdateFotoDAO update = new UpdateFotoDAO();

        update.updateUsuario(foto);

        ListFotosDAO list = new ListFotosDAO();

        List<tbFotos> listFotos = list.List();

        fotos.addAttribute("result", "fotoUpdated");

        fotos.addAttribute("fotos", listFotos);

        return "listaFotos";
    }

}
