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

import br.com.corridacompartilhada.bo.MotoristaBO;
import br.com.corridacompartilhada.dao.MotoristaDAO;
import br.com.corridacompartilhada.model.Motorista;

@WebServlet("/MotoristaServlet")
public class MotoristaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public MotoristaServlet() {
        super();
    }

    private MotoristaBO motoristaBO = new MotoristaBO();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Collection<Motorista> motorista = motoristaBO.obterTodosMotoristas();
		request.setAttribute("listMotorista", motorista);

		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarMotorista.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idMotorista = request.getParameter("idMotorista");
		String nome = request.getParameter("nomeMotorista");
		String cpf = request.getParameter("cpf");
		String sexo = request.getParameter("sexo");
		String carro = request.getParameter("selectCarro");
		String status = request.getParameter("statusMotorista");
		String dataNascimentoString = request.getParameter("dataNascimento");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dataNascimento = null;
		try {
			dataNascimento = simpleDateFormat.parse(dataNascimentoString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(idMotorista == null || idMotorista == "") {
			Motorista motorista = new Motorista(null, nome, dataNascimento, cpf, sexo, carro, Boolean.valueOf(status));
			new MotoristaDAO().cadastrarMotorista(motorista);
		} else {
			Motorista motorista = new Motorista(Integer.parseInt(idMotorista), nome, dataNascimento, cpf, sexo, carro, Boolean.valueOf(status));
			new MotoristaDAO().alterarMotorista(motorista);
		}
		
		doGet(request, response);
	}

}
