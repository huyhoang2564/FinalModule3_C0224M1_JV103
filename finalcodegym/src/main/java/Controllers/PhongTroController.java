package Controllers;

import Enity.NhaTro;
import Models.NhaTroModel;
import Models.PhuongThucThanhToanModel;
import Services.INhaTroService;
import Services.NhaTroService;
import Services.PhuongThucThanhToanService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhongTroServlet", value = "/phongtro")

public class PhongController extends HttpServlet {
    private INhaTroService phongTroService = new NhaTroService();
    private INhaToanService thanhToanService = new PhuongThucThanhToanService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "add":
                showAddForm(req, resp);
                break;
            case "delete":
                deleteById(req, resp);
                break;
            case "search":
                search(req,resp);
                break;
            case "list":
                showList(req, resp);
                break;
            default:
                showList(req, resp);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NhaTro> phongTros = phongTroService.findAllDto();
        req.setAttribute("phongTros", phongTros);
        List<PhuongThucThanhToanModel> thanhToans = thanhToanService.getAll();
        req.setAttribute("thanhToans", thanhToans);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchName = req.getParameter("searchName");
        int searchThanhToan = Integer.parseInt(req.getParameter("searchThanhToan"));
        System.out.println(searchName + searchThanhToan);
        List<NhaTro> phongTros = phongTroService.search(searchName, searchThanhToan);
        req.setAttribute("phongTros", phongTros);
        List<PhuongThucThanhToanModel> thanhToans = thanhToanService.getAll();
        req.setAttribute("thanhToans", thanhToans);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/list.jsp");
        requestDispatcher.forward(req, resp);

    }

    private boolean deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int deleteId = Integer.parseInt(req.getParameter("deleteId"));
        resp.sendRedirect("/phongtro?action=list");
        return phongTroService.deleteById(deleteId);

    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PhuongThucThanhToanModel> thanhToans = thanhToanService.getAll();
        req.setAttribute("thanhToans", thanhToans);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/add.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "add":
                add(req, resp);
                break;
            case "delete":
                deleteById(req, resp);
                break;
            case "search":
                search(req, resp);
                break;
            case "list":
                showList(req, resp);
                break;
            default:
                showList(req, resp);
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        String startDate = req.getParameter("startDate");
        String description = req.getParameter("description");
        int thanhtoan = Integer.parseInt(req.getParameter("thanhtoan"));
        boolean isOK = phongTroService.add(new NhaTroModel(name, phoneNumber, startDate,thanhtoan, description));
        String message = isOK?"OK:":"NOTOK";
        resp.sendRedirect("/phongtro?action=list&mess="+message);
    }

}
