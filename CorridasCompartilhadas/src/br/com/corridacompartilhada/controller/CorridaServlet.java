package br.com.corridacompartilhada.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corridacompartilhada.dao.CorridaDAO;
import br.com.corridacompartilhada.dao.MotoristaDAO;
import br.com.corridacompartilhada.dao.PassageiroDAO;
import br.com.corridacompartilhada.model.Corrida;
import br.com.corridacompartilhada.model.Motorista;
import br.com.corridacompartilhada.model.Passageiro;

@WebServlet("/CorridaServlet")
public class CorridaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private MotoristaDAO motoristaDAO = new MotoristaDAO();
	private PassageiroDAO passageiroDAO = new PassageiroDAO();
	private CorridaDAO corridaDAO = new CorridaDAO();
	
    public CorridaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Motorista> motoristas = motoristaDAO.obterMotoristasDisponiveis();
		List<Passageiro> passageiros = passageiroDAO.obterPassageirosDisponiveis();
		List<Corrida> corridas = corridaDAO.listarCorridas();
		
		request.setAttribute("motoristas", motoristas);
		request.setAttribute("passageiros", passageiros);
		request.setAttribute("corridas", corridas);

		RequestDispatcher dispatcher = request.getRequestDispatcher("registrarCorrida.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idMotorista = request.getParameter("motoristaSelecionado");
		String idPassageiro = request.getParameter("passageiroSelecionado");
		String valorCorrida = request.getParameter("valorCorrida");
		Date dataInicio = new Date();
		
		Motorista motorista = new Motorista();
		motorista.setId(Integer.parseInt(idMotorista));
		
		Passageiro passageiro = new Passageiro();
		passageiro.setId(Integer.parseInt(idPassageiro));
		
		Corrida corrida = new Corrida(null, motorista, passageiro, dataInicio, Double.parseDouble(valorCorrida));
		
		corridaDAO.cadastrarCorrida(corrida);
		
		doGet(request, response);
	}

}
