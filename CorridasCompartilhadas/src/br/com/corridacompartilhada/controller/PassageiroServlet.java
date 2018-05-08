package br.com.corridacompartilhada.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.corridacompartilhada.bo.PassageiroBO;
import br.com.corridacompartilhada.dao.MotoristaDAO;
import br.com.corridacompartilhada.model.Motorista;
import br.com.corridacompartilhada.model.Passageiro;

@WebServlet("/PassageiroServlet")
public class PassageiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PassageiroServlet() {
        super();
    }
    
    private PassageiroBO passageiroBO = new PassageiroBO(); 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Collection<Passageiro> passageiro = passageiroBO.obterTodosPassageiro();
		request.setAttribute("listPassageiro", passageiro);

		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarPassageiro.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPassageiro = request.getParameter("idPassageiro");
		String nome = request.getParameter("nomePassageiro");
		String dataNascimentoString = request.getParameter("dataNascimento");
		String cpf = request.getParameter("cpf");
		String sexo = request.getParameter("sexo");
		String status = request.getParameter("statusPassageiro");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dataNascimento = null;
		
		try {
			dataNascimento = simpleDateFormat.parse(dataNascimentoString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(idPassageiro == null || idPassageiro == "") {
			Passageiro passageiro = new Passageiro(null, nome, dataNascimento, cpf, sexo, Boolean.valueOf(status));
			new PassageiroBO().cadastrarPassageiro(passageiro);
		} 
		doGet(request, response);
	}

}
