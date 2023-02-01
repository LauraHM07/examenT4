package com.laura.examen.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laura.examen.model.Usuario;
import com.laura.examen.services.UsuariosService;
import com.laura.examen.model.Permiso;
import com.laura.examen.services.PermisosService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuariosService usuariosService;

    @Autowired
    PermisosService permisosService;

    @Value("${pagination.size}")
    int sizePage;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list/1/codigo/asc");

        return modelAndView;
    }

    @GetMapping(value = "/list/{numPage}/{fieldSort}/{directionSort}")
    public ModelAndView listPage(Model model,
            @PathVariable("numPage") Integer numPage,
            @PathVariable("fieldSort") String fieldSort,
            @PathVariable("directionSort") String directionSort) {


        Pageable pageable = PageRequest.of(numPage - 1, sizePage,
            directionSort.equals("asc") ? Sort.by(fieldSort).ascending() : Sort.by(fieldSort).descending());

        Page<Usuario> page = usuariosService.findAll(pageable);

        List<Usuario> usuarios = page.getContent();

        ModelAndView modelAndView = new ModelAndView("usuarios/list");
        modelAndView.addObject("usuarios", usuarios);

        modelAndView.addObject("numPage", numPage);
        modelAndView.addObject("totalPages", page.getTotalPages());
        modelAndView.addObject("totalElements", page.getTotalElements());

        modelAndView.addObject("fieldSort", fieldSort);
        modelAndView.addObject("directionSort", directionSort.equals("asc") ? "asc" : "desc");

        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Usuario usuario) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", new Usuario());
        modelAndView.setViewName("usuarios/new");

        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Usuario usuario = usuariosService.findById(codigo);

        List<Permiso> permisos = permisosService.findAll();
        for(Permiso permiso : permisos) {
            if(usuario.getPermisos().contains(permiso)) {
                permiso.setTieneUsuario(true);
            }
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", usuario);
        modelAndView.addObject("permisos", permisos);
        modelAndView.setViewName("usuarios/edit");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Usuario usuario) {

        usuariosService.insert(usuario);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + usuario.getCodigo());
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Usuario usuario, @RequestParam(value="ck_permisos") int[] ck_permisos) {

        List<Permiso> permisos = usuario.getPermisos();

        if(permisos == null) {
            permisos = new ArrayList<Permiso>();
        }

        for(int i : ck_permisos) {
            Permiso p = new Permiso(i);
            permisos.add(p);
        }

        usuario.setPermisos(permisos);

        usuariosService.update(usuario);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + usuario.getCodigo());
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

                usuariosService.delete(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/usuarios/list");
        return modelAndView;
    }
}
