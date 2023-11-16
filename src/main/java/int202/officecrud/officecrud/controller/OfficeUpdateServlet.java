package int202.officecrud.officecrud.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import int202.officecrud.officecrud.model.Office;
import int202.officecrud.officecrud.repository.OfficeRepository;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static int202.officecrud.officecrud.utils.Validator.isNullOrEmpty;

@WebServlet(name = "OfficeUpdateServlet", urlPatterns = {"/office-update"})
public class OfficeUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String editOfficeCode = request.getParameter("editOffice");
        OfficeRepository officeRepository = new OfficeRepository();
        Office office = officeRepository.find(editOfficeCode);
        session.setAttribute("officeCode", editOfficeCode);

        if (office != null) {
            request.setAttribute("office", office.getOfficeCode());
            System.out.println(office.getOfficeCode());
            request.getRequestDispatcher("/office-form.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Office not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OfficeRepository officeRepository = new OfficeRepository();
        String editOfficeCode = session.getAttribute("officeCode").toString();
        System.out.println(editOfficeCode);
        Office officeToUpdate = officeRepository.find(editOfficeCode);
        String message;

        if (officeToUpdate != null && !isNullOrEmpty(request.getParameter("city")) &&
                !isNullOrEmpty(request.getParameter("phone")) && !isNullOrEmpty(request.getParameter("addressLine1")) &&
                !isNullOrEmpty(request.getParameter("country")) && !isNullOrEmpty(request.getParameter("postalCode")) &&
                !isNullOrEmpty(request.getParameter("territory"))) {

            officeToUpdate.setOfficeCode(editOfficeCode);
            officeToUpdate.setCity(request.getParameter("city"));
            officeToUpdate.setPhone(request.getParameter("phone"));
            officeToUpdate.setAddressLine1(request.getParameter("addressLine1"));
            officeToUpdate.setAddressLine2(request.getParameter("addressLine2"));
            officeToUpdate.setState(request.getParameter("state"));
            officeToUpdate.setCountry(request.getParameter("country"));
            officeToUpdate.setPostalCode(request.getParameter("postalCode"));
            officeToUpdate.setTerritory(request.getParameter("territory"));

            if (officeRepository.update(officeToUpdate)) {
                message = "Office Updated Successfully";
            } else {
                message = "Failed to Update Office";
            }
        } else {
            System.out.println(editOfficeCode);
            message = "Invalid Input or Office Not Found";
        }

        request.getSession().setAttribute("statusMsg", message);
        response.sendRedirect(request.getContextPath() + "/office-find?officeList=all");
    }
}
