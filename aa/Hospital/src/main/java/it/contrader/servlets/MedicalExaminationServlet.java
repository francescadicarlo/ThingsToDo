package it.contrader.servlets;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.MedicalExaminationService;
import it.contrader.service.Service;
import it.contrader.service.UserService;

public class MedicalExaminationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MedicalExaminationServlet() {
    }

    // Aggiorna la lista delle visite nell'attributo "list" della richiesta
    public void updateList(HttpServletRequest request) {
        MedicalExaminationService service = new MedicalExaminationService();
        List<UserDTO> listDTO = service.getAll();
        request.setAttribute("list", listDTO);
    }

    @Override

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Creazione di un'istanza del Service per gli utenti
        MedicalExaminationService service = new MedicalExaminationService();
        String mode = request.getParameter("mode");

        MedicalExaminationDTO dto;
        int id;
        boolean ans;

        switch (mode.toUpperCase()) {

            case "VISITELIST":
                // Aggiorna la lista e inoltra alla pagina di gestione
                updateList(request);
                getServletContext().getRequestDispatcher("/user/MedExamDirectory/MedicalExamination.jsp").forward(request, response);
                break;

            case "READ":
                id = Integer.parseInt(request.getParameter("id"));
                dto = (MedicalExaminationDTO) service.read(id);
                request.setAttribute("dto", dto);

                if (request.getParameter("update")==null){
                    getServletContext().getRequestDispatcher("/MedicalExamination/readme.jsp").forward(request, response);
                }

                else getServletContext().getRequestDispatcher("/MedicalExamination/updateme.jsp").forward(request,response);

                break;

            case "INSERT":
                id = Integer.parseInt(request.getParameter("id").toString());
                String typology = request.getParameter("typology").toString();
                long code = Long.parseLong(request.getParameter("code").toString());
                double cost = Double.parseDouble(request.getParameter("cost").toString());
                String img = request.getParameter("img").toString();
                dto = new MedicalExaminationDTO(id,typology,cost,code,img);
                ans = service.insert(dto);
                request.setAttribute("ans", ans);
                updateList(request);
                getServletContext().getRequestDispatcher("/MedExamDirectory/MedExamInsert.jsp").forward(request, response);
                break;

            case "UPDATE":
                id = Integer.parseInt(request.getParameter("id").toString());
                typology = request.getParameter("typology").toString();
                code = Long.parseLong(request.getParameter("code").toString());
                cost = Double.parseDouble(request.getParameter("cost").toString());
                img = request.getParameter("img").toString();
                dto = new MedicalExaminationDTO(id,typology,cost,code,img);
                request.getRequestDispatcher("/MedExamDirectory/MedExamUpdate.jsp").forward(request, response);
                ans = service.update(dto);
                updateList(request);
                getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
                break;

            case "DELETE":
                id = Integer.parseInt(request.getParameter("id").toString());
                ans = service.delete(Integer.parseInt(String.valueOf(id)));
                request.setAttribute("ans", ans);
                updateList(request);
                getServletContext().getRequestDispatcher("/MedExamDirectory/MedExamDelete.jsp").forward(request, response);
                break;
        }
    }
}