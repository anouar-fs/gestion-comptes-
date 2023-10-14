package com.ensah.gestion_comptes.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ensah.gestion_comptes.Service.ICompteService;
import com.ensah.gestion_comptes.Service.IRoleService;
import com.ensah.gestion_comptes.Service.IUtilisateurService;
import com.ensah.gestion_comptes.bo.Compte;
import com.ensah.gestion_comptes.bo.CompteModel;
import com.ensah.gestion_comptes.bo.Loger;
import com.ensah.gestion_comptes.bo.Role;
import com.ensah.gestion_comptes.bo.Utilisateur;
import com.ensah.gestion_comptes.hasher.PasswordHasher;


@Controller
public class CompteController {

	@Autowired
	private ICompteService icmpService;

		
	@Autowired
	private IUtilisateurService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private ServletContext appContext;
	
	
	
	private Map<String, Long> RoleList = new HashMap<String, Long>(); 
	public CompteController() {
		RoleList.put("Etudiant", 1L);
		RoleList.put("Enseignant", 2L);
		RoleList.put("Cadre Administrateur", 3L);
	
	}
	
	
	
	
	
	@RequestMapping("/LoginForm")
	public String LoginForm(Model model) {
		
		
		
		
		
		
		model.addAttribute("Loger", new Loger());
		
		return "Login";
	}
	
	
	@RequestMapping("/Authenticate")
	public String Authenticate(@Valid @ModelAttribute("Loger") Loger lgr, BindingResult bindingResult,
			ModelMap model,HttpServletRequest request) {
		
		System.out.println("fhdshfgdsjhfgdsh");
		PasswordHasher hasher = new PasswordHasher();
		String Hash_code = hasher.doHashing(lgr.getPassword());
		
		if(icmpService.SearchLoginAndPassword(lgr.getLogin(),Hash_code)!=null) {
			System.out.println("Test controller ");
			HttpSession session  = request.getSession();

		    // Access and modify session attributes
		    session.setAttribute("Role",icmpService.SearchLoginAndPassword(lgr.getLogin(),Hash_code).getRole().getNomRole());
		    session.setAttribute("User",icmpService.SearchLoginAndPassword(lgr.getLogin(),Hash_code).getProprietaire());
		    
	    	model.addAttribute("user",icmpService.SearchLoginAndPassword(lgr.getLogin(),Hash_code).getProprietaire());
	    	model.addAttribute("Role",icmpService.SearchLoginAndPassword(lgr.getLogin(),Hash_code).getRole().getIdRole());
	   		    
			return "Profile";
			
		}else {
			
			model.addAttribute("UniqueMsg", "Le Login ou mot de passe est incorrect ");
			return "Login";
		}
		
}
	
	
	
	
	@RequestMapping("/showForm")
	public String showForm(Model model,HttpServletRequest request) {
		HttpSession session  = request.getSession();
		String attribute = (String) session.getAttribute("Role");
		System.out.println(attribute);
		model.addAttribute("UtilisateurModel", new Utilisateur());
		model.addAttribute("UtilisateurList",userService.getAllUsers());
		return "form";
	}
	
	
	
	
	
	
	
	//addUtilisateur
	@RequestMapping("/addUtilisateur")
	public String process(@Valid @ModelAttribute("UtilisateurModel") Utilisateur user, BindingResult bindingResult,
			ModelMap model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("errorMsg", "Les données sont invalides.");
		} else {
			userService.addUser(user);
		}
		
		model.addAttribute("UtilisateurModel", new Utilisateur());
		model.addAttribute("UtilisateurList",userService.getAllUsers()); 
		return "form";

	}
	
	
	
	
	@RequestMapping("/admin/ModifierCompte/updateCompte")
	public String updateCompte(@Valid @ModelAttribute("compteModel") Compte compte, BindingResult bindingResult,
			ModelMap model) {
		
		model.addAttribute("compteList",icmpService.getAllComptes());
		Compte cmp = icmpService.getCompte(compte.getIdCompte());
		
		PasswordHasher hasher = new PasswordHasher();
		String Hash_code = hasher.doHashing(compte.getPassword());
		cmp.setPassword(Hash_code);
		//System.out.println(compte.getRole().getIdRole());
		cmp.setRole(roleService.getRole(compte.getRole().getIdRole()));
		icmpService.updateCompte(cmp);
		return "CompteList";
	}
	
	@RequestMapping("/admin/desactive/{id}")
	public String desactive(@PathVariable(name = "id") Long id, Model model) {
		
		model.addAttribute("compteList",icmpService.getAllComptes());
		
		Compte cmp = icmpService.getCompte(id);
		cmp.setEnabled(false);
		icmpService.updateCompte(cmp);
		return "CompteList";
	}
	
	@RequestMapping("/admin/active/{id}")
	public String active(@PathVariable(name = "id") Long id, Model model) {
		
		model.addAttribute("compteList",icmpService.getAllComptes());
		
		Compte cmp = icmpService.getCompte(id);
		cmp.setEnabled(true);
		icmpService.updateCompte(cmp);
		return "CompteList";
	}
	
	
	
	
	
	
	@RequestMapping("/admin/serachUtilisateur")
	public String serachUtilisateur(@RequestParam String cin , Model model) {

	
		if(cin.equals("")) {
			model.addAttribute("UtilisateurList", userService.getAllUsers());
		}else {
			
			model.addAttribute("UtilisateurList", userService.getAllUsersByCin(cin));
		}
		
		return "CompteCreation";
	}
	
	
	// /admin/ModifierCompte/${a.idCompte}
	
	
	@RequestMapping(value = "/admin/ModifierCompte/{id}", method = RequestMethod.GET)
	public String ModifierCompte(@PathVariable(name = "id") Long id, Model model) {
		
		Compte cmptmdl = icmpService.getCompte(id);
		model.addAttribute("compteModel",cmptmdl);
		model.addAttribute("roleList", RoleList);
		model.addAttribute("compteList",icmpService.getAllComptes());
		return "UpdateCompte";
	}
	
	
	
	
	@RequestMapping(value = "/admin/createCompteForm/{id}", method = RequestMethod.GET)
	public String CreateCompteForm(@PathVariable(name = "id") String id, Model model) {
		CompteModel cmptmdl = new CompteModel();
		cmptmdl.setPersonId(Long.parseLong(id));
		model.addAttribute("compteModel",cmptmdl);
		model.addAttribute("roleList", RoleList);
		model.addAttribute("compteList",icmpService.getAllComptes());
		
		
		return "formCompte";
	}

	
	@RequestMapping("/admin/addCompte")
	public String addCompte(@Valid @ModelAttribute("compteModel") CompteModel compte, BindingResult bindingResult,
			ModelMap model) {
		
		
		Compte cmpt = new Compte();
		Role role = roleService.getRole(compte.getRoleId());
		cmpt.setRole(role);
		
		
		
		////////////////////////////// PASSWORD CREATION ///////////////////////////////////////////
		
		String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(allowedCharacters.length());
            char randomChar = allowedCharacters.charAt(randomIndex);
            password.append(randomChar);
        }

		
        ///////////////////////////////////////////////////////////////////////////////////////////// 
        
		Utilisateur tmpuser = userService.getUser(compte.getPersonId()); 
        String buffer = (tmpuser.getNom()+tmpuser.getPrenom());
		List<Compte> compts =  icmpService.getAllCompteNamesAsc(buffer);
		
		
		
		
        if(!compts.isEmpty()) {
        	System.out.println(compts.size());
        	System.out.println(compts.get(compts.size() - 1).getLogin());
        	Pattern pattern = Pattern.compile("\\d+$");
            Matcher matcher = pattern.matcher(compts.get(compts.size() - 1).getLogin());
        	if (matcher.find()) {
                String number = matcher.group();
                int ser = Integer.parseInt(number);
                ser+=1;
                System.out.println("fdbfsdhbfs");
                buffer=buffer+ser;
            } else {
            	buffer=buffer+"1";
            }
        }
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        PasswordHasher hasher = new PasswordHasher();
		String Hash_code = hasher.doHashing(password.toString());
        
		cmpt.setPassword(Hash_code);
		cmpt.setLogin(buffer);
		cmpt.setProprietaire(tmpuser);
		
		icmpService.addCompte(cmpt);
		
		model.addAttribute("compteList",icmpService.getAllComptes());
		
		return "CompteList";

	}
	
	
	///////////////////////////NAV BARS REDIRECTION //////////////////////////////////////////////////////////
	
	@RequestMapping("/admin/comptes")
	public String ListCompt(Model model) {
		
		model.addAttribute("compteList",icmpService.getAllComptes());
		return "CompteList";
	}
	
	
	
	@RequestMapping("/GoProfile")
	public String Profil(Model model,HttpServletRequest request) {
		
		HttpSession session  = request.getSession();
	    Utilisateur user =  (Utilisateur) session.getAttribute("User");
	    
	    System.out.println(user.getEmail());
	    
	    if(user!=null) {
	    	 	model.addAttribute("user",user);
	    }
	   		    
		return "Profile";
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////
	/*
	@RequestMapping("/admin/FormCompte")
	public String FormCompt(Model model) {
		CompteModel cmptmdl = new CompteModel();
		cmptmdl.setPersonId(Long.parseLong(id));
		model.addAttribute("compteModel",cmptmdl);
		model.addAttribute("roleList", RoleList);
		model.addAttribute("compteList",icmpService.getAllComptes());
		
		
		return "formCompte";
	}*/
	
	@RequestMapping("/admin/FormCompte")
	public String FormCompt(Model model) {
		
		model.addAttribute("UtilisateurList", userService.getAllUsers());
		return "CompteCreation";
	}
	
	///////////////Disconnect/////////////////////////////
	
	@RequestMapping("/Disconnect")
	public String Disconnect(Model model,HttpServletRequest request) {
		
		HttpSession session  = request.getSession();

		session.setAttribute("Role",null);
	    session.setAttribute("User",null);
		model.addAttribute("Loger", new Loger());
		return "Login";
	}
	
	
	
	
}
