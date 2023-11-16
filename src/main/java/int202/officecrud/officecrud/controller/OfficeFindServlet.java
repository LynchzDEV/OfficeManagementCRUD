package int202.officecrud.officecrud.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import int202.officecrud.officecrud.model.Office;
import int202.officecrud.officecrud.repository.OfficeRepository;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "OfficeFindServlet", value = "/office-find")
public class OfficeFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        List<Office> officeList = officeRepository.findAll();
        Set<String> uniqueSetCountry = new HashSet<>();
        Set<String> uniqueSetCity = new HashSet<>();
        if (officeList != null && !officeList.isEmpty()) {
            for (Office office : officeList) {
                uniqueSetCountry.add(office.getCountry());
                uniqueSetCity.add(office.getCity());
            }
        }
        request.setAttribute("uniqueCountry", uniqueSetCountry);
        request.setAttribute("uniqueCity", uniqueSetCity);
        request.setAttribute("officeList", officeList);
        String findVal = request.getParameter("officeList");
        if (findVal != null) {
            if (!findVal.equals("all")) {
                List<Office> offices = officeRepository.findByCityOrCountry(findVal);
                request.setAttribute("offices", offices);
            } else {
                request.setAttribute("offices", officeList);
            }
        } else {
            request.setAttribute("offices", officeList);
        }
        request.getRequestDispatcher("/office-management.jsp").forward(request, response);
    }
}
