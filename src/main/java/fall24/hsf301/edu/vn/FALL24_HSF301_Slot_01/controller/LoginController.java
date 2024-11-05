package fall24.hsf301.edu.vn.FALL24_HSF301_Slot_01.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fall24.hsf301.slot1.dao.AccountDAO;
import fall24.hsf301.slot1.pojo.Account;
import fall24.hsf301.slot1.repository.AccountRepository;
import fall24.hsf301.slot1.service.AccountService;
import fall24.hsf301.slot1.service.IAccountService;

@Controller
public class LoginController {

    private final IAccountService accountService;

    public LoginController() {
        AccountDAO accountDAO = new AccountDAO("JPAs");
        AccountRepository accountRepository = new AccountRepository(accountDAO);
        this.accountService = new AccountService(accountRepository);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login"; 
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLogin(@RequestParam String username, @RequestParam String password, HttpSession session,
                               Model model) {
        Account account = accountService.login(username, password);

        if (account != null) {
            if ("admin".equals(account.getRole())) {
                session.setAttribute("user", account);
                return "redirect:/home"; // Redirect to home page for admin
            } else {
                model.addAttribute("errorMessage", "Access denied. Admin role required.");
                return "login"; // Stay on login page if not an admin
            }
        } else {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "login"; // Stay on login page if login failed
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        // Invalidate the session
        session.invalidate();
        return "redirect:/login"; // Redirect to the login page after logout
    }
}
