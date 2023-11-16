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

@WebServlet(name = "OfficeAddServlet", urlPatterns = {"/office-add"})
public class OfficeAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("add",request.getParameter("insert"));
        request.getRequestDispatcher("/office-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        String officeCode = request.getParameter("officeCode");
        String message;

        if (isNullOrEmpty(officeCode) || isNullOrEmpty(request.getParameter("city")) ||
                isNullOrEmpty(request.getParameter("phone")) || isNullOrEmpty(request.getParameter("addressLine1")) ||
                isNullOrEmpty(request.getParameter("country")) || isNullOrEmpty(request.getParameter("postalCode")) ||
                isNullOrEmpty(request.getParameter("territory"))) {
            message = "Missing Input";
        } else {
            Office newOffice = createOfficeFromRequest(request);
            if (officeRepository.insert(newOffice)) {
                message = "Office Added Successfully";
            } else {
                message = "Failed to Add Office";
            }
        }

        request.getSession().setAttribute("statusMsg", message);
        response.sendRedirect(request.getContextPath() + "/office-find?officeList=all");
    }

    private Office createOfficeFromRequest(HttpServletRequest request) {
        Office office = new Office();
        office.setOfficeCode(request.getParameter("officeCode"));
        office.setCity(request.getParameter("city"));
        office.setPhone(request.getParameter("phone"));
        office.setAddressLine1(request.getParameter("addressLine1"));
        office.setAddressLine2(request.getParameter("addressLine2"));
        office.setState(request.getParameter("state"));
        office.setCountry(request.getParameter("country"));
        office.setPostalCode(request.getParameter("postalCode"));
        office.setTerritory(request.getParameter("territory"));
        return office;
    }
}
