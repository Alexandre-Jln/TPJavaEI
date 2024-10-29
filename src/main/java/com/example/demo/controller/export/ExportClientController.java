package com.example.demo.controller.export;

import com.example.demo.dto.ClientDto;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Controller pour réaliser l'export des clients.
 */
@Controller
@RequestMapping("export/clients")
public class ExportClientController {

    @Autowired
    private ClientService clientService;

    /**
     * Export des articles au format CSV.
     */
    @GetMapping("csv")
    public void exportCSV(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"export-clients.csv\"");
        PrintWriter writer = response.getWriter();
        writer.println("Nom;Prénom");
        List<ClientDto> clients = clientService.findAll();
        for (ClientDto client : clients) {
            writer.println(client.getNom() + ";" + client.getPrenom());
        }
    }
}
