package int202.officecrud.officecrud.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import int202.officecrud.officecrud.model.Office;
import int202.officecrud.officecrud.repository.OfficeRepository;

import java.io.IOException;

import static int202.officecrud.officecrud.utils.Validator.isNullOrEmpty;

@WebServlet(name = "OfficeRemoveServlet", value = "/office-remove")
public class OfficeRemoveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        String officeCode = request.getParameter("officeRemoveCode") == null ? request.getParameter("removeOffice") : request.getParameter("officeRemoveCode");
        String message;
        if (!isNullOrEmpty(officeCode)) {
            Office office = officeRepository.find(officeCode);
            if (office != null) {
                if (officeRepository.delete(office)) {
                    message = "Office Removed Successfully";
                } else {
                    message = "Failed to Remove Office";
                }
            } else {
                message = "Office Not Found";
            }
        } else {
            message = "Invalid Input";
        }
        request.getSession().setAttribute("statusMsg", message);
        response.sendRedirect(request.getContextPath() + "/office-find?officeList=all");
    }
}
