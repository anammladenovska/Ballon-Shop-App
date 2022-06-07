package mk.ukim.finki.wp.lab.web;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="confirm-info-servlet", urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        String color = (String) req.getSession().getAttribute("color");
        context.setVariable("color", color);
        String size = (String) req.getSession().getAttribute("size");
        context.setVariable("size", size);
        context.setVariable("clientName", req.getSession().getAttribute("clientName"));
        context.setVariable("clientAddress", req.getSession().getAttribute("clientAddress"));
        context.setVariable("ipAddress", req.getRemoteAddr());
        context.setVariable("clientBrowser", req.getHeader("User-Agent"));
        this.springTemplateEngine.process("confirmationInfo.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.sendRedirect("/orders");
    }
}
